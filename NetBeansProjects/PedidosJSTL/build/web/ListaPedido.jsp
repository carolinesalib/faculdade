<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista pedido</title>
    </head>
    <body>
        <h1>Lista pedido</h1>
        
         <c:forEach var="pedido" items="${pedido.produtos}">
             <div>
                 ${pedido.descricao} - ${pedido.quantidade} - ${pedido.preco}
             </div>
         </c:forEach>
        
        <hr>
        Total do pedido: ${pedido.total}
        </hr>
        
        <a href="index.jsp">Voltar</a>
    </body>
</html>
