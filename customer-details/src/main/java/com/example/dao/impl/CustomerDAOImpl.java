package com.example.dao.impl;

import com.example.beans.request.CustomerDAORequest;
import com.example.beans.request.CustomerResourceRequest;
import com.example.beans.response.CustomerDAOResponse;
import com.example.dao.ICustomerDAO;
import com.example.exception.CustomerException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomerDAOImpl implements ICustomerDAO {
    @Value("${driver.className}")
    String className;

    @Value("${driver.user}")
    String user;

    @Value("${driver.url}")
    String url;

    @Value("${driver.password}")
    String password;

    @Override
    public CustomerDAOResponse saveCustomer(CustomerDAORequest daoRequest) throws CustomerException {
        System.out.println("CustomerDAOImpl.saveCustomer&&&&&&&&&&&&&&&&&&&&&&&&&&&&>"+daoRequest);

        CustomerDAOResponse daoResponse = new CustomerDAOResponse();

        PreparedStatement ps = null ;
//        Connection con = null ;
        int rowInserted = 0;
        try(Connection con = DriverManager.getConnection(url,user,password) ) {
            Class.forName(className);
//            con = DriverManager.getConnection(url, user, password);
            String query = "insert into customers(cust_id,name,mobileno) values(?,?,?)";
            ps = con.prepareStatement(query);
            ps.setInt(1,daoRequest.getCustomerId());
            ps.setString(2,daoRequest.getName());
            ps.setString(3,daoRequest.getMobileNo());
            rowInserted = ps.executeUpdate();
        } catch (ClassNotFoundException|SQLException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getCause());


            if(e instanceof ClassNotFoundException ){
                System.out.println(e.getMessage());
                System.out.println(e.getCause());
                throw new CustomerException("401","class Not Found Exception");

            }
            if(e instanceof SQLException){
                System.out.println(e.getMessage());
                System.out.println(e.getCause());

                throw new CustomerException("402","SQL Exception");
            }

        }catch(Exception e){
           System.out.println(e.getCause());
           System.out.println(e.getMessage());
           throw new CustomerException("403","unknow Exception");
        }


        if(rowInserted > 0) {
            daoResponse.setCustomerId(daoRequest.getCustomerId());
            daoResponse.setName(daoRequest.getName());
            daoResponse.setMobileNo(daoRequest.getMobileNo());
        }

        System.out.println("CustomerDAOImpl.saveCustomer&&&&&&&&&&&&&&&&&&&&&&&&&>"+daoResponse);

        return daoResponse;
    }

    @Override
    public List<CustomerDAOResponse> savesCustomers(List<CustomerDAORequest> daoRequestList) throws CustomerException
    {
        System.out.println("CustomerDAOImpl.savesCustomers&&&&&&&&&&&&&&&&&&&&&&&&&&&&>"+daoRequestList);

//         Connection con = null;
//         PreparedStatement ps = null;
         int[] results = new int[0];
         List<CustomerDAOResponse> daoResponseList = new ArrayList<>();

        try( Connection con = DriverManager.getConnection(url,user,password); PreparedStatement ps = con.prepareStatement("insert into customers(cust_id,name,mobileno) values(?,?,?)");){
            Class.forName(className);
        for(CustomerDAORequest daoRequest : daoRequestList){
                ps.setInt(1,daoRequest.getCustomerId());
                ps.setString(2,daoRequest.getName());
                ps.setString(3,daoRequest.getMobileNo());
                ps.addBatch();
            }
            results = ps.executeBatch();

        }catch (SQLException|ClassNotFoundException e){
              System.out.println(e.getMessage());
              System.out.println(e.getCause());
              if(e instanceof SQLException){
                  System.out.println(e.getMessage());
                  System.out.println(e.getCause());
                  throw new CustomerException("4001","SQL Exception");
              }
              if(e instanceof ClassNotFoundException){
                  System.out.println(e.getMessage());System.out.println(e.getCause());
                 throw new CustomerException("4002","Class Not Found Exception");
              }
        }

        for(int i = 0; i < results.length; i++){
            CustomerDAORequest daoRequest = daoRequestList.get(i);
            CustomerDAOResponse daoResponse = new CustomerDAOResponse();
            daoResponse.setCustomerId(daoRequest.getCustomerId());
            daoResponse.setName(daoRequest.getName());
            daoResponse.setMobileNo(daoRequest.getMobileNo());
            daoResponseList.add(daoResponse);
        }

        System.out.println("CustomerDAOImpl.savesCustomers&&&&&&&&&&&&&&&&&&&&&&&&&&&>"+daoResponseList);

        return daoResponseList;
    }
}
