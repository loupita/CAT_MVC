<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Catalogue</title>
	<link href="css/style.css" rel="stylesheet">
</head>
<body>
	<div>
		<form action="controleur.php" method="post">
			
		<table>
			<tr>
			<td> Mot clé :</td>
			<td><input type="text" name="motCle" value="${model.motCle}"/></td> 
			<td> <input type="submit" value="chercher" name="action"/></td>
		</table>
		</form>
	</div>
	<div>
		<form action="controleur.php" method="post">
			<input type="hidden" value="${model.mode }" name="mode">
		<table>
			<c:if test="${model.mode=='ajout' }">
				<tr>
				<td> REF:</td>
				<td><input type="text" name="reference" value="${model.produit.reference}"  "/></td> 
				<td> </td>
				</tr>
			</c:if>
			<c:if test="${model.mode=='edit' }">
				<tr>
				<td> REF:</td>
				<td>${model.produits.reference}<input type="hidden" name="reference" value="${model.produit.reference}" "/></td> 
				<td> </td>
				</tr>
			</c:if>
			<tr>
			<td> Designation:</td>
			<td><input type="text" name="destination" value="${model.produit.destination}""/></td> 
			<td> </td>
			</tr>
			<tr>
			<td> Prix :</td>
			<td><input type="text" name="prix" value="${model.produit.prix}""/></td> 
			<td> </td>
			</tr>
			<tr>
			<td> Quantité :</td>
			<td><input type="text" name="quantite" value="${model.produit.quantite}""/></td> 
			<td> </td>
			</tr>
			<tr>
			<td><input type="submit" name="action" value="save"></tr>
		</table>
		<div>${model.errors}</div>
		</form>
	</div>
	<div>
		<table class="table1">
		<tr>
			<th>REF</th> <th>DES</th> <th>PRIX</th> <th>QUANTITES</th>
		</tr>
		<c:forEach items="${model.produits}" var="p">
			<tr>
				<td>${ p.reference }</td>
				<td>${ p.destination }</td>
				<td>${ p.prix }</td>
				<td>${ p.quantite }</td>
				<td><a href="controlleur.php?action=delete&ref=${p.reference}">Supprimer</a></td>
				<td><a href="controlleur.php?action=edit&ref=${p.reference}">Editer</a></td>
		</c:forEach>
		</table>
	</div>
</body>
</html>