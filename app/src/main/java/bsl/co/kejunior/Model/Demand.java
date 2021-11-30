package bsl.co.kejunior.Model;

public class Demand {
    public int demandid;
    public String prodemand;
    public String countryo;
    public String quantityd;
    public String qualityd;
    public String countryd;

    public Demand(int demandid, String prodemand, String countryo, String quantityd, String qualityd, String countryd) {
        this.demandid = demandid;
        this.prodemand = prodemand;
        this.countryo = countryo;
        this.quantityd = quantityd;
        this.qualityd = qualityd;
        this.countryd = countryd;
    }

    public Demand() {

    }

    public String getCountryd() {
        return countryd;
    }

    public void setCountryd(String countryd) {
        this.countryd = countryd;
    }

    public String getQualityd() {
        return qualityd;
    }

    public void setQualityd(String qualityd) {
        this.qualityd = qualityd;
    }

    public String getQuantityd() {
        return quantityd;
    }

    public void setQuantityd(String quantityd) {
        this.quantityd = quantityd;
    }

    public String getCountryo() {
        return countryo;
    }

    public void setCountryo(String countryo) {
        this.countryo = countryo;
    }

    public String getProdemand() {
        return prodemand;
    }

    public void setProdemand(String prodemand) {
        this.prodemand = prodemand;
    }

    public int getDemandid() {
        return demandid;
    }

    public void setDemandid(int demandid) {
        this.demandid = demandid;
    }
}
