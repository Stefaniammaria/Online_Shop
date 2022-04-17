package bll;

import bll.validators.ClientEmailValidator;
import bll.validators.Validator;
import dao.ClientDAO;
import model.Client;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * clasa care face legatura intre interfata si clasa ClientDAO
 */
public class ClientBLL {

    private List<Validator<Client>> validators;
    private ClientDAO clientDAO;

    /**
     * constructor
     */
    public ClientBLL(){
        validators = new ArrayList<Validator<Client>>();
        validators.add(new ClientEmailValidator());
        clientDAO = new ClientDAO();
    }

    /*public Client findClientById(int id) {
        Client client = (Client) clientDAO.findById(id);
        if (client == null) {
            throw new NoSuchElementException("The client with id =" + id + " was not found!");
        }
        return client;
    }*/

    /**
     *aceasta metoda a fost folosita pentru a apela metoda insert din clasa ClientDAO
     * @param client
     */
    public void insert(Client client){
        Client cl = clientDAO.insert(client);
        if (cl == null) {
            throw new NoSuchElementException("The client with name =" + client.getName() + " was not inserted!");
        }
    }

    /**
     * aceasta metoda a fost folosita pentru a apela metoda update din clasa ClientDAO
     * @param client
     */
    public void update(Client client){
        Client cl = (Client) clientDAO.update(client);
        if (cl == null) {
            throw new NoSuchElementException("The client with name =" + client.getName() + " was not updated!");
        }
    }

    /**
     * aceasta metoda a fost folosita pentru a apela metoda delete din clasa ClientDAO
     * @param client
     * @throws Exception
     */
    public void delete(Client client) throws Exception {
        try{
       clientDAO.delete(client.getId());}
        catch(Exception e){
            throw new NoSuchElementException("The client with name =" + client.getName() + " was not deleted!");}
    }

    /*public List<Client> findAll(){
        List<Client> lista = new ArrayList<>();
        lista = clientDAO.findAll();
        if (lista == null) {
            throw new NoSuchElementException("The list was not printed!");
        }
        return lista;
    }*/
}
