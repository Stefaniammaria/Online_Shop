package presentation;

import dao.ClientDAO;
import dao.OrderDAO;
import dao.ProductDAO;
import model.Order;
import model.Product;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;

/**
 * clasa unde implementam interfata grafica a comenzii
 */
public class OrderView extends JFrame{
    private JTextField textField2;
    private JTextField textField3;
    private JButton addOrderButton;
    private JButton exitButton;
    private JButton backButton;
    private JTable table1;
    private JTable table2;
    private JTextField textField1;
    private JPanel contentPane;
    private JButton showInformationButton;
    private JTable table3;

    /**
     * contructorul clasei
     * in interiorul lui avem implementarile pentru fiecare buton in parte
     */
    public OrderView () {

        setContentPane(contentPane);
        setTitle("Client");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(900,600);


        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                dispose();


            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.exit(0);

            }
        });

        addOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int id = Integer.parseInt(textField1.getText());
                int idClient = Integer.parseInt(textField2.getText());
                int idProdus = Integer.parseInt(textField3.getText());
                Order order = new Order();
                order.setId(id);
                order.setIdClient(idClient);
                order.setIdProduct(idProdus);
                OrderDAO orderDAO = new OrderDAO();
                orderDAO.insert(order);
                ProductDAO productDAO = new ProductDAO();
                Product product = productDAO.findById(order.getIdProduct());
                productDAO.decrementStock(product);

            }
        });

        showInformationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ClientDAO clientDAO = new ClientDAO();
                try {
                    DefaultTableModel tableModel=clientDAO.showInformation(clientDAO.findAll());
                    table1.setModel(tableModel);
                } catch (NoSuchMethodException ex) {
                    ex.printStackTrace();
                } catch (InvocationTargetException ex) {
                    ex.printStackTrace();
                } catch (IllegalAccessException ex) {
                    ex.printStackTrace();
                }

                ProductDAO productDAO = new ProductDAO();
                try {
                    DefaultTableModel tableModel=productDAO.showInformation(productDAO.findAll());
                    table2.setModel(tableModel);
                } catch (NoSuchMethodException ex) {
                    ex.printStackTrace();
                } catch (InvocationTargetException ex) {
                    ex.printStackTrace();
                } catch (IllegalAccessException ex) {
                    ex.printStackTrace();
                }

                OrderDAO orderDAO = new OrderDAO();
                try {
                    DefaultTableModel tableModel=orderDAO.showInformation(orderDAO.findAll());
                    table3.setModel(tableModel);
                } catch (NoSuchMethodException ex) {
                    ex.printStackTrace();
                } catch (InvocationTargetException ex) {
                    ex.printStackTrace();
                } catch (IllegalAccessException ex) {
                    ex.printStackTrace();
                }

            }
        });

    }



}
