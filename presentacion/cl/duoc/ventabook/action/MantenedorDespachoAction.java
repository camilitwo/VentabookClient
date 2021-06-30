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

import cl.ventabook.delegate.LibreriaWS;
import cl.ventabook.dto.DespachoDTO;

import com.google.gson.Gson;

public class MantenedorDespachoAction extends DispatchAction{

	ActionErrors errors = new ActionErrors();
	
	protected ActionForward unspecified(ActionMapping mapping,
			ActionForm aform, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		errors.clear();
		HttpSession session = request.getSession();
		Gson googleJson = new Gson();
		List<DespachoDTO> lista = new ArrayList<DespachoDTO>();
		
		String json = LibreriaWS.obtenerDespachos();
		lista = Arrays.asList(googleJson.fromJson(json, DespachoDTO[].class));
		
		session.setAttribute("listaDespachos", lista);
		return mapping.findForward("MantenedorDespacho");

	}// unspecified
}
