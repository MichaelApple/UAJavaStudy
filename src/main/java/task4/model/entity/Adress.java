package task4.model.entity;

/**
 * Created by Miha on 28.07.2017.
 */
public class Adress {

    private String zip;
    private String city;
    private String street;
    private String buildingNumber;
    private String flat;

    public Adress(String zip, String city, String street, String buildingNumber, String flat) {
        this.zip = zip;
        this.city = city;
        this.street = street;
        this.buildingNumber = buildingNumber;
        this.flat = flat;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuildingNumber() {
        return buildingNumber;
    }

    public void setBuildingNumber(String buildingNumber) {
        this.buildingNumber = buildingNumber;
    }

    public String getFlat() {
        return flat;
    }

    public void setFlat(String flat) {
        this.flat = flat;
    }

    @Override
    public String toString() {
        return "Adress{" +
                "zip='" + zip + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", buildingNumber='" + buildingNumber + '\'' +
                ", flat='" + flat + '\'' +
                '}';
    }
}
