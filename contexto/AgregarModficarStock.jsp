<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-nested.tld" prefix="nested" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Producto</title>

<script type="text/javascript">

	function agregarModificar(accion){
		document.AgregarModficarStockForm.action = "AgregarModficarStock.do?do=agregarModificar&accion="+accion;
		document.AgregarModficarStockForm.submit();
	}

</script>

</head>
<body>

<jsp:directive.include file="MenuMantenedores.jsp" />
<html:form action="AgregarModficarStock" method="POST">
<html:hidden property="idProducto"/>
<logic:equal name="AgregarModficarStockForm" property="accion" value="MODIFICAR">
	<html:hidden property="idBodega"/>
</logic:equal>
	<div align="center" style="width: 100%">
		<div class="mt-9" align="center">
			<div class="col-sm-4 mt-5">
				<div class="card border-light mb-3 w-70 shadow-lg p-3 mb-5 bg-body rounded">
					<logic:equal name="AgregarModficarStockForm" property="accion" value="AGREGAR">
						<h5 class="card-header">Agregar Producto</h5>
					</logic:equal>
					<logic:equal name="AgregarModficarStockForm" property="accion" value="MODIFICAR">
						<h5 class="card-header">Modificar Producto</h5>
					</logic:equal>
					<div class="card-body">
						<p class="card-text" align="left">
							<label>Nombre Libro</label>
							<html:text styleClass="form-control sm=12 needs-validation" styleId="nombreProducto"
								property="nombreProducto"/>
								
						</p>
						<p class="card-text" align="left">
							<label>Código SKU</label>
							
							<logic:equal name="AgregarModficarStockForm" property="accion" value="AGREGAR">
								<html:text styleClass="form-control sm=12 needs-validation" styleId="codigoSku"
								property="codigoSku" />
							</logic:equal>
							<logic:equal name="AgregarModficarStockForm" property="accion" value="MODIFICAR">
								<html:text styleClass="form-control sm=12 needs-validation" styleId="codigoSku"
								property="codigoSku" readonly="true"/>
							</logic:equal>
							
						</p>
						<p class="card-text" align="left">
							<label>Bodega</label>
							<logic:equal name="AgregarModficarStockForm" property="accion" value="AGREGAR">
								<html:select styleClass="form-control sm=12 needs-validation form-select" styleId="capitalInvertido"
									property="idBodega" >
										<html:option value="null">Seleccione...</html:option>
										<html:optionsCollection name="listaBodegasCombo" value="idBodega" label="nombre"/>
								</html:select>	
							</logic:equal>
							
							<logic:equal name="AgregarModficarStockForm" property="accion" value="MODIFICAR">
								<html:select styleClass="form-control sm=12 needs-validation form-select" styleId="capitalInvertido"
									property="idBodega" disabled="true">
										<html:option value="null">Seleccione...</html:option>
										<html:optionsCollection name="listaBodegasCombo" value="idBodega" label="nombre"/>
								</html:select>	
							</logic:equal>
								
								
						</p>
						<p class="card-text" align="left">
							<label >Cantidad Stock</label>
							<html:text styleClass="form-control sm=12 needs-validation" styleId="stock"
								property="stock"/>
								
						</p>
						
						<div class="btn-group" >
							<logic:equal name="AgregarModficarStockForm" property="accion" value="MODIFICAR">
								<input type="submit" value="Grabar" class="btn btn-primary"  onclick='javascript:agregarModificar("MODIFICAR")'/>
							</logic:equal>
							<logic:equal name="AgregarModficarStockForm" property="accion" value="AGREGAR">
								<input type="submit" value="Grabar" class="btn btn-primary"  onclick='javascript:agregarModificar("AGREGAR")'/>
							</logic:equal>
							<a class="nav-link" href="MantenedorStock.do">Volver</a>
						</div>
							
					</div>
					
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