package dao;

import connection.ConnectionFactory;
import model.Order;
import model.Product;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;

/**
 * clasa care implementeaza metode care modifica informatiile din baza de date pentru elementele din tabela order
 */
public class OrderDAO extends AbstractDAO<Order>{

    /**
     * metoda care adauga o noua comanda in tabela din baza de date
     * @param order
     * @return
     */
    public Order insert(Order order){

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String query = "insert into schooldb.order values (" + order.getId() + "," + order.getIdClient() + " , " + order.getIdProduct()
                + ")";
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            statement.executeUpdate(query);

            return order;
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
     * metoda care modifica informatiile unei comenzi
     * @param order
     * @return
     */
    public Order update(Order order){

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String query = "update schooldb.order set idClient=" + order.getIdClient() + ", idProduct=" + order.getIdProduct()
                + " where id =" + order.getId();
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            statement.executeUpdate(query);

            return order;
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
     * metoda care sterge o comanda
     * @param id
     * @throws Exception
     */
    public void delete(int id) throws Exception{

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String query = "delete from schooldb.order where id =" + id;
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

}
