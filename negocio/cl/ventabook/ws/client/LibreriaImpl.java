/**
 * LibreriaImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cl.ventabook.ws.client;

public interface LibreriaImpl extends java.rmi.Remote {
    public java.lang.String obtenerDespacho(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String actualizarStock(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String obtenerStock(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String obtenerClientes() throws java.rmi.RemoteException;
    public java.lang.String obtenerBodega(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String actualizarBodega(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String obtenerVentas(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String actualizarVentas(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String actualizarDespacho(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String actualizarCliente(java.lang.String arg0) throws java.rmi.RemoteException;
}
