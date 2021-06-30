package cl.duoc.ventabook.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import cl.duoc.ventabook.form.AgregarModficarClienteForm;
import cl.duoc.ventabook.form.AgregarModficarStockForm;
import cl.ventabook.delegate.LibreriaWS;
import cl.ventabook.dto.ClienteDTO;
import cl.ventabook.dto.StockDTO;

public class AgregarModficarClienteAction extends DispatchAction{
	ActionErrors errors = new ActionErrors();
	
	protected ActionForward unspecified(ActionMapping mapping,
			ActionForm aform, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		errors.clear();
		HttpSession session = request.getSession();
		AgregarModficarClienteForm form = (AgregarModficarClienteForm)aform;
		
		form.setAccion((String)session.getAttribute("accionCliente"));
		
		if("MODIFICAR".equals(form.getAccion())) {
			ClienteDTO cliente = (ClienteDTO)session.getAttribute("cliente");
			form.setNombreCliente(cliente.getNombreCliente());
			form.setEmail(cliente.getEmail());
			form.setDireccion(cliente.getDireccion());
			form.setTelefono(cliente.getTelefono());
		}
		return mapping.findForward("AgregarModficarCliente");

	}// unspecified
	
	
	
	public ActionForward agregarModificar(ActionMapping mapping,
			ActionForm aform, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		errors.clear();
		
		AgregarModficarClienteForm form = (AgregarModficarClienteForm) aform;
		String accion = request.getParameter("accion");
		ClienteDTO cliente = new ClienteDTO();
		
		cliente.setAccion(accion);
		cliente.setDireccion(form.getDireccion());
		cliente.setEmail(form.getEmail());
		cliente.setNombreCliente(form.getNombreCliente());
		cliente.setTelefono(form.getTelefono());
		
		LibreriaWS.actualizarCliente(cliente);
		
		return mapping.findForward("MantenedorClienteDo"); 
	}
}
