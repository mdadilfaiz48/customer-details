package com.example.service;

import com.example.beans.request.CustomerServiceRequest;
import com.example.beans.response.CustomerServiceResponse;
import com.example.exception.CustomerException;

import java.util.List;

public interface ICustomerService {
    public CustomerServiceResponse saveCustomer(CustomerServiceRequest serviceRequest ) throws CustomerException;

    public List<CustomerServiceResponse> savesCustomers(List<CustomerServiceRequest > serviceRequestList ) throws CustomerException;
}
