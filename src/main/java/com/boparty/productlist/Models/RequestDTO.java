package com.boparty.productlist.Models;

public class RequestDTO {
    private String param1="";
    private String param2="";
    private String param3="";

    public String getParam3() {
        return param3;
    }

    public void setParam3(String param3) {
        this.param3 = param3;
    }

    public String getParam1() {
        return param1;
    }

    public void setParam1(String name) {
        this.param1 = name;
    }

    public String getParam2() {
        return param2;
    }

    public void setParam2(String amount) {
        this.param2 = amount;
    }
}
