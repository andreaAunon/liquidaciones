package com.babel.liquidaciones.model;


import lombok.Data;

import java.util.List;

@Data
public class Product {
    private String code;
    private String name;
    List<ProductWarranty> productWarranties;


}