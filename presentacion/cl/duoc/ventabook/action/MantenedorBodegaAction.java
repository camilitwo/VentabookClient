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
import cl.ventabook.dto.BodegaDTO;
import cl.ventabook.dto.StockDTO;

import com.google.gson.Gson;

public class MantenedorBodegaAction extends DispatchAction{
	ActionErrors errors = new ActionErrors();
	
	protected ActionForward unspecified(ActionMapping mapping,
			ActionForm aform, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		errors.clear();
		HttpSession session = request.getSession();
		Gson googleJson = new Gson();
		try {
			List<BodegaDTO> lista = new ArrayList<BodegaDTO>();
			String json = LibreriaWS.obtenerBodega();
			lista = Arrays.asList(googleJson.fromJson(json, BodegaDTO[].class));
			session.setAttribute("listaBodega", lista);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return mapping.findForward("MantenedorBodega");

	}// unspecified
	
	public ActionForward agregarModificar(ActionMapping mapping,
			ActionForm aform, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		errors.clear();
		HttpSession session = request.getSession();
		
		
		String accion = request.getParameter("accion");
		String idBodega = request.getParameter("idBodega");
		BodegaDTO stock = null;
		if("MODIFICAR".equals(accion) || "ELIMINAR".equals(accion)) {
			List<BodegaDTO> listaStock = (List<BodegaDTO>)session.getAttribute("listaBodega");
			
			for (BodegaDTO stockdto : listaStock) {
				if(idBodega.equals(stockdto.getIdBodega())){
					stock = stockdto;
					break;
				}
			}
			session.setAttribute("bodega", stock);
		}

		session.setAttribute("accionBodega", accion);
		
		if(!"ELIMINAR".equals(accion)) {			
			return mapping.findForward("AgregarModficarBodegaDo");
		}else{
			stock.setAccion("ELIMINAR");
			LibreriaWS.actualizarBodega(stock);
			
			return mapping.findForward("MantenedorBodegaDo");
		}
	}

}
