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

	function agregarModificar(accion, idBodega){
		
		document.MantenedorBodegaForm.action = "MantenedorBodega.do?do=agregarModificar&accion="+accion+"&idBodega="+idBodega;
		document.MantenedorBodegaForm.submit();
	}

</script>

</head>
<body>
<jsp:directive.include file="MenuMantenedores.jsp" />
<html:form action="MantenedorBodega" method="POST">

		<div align="center" style="width: 100%">
			
			<div class="mt-9" align="center">
			
				<div class="col-sm-7 mt-5" align="left">
					<ul class="nav flex-column"  >
			  <li class="nav-item">
			    <a class="nav-link active" onclick="agregarModificar('AGREGAR', null);" style="cursor: pointer;">Agregar Centro de Almacenaje</a>
			  </li>
			</ul>
					<div class="card border-light mb-3 w-100 shadow-lg p-3 mb-5 bg-body rounded" align="center">
					
						<table class="table table-striped">
							<thead>
								<tr>
									<th>ID Bodega</th>
									<th>Nombre Local</th>
									<th>Estado</th>
									<th/>
									<th/>
									<th/>
								</tr>
							</thead>
							<logic:iterate name="listaBodega" id="indice">
								<tbody class="searchable">
									<tr>
										<td>
											<bean:write name="indice" property="idBodega"/>
										</td>
										<td>
											<bean:write name="indice" property="nombre"/>
										</td>
										<td>
											<bean:write name="indice" property="estado"/>
										</td>
										<td/>
										<td/>
										<td>
										<div class="btn-group mb-3">
								              <button type="submit" class="btn btn-outline-secondary" name="actualizar"
								              	onclick='javascript:agregarModificar("MODIFICAR", 
								              	"<bean:write name='indice' property='idBodega'/>")'>
								              	Actualizar
								              </button>
								               <button type="submit" class="btn btn-outline-secondary" name="actualizar"
								               onclick='javascript:agregarModificar("ELIMINAR", 
								              	"<bean:write name='indice' property='idBodega'/>")'>
								              	Eliminar
								              </button>
							            </div>
									</td>
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