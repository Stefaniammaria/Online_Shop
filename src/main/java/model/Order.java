package model;

/**
 * Clasa Order cu atributele care se afla si in baza de data,constructori, gettere si settere
 */
public class Order {

    private int id;
    private int idClient;
    private int idProduct;

    /**
     * constructor implicit
     */
    public Order(){}

    /**
     * constructor modificat
     * @param id
     * @param idClinet
     * @param idProduct
     */
    public Order(int id, int idClinet, int idProduct) {
        this.id = id;
        this.idClient = idClinet;
        this.idProduct = idProduct;
    }

    /**
     * getter pentru id
     * @return
     */
    public int getId() {
        return id;
    }

    /**
     * setter pentru id
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * getter pentru id-ul clientului
     * @return
     */
    public int getIdClient() {
        return idClient;
    }

    /**
     * setter pentru id-ul clientului
     * @param idClinet
     */
    public void setIdClient(int idClinet) {
        this.idClient = idClinet;
    }

    /**
     * getter pentru id-il produsului
     * @return
     */
    public int getIdProduct() {
        return idProduct;
    }

    /**
     * setter pentru id-ul produsului
     * @param idProduct
     */
    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    /**
     * metoda suprascrisa toString care ne ajuta la afisare
     * @return
     */
    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", idClinet=" + idClient +
                ", idProduct=" + idProduct +
                '}';
    }
}
