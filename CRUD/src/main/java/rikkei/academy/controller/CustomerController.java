package rikkei.academy.controller;

import rikkei.academy.model.Customer;
import rikkei.academy.service.CustomerServiceIMPL;
import rikkei.academy.service.ICustomerService;

import java.io.*;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(value = "/customer")
public class CustomerController extends HttpServlet {
    private ICustomerService customerService = new CustomerServiceIMPL();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("---> call doGet");
        String action = request.getParameter("action");
        System.out.println("action -->" + action);
        if (action == null){
            action = "";
        }
        switch (action) {
            case "create":
                showFormCreate(request, response);
                break;
            default:
                showListCustomer(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("---> call doPost");
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action) {
            case "create":
                actionCreate(request, response);
                break;
        }
    }

    //! Show List
    public void showListCustomer(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customerList = customerService.findAll();
        request.setAttribute("customerList", customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/CustomerView/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //! Show Form Create
    public void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/CustomerView/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void actionCreate(HttpServletRequest request, HttpServletResponse response){
        int id = customerService.findAll().get(customerService.findAll().size()-1).getId() + 1;
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customer = new Customer(id,name,email,address);
        customerService.save(customer);
        request.setAttribute("validate", "Create Success!");
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/CustomerView/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}