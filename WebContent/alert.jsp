<!--登录成功的提示-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html;charset=UTF-8");
	response.setCharacterEncoding("UTF-8");
    String m = (String)application.getAttribute("m");
    %>
<script type="text/javascript">
	alert("<%=m%>");

</script>
<%
	String URL = (String)application.getAttribute("URL");
	response.setHeader("refresh", "0;URL="+URL);

%>