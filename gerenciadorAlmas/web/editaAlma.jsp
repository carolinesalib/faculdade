<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro Alma</title>
        <%@ include file="/menu.html"%>  
    </head>
    <body>
        <div class="col-md-4"></div>
        <div class="col-md-4">
            <h1>Cadastro de almas</h1>
            <form action="salvaAlma" method="post">
              <div class="form-group">
                  <fieldset class="form-group">
                    <label for="id">Código</label>
                    <input readonly class="form-control" name="id" id="id" value="${alma.getId()}"/>
                  </fieldset>
              </div>
              <div class="form-group">
                  <fieldset class="form-group">
                    <label for="nome">Nome</label>
                    <input type="text" class="form-control" name="nome" id="nome" placeholder="Nome do individuo" value="${alma.getNome()}"/>
                  </fieldset>
              </div>
              <div class="form-group">
                  <fieldset class="form-group">
                    <label for="pecado">Pecado</label>
                    <input type="text" class="form-control" name="pecado" id="pecado" placeholder="Pecado" value="${alma.getPecado()}">
                  </fieldset>
              </div>
              <div class="form-group">
                <label for="status">Status</label>
                  <select class="form-control" name="status" id="status" >
                    <option ${alma.getStatus() == 1 ? "selected='selected'" : ''} value="1">Céu</option>
                    <option ${alma.getStatus() == 2 ? "selected='selected'" : ''} value="2">Inferno</option>
                  </select>
              </div>
              <div class="form-group" style="float:right;">
                <div class="col-sm-offset-2 col-sm-10">
                  <button style="width: 100px" type="submit" class="btn btn-primary">Salvar</button>
                </div>
              </div>
            </form>
        </div>
        <div class="col-md-4"></div>
    </body>
</html>
