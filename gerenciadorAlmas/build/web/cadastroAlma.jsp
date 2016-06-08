<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro Alma</title>
        <%@ include file="/menu.html"%>  
    </head>
    <body>
        <div style='width:600px; position: absolute; left: 25%;'>
            <h1>Cadastro de almas</h1>
            <form action="salvaAlma" method="post">
              <div class="form-group">
                  <fieldset class="form-group">
                    <label for="nome">Nome</label>
                    <input type="text" class="form-control" name="nome" id="nome" placeholder="Nome do individuo">
                  </fieldset>
              </div>
              <div class="form-group">
                  <fieldset class="form-group">
                    <label for="pecado">Pecado</label>
                    <input type="text" class="form-control" name="pecado" id="pecado" placeholder="Pecado">
                  </fieldset>
              </div>
              <div class="form-group">
                <label for="status">Status</label>
                  <select class="form-control" name="status" id="status">
                    <option value="1">Céu</option>
                    <option value="2">Inferno</option>
                  </select>
              </div>
              <div class="form-group" style="float:right;">
                <div class="col-sm-offset-2 col-sm-10">
                  <button style="width: 100px" type="submit" class="btn btn-primary">Salvar</button>
                </div>
              </div>
            </form>
        </div>
    </body>
</html>
