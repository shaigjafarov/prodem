package com.example.prodem.controller;

import com.example.prodem.entity.AccountEn;
import com.example.prodem.model.Account;
import com.example.prodem.repository.AccountJpaRepository;
import com.example.prodem.repository.AccountRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet( "/account")
public class AccounServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {

        String accId = req.getParameter("accId");
        System.out.println(accId);

        long id = Long.parseLong(accId);
        AccountJpaRepository jpaRepository=new AccountJpaRepository();

        AccountEn accountEn= jpaRepository.getAccountEnById(id);
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(accountEn);

        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().write(json);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        String jsonStr = sb.toString();

        ObjectMapper objectMapper= new ObjectMapper();
        AccountEn accountEn = objectMapper.readValue(jsonStr, AccountEn.class);
        AccountJpaRepository jpaRepository=new AccountJpaRepository();

        List<AccountEn> accountEnList= jpaRepository.getAccountsByParams(accountEn);

        String json = objectMapper.writeValueAsString(accountEnList);

        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().write(json);

    }
}
