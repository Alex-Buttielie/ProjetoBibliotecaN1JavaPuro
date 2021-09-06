
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Livros</title>
    </head>
    <body bgcolor="#deb887">
        <h3> Lista de Livros </h3>
        <form method="POST" action='EmprestimoController' name="emprestarLivro">
            
            <table border="1">
                <thead>
                    <tr>
                        <th>Código Livro</th>
                        <th>Nome Livro</th>
                        <th>Data Publicação</th>
                    </tr>
                </thead>
                <tbody>
                        <tr>
                            <td><c:out value="${livro.codigoLivro}"/></td>
                            <td><c:out value="${livro.nomeLivro}"/></td>
                            <td><c:out value="${livro.dataPublicacao}"/></td>
                        </tr>
                </tbody>
            </table>

            <table>
                <tr>
                    <td>Codigo Livro a ser emprestado</td>
                    <td><input type="number"  name="codLivroEmprestimo"
                               size="10" maxlength="10"
                               value="<c:out value="${emprestimo.codLivroEmprestimo}" />"/></td>
                </tr>
                <tr>
                    <td>Codigo Emprestimo</td>
                    <td><input type="text" readonly="readonly" name="codEmprestimo"
                               STYLE="font-family: Verdana; font-size: 12px; background-color: #e0e0d1;" size="10" maxlength="10"
                               value="<c:out value="${emprestimo.codEmprestimo}" />"/></td>
                </tr>
                <tr>
                    <td>Codigo Pessoa</td>
                    <td><input type="text" readonly="readonly" name="codPessoaEmprestimo"
                               STYLE="font-family: Verdana; font-size: 12px; background-color: #e0e0d1;" size="10" maxlength="10"
                               value="<c:out value="${emprestimo.codPessoaEmprestimo}" />"/></td>
                </tr>
                <tr>
                    <td>Nome Pessoa</td>
                    <td><input type="text" name="nomePessoa" value="<c:out value="${emprestimo.nomePessoa}" />"/></td>
                </tr>
                <tr>
                    <td>Data Emprestimo</td>
                    <td><input type="date" name="dataEmprestimo" value="<c:out value="${emprestimo.dataEmprestimo}" />"/></td>
                </tr>
                <tr>
                    <td>Observação emprestimo</td>
                    <td><input type="text" name="observacao" value="<c:out value="${emprestimo.observacao}" />"/></td>
                </tr>
                <tr align="center">
                    <td><input type="submit" value="Salvar"/></td>
                    <td><input type="button" value="Voltar" onclick="history.go(-1)"/></td>
                </tr>
            </table>
        </form>
    </body>
</html>
