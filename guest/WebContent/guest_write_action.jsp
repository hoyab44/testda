<%@page import="com.itwill.guest.GuestDao"%>
<%@page import="java.sql.Date"%>
<%@page import="com.itwill.guest.Guest"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String method=request.getMethod();
	System.out.println("method:"+method);
	if(method.equalsIgnoreCase("GET")) {
		response.sendRedirect("guest_list.jsp");
		return;
	}
	
	request.setCharacterEncoding("EUC-KR");

	String guest_name=request.getParameter("guest_name");
	String guest_homepage=request.getParameter("guest_homepage");
	String guest_email=request.getParameter("guest_email");
	String guest_title=request.getParameter("guest_title");
	String guest_content=request.getParameter("guest_content");
	
	Guest insertGuest=new Guest(0,
								guest_name,
								new Date(System.currentTimeMillis()),
								guest_email,
								guest_homepage,
								guest_title,
								guest_content);
	
	GuestDao gd=new GuestDao();
	boolean insertOK=gd.insertGuest(insertGuest);
	
	System.out.println("insertOK"+insertOK);
	
	//out.println("<script>alert('수정완료');</script>");
	
	response.sendRedirect("guest_list.jsp");
%>