package academy.belhard;

public class Address {

    private int id;
    private String town;
    private String street;
    private int number_house;
    private int number_corpus;
    private int number_flat;

    public Address(int id, String town, String street, int number_house, int number_corpus, int number_flat) {
        this.id = id;
        this.town = town;
        this.street = street;
        this.number_house = number_house;
        this.number_corpus = number_corpus;
        this.number_flat = number_flat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber_house() {
        return number_house;
    }

    public void setNumber_house(int number_house) {
        this.number_house = number_house;
    }

    public int getNumber_corpus() {
        return number_corpus;
    }

    public void setNumber_corpus(int number_corpus) {
        this.number_corpus = number_corpus;
    }

    public int getNumber_flat() {
        return number_flat;
    }

    public void setNumber_flat(int number_flat) {
        this.number_flat = number_flat;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", town='" + town + '\'' +
                ", street='" + street + '\'' +
                ", number_house=" + number_house +
                ", number_corpus=" + number_corpus +
                ", number_flat=" + number_flat +
                '}';
    }
}
