package com.example.prodem.controller;

import com.example.prodem.model.Account;
import com.example.prodem.repository.AccountRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String accId = request.getParameter("accId");
        System.out.println(accId);

        int id = Integer.parseInt(accId);
        AccountRepository accountRepository = new AccountRepository();
        Account accountById = accountRepository.getAccountById(id);

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonStr = objectMapper.writeValueAsString(accountById);

        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().write(jsonStr);
    }

}