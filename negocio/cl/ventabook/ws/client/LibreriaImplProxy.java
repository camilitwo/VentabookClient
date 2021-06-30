package cl.ventabook.ws.client;

public class LibreriaImplProxy implements cl.ventabook.ws.client.LibreriaImpl {
  private String _endpoint = null;
  private cl.ventabook.ws.client.LibreriaImpl libreriaImpl = null;
  
  public LibreriaImplProxy() {
    _initLibreriaImplProxy();
  }
  
  public LibreriaImplProxy(String endpoint) {
    _endpoint = endpoint;
    _initLibreriaImplProxy();
  }
  
  private void _initLibreriaImplProxy() {
    try {
      libreriaImpl = (new cl.ventabook.ws.client.LibrosLocator()).getLibreriaImplPort();
      if (libreriaImpl != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)libreriaImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)libreriaImpl)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (libreriaImpl != null)
      ((javax.xml.rpc.Stub)libreriaImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public cl.ventabook.ws.client.LibreriaImpl getLibreriaImpl() {
    if (libreriaImpl == null)
      _initLibreriaImplProxy();
    return libreriaImpl;
  }
  
  public java.lang.String obtenerDespacho(java.lang.String arg0) throws java.rmi.RemoteException{
    if (libreriaImpl == null)
      _initLibreriaImplProxy();
    return libreriaImpl.obtenerDespacho(arg0);
  }
  
  public java.lang.String actualizarStock(java.lang.String arg0) throws java.rmi.RemoteException{
    if (libreriaImpl == null)
      _initLibreriaImplProxy();
    return libreriaImpl.actualizarStock(arg0);
  }
  
  public java.lang.String obtenerStock(java.lang.String arg0) throws java.rmi.RemoteException{
    if (libreriaImpl == null)
      _initLibreriaImplProxy();
    return libreriaImpl.obtenerStock(arg0);
  }
  
  public java.lang.String obtenerClientes() throws java.rmi.RemoteException{
    if (libreriaImpl == null)
      _initLibreriaImplProxy();
    return libreriaImpl.obtenerClientes();
  }
  
  public java.lang.String obtenerBodega(java.lang.String arg0) throws java.rmi.RemoteException{
    if (libreriaImpl == null)
      _initLibreriaImplProxy();
    return libreriaImpl.obtenerBodega(arg0);
  }
  
  public java.lang.String actualizarBodega(java.lang.String arg0) throws java.rmi.RemoteException{
    if (libreriaImpl == null)
      _initLibreriaImplProxy();
    return libreriaImpl.actualizarBodega(arg0);
  }
  
  public java.lang.String obtenerVentas(java.lang.String arg0) throws java.rmi.RemoteException{
    if (libreriaImpl == null)
      _initLibreriaImplProxy();
    return libreriaImpl.obtenerVentas(arg0);
  }
  
  public java.lang.String actualizarVentas(java.lang.String arg0) throws java.rmi.RemoteException{
    if (libreriaImpl == null)
      _initLibreriaImplProxy();
    return libreriaImpl.actualizarVentas(arg0);
  }
  
  public java.lang.String actualizarDespacho(java.lang.String arg0) throws java.rmi.RemoteException{
    if (libreriaImpl == null)
      _initLibreriaImplProxy();
    return libreriaImpl.actualizarDespacho(arg0);
  }
  
  public java.lang.String actualizarCliente(java.lang.String arg0) throws java.rmi.RemoteException{
    if (libreriaImpl == null)
      _initLibreriaImplProxy();
    return libreriaImpl.actualizarCliente(arg0);
  }
  
  
}