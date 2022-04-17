package dao;

import bll.ProductBLL;
import connection.ConnectionFactory;
import model.Client;
import model.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;

/**
 * clasa care implementeaza metode care modifica informatiile din baza de date pentru elementele din tabela product
 */
public class ProductDAO extends AbstractDAO<Product>{

    /**
     * metoda care insereaza un nou produs in tabela
     * @param product
     * @return
     */
    public Product insert(Product product){

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String query = "insert into schooldb.product values (" + product.getId() + ", '" + product.getName() + "' , " + product.getStoc()
                + ")";
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            statement.executeUpdate(query);

            return product;
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:insert " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;

    }

    /**
     * metoda care updateaza informatiile despre un produs in tabela din baza de date
     * @param product
     * @return
     */
    public Product update(Product product){

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String query = "update schooldb.product set name='" + product.getName() + "', stoc=" + product.getStoc()
                + " where id =" + product.getId();
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            statement.executeUpdate(query);

            return product;
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:update " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;

    }

    /**
     * metoda care sterge un produs din tabela
     * @param id
     * @throws Exception
     */
    public void delete(int id) throws Exception{

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String query = "delete from schooldb.product where id =" + id;
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            statement.executeUpdate(query);

        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:delete " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }

    }

    /**
     * metoda care decrementeaza stocul unui produs pe care il primeste ca parametru
     * @param product
     * @return
     */
    public Product decrementStock(Product product){

        product.setStoc(product.getStoc()-1);
        update(product);
        return product;

    }

}
