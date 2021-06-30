<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/struts-nested.tld" prefix="nested" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<html:html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Bodega</title>

<script type="text/javascript">

	function agregarModificar(accion){
		document.AgregarModficarBodegaForm.action = "AgregarModficarBodega.do?do=agregarModificar&accion="+accion;
		document.AgregarModficarBodegaForm.submit();
	}

</script>

</head>
<body>

<jsp:directive.include file="MenuMantenedores.jsp" />
<html:form action="AgregarModficarBodega" method="POST">
	<div align="center" style="width: 100%">
		<div class="mt-9" align="center">
			<div class="col-sm-4 mt-5">
				<div class="card border-light mb-3 w-70 shadow-lg p-3 mb-5 bg-body rounded">
					<logic:equal name="AgregarModficarBodegaForm" property="accion" value="AGREGAR">
						<h5 class="card-header">Agregar Bodega</h5>
					</logic:equal>
					<logic:equal name="AgregarModficarBodegaForm" property="accion" value="MODIFICAR">
						<h5 class="card-header">Modificar Bodega</h5>
					</logic:equal>
					<div class="card-body">
						<logic:equal name="AgregarModficarBodegaForm" property="accion" value="MODIFICAR">
							<p class="card-text" align="left">
								<label>ID Bodega</label>
								<html:text styleClass="form-control sm=12 needs-validation" styleId="codigoSku"
								property="idBodega" readonly="true"/>							
							</p>
						</logic:equal>
						
						<p class="card-text" align="left">
							<label>Nombre Bodega</label>
							<html:text styleClass="form-control sm=12 needs-validation" styleId="nombreProducto"
								property="nombre"/>
								
						</p>
						
						<logic:equal name="AgregarModficarBodegaForm" property="accion" value="MODIFICAR">
							<p class="card-text" align="left">
								<label>Estado Bodega</label>
								<html:select styleClass="form-control sm=12 needs-validation form-select" styleId="capitalInvertido"
									property="estado" >
										<html:option value="ACTIVO">ACTIVO</html:option>
										<html:option value="NO ACTIVO">NO ACTIVO</html:option>
								</html:select>							
							</p>
						</logic:equal>
						
						<div class="btn-group" >
							<logic:equal name="AgregarModficarBodegaForm" property="accion" value="MODIFICAR">
								<input type="submit" value="Grabar" class="btn btn-primary"  onclick='javascript:agregarModificar("MODIFICAR")'/>
							</logic:equal>
							<logic:equal name="AgregarModficarBodegaForm" property="accion" value="AGREGAR">
								<input type="submit" value="Grabar" class="btn btn-primary"  onclick='javascript:agregarModificar("AGREGAR")'/>
							</logic:equal>
							<a class="nav-link" href="MantenedorBodega.do">Volver</a>
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