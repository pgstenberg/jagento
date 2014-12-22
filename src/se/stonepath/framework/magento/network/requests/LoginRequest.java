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


}
