package bsl.co.kejunior.Model;

public class Country {
    public int countryid;
    public String code;
    public String countryname;

    public Country(int countryid, String code, String countryname) {
        this.countryid = countryid;
        this.code = code;
        this.countryname = countryname;
    }

    public Country() {

    }

    public String getCountryname() {
        return countryname;
    }

    public void setCountryname(String countryname) {
        this.countryname = countryname;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getCountryid() {
        return countryid;
    }

    public void setCountryid(int countryid) {
        this.countryid = countryid;
    }
}
