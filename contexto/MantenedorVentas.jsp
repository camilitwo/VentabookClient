<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-nested.tld" prefix="nested" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Ventas</title>

<script type="text/javascript">

	function agregarModificar(accion, indice){
		document.MantenedorClienteForm.action = "MantenedorCliente.do?do=agregarModificar&accion="+accion+"&id="+indice;
		document.MantenedorClienteForm.submit();
	}

</script>

</head>
<body>
<jsp:directive.include file="MenuMantenedores.jsp" />
<html:form action="MantenedorVentas" method="POST">

		<div align="center" style="width: 100%">
			
			<div class="mt-9" align="center">
			
				<div class="col-sm-9 mt-5" align="left">
					<div class="card border-light mb-3 w-100 shadow-lg p-3 mb-5 bg-body rounded" align="center">
					
						<table class="table table-striped">
							<thead>
								<tr>
									<th>Id Venta</th>
									<th>Fecha</th>
									<th>Producto</th>
									<th>Cliente</th>
									<th>Tipo Entrega Producto</th>
									<th>Total</th>
									<th/>
									<th/>
								</tr>
							</thead>
							<logic:iterate name="listaVentas" id="indice">
								<tbody class="searchable">
									<tr>
										<td>
											<bean:write name="indice" property="idVenta"/>
										</td>
										<td>
											<bean:write name="indice" property="fecha"/>
										</td>
										<td>
											<bean:write name="indice" property="nombreProducto"/>
										</td>
										<td>
											<bean:write name="indice" property="nombreCliente"/>
										</td>
										<td>
											<bean:write name="indice" property="direccionDespacho"/>
										</td>
										<td>
											<bean:write name="indice" property="total"/>
										</td>
										<td/>
										<td/>
									</tr>
								</tbody>
							</logic:iterate>
						</table>
					
					
					</div>
				</div>
			</div>
		</div>
	
	
</html:form>
</body>


<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
	crossorigin="anonymous"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>

</html:html>