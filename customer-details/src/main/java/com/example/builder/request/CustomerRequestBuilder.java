package com.example.builder.request;

import com.example.beans.request.CustomerDAORequest;
import com.example.beans.request.CustomerResourceRequest;
import com.example.beans.request.CustomerServiceRequest;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerRequestBuilder {

    public CustomerServiceRequest buildServiceRequest1(CustomerResourceRequest resourceRequest ){
        System.out.println("CustomerRequestBuilder.buildServiceRequest1++++++++++++++++++++++>"+resourceRequest);

        CustomerServiceRequest serviceRequest = new CustomerServiceRequest();

        serviceRequest.setCustomerId(resourceRequest.getCustomerId());
        serviceRequest.setName(resourceRequest.getName());
        serviceRequest.setMobileNo(resourceRequest.getMobileNo());

        System.out.println("CustomerRequestBuilder.buildServiceRequest1++++++++++++++++++++++++++>"+serviceRequest);
        return serviceRequest;
    }

    public CustomerDAORequest buildDAORequest1(CustomerServiceRequest serviceRequest){
        System.out.println("CustomerRequestBuilder.buildDAORequest1++++++++++++++++++++++++++++++>"+serviceRequest);

        CustomerDAORequest daoRequest = new CustomerDAORequest();

        daoRequest.setCustomerId(serviceRequest.getCustomerId());
        daoRequest.setName(serviceRequest.getName());
        daoRequest.setMobileNo(serviceRequest.getMobileNo());

        System.out.println("CustomerRequestBuilder.buildDAORequest1++++++++++++++++++++++++>"+daoRequest);
        return daoRequest;
    }


    public List<CustomerServiceRequest> buildServiceRequest2(List<CustomerResourceRequest > resourceRequestList ){

        List<CustomerServiceRequest > serviceRequestList = new ArrayList<>();

        for(CustomerResourceRequest resourceRequest : resourceRequestList){

            CustomerServiceRequest serviceRequest = new CustomerServiceRequest();

            serviceRequest.setCustomerId(resourceRequest.getCustomerId() );
            serviceRequest.setName(resourceRequest.getName() );
            serviceRequest.setMobileNo(resourceRequest.getMobileNo() );
            serviceRequestList.add(serviceRequest);

        }

        return serviceRequestList;
    }


    public List<CustomerDAORequest > buildDAORequest(List<CustomerServiceRequest > serviceRequestList ){

        List<CustomerDAORequest > daoRequestList = new ArrayList<>();

        for(CustomerServiceRequest serviceRequest : serviceRequestList){

            CustomerDAORequest daoRequest = new CustomerDAORequest();

            daoRequest.setCustomerId(serviceRequest.getCustomerId());
            daoRequest.setName(serviceRequest.getName());
            daoRequest.setMobileNo(serviceRequest.getMobileNo());
            daoRequestList.add(daoRequest);
        }
        return daoRequestList;
    }
}
