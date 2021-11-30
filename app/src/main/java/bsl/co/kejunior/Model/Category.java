package bsl.co.kejunior.Model;

public class Category {
    public int categoryid;
    public String proname;
    public String description;

    public Category(int categoryid) {
        this.categoryid = categoryid;
    }

    public Category(int categoryid, String proname, String description) {
        this.categoryid = categoryid;
        this.proname = proname;
        this.description = description;
    }

    public Category() {

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProname() {
        return proname;
    }

    public void setProname(String proname) {
        this.proname = proname;
    }

    public int getCategoryid() {
        return categoryid;
    }

    public void setCategoryid(int categoryid) {
        this.categoryid = categoryid;
    }
}
