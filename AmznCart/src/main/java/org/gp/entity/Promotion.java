package org.gp.entity;

import org.springframework.stereotype.Component;

@Component
public class Promotion {

    private static final double AED_TO_INR_RATE = 22.60;
    

    public void applyPromotionSetA(Product product) {
        double maxDiscount = 0.0;
        Discount discount = new Discount(); 
        discount.setDiscountTag(""); 

        if ("UAE".equalsIgnoreCase(product.getOrigin())) {
            if ("AED".equalsIgnoreCase(product.getCurrency())) {
                // As the exchangAPI was locked behind CreditCard access, I am using manualconversion.But can be easily implmented
                product.setPrice(Math.round(product.getPrice() * AED_TO_INR_RATE * 100.0) / 100.0);
            }
            
            double discountAmount = Math.round(product.getPrice() * 0.06 * 100.0) / 100.0; // 6% discount
            if (discountAmount > maxDiscount) 
            {
                maxDiscount = discountAmount;
                discount.setAmount(maxDiscount);
                discount.setDiscountTag("6% discount for UAE origin");
            }
        }

        if (product.getRating() == 2) 
        {
            double discountAmount = Math.round(product.getPrice() * 0.04 * 100.0) / 100.0; // 4% discount
            if (discountAmount > maxDiscount) 
            {
                maxDiscount = discountAmount;
                discount.setAmount(maxDiscount);
                discount.setDiscountTag("4% discount for rating equal to 2");
            }
        } 
        
        else if (product.getRating() < 2) 
        {
            double discountAmount = Math.round(product.getPrice() * 0.08 * 100.0) / 100.0; // 8% discount
            if (discountAmount > maxDiscount) 
            {
                maxDiscount = discountAmount;
                discount.setAmount(maxDiscount);
                discount.setDiscountTag("8% discount for rating below 2");
            }
        }

        if ((product.getCategory().equalsIgnoreCase("electronics") || product.getCategory().equalsIgnoreCase("furnishing")) && product.getPrice() >= 500) 
        {
            double discountAmount = 100;
            if (discountAmount > maxDiscount) 
            {
                maxDiscount = discountAmount;
                discount.setAmount(maxDiscount);
                discount.setDiscountTag("Rs 100 flat discount for electronics/furnishing items costing Rs 500 and above");
            }
        }

        if (maxDiscount > 0) 
        {
            product.setPrice(Math.round((product.getPrice() - maxDiscount) * 100.0) / 100.0); 
            discount.setAmount(Math.round(maxDiscount * 100.0) / 100.0); 
            product.setDiscount(discount); 
        } 
        
        else 
        {
            if (product.getPrice() > 1000) 
            {
                double defaultDiscount = Math.round((product.getPrice() * 0.02) * 100.0) / 100.0; // 2% default discount
                product.setPrice(Math.round((product.getPrice() - defaultDiscount) * 100.0) / 100.0); 
                discount.setAmount(defaultDiscount); 
                discount.setDiscountTag("2% default discount for price exceeding Rs 1000");
                product.setDiscount(discount); 
            }
        }
    }

    public void applyPromotionSetB(Product product) 
    {
        double maxDiscount = 0.0;
        Discount discount = new Discount(); 
        discount.setDiscountTag(""); 

        if (product.getInventory() > 20) 
        {
            double discountAmount = Math.round(product.getPrice() * 0.12 * 100.0) / 100.0; // 12% discount
            if (discountAmount > maxDiscount) 
            {
                maxDiscount = discountAmount;
                discount.setAmount(maxDiscount);
                discount.setDiscountTag("12% discount for inventory");
            }
        }

        if ("new".equalsIgnoreCase(product.getArrivalStatus())) 
        {
            double discountAmount = Math.round(product.getPrice() * 0.07 * 100.0) / 100.0; // 7% discount
            if (discountAmount > maxDiscount) 
            {
                maxDiscount = discountAmount;
                discount.setAmount(maxDiscount);
                discount.setDiscountTag("7% discount for new arrival status");
            }
        }

        if (maxDiscount > 0) 
        {
            product.setPrice(Math.round((product.getPrice() - maxDiscount) * 100.0) / 100.0); 
            discount.setAmount(Math.round(maxDiscount * 100.0) / 100.0); 
            product.setDiscount(discount); 
        } 
        
        else 
        {
            if (product.getPrice() > 1000) 
            {
                double defaultDiscount = Math.round((product.getPrice() * 0.02) * 100.0) / 100.0; // 2% default discount
                product.setPrice(Math.round((product.getPrice() - defaultDiscount) * 100.0) / 100.0); 
                discount.setAmount(defaultDiscount); 
                discount.setDiscountTag("2% default discount for price exceeding Rs 1000");
                product.setDiscount(discount);
            }
        }
    }

 }