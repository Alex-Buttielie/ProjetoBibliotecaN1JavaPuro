<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
    <title>Manter Livro</title>
</head>
<body bgcolor="#deb887">
<h3> Manter Livro </h3>
<form method="POST" action='LivroController' name="manterLivro">

    <c:if test="${not empty erro}">
        <script language='javascript' type='text/javascript'>alert('<c:out value="${erro}" />');</script>
    </c:if>

    <table>
        <tr>
            <td>Codigo</td>
            <td><input type="text" readonly="readonly" name="codigo"
                       STYLE="font-family: Verdana; font-size: 12px; background-color: #e0e0d1;" size="10" maxlength="10"
                       value="<c:out value="${livro.codigoLivro}" />"/></td>
        </tr>
        <tr>
            <td>Nome</td>
            <td><input type="text" name="nome" value="<c:out value="${livro.nomeLivro}" />"/></td>
        </tr>
        <tr>
            <td>Data publicação</td>
            <td><input type="date" name="quantidade" value="<c:out value="${livro.dataPublicacao}" />"/></td>
        </tr>
        <tr align="center">
            <td><input type="submit" value="Salvar"/></td>
            <td><input type="button" value="Voltar" onclick="history.go(-1)"/></td>
        </tr>

    </table>
</form>
</body>
</html>