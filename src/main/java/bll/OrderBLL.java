package bll;

import bll.validators.Validator;
import dao.OrderDAO;
import model.Client;
import model.Order;
import model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * clasa care face legatura intre interfara si OrderDAO
 */
public class OrderBLL {

    private List<Validator<Order>> validators;
    private OrderDAO orderDAO;

    /**
     * constructor
     */
    public OrderBLL() {
        validators = new ArrayList<Validator<Order>>();
        orderDAO = new OrderDAO();
    }

    /*public Order findOrderById(int id) {

        Order order = (Order) orderDAO.findById(id);
        if (order == null) {
            throw new NoSuchElementException("The order with id =" + id + " was not found!");
        }
        return order;
    }*/

    /**
     * aceasta metoda a fost folosita pentru a apela metoda insert din clasa OrderDAO
     * @param order
     */
    public void insert(Order order) {
        Order or = orderDAO.insert(order);
        if (or == null) {
            throw new NoSuchElementException("The order with id =" + order.getId() + " was not inserted!");
        }
    }

    /**
     * aceasta metoda a fost folosita pentru a apela metoda update din clasa OrderDAO
     * @param order
     */
    public void update(Order order) {
        Order or = orderDAO.update(order);
        if (or == null) {
            throw new NoSuchElementException("The order with id =" + order.getId() + " was not updated!");
        }
    }

    /**
     * aceasta metoda a fost folosita pentru a apela metoda delete din clasa OrderDAO
     * @param order
     * @throws Exception
     */
    public void delete(Order order) throws Exception {
        try {
            orderDAO.delete(order.getId());
        } catch (Exception e) {
            throw new NoSuchElementException("The order with id =" + order.getId() + " was not deleted!");
        }

    }

    /*public List<Order> findAll() {
        List<Order> lista = new ArrayList<>();
        lista = orderDAO.findAll();
        if (lista == null) {
            throw new NoSuchElementException("The list was not printed!");
        }
        return lista;
    }*/
}
