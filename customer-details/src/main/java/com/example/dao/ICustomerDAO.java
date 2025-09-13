package com.example.dao;

import com.example.beans.request.CustomerDAORequest;
import com.example.beans.request.CustomerResourceRequest;
import com.example.beans.response.CustomerDAOResponse;
import com.example.beans.response.CustomerResourceResponse;
import com.example.exception.CustomerException;

import java.util.List;

public interface ICustomerDAO {

  public CustomerDAOResponse saveCustomer(CustomerDAORequest daoRequest) throws CustomerException;

  public List<CustomerDAOResponse > savesCustomers(List<CustomerDAORequest > daoRequestList ) throws CustomerException;
}
