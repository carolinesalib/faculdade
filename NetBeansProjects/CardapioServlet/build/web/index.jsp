<%-- 
    Document   : index
    Created on : 09/03/2016, 21:51:42
    Author     : root
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Cardápio</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  </head>
  <body>
  <H1>Escolha seu cardápio</h1>
<form action="cardapio" method="post">
    <table>
    <tr>
        <td><input type="checkbox" name="opcao" value="20"> Pizza </td>
        <td> R$20,00 </td>
    </tr>
    <tr>
        <td><input type="checkbox" name="opcao" value="5"> Xis salada </td>
        <td> R$5,00 </td>
    </tr>
    <tr>
        <td><input type="checkbox" name="opcao" value="2"> Refri 600ml </td>
        <td> R$2,00 </td>
    </tr>
    <tr>
        <td><input type="checkbox" name="opcao" value="3"> Cerveja </td>
        <td> R$3,00 </td>
    </tr>
    <tr>
        <td><input type="submit" value="Pedir"></td>
    </tr>
</table>
</form>
    </body>
</html>
