<%@page import="dao_p.MainDAO"%>
<%@page import="dto_p.MainDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% response.sendRedirect("main/Main");%>

<%-- <%

	MainDTO dto = new MainDTO();		
	MainDTO user = new MainDAO().userRead(dto);

	Cookie coo = new Cookie("user", String.valueOf(dto.getName()));
	response.addCookie(coo);
	if(coo.getValue() == null){
		response.sendRedirect("main/Start");
	}else{
		response.sendRedirect("main/Main");
	}
%> --%>