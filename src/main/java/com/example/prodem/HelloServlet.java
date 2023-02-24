package com.example.prodem;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        MyJsonData jsonData = new MyJsonData("Errorsd", "World123");

        // Jackson Object Mapper kullanarak JSON nesnesini stringe dönüştürün
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonStr = objectMapper.writeValueAsString(jsonData);
        /*{
        "message": "hello",
        "name": "world"

        }*/

        // Response content type ve status kodunu ayarlayın
        response.setContentType("application/json");
        response.setStatus(HttpServletResponse.SC_OK);

        // JSON stringi response body'sine yazın
        response.getWriter().write(jsonStr);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // Request body'sini oku ve JSON stringini al
        BufferedReader reader = request.getReader();
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            sb.append(line);
        }
        String jsonStr = sb.toString();
        System.out.println(jsonStr);

        // JSON stringini Java nesnesine dönüştür
        ObjectMapper objectMapper = new ObjectMapper();
        MyJsonData jsonData = objectMapper.readValue(jsonStr, MyJsonData.class);

        // Java nesnesini kullanarak işlem yap
        String message = jsonData.getMessage();
        String name = jsonData.getName();

        response.getWriter().write("Ugurla elave olunmusdur.");
        // ...
    }

    public void destroy() {
    }


}