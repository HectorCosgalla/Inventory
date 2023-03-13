package com.valcos98.inventoryjava.viewcontrollers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.valcos98.inventoryjava.entities.Products;
import com.valcos98.inventoryjava.services.ProductsServices;

@Controller
public class ProductsViewController {

    @Autowired
    private ProductsServices productsServices;

    @GetMapping("/")
    public String getProducts(Model model){
        List<Products> threeProducts = new ArrayList<Products>();
        List<Products> productsList = productsServices.getAll();
        if (productsList.size() > 3) {
            for (int i = productsList.size(); i > productsList.size()-3; i--) {
                threeProducts.add(productsList.get(i-1));
            }
            model.addAttribute("products", threeProducts);
        } else {
            model.addAttribute("products", productsList);
        }
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

    @GetMapping("/product/{id}")
    public String viewProduct(Model model, @PathVariable Long id){
        Optional<Products> product = productsServices.getById(id);
        model.addAttribute("product", product.get());
        return "product";
    }

    @GetMapping("/products/all")
    public String getAllProducts(Model model){
        List<Products> productsList = productsServices.getAll();
        model.addAttribute("products", productsList);
        return "all_products";
    }
}
