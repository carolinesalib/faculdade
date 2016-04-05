<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pedidos</title>
    </head>
    <body>
        <form action="pedido" method="post">
            <div>
                <input type="text" placeholder="Descrição" name="descricao"/>
            </div>
            <div>
                <input type="number" placeholder="Preço" name="preco"/>
            </div>
            <div>
                <input type="number" placeholder="Quantidade" name="quantidade"/>
            </div>
            <input type="submit" value="Enviar"/>
        </form>
    </body>
</html>
