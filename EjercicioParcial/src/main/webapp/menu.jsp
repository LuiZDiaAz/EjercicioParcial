<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl"
	crossorigin="anonymous">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="ControllerCerrarSession" method="post">
				<button class="btn btn-success " name="btnConsultar"
					value="Consultar">Cerrar Session</button>
			</form>


<script type="text/javascript">

	$(document).ready(function(){
		
		$.post('ControllerConsulta',{
			//Enviar informacion
			
		}, function(response){
			//Recibir informacion
			
			let datos = JSON.parse(response);
			console.log(datos);
			
			var tabla = document.getElementById('tabla');
			for(let item of datos){
				
				tabla.innerHTML += `
				 <tr>
					<td> ${item.Id} </td>
				    <td> ${item.Nombre} </td>
					<td> ${item.Apellido} </td>
					
					<td>
					<a href="ControllerConsulta?usu=${item.Id}" class="btn btn-danger"> Eliminar </a> 

					 
					</td>

				</tr>
				`
				
				console.log(item.Pass);
			}
			
			
		});
	});
	<%
	HttpSession sesion = (HttpSession) request.getSession();
	String usuSession = String.valueOf(sesion.getAttribute("usuario"));

	%>
	</script>
	<table class="table table-dark" id="tabla">
		<thead>
			<th>Id</th>
			<th>Usuario</th>
			<th>Apellido</th>
			
			<th>Acciones</th>
		</thead>
	</table>
</body>
</html>