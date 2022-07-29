<%@page import="modelo.Libro"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="modelo.Editorial" %>
<%@ page import ="java.util.List"%>
<jsp:include page="../plantillas/cabecera.jsp"></jsp:include>

<h2>Edita un libro</h2>

<%
	List<Editorial> listaEditoriales = (List<Editorial>)request.getAttribute("listaEditoriales");
	
	Libro l = (Libro)request.getAttribute("libro");
%>
<form action="libros" method="post" class="estilo-tabla">
	<input type="hidden" name="opcion" value="editar">
	
	<div>
		<label for="isbn">ISBN:</label>
		<input type="text" name="isbn" id="isbn" value="<%=l.getIsbn()%>" readonly/>
	</div>
	<div>
		<label for="titulo">Título:</label>
		<input type="text" name="titulo" id="titulo" value="<%=l.getTitulo()%>" />
	</div>
	<div>
		<label for="CodEditorial">Editorial:</label>
		<select name="codEditorial" id="codEditorial">
			<%
				for (Editorial e: listaEditoriales){
			%>		
				<option value="<%=e.getCodEditorial()%>" 
				<% if(e.getCodEditorial()==l.getCodEditorial()){
					out.println("selected");
				}
				%>
				><%=e.getNombre() %></option>
				<%
				}
				%>
			
						
		</select>
	</div>
	<div>
		<label for="anio">Año:</label>
		<input type="number" name="anio" id="anio" value="<%=l.getAño()%>" min="1900"  />
	</div>
	<div>
		<label for="numPags">Núm. Páginas:</label>
		<input type="text" name="numPags" id="numPags" value="<%=l.getNumPags() %>" />
	</div>
	<div>
		<label for="precio">Precio:</label>
		<input type="text" name="precio" id="precio" value="<%=l.getPrecio() %>" />
	</div>
	<div>
		<label for="cantidad">Cantidad:</label>
		<input type="number" name="cantidad" id="cantidad" value="<%=l.getCantidad() %>" min="1"  />
	</div>
	<div>
		<label for="precioCD">PrecioCD:</label>
		<input type="text" name="precioCD" id="precioCD" value="<%=l.getPrecioCD() %>"/>
	</div>
	
	<div>
		<input type="submit" value="Editar" />
	</div>
</form>


<jsp:include page="../plantillas/pie.jsp"></jsp:include>
