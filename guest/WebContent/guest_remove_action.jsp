<%@page import="com.itwill.guest.GuestDao"%>
<%@page import="java.sql.Date"%>
<%@page import="com.itwill.guest.Guest"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	
	/*
	
	1.파라메타받기
	2.GuestDao.delteByNo() 호출
	3.성공시:guest_list.jsp redirection
	4.실패시:guest_view.jsp redirection
	
	*/
	String method=request.getMethod(); 
	System.out.println("method:"+method);
	if(method.equalsIgnoreCase("GET")) {
		response.sendRedirect("guest_list.jsp");
		return;
	}
	
	request.setCharacterEncoding("EUC-KR");

	String guest_noStr=request.getParameter("guest_no");
	
	GuestDao gd=new GuestDao();
	boolean deleteOK=gd.deleteGuest(Integer.parseInt(guest_noStr));
	
	System.out.println("deleteOK"+deleteOK);
	
	if(deleteOK) {
		response.sendRedirect("guest_list.jsp");
	} else {
		response.sendRedirect("guest_view.jsp?guest_no="+guest_noStr);
	}
	
%>