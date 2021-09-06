
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Lista de Livros</title>
</head>
<body bgcolor="#deb887">
<h3> Lista de Livros </h3>
<form method="GET" action='EmprestimoController' name="listarEmprestimo">

    <table border="1">
        <thead>
        <tr>
            <th>Código</th>
            <th>Nome Livro</th>
            <th>Data Publicação</th>
            <th>Código Emprestimo</th>
            <th>Data Emprestimo</th>
            <th>Observação Emprestimo</th>
            <th>Código Pessoa</th>
            <th>Nome Pessoa</th>
            <th>Emprestimo ativo</th>
            <th>Devolver livro</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${emprestimos}" var="emprestimo">
            <tr>
                <td><c:out value="${emprestimo.codigolivro}"/></td>
                <td><c:out value="${emprestimo.nomelivro}"/></td>
                <td><c:out value="${emprestimo.datapublicacao}"/></td>
                <td><c:out value="${emprestimo.codigoemprestimo}"/></td>
                <td><c:out value="${emprestimo.dataemprestimo}"/></td>
                <td><c:out value="${emprestimo.observacao}"/></td>
                <td><c:out value="${emprestimo.codpessoa}"/></td>
                <td><c:out value="${emprestimo.nomepessoa}"/></td>
                <td><c:out value="${emprestimo.isemprestimoativo}"/></td>
                <td><a href="EmprestimoController?acao=devolver&codigoemprestimo=<c:out value="${emprestimo.codigoemprestimo}"/>">Devolver</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</form>
</body>
</html>
