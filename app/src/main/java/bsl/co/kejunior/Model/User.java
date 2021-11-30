package bsl.co.kejunior.Model;

public class User {
    public   int userid;
    public String uname;
    public   String first;
    public   String last;
    public   String uid;
    public String udate;

    public User(int userid, String uname, String first, String last, String uid, String udate, String umobile) {
        this.userid = userid;
        this.uname = uname;
        this.first = first;
        this.last = last;
        this.uid = uid;
        this.udate = udate;
        this.umobile = umobile;
    }

    public   String umobile;

    public User() {

    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUdate() {
        return udate;
    }

    public void setUdate(String udate) {
        this.udate = udate;
    }

    public String getUmobile() {
        return umobile;
    }

    public void setUmobile(String umobile) {
        this.umobile = umobile;
    }
}
