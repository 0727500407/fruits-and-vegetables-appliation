package bsl.co.kejunior.Model;

public class Aggregator {

   public int aggregatorid;
   public String aggname;
   public String aggcountry;

    public Aggregator() {
    }

    public Aggregator(int aggregatorid) {
        this.aggregatorid = aggregatorid;
    }

    public Aggregator(int aggregatorid, String aggname, String aggcountry) {
        this.aggregatorid = aggregatorid;
        this.aggname = aggname;
        this.aggcountry = aggcountry;
    }

    public String getAggcountry() {
        return aggcountry;
    }

    public void setAggcountry(String aggcountry) {
        this.aggcountry = aggcountry;
    }

    public String getAggname() {
        return aggname;
    }

    public void setAggname(String aggname) {
        this.aggname = aggname;
    }

    public int getAggregatorid() {
        return aggregatorid;
    }

    public void setAggregatorid(int aggregatorid) {
        this.aggregatorid = aggregatorid;
    }
}
