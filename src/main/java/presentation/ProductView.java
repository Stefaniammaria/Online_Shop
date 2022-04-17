package presentation;

import bll.ProductBLL;
import dao.ClientDAO;
import dao.ProductDAO;
import model.Client;
import model.Product;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;

/**
 * clasa unde implementam interfata grafica a produsului
 */
public class ProductView extends JFrame{
    private JTextField textField1;
    private JTextField textField2;
    private JButton addButton;
    private JTextField textField3;
    private JButton deleteButton;
    private JButton showProductsButton;
    private JButton updateButton;
    private JTable table1;
    private JButton backButton;
    private JButton exitButton;
    private JPanel contentPane;
    private JTextField textField4;

    /**
     * contructorul clasei
     * in interiorul lui avem implementarile pentru fiecare buton in parte
     */
    public ProductView (){

        setContentPane(contentPane);
        setTitle("Client");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(900,600);

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.exit(0);

            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                dispose();

            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Product product = new Product();
                ProductDAO productDAO = new ProductDAO();
                int i = Integer.parseInt(textField4.getText());
                int s = Integer.parseInt(textField2.getText());
                product.setId(i);
                product.setName(textField1.getText());
                product.setStoc(s);
                productDAO.insert(product);

            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ProductDAO productDAO = new ProductDAO();
                int i = Integer.parseInt(textField3.getText());
                try {
                    productDAO.delete(i);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        });


        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Product product = new Product();
                ProductDAO productDAO = new ProductDAO();
                int i = Integer.parseInt(textField4.getText());
                int s = Integer.parseInt(textField2.getText());
                product.setId(i);
                product.setName(textField1.getText());
                product.setStoc(s);
                productDAO.update(product);

            }
        });

        showProductsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ProductDAO productDAO = new ProductDAO();
                try {
                    DefaultTableModel tableModel=productDAO.showInformation(productDAO.findAll());
                    table1.setModel(tableModel);
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
