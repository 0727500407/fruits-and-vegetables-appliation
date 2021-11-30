package bsl.co.kejunior.Model;

public class Form {
    public int formid;
    public String proform;
    public String formname;

    public Form(int formid, String proform, String formname) {
        this.formid = formid;
        this.proform = proform;
        this.formname = formname;
    }

    public Form() {

    }

    public String getFormname() {
        return formname;
    }

    public void setFormname(String formname) {
        this.formname = formname;
    }

    public String getProform() {
        return proform;
    }

    public void setProform(String proform) {
        this.proform = proform;
    }

    public int getFormid() {
        return formid;
    }

    public void setFormid(int formid) {
        this.formid = formid;
    }
}
