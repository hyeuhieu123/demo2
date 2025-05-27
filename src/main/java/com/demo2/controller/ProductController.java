package com.demo2.controller;


import com.demo2.model.Product;
import com.demo2.service.CloudinaryService;
import com.demo2.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

public class ProductController {
   @Autowired
    private ProductService productService;

    @Autowired
    private CloudinaryService cloudinaryService;

    @GetMapping("products")
    public String products(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "list_products";
    }

    @GetMapping("add-product")
    public String addProduct(Model model) {
        Product productDTO = new Product();
        model.addAttribute("product", productDTO);
        return "add_product";
    }

    @PostMapping("create-product")
    public String createProduct(@Valid @ModelAttribute("product") Product productDTO, BindingResult result) throws IOException {
        if (result.hasErrors()) {
            return "add_product";
        }

        String URL = cloudinaryService.uploadFile(productDTO.getFile());

        productDTO.setImage(URL);

        productService.add(productDTO);
        return "redirect:/products";
    }

    @GetMapping("edit-product/{id}")
    public String editProduct(Model model, @PathVariable int id) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "edit_product";
    }

    @PostMapping("update-product")
    public String updateProduct(@Valid @ModelAttribute("product") Product productDTO, BindingResult result) throws IOException {
        if (result.hasErrors()) {
            return "edit_product";
        }

        String newURL = cloudinaryService.uploadFile(productDTO.getFile());
        productDTO.setImage(newURL);
        productService.update(productDTO);
        return "redirect:/products";
    }

    @PostMapping("delete-product/{id}")
    public String deleteProduct(@PathVariable int id) {
        productService.delete(id);
        return "redirect:/products";
    }
}