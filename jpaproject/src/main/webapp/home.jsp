<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<label>Add:</label><br>
 <form action="addAlien">
  <input type="text" name="aid"><br>
  <input type="text" name="aname"><br>
  <input type="text" name="tech"><br>
  <input type="submit">
 </form>
 <label>Get by ID:</label><br>
 <form action="getAlien">
  <input type="text" name="aid"><br>
  <input type="submit">
 </form>
 <label>Update:</label><br>
 <form action="updateAlien">
  <input type="text" name="aid"><br>
  <input type="text" name="aname"><br>
  <input type="text" name="tech"><br>
  <input type="submit">
 </form>
 <label>Delete ID:</label><br>
 <form action="deleteAlien">
  <input type="text" name="aid"><br>
  <input type="submit">
 </form>
 <label>Get by Tech:</label><br>
 <form action="getByTech">
  <input type="text" name="tech"><br>
  <input type="submit">
 </form>
 <label>Get by ID Greater than:</label><br>
 <form action="getByIdGreaterThan">
  <input type="text" name="aid"><br>
  <input type="submit">
 </form>
 
 <label>Get by Tech Sorted by Name:</label><br>
 <form action="getByTechSorted">
  <input type="text" name="tech"><br>
  <input type="submit">
 </form>
</body>
</html>