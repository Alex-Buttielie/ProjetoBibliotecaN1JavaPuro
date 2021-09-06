
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Livros</title>
    </head>
    <body bgcolor="#deb887">
        <h3> Lista de Livros </h3>
        <form method="GET" action='LivroController' name="listarLivro">
            
            <table border="1">
                <thead>
                    <tr>
                        <th>Código</th>
                        <th>Nome Livro</th>
                        <th>Data Publicação</th>
                        <th colspan="5">Ação</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${livros}" var="livro">
                        <tr>
                            <td><c:out value="${livro.codigoLivro}"/></td>
                            <td><c:out value="${livro.nomeLivro}"/></td>
                            <td><c:out value="${livro.dataPublicacao}"/></td>
                            <td><a href="LivroController?acao=alterar&codigoLivro=<c:out value="${livro.codigoLivro}"/>">Alterar</a></td>
                            <td><a href="LivroController?acao=excluir&codigoLivro=<c:out value="${livro.codigoLivro}"/>" onclick="return confirm('Confirma a exclusão?')">Excluir</a></td>
                            <td><a href="LivroController?acao=emprestar&codigoLivro=<c:out value="${livro.codigoLivro}"/>" onclick="return confirm('Deseja emprestar?')">Emprestar</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
                <tfoot>
                <td align="center"><a href="LivroController?acao=incluir=">Novo Livro</a>
                </td>
                </tfoot>
            </table>
        </form>
    </body>
</html>
