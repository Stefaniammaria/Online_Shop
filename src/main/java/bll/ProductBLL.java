package bll;

import bll.validators.ProductStocValidator;
import bll.validators.Validator;
import dao.ProductDAO;
import model.Client;
import model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * clasa care face legatura intre interfata si clasa ProductDAO
 */
public class ProductBLL {


    private List<Validator<Product>> validators;
    private ProductDAO productDAO;

    /**
     * constructor
     */
    public ProductBLL(){
        validators = new ArrayList<Validator<Product>>();
        validators.add(new ProductStocValidator());
        productDAO = new ProductDAO();
    }

    /*public Product findProductById(int id){

        Product product = (Product) productDAO.findById(id);
        if(product == null){
            throw new NoSuchElementException("The product with id =" + id + " was not found!");
        }
        return product;
    }*/

    /**
     * aceasta metoda a fost folosita pentru a apela metoda insert din clasa ProductDAO
     * @param product
     */
    public void insert(Product product){
        Product pr = productDAO.insert(product);
        if (pr == null) {
            throw new NoSuchElementException("The product with name =" + product.getName() + " was not inserted!");
        }
    }

    /**
     * aceasta metoda a fost folosita pentru a apela metoda update din clasa ProductDAO
     * @param product
     */
    public void update(Product product){
        Product pr = productDAO.update(product);
        if (pr == null) {
            throw new NoSuchElementException("The product with name =" + product.getName() + " was not updated!");
        }
    }

    /**
     * aceasta metoda a fost folosita pentru a apela metoda delete din clasa ProductDAO
     * @param product
     * @throws Exception
     */
    public void delete(Product product) throws Exception {
        try{
            productDAO.delete(product.getId());}
        catch(Exception e){
            throw new NoSuchElementException("The product with name =" + product.getName() + " was not deleted!");}
    }

    /*public List<Product> findAll(){
        List<Product> lista = new ArrayList<>();
        lista = productDAO.findAll();
        if (lista == null) {
            throw new NoSuchElementException("The list was not printed!");
        }
        return lista;
    }*/

}
