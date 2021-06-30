<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-nested.tld" prefix="nested" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Agregar Venta</title>

<script type="text/javascript">

	function agregarVenta(){
		var prueba = 0;
		document.VentaForm.action = "Venta.do?do=agregarVenta&prueba"+prueba;
		document.VentaForm.submit();
	}
	
	function mostrarDireccionEnvio(mostrar){
		document.VentaForm.action = "Venta.do?do=mostrarDireccion&mostrar="+mostrar;
		document.VentaForm.submit();
	}
	
	function mostrarTotal(){
		var prueba = 0;
		document.VentaForm.action = "Venta.do?do=mostrarTotal&prueba="+prueba;
		document.VentaForm.submit();
	}

</script>

</head>
<body>

<jsp:directive.include file="Nav.jsp" />
<html:form action="Venta" method="POST">

<html:hidden property="total"/>

<div align="center" style="width: 100%">
		<div class="mt-9" align="center">
			<div class="col-sm-4 mt-5">
				<div class="card border-light mb-3 w-70 shadow-lg p-3 mb-5 bg-body rounded">
					<h5 class="card-header">Ingreso Nueva Venta</h5>
						
						<p class="card-text" align="left">
							<label>Cliente</label>
							<html:select styleClass="form-control sm=12 needs-validation form-select" styleId="capitalInvertido"
								property="idCliente" onchange="mostrarDireccionEnvio('null')">
									<html:option value="null">Seleccione...</html:option>
									<html:optionsCollection name="listaClienteCombo" value="idCliente" label="nombreCliente"/>
							</html:select>	
								
						</p>
						
						<p class="card-text" align="left">
							<label>Producto</label>
							<html:select styleClass="form-control sm=12 needs-validation form-select" styleId="capitalInvertido"
								property="idProducto" onchange="mostrarTotal();">
									<html:option value="null">Seleccione...</html:option>
									<html:optionsCollection name="listaProductosCombo" value="idProducto" label="nombreProducto"/>
							</html:select>
								
						</p>
						
						<p class="card-text" align="left">
							
						</p>
						
						<p class="card-text" align="left">
							<label>Modalidad de retiro</label>
						</p>
						<p class="card-text" align="left">
							  <html:radio property="tipoRetiro" value="DOMICILIO" styleClass="form-check-input" onclick="mostrarDireccionEnvio('M')"/>
							  <label class="form-check-label" for="flexRadioDefault1">
							    ENVIO DOMICILIO
							  </label>
						</p>
						<p class="card-text" align="left">
							  <html:radio property="tipoRetiro" value="LOCAL" styleClass="form-check-input" onclick="mostrarDireccionEnvio('O')"/>
							  <label class="form-check-label" for="flexRadioDefault1">
							    RETIRO LOCAL
							  </label>
						</p>

						<logic:notEmpty name="VentaForm" property="direccionDespacho">
							<p class="card-text" align="left">
								<label>Dirección</label>
								<html:text styleClass="form-control sm=12 needs-validation" styleId="nombreProducto"
									property="direccionDespacho" readonly="true"/>
							</p>
						</logic:notEmpty>

						<p class="card-text" align="left">
							<label>Comprobante</label>
						</p>
						<p class="card-text" align="left">
							<html:radio property="tipoComprobante" value="BOLETA" styleClass="form-check-input"> BOLETA</html:radio>
						</p>
						<p class="card-text" align="left">
							<html:radio property="tipoComprobante" value="FACTURA" styleClass="form-check-input">FACTURA</html:radio>	
						</p>
						
						<p class="card-text" align="left">
								<label>Total</label>
								<html:text styleClass="form-control sm=12 needs-validation" styleId="nombreProducto"
									property="totalFomat" readonly="true"/>
							</p>
						
						<div class="btn-group" >
							<input type="submit" value="Grabar" class="btn btn-primary"  
							onclick='javascript:agregarVenta()'/>
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