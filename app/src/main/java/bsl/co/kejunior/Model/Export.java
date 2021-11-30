package bsl.co.kejunior.Model;

public class Export {
    public int exportid;
    public   String producte;
    public   String purpose;
    public   String form;
    public   String countrye;
    public   String datee;

    public Export(int exportid, String producte, String purpose, String form, String countrye, String datee) {
        this.exportid = exportid;
        this.producte = producte;
        this.purpose = purpose;
        this.form = form;
        this.countrye = countrye;
        this.datee = datee;
    }

    public Export() {

    }

    public String getDatee() {
        return datee;
    }

    public void setDatee(String datee) {
        this.datee = datee;
    }

    public String getCountrye() {
        return countrye;
    }

    public void setCountrye(String countrye) {
        this.countrye = countrye;
    }

    public String getForm() {
        return form;
    }

    public void setForm(String form) {
        this.form = form;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getProducte() {
        return producte;
    }

    public void setProducte(String producte) {
        this.producte = producte;
    }

    public int getExportid() {
        return exportid;
    }

    public void setExportid(int exportid) {
        this.exportid = exportid;
    }
}
