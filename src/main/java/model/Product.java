package model;

/**
 *  Clasa Product cu atributele care se afla si in baza de data,constructori, gettere si settere
 */
public class Product {

    private int id;
    private String name;
    private int stoc;

    /**
     * constructor implicit
     */
    public Product(){}

    /**
     * constructor modificat
     * @param id
     * @param nume
     * @param stoc
     */
    public Product(int id, String nume, int stoc) {
        this.id = id;
        this.name = nume;
        this.stoc = stoc;
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
     * getter pentru nume
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * setter pentru nume
     * @param nume
     */
    public void setName(String nume) {
        this.name = nume;
    }

    /**
     * getter pentru stoc
     * @return
     */
    public int getStoc() {
        return stoc;
    }

    /**
     * setter pentru stoc
     * @param stoc
     */
    public void setStoc(int stoc) {
        this.stoc = stoc;
    }

    /**
     * metoda suprascrisa toString care ne ajuta la afisare
     * @return
     */
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", nume='" + name + '\'' +
                ", stoc=" + stoc +
                '}';
    }
}
