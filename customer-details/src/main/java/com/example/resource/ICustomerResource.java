package com.example.resource;

import com.example.beans.request.CustomerResourceRequest;
import com.example.beans.response.CustomerResourceResponse;
import com.example.exception.CustomerException;

import java.util.List;

public interface ICustomerResource {
    public CustomerResourceResponse saveCustomer(CustomerResourceRequest resourceRequest ) throws CustomerException;

    public List<CustomerResourceResponse> savesCustomers(List<CustomerResourceRequest> resourceRequestList) throws CustomerException;
}
