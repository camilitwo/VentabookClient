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
import cl.ventabook.dto.StockDTO;

public class MantenedorStockAction extends DispatchAction{
ActionErrors errors = new ActionErrors();
	
	protected ActionForward unspecified(ActionMapping mapping,
			ActionForm aform, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		errors.clear();
		HttpSession session = request.getSession();
		Gson googleJson = new Gson();
		try {
			List<StockDTO> lista = new ArrayList<StockDTO>();
			String json = LibreriaWS.obtenerStock(null);
			lista = Arrays.asList(googleJson.fromJson(json, StockDTO[].class));
			session.setAttribute("listaStock", lista);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return mapping.findForward("MantenedorStock");

	}// unspecified
	
	public ActionForward agregarModificar(ActionMapping mapping,
			ActionForm aform, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		errors.clear();
		HttpSession session = request.getSession();
		
		
		String accion = request.getParameter("accion");
		String codigoSku = request.getParameter("id");
		String idBodega = request.getParameter("idBodega");
		StockDTO stock = null;
		if("MODIFICAR".equals(accion) || "ELIMINAR".equals(accion)) {
			List<StockDTO> listaStock = (List<StockDTO>)session.getAttribute("listaStock");
			
			for (StockDTO stockdto : listaStock) {
				if(codigoSku.equals(stockdto.getCodigoSku())&& idBodega.equals(stockdto.getIdBodega())){
					stock = stockdto;
					break;
				}
			}
			session.setAttribute("stock", stock);
		}

		session.setAttribute("accionStock", accion);
		
		if(!"ELIMINAR".equals(accion)) {			
			return mapping.findForward("AgregarModficarStockDo");
		}else{
			stock.setAccion("ELIMINAR");
			LibreriaWS.actualizarStock(stock);
			
			return mapping.findForward("MantenedorStockDo");
		}
	}

}
