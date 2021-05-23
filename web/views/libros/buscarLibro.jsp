<%-- 
    Document   : index
    Created on : 22-05-2021, 17:18:11
    Author     : Diego
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Buscar libro</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>
        
        <link rel="stylesheet" href="resources/css/style.css">
    </head>
    <body>
        <nav class="navbar navbar-light bg-light">
            <div class="container-fluid">
                
            </div>
        </nav>
        <nav class="nav flex-column main-sidebar bg-dark">
            <a class="logo text-center bg-light mr-0 mb-2" href="libros">
                <img src="resources/img/venta-stock.jpg" alt=""  class="d-inline-block align-text-top img">
            </a>
            <a class="btn btn-outline-light m-2" href="libros">Listar libros</a>
            <a class="btn btn-outline-light m-2" href="libros?action=buscar">Buscar libro</a>
            <a class="btn btn-outline-light m-2" href="#">Agregar libro</a>
        </nav>
        <div class="content pt-3" >
            <div class="content-header">
                <div class="row mb-2">
                    <div class="col-sm-6">
                        <h1 class="m-0">Bienvenidos a la API WEB</h1>
                    </div><!-- /.col -->
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item active">Buscar libro</li>
                        </ol>
                    </div><!-- /.col -->
                </div><!-- /.row -->
            </div>
            <div class="card">
                <div class="card-header">
                    <h3>Buscar libro</h3>
                </div>
                <div class="card-body">
                    <!-- contenido -->
                    <form method="post">
                        <div class="mb-3">
                            <label for="id">Ingrese id del libro</label>
                            <input id="id" type="text" class="form-control">
                        </div>
                        
                        <button type="submit" class="btn btn-primary">Buscar</button>
                    </form>
                    
                </div>
            </div>
        </div>
            
        </div>

    </body>
    <script src="resources/js/apiconsume.js"></script>
</html>