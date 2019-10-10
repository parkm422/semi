<%@page import="com.semi.vo.product.Product_ImgVO"%>
<%@page import="com.semi.dao.product.ProductDAO"%>
<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>fileuploadOK.jsp</title>
</head>
<body>
<%
	/*
	MultipartRequest(javax.servlet.http.HttpServletRequest request,
			java.lang.String saveDirectory, 
			int maxPostSize,
			java.lang.String encoding,
			FileRenamePolicy policy)
	  
	*/
	String path = application.getRealPath("/upload");
	MultipartRequest mr = new MultipartRequest(
				request,
				path,
				1024*1024*5,
				"utf-8",
				new DefaultFileRenamePolicy()
			);
	//"multipart/form-data" 인코딩타입으로 전송된 데이터를 request객체를 사용할 수 없고
	//MultipartRequest객체를 사용해서 파라미터값들을 읽어온다.
	String writer = mr.getParameter("writer");
	String title = mr.getParameter("title");
	String content = mr.getParameter("content");
	String fileName = mr.getOriginalFileName("file1");//전송된 파일명
	String saveFileName = mr.getFilesystemName("file1");//저장된 파일명
	// 전송된 파일정보 DB에 저장하기
	ProductDAO dao = ProductDAO.getProductDao();
	File file1 = mr.getFile("file1");// 업로드된 파일에 대한 정보를 갖는 File객체
	long fileSize = file1.length();//업로드된 파일 크기
	Product_ImgVO vo = new Product_ImgVO(0,1,fileName,saveFileName);
	int n = dao.img_insert(vo);
	if(n>0){
		out.print("<h1>DB에 데이터 저장성공!</h1>");
	}else{
		out.print("<h1>DB에 데이터 저장실패!!</h1>");
	}
%>

</body>
</html>