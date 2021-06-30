package cl.duoc.ventabook.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import cl.duoc.ventabook.form.AgregarModficarBodegaForm;
import cl.duoc.ventabook.form.AgregarModficarStockForm;
import cl.ventabook.delegate.LibreriaWS;
import cl.ventabook.dto.BodegaDTO;
import cl.ventabook.dto.StockDTO;

public class AgregarModficarBodegaAction extends DispatchAction{
	ActionErrors errors = new ActionErrors();
	
	protected ActionForward unspecified(ActionMapping mapping,
			ActionForm aform, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		errors.clear();
		HttpSession session = request.getSession();
		AgregarModficarBodegaForm form = (AgregarModficarBodegaForm)aform;
		
		form.setAccion((String)session.getAttribute("accionBodega"));
		
		if("MODIFICAR".equals(form.getAccion())) {
			BodegaDTO bodega = (BodegaDTO)session.getAttribute("bodega");
 			form.setIdBodega(bodega.getIdBodega());
 			form.setEstado(bodega.getEstado());
 			form.setNombre(bodega.getNombre());
		}
		return mapping.findForward("AgregarModficarBodega");

	}// unspecified
	
	
	public ActionForward agregarModificar(ActionMapping mapping,
			ActionForm aform, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		errors.clear();
		
		AgregarModficarBodegaForm form = (AgregarModficarBodegaForm) aform;
		String accion = request.getParameter("accion");
		BodegaDTO bodega = new BodegaDTO();
		
		bodega.setAccion(accion);
		bodega.setIdBodega(form.getIdBodega());
		bodega.setEstado(form.getEstado());
		bodega.setNombre(form.getNombre());
		
		LibreriaWS.actualizarBodega(bodega);
		
		return mapping.findForward("MantenedorBodegaDo"); 
	}

}
