<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="modelo.Editorial" %>
<%@ page import ="java.util.List"%>

<jsp:include page="../plantillas/cabecera.jsp"></jsp:include>

<h2>Listado de editoriales</h2>

<% List<Editorial> lista = (List<Editorial>)request.getAttribute("listaEditoriales"); 
	if (lista==null || lista.size()==0){
		%>
		<h3> No se han encontrado editoriales</h3>
<%
	} else{
		%>
		<table class="estilo-tabla">	
		<tr>
			<th>Cod. Editorial</th>
			<th>Nombre</th>
			<th>Año</th>
		
		</tr>
		<%
		for(Editorial ed : lista){
			%>
			<tr>
				<td><%=ed.getCodEditorial() %></td>
				<td><%=ed.getNombre() %></td>
				<td><%= ed.getAño()%></td>
			
			</tr>
			<%
			}
		%>
		</table>
		<%
	}	
		%>


<jsp:include page="../plantillas/pie.jsp"></jsp:include>
