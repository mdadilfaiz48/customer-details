package com.example.resource.impl;

import com.example.beans.request.CustomerResourceRequest;
import com.example.beans.request.CustomerServiceRequest;
import com.example.beans.response.CustomerResourceResponse;
import com.example.beans.response.CustomerServiceResponse;
import com.example.builder.request.CustomerRequestBuilder;
import com.example.builder.response.CustomerResponseBuilder;
import com.example.dao.ICustomerDAO;
import com.example.exception.CustomerException;
import com.example.resource.ICustomerResource;
import com.example.service.ICustomerService;
import com.example.validator.CustomerValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerResourceImpl implements ICustomerResource {
    @Autowired
    private ICustomerService service;

    @Autowired
    private CustomerRequestBuilder requestBuilder;

    @Autowired
    private CustomerResponseBuilder responseBuilder;

    @Autowired
    private CustomerValidator validator;

    @Override
    @RequestMapping (path = "/customer",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public CustomerResourceResponse saveCustomer(@RequestBody CustomerResourceRequest resourceRequest) throws CustomerException {

        System.out.println("CustomerResourceImpl.saveCustomer@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@>"+resourceRequest);

        validator.validCustomer(resourceRequest );


        CustomerServiceRequest serviceRequest = requestBuilder.buildServiceRequest1(resourceRequest );

        CustomerServiceResponse serviceResponse = service.saveCustomer(serviceRequest);

        CustomerResourceResponse resourceResponse = responseBuilder.buildResourceResponse1(serviceResponse);

        System.out.println("CustomerResourceImpl.saveCustomer@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@>"+resourceResponse);

        return resourceResponse;
    }
}
