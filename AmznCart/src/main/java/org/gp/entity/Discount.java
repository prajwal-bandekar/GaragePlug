package org.gp.entity;

import lombok.Data;

@Data
public class Discount {
    private double amount;
    private String discountTag;
}