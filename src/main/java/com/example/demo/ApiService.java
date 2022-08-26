package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ApiService {
    private ApiRepo apiRepo;

    @Autowired
    public ApiService(ApiRepo apiRepo)
    {
        this.apiRepo = apiRepo;
    }

    public List<Customer> getCustomers()
    {
        return apiRepo.GetAllCustomers();
    }

    public int AddCustomers(Customer customer)
    {
         return apiRepo.AddCustomer(customer);
    }

    public Customer UpdateCustomers(int id, Customer customer)
    {
         return apiRepo.UpdateCustomer(id, customer);
    }

    public int DeleteCustomer(int id)
    {
        return apiRepo.DeleteCustomer(id);
    }
}
