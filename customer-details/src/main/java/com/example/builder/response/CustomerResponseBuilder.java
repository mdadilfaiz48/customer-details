package com.example.builder.response;

import com.example.beans.request.CustomerDAORequest;
import com.example.beans.response.CustomerDAOResponse;
import com.example.beans.response.CustomerResourceResponse;
import com.example.beans.response.CustomerServiceResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerResponseBuilder {

    public CustomerResourceResponse buildResourceResponse1(CustomerServiceResponse serviceResponse){

        System.out.println("CustomerResponseBuilder.buildResourceResponse1=============================>"+serviceResponse);

        CustomerResourceResponse resourceResponse = new CustomerResourceResponse();

        resourceResponse.setCustomerId(serviceResponse.getCustomerId());
        resourceResponse.setName(serviceResponse.getName());
        resourceResponse.setMobileNo(serviceResponse.getMobileNo());

        System.out.println("CustomerResponseBuilder.buildResourceResponse1===================================>"+resourceResponse);

        return resourceResponse;
    }

    public CustomerServiceResponse buildServiceResponse(CustomerDAOResponse daoResponse){
        System.out.println("CustomerResponseBuilder.buildServiceResponse=========================>"+daoResponse);

        CustomerServiceResponse serviceResponse = new CustomerServiceResponse();

        serviceResponse.setCustomerId(daoResponse.getCustomerId());
        serviceResponse.setName(daoResponse.getName());
        serviceResponse.setMobileNo(daoResponse.getMobileNo() );

        System.out.println("CustomerResponseBuilder.buildServiceResponse============================>"+serviceResponse);

        return serviceResponse;

    }

    public List<CustomerServiceResponse > buildServiceResponse2(List<CustomerDAOResponse > daoResponseList ){

        List<CustomerServiceResponse > serviceResponseList = new ArrayList<>();

        for(CustomerDAOResponse daoResponse : daoResponseList){

            CustomerServiceResponse serviceResponse = new CustomerServiceResponse();

            serviceResponse.setCustomerId(daoResponse.getCustomerId());
            serviceResponse.setName(daoResponse.getName());
            serviceResponse.setMobileNo(daoResponse.getMobileNo());
            serviceResponseList.add(serviceResponse);
        }
        return serviceResponseList;
    }

    public List<CustomerResourceResponse > buildResourceResponse2(List<CustomerServiceResponse > serviceResponseList){

       List<CustomerResourceResponse > resourceResponseList = new ArrayList<>();

        for(CustomerServiceResponse serviceResponse : serviceResponseList){

            CustomerResourceResponse resourceResponse = new CustomerResourceResponse();

            resourceResponse.setCustomerId(serviceResponse.getCustomerId());
            resourceResponse.setName(serviceResponse.getName());
            resourceResponse.setMobileNo(serviceResponse.getMobileNo());
            resourceResponseList.add(resourceResponse);
        }
        return resourceResponseList;
    }
}
