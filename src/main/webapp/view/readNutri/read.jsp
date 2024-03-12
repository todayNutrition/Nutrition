<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.InputStreamReader"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
/* 	String path = "../py/ReadNu.py";
	
	ProcessBuilder pb = new ProcessBuilder("python",path);
	String info = "하이";
	try {
		Process process = pb.start();
		
		// 실행중에 print()로 출력하는 내용 가져오기
		InputStreamReader isr = new InputStreamReader(process.getInputStream(),"ms949");
		BufferedReader br = new BufferedReader(isr);
		
		String line = null;
		while((line=br.readLine())!=null) {
			System.out.println("pythonf 출력 : "+line);
		}
		
		br.close();
		isr.close();
		System.out.println(info);
		int exitCode = process.waitFor();
		System.out.println("종료 코드 : "+ exitCode);
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} */
%>