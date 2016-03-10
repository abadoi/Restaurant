<#-- @ftlvariable name="user" type="eu.kielczewski.example.domain.User" -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>My pets</title>
</head>
<body>
<nav role="navigation">
    <ul>
        <li><a href="/">Home</a></li>
    </ul>
</nav>

<h1>My pets </h1>
<table>
    <thead>
    <tr>
        <th>Pet-name</th>
        <th>Type</th>
    </tr>
    </thead>
    <tbody>
    <#list pets as pet>
    <tr>
        <td>${pet.name}</a></td>
        <td>${pet.type}</td>
    </tr>
    </#list>
    </tbody>
</table>

</body>
</html>