package cl.duoc.ventabook.action;

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

import cl.duoc.ventabook.form.AgregarModficarStockForm;
import cl.ventabook.delegate.LibreriaWS;
import cl.ventabook.dto.BodegaDTO;
import cl.ventabook.dto.StockDTO;

public class AgregarModficarStockAction extends DispatchAction{
	
ActionErrors errors = new ActionErrors();
	
	protected ActionForward unspecified(ActionMapping mapping,
			ActionForm aform, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		errors.clear();
		HttpSession session = request.getSession();
		AgregarModficarStockForm form = (AgregarModficarStockForm)aform;
		Gson googleJson = new Gson();
		form.setAccion((String)session.getAttribute("accionStock"));
		
		if("MODIFICAR".equals(form.getAccion())) {
			StockDTO stock = (StockDTO)session.getAttribute("stock");
			form.setCodigoSku(stock.getCodigoSku());
 			form.setIdBodega(stock.getIdBodega());
			form.setNombreLocal(stock.getNombreLocal());
			form.setNombreProducto(stock.getNombreProducto());
			form.setStock(stock.getStock());
			form.setIdProducto(stock.getIdProducto());
		}
		
		String json = LibreriaWS.obtenerBodega();
		List<BodegaDTO> listaBodegas = Arrays.asList(googleJson.fromJson(json, BodegaDTO[].class));
		session.setAttribute("listaBodegasCombo", listaBodegas);
		
		return mapping.findForward("AgregarModficarStock");

	}// unspecified
	
	
	public ActionForward agregarModificar(ActionMapping mapping,
			ActionForm aform, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		errors.clear();
		
		AgregarModficarStockForm form = (AgregarModficarStockForm) aform;
		String accion = request.getParameter("accion");
		StockDTO stock = new StockDTO();
		
		stock.setAccion(accion);
		stock.setCodigoSku(form.getCodigoSku());
		stock.setIdBodega(form.getIdBodega());
		stock.setIdProducto(form.getIdProducto());
		stock.setNombreLocal(form.getNombreLocal());
		stock.setNombreProducto(form.getNombreProducto());
		stock.setStock(form.getStock());
		
		LibreriaWS.actualizarStock(stock);
		
		return mapping.findForward("MantenedorStockDo"); 
	}

}
