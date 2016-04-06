<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="mesAniversario" 
	class="aniversario.mesAniversarioServlet" 
	scope="request" />
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>O mês do seu aniversário é:</h1>
        <%= request.getParameter("mes")%>
    </body>
</html>
