package bsl.co.kejunior.Model;

public class Proclass {
    public int classid;
    public String productname;
    public String proclass;

    public Proclass(int classid, String productname, String proclass) {
        this.classid = classid;
        this.productname = productname;
        this.proclass = proclass;
    }

    public Proclass() {

    }

    public String getProclass() {
        return proclass;
    }

    public void setProclass(String proclass) {
        this.proclass = proclass;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public int getClassid() {
        return classid;
    }

    public void setClassid(int classid) {
        this.classid = classid;
    }
}
