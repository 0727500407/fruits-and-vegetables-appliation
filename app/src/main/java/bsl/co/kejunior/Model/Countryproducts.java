package bsl.co.kejunior.Model;

public class Countryproducts {
    public int productsid;
    public String proname;
    public String countrypro;
    public String quantity;
    public String dat;
    public String season;

    public Countryproducts(int productsid, String proname, String countrypro, String quantity, String dat, String season) {
        this.productsid = productsid;
        this.proname = proname;
        this.countrypro = countrypro;
        this.quantity = quantity;
        this.dat = dat;
        this.season = season;
    }

    public Countryproducts() {

    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getDat() {
        return dat;
    }

    public void setDat(String dat) {
        this.dat = dat;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getCountrypro() {
        return countrypro;
    }

    public void setCountrypro(String countrypro) {
        this.countrypro = countrypro;
    }

    public String getProname() {
        return proname;
    }

    public void setProname(String proname) {
        this.proname = proname;
    }

    public int getProductsid() {
        return productsid;
    }

    public void setProductsid(int productsid) {
        this.productsid = productsid;
    }
}
