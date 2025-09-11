package com.example.dao;

import com.example.beans.request.CustomerDAORequest;
import com.example.beans.request.CustomerResourceRequest;
import com.example.beans.response.CustomerDAOResponse;
import com.example.beans.response.CustomerResourceResponse;
import com.example.exception.CustomerException;

public interface ICustomerDAO {

  public CustomerDAOResponse saveCustomer(CustomerDAORequest daoRequest) throws CustomerException;
}
