package se.stonepath.framework.magento.network.requests;

import java.util.Vector;

import se.stonepath.framework.magento.network.MagentoConnection;
import se.stonepath.framework.xmlrpc.XmlRpcRequest;




public abstract class MagentoCall extends XmlRpcRequest{

	
	private static final long serialVersionUID = MagentoConnection.serialVersionUID;

	@Override
	public String methodName() {
		return "call";
	}

	public abstract String callName();
	public abstract Vector<Object> getParameters();

	
	public void prepareCall(String sessionKey){
		
		clear();
		
		add(sessionKey);
		add(callName());
		
		add(getParameters());
		
	}

}
