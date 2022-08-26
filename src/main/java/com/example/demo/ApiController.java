package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ApiController {
    private ApiService apiService;

    @Autowired
    public ApiController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping("/Get")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return ResponseEntity.status(200).body(apiService.getCustomers());
    }

    @PostMapping("/Add")
    public List<Customer> AddCustomer(@RequestBody Customer customer)
    {
        apiService.AddCustomers(customer);
        return apiService.getCustomers();
    }

    @PutMapping("/Update/{id}")
    public List<Customer> UpdateCustomer(@PathVariable("id") int id, @RequestBody Customer customer)
    {
        apiService.UpdateCustomers(id, customer);
        return apiService.getCustomers();
    }


    @DeleteMapping("/Del/{id}")
    public List<Customer> DeleteCustomer(@PathVariable("id") int id)
    {
        apiService.DeleteCustomer(id);
        return apiService.getCustomers();
    }
}