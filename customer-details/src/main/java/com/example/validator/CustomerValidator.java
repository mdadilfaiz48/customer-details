package com.example.validator;

import com.example.beans.request.CustomerResourceRequest;
import com.example.beans.response.CustomerResourceResponse;
import com.example.exception.CustomerException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerValidator {
    public void validCustomer(CustomerResourceRequest resourceRequest) throws CustomerException {

        if(resourceRequest.getCustomerId() < 1){
            throw new CustomerException("101","Invalid customerId");
        }
        if(resourceRequest.getMobileNo().length() > 10 || resourceRequest.getMobileNo().length() < 10){
            throw new CustomerException("102","mobile number must be 10 digit ");
        }
    }

    public void validCustomers(List<CustomerResourceRequest> resourceRequestList) throws CustomerException{

        for(CustomerResourceRequest resourceRequest : resourceRequestList){
            if(resourceRequest.getCustomerId() < 1){
                throw new CustomerException("1001","your customerId not valid please put positive customer id");
            }
            if(resourceRequest.getMobileNo().length() < 10 || resourceRequest.getMobileNo().length() > 10){
                throw new CustomerException("1002","your mobile number not valid please put valid mobile number");
            }
            if(resourceRequest.getName() == null){
                throw new CustomerException("1003","please put your name");
            }
        }
    }
}
