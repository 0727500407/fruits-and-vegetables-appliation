package bsl.co.kejunior.Model;

public class Buyers {
    public   int buyerid;
    public   String product;
    public   String buy;
    public   String origin;
    public   String destination;

    public Buyers(int buyerid, String product, String buy, String origin, String destination) {
        this.buyerid = buyerid;
        this.product = product;
        this.buy = buy;
        this.origin = origin;
        this.destination = destination;
    }

    public Buyers() {
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

    public String getBuy() {
        return buy;
    }

    public void setBuy(String buy) {
        this.buy = buy;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getBuyerid() {
        return buyerid;
    }

    public void setBuyerid(int buyerid) {
        this.buyerid = buyerid;
    }
}
