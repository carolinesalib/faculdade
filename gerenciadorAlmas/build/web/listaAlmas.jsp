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
                <th>Ações</th>
            </tr>
            <c:if test="${empty resultadoBusca}">
                <tr>
                <td colspan="3"><i>Não há almas cadastradas.</i></td>
                </tr>
            </c:if>   
            <c:forEach var="alma" items="${resultadoBusca}" varStatus="s">
                <tr>
                <td><a href="editaAlma?id=${alma.id}">${alma.nome}</a></td>
                <td>${alma.status == 1 ? "Céu" : "Inferno"}</td>
                <td>${alma.pecado}</td>
                <td><a class="btn btn-primary btn-xs glyphicon glyphicon-pencil" href="editaAlma?id=${alma.id}" role="button"></a>
                    <a class="btn btn-danger btn-xs glyphicon glyphicon-trash" href="excluirAlma?id=${alma.id}" role="button"></a>
                </td>
                </tr>
            </c:forEach>
        </table>
        </div>
        <div class="col-md-2"></div>
    </body>
</html>
