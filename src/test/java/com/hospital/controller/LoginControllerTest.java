package com.hospital.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class LoginControllerTest extends Mockito {

	@Test
    public void loginControllerTest() throws Exception {
        HttpServletRequest request = mock(HttpServletRequest.class);       
        HttpServletResponse response = mock(HttpServletResponse.class);    

        when(request.getParameter("userName")).thenReturn("abishek");
        when(request.getParameter("passWord")).thenReturn("abishek");

        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

        new LoginController().doPost(request, response);

        verify(request, atLeast(1)).getParameter("userName"); // only if you want to verify username was called...
        writer.flush(); // it may not have been flushed yet...
        assertTrue(stringWriter.toString().contains("My expected string"));
    }
}
