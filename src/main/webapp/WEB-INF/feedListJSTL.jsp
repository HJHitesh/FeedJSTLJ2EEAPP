<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<%@ taglib prefix="custom" uri="http://hitesh/custom-tags"%>

<!DOCTYPE html>
<html>
<head>
<title>Inventory Page</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.3.0/css/bootstrap.min.css">
</head>
<body>
	<div class="container mt-5">
		<h2>
			Current Date and Time:
			<fmt:formatDate value="<%= new java.util.Date() %>"
				pattern="MMMM dd, yyyy, hh:mm a" />
		</h2>

		<h2>Feed Entries</h2>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Title</th>
					<th>Description</th>
					<th>Date</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="feed" items="${feedsList}">
					<tr>
						<td>${feed.title}</td>
						<td>${feed.description}</td>
						<td>${feed.date}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<footer>
			<custom:copyright year="2024" name="Hitesh" />
		</footer>
	</div>
</body>
</html>
