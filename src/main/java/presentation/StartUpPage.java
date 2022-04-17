package presentation;

import model.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

/**
 * clasa unde implementam interfata grafica pentru start up page
 */
public class StartUpPage extends JFrame{
    private JButton clientButton;
    private JButton productButton;
    private JButton orderButton;
    private JButton exitButton;
    private JPanel contentPane;

    /**
     * contructorul clasei
     * in interiorul lui avem implementarile pentru fiecare buton in parte
     */
    public StartUpPage(){

        setContentPane(contentPane);
        setTitle("StartUpPage");
        setSize(600,400);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.exit(0);

            }
        });

        clientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClientView cv = new ClientView();
                cv.setVisible(true);
                cv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });

        productButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProductView pv = new ProductView();
                pv.setVisible(true);
                pv.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });

        orderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OrderView ov = new OrderView();
                ov.setVisible(true);
                ov.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        });

    }

}
