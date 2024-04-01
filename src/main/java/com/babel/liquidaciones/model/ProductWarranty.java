package com.babel.liquidaciones.model;

import lombok.Data;

@Data
public class ProductWarranty {
    private Risk risk;
    private Warranty warranty;
    private boolean excluded;
    private PaymentType paymentType;
    private double capitalInsured;
}