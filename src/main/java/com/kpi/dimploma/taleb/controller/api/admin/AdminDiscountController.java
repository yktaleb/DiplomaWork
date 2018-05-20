package com.kpi.dimploma.taleb.controller.api.admin;

import com.kpi.dimploma.taleb.controller.api.data.DiscountResponseHolder;
import com.kpi.dimploma.taleb.controller.api.data.NewDiscountResponseHolder;
import com.kpi.dimploma.taleb.controller.api.dto.FrontEndProductRegionPrice;
import com.kpi.dimploma.taleb.controller.api.dto.FrontendDiscount;
import com.kpi.dimploma.taleb.controller.api.dto.FrontendRegion;
import com.kpi.dimploma.taleb.model.Discount;
import com.kpi.dimploma.taleb.service.discount.DiscountService;
import com.kpi.dimploma.taleb.service.exceptions.DiscountException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Created by Alex on 5/16/2017.
 */
@RestController
@RequestMapping("/api/admin/discounts")
@Slf4j
public class AdminDiscountController {

    private DiscountService discountService;

    @Autowired
    public AdminDiscountController(DiscountService discountService) {
        this.discountService = discountService;
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public NewDiscountResponseHolder add(@RequestBody FrontendDiscount frontendDiscount) {

        Discount discount = FrontendDiscount.toEntity(frontendDiscount);
        NewDiscountResponseHolder responseHolder = new NewDiscountResponseHolder();

        log.info("Adding discount: {} ",frontendDiscount.getDiscountTitle() );

        try{
            discountService.add(discount);
            if (discountService.getAddedDiscountId() >= 0){
                responseHolder.setMessage(discountService.getMessage());
                responseHolder.setStatus(discountService.getStatus());
                responseHolder.setDiscountID(discountService.getAddedDiscountId());
                System.out.println(discountService.getAddedDiscountId());

            }
            else {
                responseHolder.setMessage(discountService.getMessage());
                responseHolder.setStatus(discountService.getStatus());

            }

        }
        catch (DiscountException de){
            responseHolder.setMessage(de.getMessage());
            responseHolder.setStatus(discountService.getStatus());

        }



        return responseHolder;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST, consumes = "application/json", produces = "application/json")
    @ResponseBody
    public DiscountResponseHolder update(@RequestBody FrontendDiscount frontendDiscount) {
        Discount discount = FrontendDiscount.toEntity(frontendDiscount);
        DiscountResponseHolder responseHolder = new DiscountResponseHolder();

        log.info("Updating discount: {}",  frontendDiscount.getDiscountTitle() + frontendDiscount.getStartDate() );

        try{
            discountService.update(discount);
            responseHolder.setMessage(discountService.getMessage());
            responseHolder.setStatus(discountService.getStatus());

        }
        catch (DiscountException de){
            responseHolder.setMessage(de.getMessage());
            responseHolder.setStatus(discountService.getStatus());

        }

        return responseHolder;
    }
    
    @RequestMapping(value = "/allDiscounts/size/{size}/offset/{offset}", method = RequestMethod.GET)
    @ResponseBody
    public Collection<FrontendDiscount> getDiscounts(@PathVariable Long size, @PathVariable Long offset) {

        return discountService.getDiscountsPage(size, offset).stream()
                .map(FrontendDiscount::fromEntity)
                .collect(Collectors.toList());

    }

    @RequestMapping(value = "/allRegions", method = RequestMethod.GET)
    @ResponseBody
    public Collection<FrontendRegion> getRegions() {
        return discountService.getRegions().stream()
                .map(FrontendRegion::fromEntity)
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "/productPricesForRegion", method = RequestMethod.GET)
    @ResponseBody
    public Collection<FrontEndProductRegionPrice> getProductsRegionPricesForRegion(@RequestParam("regionId") Long regionId) {

        return discountService.getProductsRegionPricesForRegion(regionId).stream()
                .map(FrontEndProductRegionPrice::fromEntity)
                .collect(Collectors.toList());
    }
}
