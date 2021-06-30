package cl.duoc.ventabook.action;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.google.gson.Gson;

import cl.duoc.ventabook.form.VentaForm;
import cl.ventabook.delegate.LibreriaWS;
import cl.ventabook.dto.ClienteDTO;
import cl.ventabook.dto.StockDTO;
import cl.ventabook.dto.VentasDTO;
import cl.ventabook.utils.Util;

public class VentaAction extends DispatchAction{

	
ActionErrors errors = new ActionErrors();
	
	protected ActionForward unspecified(ActionMapping mapping,
			ActionForm aform, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		errors.clear();
		HttpSession session = request.getSession();
		Gson googleJson = new Gson();
		
		String json = LibreriaWS.obtenerClientes();
		List<ClienteDTO> listaCliente = Arrays.asList(googleJson.fromJson(json, ClienteDTO[].class));
		
		json = LibreriaWS.obtenerStock(null);
		List<StockDTO> listaStock = Arrays.asList(googleJson.fromJson(json, StockDTO[].class));
		
		session.setAttribute("listaClienteCombo", listaCliente);
		session.setAttribute("listaProductosCombo", listaStock);
		
		return mapping.findForward("Venta");

	}// unspecified
	
	
	public ActionForward mostrarDireccion(ActionMapping mapping,
			ActionForm aform, HttpServletRequest request,
			HttpServletResponse response){
		errors.clear();
		VentaForm form = (VentaForm)aform;
		HttpSession session = request.getSession();
		
		String mostrar = request.getParameter("mostrar");
		
		if("M".equalsIgnoreCase(mostrar) || 
				(form.getDireccionDespacho()!=""
				&&form.getDireccionDespacho()!=null
				&& !"O".equalsIgnoreCase(mostrar))){
			List<ClienteDTO> listaCliente = (List<ClienteDTO>)session.getAttribute("listaClienteCombo");
			for (ClienteDTO clienteDTO : listaCliente) {
				if(clienteDTO.getIdCliente().equals(form.getIdCliente())){
					form.setDireccionDespacho(clienteDTO.getDireccion());
				}
			}
		}else{
			form.setDireccionDespacho("");
		}
		
		return mapping.findForward("Venta");
	}
	
	
	public ActionForward mostrarTotal(ActionMapping mapping,
			ActionForm aform, HttpServletRequest request,
			HttpServletResponse response){
		errors.clear();
		VentaForm form = (VentaForm)aform;
		Random random = new Random();
		
		form.setTotal(String.valueOf(random.nextInt(20010)));
		
		form.setTotalFomat(Util.formatPrice(Double.parseDouble(form.getTotal())));
		
		return mapping.findForward("Venta");
	}
	
	
	public ActionForward agregarVenta(ActionMapping mapping,
			ActionForm aform, HttpServletRequest request,
			HttpServletResponse response){
		errors.clear();
		VentaForm form = (VentaForm)aform;
		
		VentasDTO venta = new VentasDTO();
		
		venta.setIdCliente(form.getIdCliente());
		venta.setIdProducto(form.getIdProducto());
		venta.setTipoRetiro(form.getTipoRetiro());
		venta.setTipoComprobante(form.getTipoComprobante());
		venta.setTotal(form.getTotal());
		
		try {
			LibreriaWS.actualizarVentas(venta);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return mapping.findForward("MantenedorVentasDo");
	}
}
