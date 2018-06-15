package com.kpi.dimploma.taleb.controller.api;

import com.kpi.dimploma.taleb.controller.api.dto.FrontendCategory;
import com.kpi.dimploma.taleb.model.Category;
import com.kpi.dimploma.taleb.model.ProductOrder;
import com.kpi.dimploma.taleb.service.Category.CategoryService;
import com.kpi.dimploma.taleb.service.instances.InstanceService;
import com.kpi.dimploma.taleb.service.orders.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Taleb on 20.05.2018.
 */
@RestController
@RequestMapping("api/category")
public class CategoryController {


    CategoryService categoryService;
    InstanceService instanceService;
    OrdersService ordersService;

    @Autowired
    public CategoryController(CategoryService categoryService, InstanceService instanceService, OrdersService ordersService) {
        this.categoryService = categoryService;
        this.instanceService = instanceService;
        this.ordersService = ordersService;
    }

    @RequestMapping(value = "/getstatus/frominstance/{id}", method = RequestMethod.GET)
    public Map<String, Object> getCategoryByInstanceId(@PathVariable Long id) {

        Map<String, Object> result = new HashMap<>();
        Collection<ProductOrder> openOrders = ordersService.getOpenInstanceOrders(id, 2, 0);
        if(openOrders.size()==0){
            result.put("openOrders", "false" );
            result.put("productStatus", FrontendCategory.fromEntity(categoryService.getByProductInstanceId(id)));
        } else {
            result.put("openOrders", "true" );
        }
        return result;
    }

    @RequestMapping(value = "/get/bytype/{typeId}/", method = RequestMethod.GET)
    public Map<String, Object> findByCategoryTypeName(@PathVariable long typeId){
        Map<String, Object> result = new HashMap<>();
        Collection<Category> categories = categoryService.findByCategoryType(typeId);
        if(categories.size()>0){
            result.put("status", "found");
            result.put("categories", categories);
        } else {
            result.put("status", "not found");
        }
        return result;
    }
}
