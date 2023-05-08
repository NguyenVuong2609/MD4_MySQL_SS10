package rikkei.academy.service;

import rikkei.academy.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerServiceIMPL implements ICustomerService{
    public static List<Customer> customerList = new ArrayList<>();
    static  {
        customerList.add(new Customer(1, "Thu", "thu@gmail.com", "Yen Bai"));
        customerList.add(new Customer(2, "Ha", "ha@gmail.com", "Phu Tho"));
        customerList.add(new Customer(3, "Chuan", "chuan@gmail.com", "Nam Dinh"));
    }

    @Override
    public List<Customer> findAll() {
        return customerList;
    }

    @Override
    public void save(Customer customer) {
        customerList.add(customer);
    }

    @Override
    public Customer findById(int id) {
        return null;
    }

    @Override
    public void deleteById(int id) {

    }
}
