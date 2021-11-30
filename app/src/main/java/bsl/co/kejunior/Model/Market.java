package bsl.co.kejunior.Model;

public class Market {
    public int marketid;
    public   String promarket;
    public   String price;
    public   String countrym;
    public   String datem;

    public Market(int marketid, String promarket, String price, String countrym, String datem) {
        this.marketid = marketid;
        this.promarket = promarket;
        this.price = price;
        this.countrym = countrym;
        this.datem = datem;
    }

    public Market() {

    }

    public String getDatem() {
        return datem;
    }

    public void setDatem(String datem) {
        this.datem = datem;
    }

    public String getCountrym() {
        return countrym;
    }

    public void setCountrym(String countrym) {
        this.countrym = countrym;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPromarket() {
        return promarket;
    }

    public void setPromarket(String promarket) {
        this.promarket = promarket;
    }

    public int getMarketid() {
        return marketid;
    }

    public void setMarketid(int marketid) {
        this.marketid = marketid;
    }
}
