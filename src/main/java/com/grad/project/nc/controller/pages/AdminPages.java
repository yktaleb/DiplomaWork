package com.grad.project.nc.controller.pages;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminPages {
    @RequestMapping("/admin/products")
    public String productsPage() {
        return "/admin/products";
    }

    @RequestMapping("/admin/productTypes")
    public String categoriesPage() {
        return "/admin/productTypes";
    }

    @RequestMapping("/admin/users")
    public String usersPage() {
        return "/admin/users";
    }

    @RequestMapping("/admin/discounts")
    public String discountsPage() {
        return "/admin/discounts";
    }

    @RequestMapping("/admin/g")
    public String g() {
        return "/admin/g";
    }

    @RequestMapping("/admin/ordersAndComplains")
    public String ordersAndComplains() {
        return "/admin/ordersAndComplains";
    }

}
