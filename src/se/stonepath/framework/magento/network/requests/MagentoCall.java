package se.stonepath.framework.magento.network.requests;

import java.util.ArrayList;

import se.stonepath.framework.xmlrpc.XmlRpcRequest;




public abstract class MagentoCall extends XmlRpcRequest {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = -7130358093496497423L;

	public abstract String callName();
	public abstract ArrayList<Object> getParameters();

	
	public void prepareCall(String sessionKey){
		
		
		
		clear();
		
		add(sessionKey);
		add(callName());
		
		add(getParameters());
		
		/*
		for(Object param : getParameters())
			add(param);
		*/
	}

	@Override
	public String getMethodName() {
		return "call";
	}


}
