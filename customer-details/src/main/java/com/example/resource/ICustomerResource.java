package com.example.resource;

import com.example.beans.request.CustomerResourceRequest;
import com.example.beans.response.CustomerResourceResponse;
import com.example.exception.CustomerException;

public interface ICustomerResource {
    public CustomerResourceResponse saveCustomer(CustomerResourceRequest resourceRequest ) throws CustomerException;
}
