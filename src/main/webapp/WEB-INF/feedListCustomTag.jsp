<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="ft" uri="http://hitesh/custom-tags" %>
<html>
<head>
    <title>Feed List</title>
    <style>
        .feed-entry {
            border: 1px solid #ddd;
            padding: 10px;
            margin: 5px;
        }
    </style>
</head>
<body>
    <h2>Feed List</h2>
    <ft:feedTag feedEntries="${feedsList}" />
</body>
</html>
