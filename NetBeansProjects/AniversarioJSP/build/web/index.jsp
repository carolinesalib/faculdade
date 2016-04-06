<%@page import="aniversario.Mes"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Aniversário</title>
    </head>
    <body>
        <h1>JSP Aniversário</h1>
        
        <form action="mesAniversario" method="post">
            <p>Selecione o mês do seu aniversário</p>
            <div style="margin-bottom: 10px">
                <select name="mes">
                    <% for (String mes : Mes.meses) {%>
                    <option value=<%=mes%>><%=mes%></option>
                    <%}%>
                </select>
            </div>
            <div>
                <input type="submit" value="Enviar"/>
            </div>
        </form>
    </body>
</html>
