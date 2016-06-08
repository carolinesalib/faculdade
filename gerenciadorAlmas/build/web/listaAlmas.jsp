<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/menu.html"%>  
<html>
    <body>
        <div class="col-md-2"></div>
        <div class="col-md-8">
        <table class="table table-striped table-bordered">
            <tr>
                <th>Nome</th>
                <th>Status</th>
                <th>Pecado</th>
            </tr>
            <c:if test="${empty resultadoBusca}">
                <tr>
                <td colspan="3"><i>Não há almas cadastradas.</i></td>
            </c:if>   
            <c:forEach var="alma" items="${resultadoBusca}" varStatus="s">
                <tr>
                <td><a href="editaAlma?id=${s.index}">${alma.nome}</a></td>
                <td>${contato.email}</td>
                <td><a href="removeAlma?id=${s.index}">[X]</a></td>
            </c:forEach>
        </table>
        </div>
        <div class="col-md-2"></div>
    </body>
</html>
