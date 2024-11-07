package com.example.usermanagementsystem.controller;

import java.io.IOException;
import java.util.List;

import com.example.usermanagementsystem.DAO.SoftwareDAO;
import com.example.usermanagementsystem.model.SoftwareModel;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/SoftwarelistServlet")
public class SoftwarelistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SoftwareDAO sd = new SoftwareDAO();
		List<SoftwareModel> softwarelist = sd.selectallsoftwaredata();
		request.setAttribute("softwareList", softwarelist);
		request.setAttribute("Message", "Request Success");

		request.getRequestDispatcher("requestAccess.jsp").include(request, response);
	}

}
