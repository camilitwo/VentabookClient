package cl.ventabook.delegate;

import com.google.gson.Gson;

import cl.ventabook.dto.BodegaDTO;
import cl.ventabook.dto.ClienteDTO;
import cl.ventabook.dto.ResponseDTO;
import cl.ventabook.dto.StockDTO;
import cl.ventabook.dto.VentasDTO;
import cl.ventabook.ws.client.LibreriaImpl;
import cl.ventabook.ws.client.LibreriaImplProxy;

public class LibreriaWS {
	
	public static String obtenerStock(String sku) throws Exception {
		String response = null;
		
		try {
			
			LibreriaImplProxy proxy = new LibreriaImplProxy();
			LibreriaImpl ser = proxy.getLibreriaImpl();
			
			response = ser.obtenerStock(sku);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
		return response;
	}

	public static void actualizarStock(StockDTO stock) throws Exception {
		Gson gson = new Gson();
		String response = null;
		try {
			
			LibreriaImplProxy proxy = new LibreriaImplProxy("http://localhost:8050/ventaBookWS/libros");
			LibreriaImpl ser = proxy.getLibreriaImpl();
			String json = gson.toJson(stock);
			response = ser.actualizarStock(json);
			ResponseDTO resp = gson.fromJson(response, ResponseDTO.class);
			
//			if(!"200".equalsIgnoreCase(resp.getCodigo())){
//				throw new Exception("Error al eliminar");
//			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
		
	}

	public static String obtenerClientes() throws Exception {
		String response = null;
		
		try {
			
			LibreriaImplProxy proxy = new LibreriaImplProxy();
			LibreriaImpl ser = proxy.getLibreriaImpl();
			
			response = ser.obtenerClientes();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
		return response;
	}

	public static void actualizarCliente(ClienteDTO cliente) throws Exception {
		Gson gson = new Gson();
		String response = null;
		try {
			
			LibreriaImplProxy proxy = new LibreriaImplProxy("http://localhost:8050/ventaBookWS/libros");
			LibreriaImpl ser = proxy.getLibreriaImpl();
			String json = gson.toJson(cliente);
			response = ser.actualizarCliente(json);
			ResponseDTO resp = gson.fromJson(response, ResponseDTO.class);
			
//			if(!"200".equalsIgnoreCase(resp.getCodigo())){
//				throw new Exception("Error al eliminar");
//			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

	public static String obtenerVentas() throws Exception {
		String response = null;
		
		try {
			
			LibreriaImplProxy proxy = new LibreriaImplProxy();
			LibreriaImpl ser = proxy.getLibreriaImpl();
			
			response = ser.obtenerVentas(null);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
		return response;
	}

	public static String obtenerDespachos() throws Exception {
		String response = null;
		
		try {
			
			LibreriaImplProxy proxy = new LibreriaImplProxy();
			LibreriaImpl ser = proxy.getLibreriaImpl();
			
			response = ser.obtenerDespacho(null);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
		return response;
	}

	public static String obtenerBodega() throws Exception {
		String response = null;
		
		try {
			
			LibreriaImplProxy proxy = new LibreriaImplProxy();
			LibreriaImpl ser = proxy.getLibreriaImpl();
			
			response = ser.obtenerBodega(null);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
		return response;
	}

	public static void actualizarBodega(BodegaDTO bodega) throws Exception {
		Gson gson = new Gson();
		String response = null;
		try {
			
			LibreriaImplProxy proxy = new LibreriaImplProxy("http://localhost:8050/ventaBookWS/libros");
			LibreriaImpl ser = proxy.getLibreriaImpl();
			String json = gson.toJson(bodega);
			response = ser.actualizarBodega(json);
			ResponseDTO resp = gson.fromJson(response, ResponseDTO.class);
			
//			if(!"200".equalsIgnoreCase(resp.getCodigo())){
//				throw new Exception("Error al eliminar");
//			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
		
	}

	public static void actualizarVentas(VentasDTO venta) throws Exception {
		Gson gson = new Gson();
		String response = null;
		try {
			
			LibreriaImplProxy proxy = new LibreriaImplProxy("http://localhost:8050/ventaBookWS/libros");
			LibreriaImpl ser = proxy.getLibreriaImpl();
			String json = gson.toJson(venta);
			response = ser.actualizarVentas(json);
			ResponseDTO resp = gson.fromJson(response, ResponseDTO.class);
			
//			if(!"200".equalsIgnoreCase(resp.getCodigo())){
//				throw new Exception("Error al eliminar");
//			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
	}

}
