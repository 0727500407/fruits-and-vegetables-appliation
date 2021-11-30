package bsl.co.kejunior.Model;

public class Sellers {
    public   int sellersid;
    public   String productse;
    public   String sellers;
    public   String origin;
    public   String destination;

    public Sellers(int sellersid, String productse, String sellers, String origin, String destination) {
        this.sellersid = sellersid;
        this.productse = productse;
        this.sellers = sellers;
        this.origin = origin;
        this.destination = destination;
    }

    public Sellers() {

    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getSellers() {
        return sellers;
    }

    public void setSellers(String sellers) {
        this.sellers = sellers;
    }

    public String getProductse() {
        return productse;
    }

    public void setProductse(String productse) {
        this.productse = productse;
    }

    public int getSellersid() {
        return sellersid;
    }

    public void setSellersid(int sellersid) {
        this.sellersid = sellersid;
    }
}
