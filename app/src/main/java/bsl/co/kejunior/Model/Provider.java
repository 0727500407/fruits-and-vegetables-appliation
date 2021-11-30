package bsl.co.kejunior.Model;

public class Provider {
    public int providerid;
    public String service;
    public String countrypro;

    public Provider(int providerid, String service, String countrypro) {
        this.providerid = providerid;
        this.service = service;
        this.countrypro = countrypro;
    }

    public Provider() {

    }

    public String getCountrypro() {
        return countrypro;
    }

    public void setCountrypro(String countrypro) {
        this.countrypro = countrypro;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public int getProviderid() {
        return providerid;
    }

    public void setProviderid(int providerid) {
        this.providerid = providerid;
    }
}
