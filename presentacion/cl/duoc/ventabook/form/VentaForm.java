package cl.duoc.ventabook.form;

import org.apache.struts.action.ActionForm;

public class VentaForm extends ActionForm{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String idVenta;
	private String idProducto;
	private String nombreProducto;
	private String idCliente;
	private String nombreCliente;
	private String idDespacho;
	private String direccionDespacho;
	private String tipoComprobante;
	private String fecha;
	private String total;
	private String tipoRetiro;
	private String totalFomat;
	public String getIdVenta() {
		return idVenta;
	}
	public void setIdVenta(String idVenta) {
		this.idVenta = idVenta;
	}
	public String getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public String getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public String getIdDespacho() {
		return idDespacho;
	}
	public void setIdDespacho(String idDespacho) {
		this.idDespacho = idDespacho;
	}
	public String getDireccionDespacho() {
		return direccionDespacho;
	}
	public void setDireccionDespacho(String direccionDespacho) {
		this.direccionDespacho = direccionDespacho;
	}
	public String getTipoComprobante() {
		return tipoComprobante;
	}
	public void setTipoComprobante(String tipoComprobante) {
		this.tipoComprobante = tipoComprobante;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getTipoRetiro() {
		return tipoRetiro;
	}
	public void setTipoRetiro(String tipoRetiro) {
		this.tipoRetiro = tipoRetiro;
	}
	public String getTotalFomat() {
		return totalFomat;
	}
	public void setTotalFomat(String totalFomat) {
		this.totalFomat = totalFomat;
	}
	
	

}