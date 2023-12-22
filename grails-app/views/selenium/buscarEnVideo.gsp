<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <meta name="layout" content="main">
</head>
<body>
    <g:form controller="selenium" action="getVideoData">
        <label for="busqueda">¿Qué deseas buscar?:</label>
        <input type="text" id="busqueda" name="busqueda" /><br /><br />

        <label for="buscarPor">Buscar Por:</label>
        <select name="buscarPor" id="buscarPor">
            <option value="descripcion">Descripción</option>
            <option value="likes">Likes</option>
            <option value="comentarios">Comentarios</option>
        </select><br /><br />

        <input type="submit" value="Buscar" />
    </g:form>
</body>

</html>