package com.demo2.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {
    private int id;
    @NotBlank(message = "Tên sản phẩm không được để trống!")
    private String name;
    private double price;
    private Integer quantity;
    private transient MultipartFile file;
    private String image;
}