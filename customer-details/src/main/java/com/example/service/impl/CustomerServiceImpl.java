package com.example.service.impl;

import com.example.beans.request.CustomerDAORequest;
import com.example.beans.request.CustomerServiceRequest;
import com.example.beans.response.CustomerDAOResponse;
import com.example.beans.response.CustomerServiceResponse;
import com.example.builder.request.CustomerRequestBuilder;
import com.example.builder.response.CustomerResponseBuilder;
import com.example.dao.ICustomerDAO;
import com.example.exception.CustomerException;
import com.example.resource.ICustomerResource;
import com.example.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    private ICustomerDAO dao;

    @Autowired
    private CustomerRequestBuilder requestBuilder;

    @Autowired
    private CustomerResponseBuilder responseBuilder;

    @Override
    public CustomerServiceResponse saveCustomer(CustomerServiceRequest serviceRequest) throws CustomerException {
        System.out.println("CustomerServiceImpl.saveCustomer###############################>"+serviceRequest);

        CustomerDAORequest daoRequest = requestBuilder.buildDAORequest1(serviceRequest);

        CustomerDAOResponse daoResponse = dao.saveCustomer(daoRequest);

        CustomerServiceResponse serviceResponse = responseBuilder.buildServiceResponse(daoResponse);

        System.out.println("CustomerServiceImpl.saveCustomer###############################>"+serviceResponse);
        return serviceResponse;
    }

    @Override
    public List<CustomerServiceResponse> savesCustomers(List<CustomerServiceRequest> serviceRequestList) throws CustomerException {
        System.out.println("CustomerServiceImpl.savesCustomers#############################>"+serviceRequestList);

        List<CustomerDAORequest > daoRequestList = requestBuilder.buildDAORequest(serviceRequestList);

        List<CustomerDAOResponse > daoResponseList = dao.savesCustomers(daoRequestList);

        List<CustomerServiceResponse> serviceResponseList = responseBuilder.buildServiceResponse2(daoResponseList);

        System.out.println("CustomerServiceImpl.savesCustomers###########################>"+serviceResponseList);

        return serviceResponseList;
    }
}
