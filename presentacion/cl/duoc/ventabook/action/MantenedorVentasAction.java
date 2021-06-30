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
import cl.ventabook.dto.ClienteDTO;
import cl.ventabook.dto.VentasDTO;
import cl.ventabook.utils.Util;

import com.google.gson.Gson;

public class MantenedorVentasAction extends DispatchAction{
	
ActionErrors errors = new ActionErrors();
	
	protected ActionForward unspecified(ActionMapping mapping,
			ActionForm aform, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		errors.clear();
		HttpSession session = request.getSession();
		Gson googleJson = new Gson();
		List<VentasDTO> lista = new ArrayList<VentasDTO>();
		
		String json = LibreriaWS.obtenerVentas();
		lista = Arrays.asList(googleJson.fromJson(json, VentasDTO[].class));
		
		for (VentasDTO ventasDTO : lista) {
			if(ventasDTO.getTotal() != null && ventasDTO.getTotal().trim().length()>0){
				ventasDTO.setTotal(Util.formatPrice(Double.parseDouble(ventasDTO.getTotal())));
			}
		}
		
		session.setAttribute("listaVentas", lista);
		return mapping.findForward("MantenedorVentas");

	}// unspecified

}
