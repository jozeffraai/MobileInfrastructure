package Models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "school")
public class School {

    private int id;
    private String schoolNaam;
    private String straat;
    private String huisnummer;
    private String postcode;
    private String stad;
    private String latitude;
    private String longtitude;

    public School() {
    }

    public School(int id, String schoolNaam, String straat, String huisnummer, String postcode, String stad, String latitude, String longtitude) {
        this.id = id;
        this.schoolNaam = schoolNaam;
        this.straat = straat;
        this.huisnummer = huisnummer;
        this.postcode = postcode;
        this.stad = stad;
        this.latitude = latitude;
        this.longtitude = longtitude;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSchoolNaam() {
        return schoolNaam;
    }

    public void setSchoolNaam(String schoolNaam) {
        this.schoolNaam = schoolNaam;
    }

    public String getStraat() {
        return straat;
    }

    public void setStraat(String straat) {
        this.straat = straat;
    }

    public String getHuisnummer() {
        return huisnummer;
    }

    public void setHuisnummer(String huisnummer) {
        this.huisnummer = huisnummer;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getStad() {
        return stad;
    }

    public void setStad(String stad) {
        this.stad = stad;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(String longtitude) {
        this.longtitude = longtitude;
    }

    @Override
    public String toString() {
        return "School{" + "id=" + id + ", schoolNaam=" + schoolNaam + ", straat=" + straat + ", huisnummer=" + huisnummer + ", postcode=" + postcode + ", stad=" + stad + ", latitude=" + latitude + ", longtitude=" + longtitude + '}';
    }
}
