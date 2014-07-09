package sk.upjs.ics.lss;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistraciaServlet extends HttpServlet{
	private AtomicInteger pocetRegistrovanych = new AtomicInteger(); 
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("Registering...");
		
		pocetRegistrovanych.incrementAndGet();
		
		PrintWriter out = resp.getWriter();
		resp.setHeader("Content-Type", "text/json");
		
		out.printf("{ \"count\" : %d }", pocetRegistrovanych.get());
	}
}
