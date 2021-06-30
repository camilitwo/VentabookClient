/**
 * LibrosLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cl.ventabook.ws.client;

public class LibrosLocator extends org.apache.axis.client.Service implements cl.ventabook.ws.client.Libros {

    public LibrosLocator() {
    }


    public LibrosLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public LibrosLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for LibreriaImplPort
    private java.lang.String LibreriaImplPort_address = "http://localhost:8050/ventaBookWS/libros";

    public java.lang.String getLibreriaImplPortAddress() {
        return LibreriaImplPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String LibreriaImplPortWSDDServiceName = "LibreriaImplPort";

    public java.lang.String getLibreriaImplPortWSDDServiceName() {
        return LibreriaImplPortWSDDServiceName;
    }

    public void setLibreriaImplPortWSDDServiceName(java.lang.String name) {
        LibreriaImplPortWSDDServiceName = name;
    }

    public cl.ventabook.ws.client.LibreriaImpl getLibreriaImplPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(LibreriaImplPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getLibreriaImplPort(endpoint);
    }

    public cl.ventabook.ws.client.LibreriaImpl getLibreriaImplPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            cl.ventabook.ws.client.LibreriaImplPortBindingStub _stub = new cl.ventabook.ws.client.LibreriaImplPortBindingStub(portAddress, this);
            _stub.setPortName(getLibreriaImplPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setLibreriaImplPortEndpointAddress(java.lang.String address) {
        LibreriaImplPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (cl.ventabook.ws.client.LibreriaImpl.class.isAssignableFrom(serviceEndpointInterface)) {
                cl.ventabook.ws.client.LibreriaImplPortBindingStub _stub = new cl.ventabook.ws.client.LibreriaImplPortBindingStub(new java.net.URL(LibreriaImplPort_address), this);
                _stub.setPortName(getLibreriaImplPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("LibreriaImplPort".equals(inputPortName)) {
            return getLibreriaImplPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ventabook.soap.com/", "libros");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ventabook.soap.com/", "LibreriaImplPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("LibreriaImplPort".equals(portName)) {
            setLibreriaImplPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
