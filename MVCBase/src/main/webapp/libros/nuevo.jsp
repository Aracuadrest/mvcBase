<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="modelo.Editorial" %>
<%@ page import ="java.util.List"%>
<jsp:include page="../plantillas/cabecera.jsp"></jsp:include>

<h2>Inserta el nuevo libro</h2>

<%
	List<Editorial> listaEditoriales = (List<Editorial>)request.getAttribute("listaEditoriales");
%>
<form action="libros" method="post" class="estilo-tabla">
	<input type="hidden" name="opcion" value="insertar">
	
	<div>
		<label for="isbn">ISBN:</label>
		<input type="text" name="isbn" id="isbn"/>
	</div>
	<div>
		<label for="titulo">Título:</label>
		<input type="text" name="titulo" id="titulo" />
	</div>
	<div>
		<label for="CodEditorial">Editorial:</label>
		<select name="codEditorial" id="codEditorial">
			<%
				for (Editorial e: listaEditoriales){
			%>		
				<option value="<%=e.getCodEditorial()%>"><%=e.getNombre() %></option>
				<%
				}
				%>
				
			
		</select>
	</div>
	<div>
		<label for="anio">Año:</label>
		<input type="number" name="anio" id="anio" value="2020" min="1900"  />
	</div>
	<div>
		<label for="numPags">Núm. Páginas:</label>
		<input type="text" name="numPags" id="numPags" />
	</div>
	<div>
		<label for="precio">Precio:</label>
		<input type="text" name="precio" id="precio" />
	</div>
	<div>
		<label for="cantidad">Cantidad:</label>
		<input type="number" name="cantidad" id="cantidad" value="1" min="1"  />
	</div>
	<div>
		<label for="precioCD">PrecioCD:</label>
		<input type="text" name="precioCD" id="precioCD" />
	</div>
	
	<div>
		<input type="submit" value="Insertar" />
	</div>
</form>


<jsp:include page="../plantillas/pie.jsp"></jsp:include>
