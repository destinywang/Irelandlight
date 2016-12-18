package com.irelandlight.vo;

/**
 * Created by lenovo on 2016/12/8.
 */
public class ProductorCustom {

    private Long administratorID;
    private String administratorName;

    @Override
    public String toString() {
        return "ProductorCustom{" +
                "administratorID=" + administratorID +
                ", administratorName='" + administratorName + '\'' +
                '}';
    }

    public String getAdministratorName() {
        return administratorName;
    }

    public void setAdministratorName(String administratorName) {
        this.administratorName = administratorName;
    }

    public Long getAdministratorID() {
        return administratorID;
    }

    public void setAdministratorID(Long administratorID) {
        this.administratorID = administratorID;
    }


}
