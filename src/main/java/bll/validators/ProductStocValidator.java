package bll.validators;

import model.Product;

/**
 * clasa de validare a stocului
 */
public class ProductStocValidator implements Validator<Product>{

    /**
     * metoda verifica stoc-ul unui produs pentru a nu fii insuficient
     * metoda suprascrisa, metoda parinte se afla in clasa StudentAgeValidator data ca exemplu in proiectul din prezentare
     * @param product
     */
    @Override
    public void validate(Product product) {
        if(product.getStoc()<=0){
            throw new IllegalArgumentException("Stock insufficient!");
        }
    }
}
