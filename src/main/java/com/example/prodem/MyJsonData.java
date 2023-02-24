package com.example.prodem;

public class MyJsonData {
    private String message;
    private String name;
    
    public MyJsonData(String message, String name) {
        this.message = message;
        this.name = name;
    }

    public MyJsonData() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "MyJsonData{" +
                "message='" + message + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}