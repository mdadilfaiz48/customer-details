package com.example.service;

import com.example.beans.request.CustomerServiceRequest;
import com.example.beans.response.CustomerServiceResponse;
import com.example.exception.CustomerException;

public interface ICustomerService {
    public CustomerServiceResponse saveCustomer(CustomerServiceRequest serviceRequest ) throws CustomerException;
}
