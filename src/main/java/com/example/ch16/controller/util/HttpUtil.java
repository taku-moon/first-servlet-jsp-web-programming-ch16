package com.example.ch16.controller.util;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HttpUtil {

    public static void forward(HttpServletRequest request, HttpServletResponse response, String path) {
        try {
            request.getRequestDispatcher(path).forward(request, response);
        } catch (Exception e) {
            System.out.println("forward exception: " + e);
        }
    }
}
