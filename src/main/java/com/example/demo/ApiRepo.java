package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ApiRepo {

    private final JdbcTemplate jdbcTemplate;

    RowMapper<Customer> customerRowMapper = new RowMapper<Customer>() {
        @Override
        public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
            Customer customer = new Customer();
            customer.setId(rs.getInt("id"));
            customer.setName(rs.getString("name"));
            customer.setCell(rs.getDouble("cell"));
            return customer;
        }
    };

    @Autowired
    public ApiRepo(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Customer> GetAllCustomers() {
        String query = "SELECT * FROM customer";
        return jdbcTemplate.query(query,customerRowMapper);
    }

    public int AddCustomer(Customer customer)
    {
        String query = "INSERT INTO customer(id, name , cell) VALUES (?,?,?)";
        return jdbcTemplate.update(query, customer.getId(), customer.getName(), customer.getCell());
    }

    public Customer UpdateCustomer(int id, Customer customer)
    {
        String query = "UPDATE customer SET name =? , cell =?  WHERE id=?";
        jdbcTemplate.update(query, customer.getName(), customer.getCell(), id);
        return customer;
    }

    public int DeleteCustomer(int id)
    {
        String query = "DELETE FROM customer WHERE id =?";
        return jdbcTemplate.update(query, id);
    }
}
