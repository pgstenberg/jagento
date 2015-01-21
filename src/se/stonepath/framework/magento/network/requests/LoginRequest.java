package se.stonepath.framework.magento.network.requests;


import se.stonepath.framework.magento.network.MagentoConnection;
import se.stonepath.framework.xmlrpc.XmlRpcRequest;




public class LoginRequest extends XmlRpcRequest{

	private static final long serialVersionUID = MagentoConnection.serialVersionUID;
	
	public LoginRequest(String username,String password){
		add(username);
		add(password);
	}

	@Override
	public String getMethodName() {
		return "login";
	}




}
