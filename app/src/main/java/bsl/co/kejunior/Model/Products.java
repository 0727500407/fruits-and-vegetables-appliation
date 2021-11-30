package bsl.co.kejunior.Model;

public class Products {
    public int productid;
    public String produname;
    public String commodityf;
    public String procategory;
    public String variety;
    public String qualityclass;

    public Products(int productid, String produname, String commodityf, String procategory, String variety, String qualityclass) {
        this.productid = productid;
        this.produname = produname;
        this.commodityf = commodityf;
        this.procategory = procategory;
        this.variety = variety;
        this.qualityclass = qualityclass;
    }

    public Products() {
    }

    public String getQualityclass() {
        return qualityclass;
    }

    public void setQualityclass(String qualityclass) {
        this.qualityclass = qualityclass;
    }

    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public String getProcategory() {
        return procategory;
    }

    public void setProcategory(String procategory) {
        this.procategory = procategory;
    }

    public String getCommodityf() {
        return commodityf;
    }

    public void setCommodityf(String commodityf) {
        this.commodityf = commodityf;
    }

    public String getProduname() {
        return produname;
    }

    public void setProduname(String produname) {
        this.produname = produname;
    }

    public int getProductid() {
        return productid;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }
}
