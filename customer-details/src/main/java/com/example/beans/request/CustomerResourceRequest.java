package com.example.beans.request;

public class CustomerResourceRequest {
    private String name;
    private String mobileNo;
    private int customerId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "CustomerResourceRequest{" +
                "name='" + name + '\'' +
                ", mobileNo='" + mobileNo + '\'' +
                ", customerId=" + customerId +
                '}';
    }
}
