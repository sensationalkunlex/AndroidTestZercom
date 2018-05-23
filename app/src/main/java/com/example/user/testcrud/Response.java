package com.example.user.testcrud;

public class Response {
    private String realm;
    private Data data;
    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }




    public String getRealm() {
        return realm;
    }

    public void setRealm(String realm) {
        this.realm = realm;
    }
}
