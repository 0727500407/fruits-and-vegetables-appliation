package bsl.co.kejunior.Model;

public class Imports {
    public int importid;
    public   String proimport;
    public   String formi;
    public   String purposei;
    public   String countryi;
    public   String datei;

    public Imports(int importid, String proimport, String formi, String purposei, String countryi, String datei) {
        this.importid = importid;
        this.proimport = proimport;
        this.formi = formi;
        this.purposei = purposei;
        this.countryi = countryi;
        this.datei = datei;
    }

    public Imports() {

    }

    public String getDatei() {
        return datei;
    }

    public void setDatei(String datei) {
        this.datei = datei;
    }

    public String getCountryi() {
        return countryi;
    }

    public void setCountryi(String countryi) {
        this.countryi = countryi;
    }

    public String getPurposei() {
        return purposei;
    }

    public void setPurposei(String purposei) {
        this.purposei = purposei;
    }

    public String getFormi() {
        return formi;
    }

    public void setFormi(String formi) {
        this.formi = formi;
    }

    public String getProimport() {
        return proimport;
    }

    public void setProimport(String proimport) {
        this.proimport = proimport;
    }

    public int getImportid() {
        return importid;
    }

    public void setImportid(int importid) {
        this.importid = importid;
    }
}
