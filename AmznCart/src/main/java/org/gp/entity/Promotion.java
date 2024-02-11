package org.gp.entity;

import org.springframework.stereotype.Component;

@Component
public class Promotion {

    public void applyPromotionSetA(Product product) {
      
        double maxDiscount = 0.0;
        String discountTag = "";

        
        if ("UAE".equalsIgnoreCase(product.getOrigin())) {
            double discount = product.getPrice() * 0.06; // 6% discount
            if (discount > maxDiscount) {
                maxDiscount = discount;
                discountTag = "6% discount for UAE origin";
            }
        }

        
        if (product.getRating() == 2) {
            double discount = product.getPrice() * 0.04; // 4% discount
            if (discount > maxDiscount) {
                maxDiscount = discount;
                discountTag = "4% discount for rating equal to 2";
            }
        } else if (product.getRating() < 2) {
            double discount = product.getPrice() * 0.08; // 8% discount
            if (discount > maxDiscount) {
                maxDiscount = discount;
                discountTag = "8% discount for rating below 2";
            }
        }

        
        if ((product.getCategory().equalsIgnoreCase("electronics") || product.getCategory().equalsIgnoreCase("furnishing")) &&
                product.getPrice() >= 500) {
            double discount = 100; 
            if (discount > maxDiscount) {
                maxDiscount = discount;
                discountTag = "Rs 100 flat discount for electronics/furnishing items costing Rs 500 and above, " + maxDiscount;
            }
        }

     
        if (maxDiscount > 0) {
            product.setPrice(product.getPrice() - maxDiscount);
            product.setDiscount(discountTag);
        } else {
         
            if (product.getPrice() > 1000) {
                double defaultDiscount = product.getPrice() * 0.02; // 2% default discount
                product.setPrice(product.getPrice() - defaultDiscount);
                product.setDiscount("2% default discount for price exceeding Rs 1000, " + maxDiscount);
            }
        }
    }

    public void applyPromotionSetB(Product product) {
    
        double maxDiscount = 0.0;
        String discountTag = "";

      
        if (product.getInventory() > 20) {
            double discount = product.getPrice() * 0.12; // 12% discount
            if (discount > maxDiscount) {
                maxDiscount = discount;
                discountTag = "12% discount for inventory, " + maxDiscount;
            }
        }

     

      
        if (maxDiscount > 0) {
            product.setPrice(product.getPrice() - maxDiscount);
            product.setDiscount(discountTag);
        } else {
            
            if (product.getPrice() > 1000) {
                double defaultDiscount = product.getPrice() * 0.02; // 2% default discount
                product.setPrice(product.getPrice() - defaultDiscount);
                product.setDiscount("2% default discount for price exceeding Rs 1000");
            }
        }
    }
}
