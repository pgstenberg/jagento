package se.stonepath.framework.magento.network.requests;

import se.stonepath.framework.magento.network.MagentoConnection;
import se.stonepath.framework.rpcxml.XmlRpcRequest;




public class LoginRequest extends XmlRpcRequest{

	private static final long serialVersionUID = MagentoConnection.serialVersionUID;

	@Override
	public String methodName() {
		return "login";
	}
	
	public LoginRequest(String username,String password){
		add(username);
		add(password);
	}

	/*
	private String username,password;
	public LoginRequest(MagentoConnection connection, String username,String password){
		super(connection,"login");
		this.username = username;
		this.password = password;
	}
	@Override
	public Object[] getContent(String sessionKey) {
		Object[] loginParams = new Object[2];
		loginParams[0] = username;
		loginParams[1] = password;
		
		return loginParams;
	}
	@Override
	protected MagentoRespond handleRespond(Object data) {
		return new StringRespond((String)data);
	}
	*/
}
