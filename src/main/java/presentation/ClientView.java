package presentation;

import dao.ClientDAO;
import model.Client;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;

/**
 * clasa unde implementam grafica a clientului
 */
public class ClientView extends JFrame{
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JButton addButton;
    private JButton deleteButton;
    private JButton updateButton;
    private JButton showClientsButton;
    private JTable table1;
    private JButton backButton;
    private JButton exitButton;
    private JPanel contentPane;
    private JTextField textField5;

    /**
     * contructorul clasei
     * in interiorul lui avem implementarile pentru fiecare buton in parte
     */
    public ClientView(){

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

                Client client = new Client();
                ClientDAO cl = new ClientDAO();
                int i = Integer.parseInt(textField5.getText());
                client.setId(i);
                client.setName(textField1.getText());
                client.setEmail(textField2.getText());
                client.setAddress(textField3.getText());
                cl.insert(client);

            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ClientDAO cl = new ClientDAO();
                int i = Integer.parseInt(textField4.getText());
                try {
                    cl.delete(i);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        });


        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Client client = new Client();
                ClientDAO cl = new ClientDAO();
                int i = Integer.parseInt(textField5.getText());
                client.setId(i);
                client.setName(textField1.getText());
                client.setEmail(textField2.getText());
                client.setAddress(textField3.getText());
                cl.update(client);

            }
        });

        showClientsButton.addActionListener(new ActionListener() {
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

            }
        });


    }
}
