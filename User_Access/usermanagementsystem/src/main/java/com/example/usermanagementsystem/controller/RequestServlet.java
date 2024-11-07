package com.example.usermanagementsystem.controller;

import java.io.IOException;

import com.example.usermanagementsystem.DAO.RequestAccessDAO;
import com.example.usermanagementsystem.model.RequestAccessModel;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RequestServlet")
public class RequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int userId = Integer.parseInt(request.getParameter("userId"));
		int softwareId = Integer.parseInt(request.getParameter("softwareId"));
		String accessType = request.getParameter("accessType");
		String reason = request.getParameter("reason");

		RequestAccessModel ram = new RequestAccessModel();
		ram.setUser_id(userId);
		ram.setSoftware_id(softwareId);
		ram.setAccess_type(accessType);
		ram.setReason(reason);
		RequestAccessDAO rad = new RequestAccessDAO();
		String Status = rad.requestaccessdata(ram);
		if (Status.equals("requestsuccess")) {
			request.setAttribute("Message", "Request Success");
			RequestDispatcher rp = request.getRequestDispatcher("requestAccess.jsp");
			rp.include(request, response);
		}

	}

}
