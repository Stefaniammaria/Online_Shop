package dao;

import connection.ConnectionFactory;
import model.Client;

import java.sql.*;
import java.util.logging.Level;

/**
 * clasa care implementeaza metode care modifica informatiile din baza de date pentru elementele din tabela client
 */
public class ClientDAO extends AbstractDAO<Client> {

    /**
     * metoda care adauga un nou client in tabela din baza de date
     * @param client
     * @return
     */
    public Client insert(Client client) {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String query = "insert into schooldb.client values (" + client.getId() + ", '" + client.getName() + "' , '" + client.getEmail()
                + "' , '" + client.getAddress() + "')";
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            statement.executeUpdate(query);

            return client;
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
     * metoda care updateaza informatiile despre un client in tabela
     * @param client
     * @return
     */
    public Client update(Client client) {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String query = "update schooldb.client set name='" + client.getName() + "', email='" + client.getEmail() + "', address='" + client.getAddress()
                + "' where id =" + client.getId();
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();
            statement.executeUpdate(query);

            return client;
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
     * metoda care sterge un client din tabela
     * @param id
     * @throws Exception
     */
    public void delete(int id) throws Exception {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String query = "delete from schooldb.client where id =" + id;
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
