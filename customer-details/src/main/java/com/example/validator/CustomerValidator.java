package com.example.validator;

import com.example.beans.request.CustomerResourceRequest;
import com.example.beans.response.CustomerResourceResponse;
import com.example.exception.CustomerException;
import org.springframework.stereotype.Component;

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
}
