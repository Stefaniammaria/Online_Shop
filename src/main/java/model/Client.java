package model;


/**
 * Clasa Client cu atributele care se afla si in baza de data,constructori, gettere si settere
 */
public class Client {

    private int id;
    private String name;
    private String email;
    private String address;

    /**
     * constructor implicit
     */
    public Client(){}

    /**
     *
     * @param id
     * @param name
     * @param email
     * @param address
     * constructor modificat
     */
    public Client(int id, String name, String email, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
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
     * getter pentru name
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * setter pentru name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getter pentru email
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * setter pentru email
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * getter pentru adresa
     * @return
     */
    public String getAddress() {
        return address;
    }

    /**
     * setter pentru adresa
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * metoda suprascrisa toString care ne ajuta la afisare
     * @return
     */
    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
