package cl.duoc.ventabook.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.google.gson.Gson;

import cl.ventabook.delegate.LibreriaWS;
import cl.ventabook.dto.ClienteDTO;
import cl.ventabook.dto.StockDTO;

public class MantenedorClienteAction  extends DispatchAction{
	ActionErrors errors = new ActionErrors();
	
	protected ActionForward unspecified(ActionMapping mapping,
			ActionForm aform, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		errors.clear();
		HttpSession session = request.getSession();
		Gson googleJson = new Gson();
		List<ClienteDTO> lista = new ArrayList<ClienteDTO>();
		
		String json = LibreriaWS.obtenerClientes();
		lista = Arrays.asList(googleJson.fromJson(json, ClienteDTO[].class));
		
		session.setAttribute("listaCliente", lista);
		return mapping.findForward("MantenedorCliente");

	}// unspecified
	
	
	public ActionForward agregarModificar(ActionMapping mapping,
			ActionForm aform, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		errors.clear();
		HttpSession session = request.getSession();
		
		
		String accion = request.getParameter("accion");
		String email = request.getParameter("id");
		ClienteDTO cliente = null;
		if("MODIFICAR".equals(accion) || "ELIMINAR".equals(accion)) {
			List<ClienteDTO> listaCliente = (List<ClienteDTO>)session.getAttribute("listaCliente");
			
			for (ClienteDTO clienteDTO : listaCliente) {
				if(email.equals(clienteDTO.getEmail()))
					cliente = clienteDTO;
			}
			session.setAttribute("cliente", cliente);
		}

		session.setAttribute("accionCliente", accion);
		
		if(!"ELIMINAR".equals(accion)) {			
			return mapping.findForward("AgregarModficarClienteDo");
		}else{
			cliente.setAccion("ELIMINAR");
			LibreriaWS.actualizarCliente(cliente);
			
			return mapping.findForward("MantenedorClienteDo");
		}
	}

}
