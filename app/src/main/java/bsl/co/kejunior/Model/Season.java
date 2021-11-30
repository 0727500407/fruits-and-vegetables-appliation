package bsl.co.kejunior.Model;

public class Season {
    public int seasonid;
    public   String seaname;
    public   String datefrom;
    public   String dateto;
    public   String countrsi;

    public Season(int seasonid, String seaname, String datefrom, String dateto, String countrsi) {
        this.seasonid = seasonid;
        this.seaname = seaname;
        this.datefrom = datefrom;
        this.dateto = dateto;
        this.countrsi = countrsi;
    }

    public Season() {

    }

    public String getCountrsi() {
        return countrsi;
    }

    public void setCountrsi(String countrsi) {
        this.countrsi = countrsi;
    }

    public String getDateto() {
        return dateto;
    }

    public void setDateto(String dateto) {
        this.dateto = dateto;
    }

    public String getDatefrom() {
        return datefrom;
    }

    public void setDatefrom(String datefrom) {
        this.datefrom = datefrom;
    }

    public String getSeaname() {
        return seaname;
    }

    public void setSeaname(String seaname) {
        this.seaname = seaname;
    }

    public int getSeasonid() {
        return seasonid;
    }

    public void setSeasonid(int seasonid) {
        this.seasonid = seasonid;
    }
}
