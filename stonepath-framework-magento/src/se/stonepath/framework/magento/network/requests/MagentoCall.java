package se.stonepath.framework.magento.network.requests;

import java.util.Vector;

import se.stonepath.framework.magento.network.MagentoConnection;
import se.stonepath.framework.rpcxml.XmlRpcRequest;




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
		
		//add(parameterVector);
		
	}

	

	
	
	
	/*
	private String callMethod;
	private MagentoConnection connection;
	public MagentoRequest(MagentoConnection connection){
		this(connection,"call");
	}
	public MagentoRequest(MagentoConnection connection,String callMethod){
		this.connection = connection;
		this.callMethod = callMethod;
	}
	
	
	public static Object[] createContent(String sessionKey,String method,Object[] arguments){
		Object[] callParams = new Object[3];
		callParams[0] = sessionKey;
		callParams[1] = method;
		callParams[2] = arguments;
		return callParams;
	}
	public static Object[] createContent(String sessionKey,String method){
		Object[] callParams = new Object[2];
		callParams[0] = sessionKey;
		callParams[1] = method;
		return callParams;
	}
	
	public MagentoRespond execute() throws Exception{
		
		return handleRespond(connection.execute(callMethod, getContent(connection.getSessionKey())));
	}
	
	protected abstract Object[] getContent(String sessionKey);
	protected abstract MagentoRespond handleRespond(Object data);
	*/
}
