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
        <title>Listar libros</title>
        <script src="https://code.jquery.com/jquery-3.6.0.slim.js" integrity="sha256-HwWONEZrpuoh951cQD1ov2HUK5zA5DwJ1DNUXaM6FsY=" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <link rel="stylesheet" href="resources/css/style.css">
    </head>
    <body>
        <nav class="navbar ml250 navbar-light bg-light">
            <div class="container-fluid">
                
            </div>
        </nav>
        <nav class="nav flex-column main-sidebar bg-dark">
            <a class="logo text-center bg-light mr-0 mb-2" href="libros">
                <img src="resources/img/venta-stock.jpg" alt=""  class="d-inline-block align-text-top img">
            </a>
            <a class="btn btn-outline-light m-2" href="libros">Listar libros</a>
            <a class="btn btn-outline-light m-2" href="libros?action=buscar">Buscar libro</a>
            <a class="btn btn-outline-light m-2" href="libros?action=agregar">Agregar libro</a>
        </nav>
        <div class="content pt-3" >
            <div class="content-header">
                <div class="row mb-2">
                    <div class="col-sm-6">
                        <h1 class="m-0">Bienvenidos a la API WEB</h1>
                    </div><!-- /.col -->
                    <div class="col-sm-6">
                        <ol class="breadcrumb float-sm-right">
                            <li class="breadcrumb-item active">Listar libros</li>
                        </ol>
                    </div><!-- /.col -->
                </div><!-- /.row -->
            </div>
            <div class="card">
                <div class="card-header">
                    <h3>Lista de libros - JSON</h3>
                </div>
                <div class="card-body">
                    <!-- contenido -->
                    <div class="json"></div>
                </div>
            </div>
            <div class="card mt-3">
                <div class="card-header">
                    <h3>Lista de libros</h3>
                </div>
                <div class="card-body">
                    <!-- contenido -->
                    <table class="table table-striped table-hover">
                        <thead>
                            <tr>
                                <td>Id</td>
                                <td>Isbn</td>
                                <td>Título</td>
                                <td>Editorial</td>
                                <td>Año</td>
                                <td>Autor 1</td>
                                <td>Autor 2</td>
                                <td>Precio</td>
                                <td>Acción</td>
                            </tr>
                        </thead>
                        <tbody>

                        </tbody>
                    </table>
                </div>
            </div>
        </div>
            
        </div>

    </body>
    <script src="resources/js/apiConsumeListar.js" type="module"></script>
</html>
