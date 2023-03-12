package com.valcos98.inventoryjava.viewcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.valcos98.inventoryjava.entities.Products;
import com.valcos98.inventoryjava.services.ProductsServices;

@Controller
public class ProductsViewController {

    @Autowired
    private ProductsServices productsServices;

    @GetMapping("/")
    public String getProducts(Model model){
        List<Products> productsList = productsServices.getAll();
        model.addAttribute("products", productsList);
        return "products";
    }

    @GetMapping("/products/new")
    public String createNewProduct(Model model) {
        Products product = new Products();
        model.addAttribute("product", product);
        return "new_product";
    }

    @PostMapping("/products/new")
    public String addNewProduct(@ModelAttribute Products product) {
        productsServices.addProduct(product);
        return "redirect:/";
    }

}
