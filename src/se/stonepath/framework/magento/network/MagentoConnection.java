package se.stonepath.framework.magento.network;

import java.util.HashMap;

import se.stonepath.framework.magento.network.requests.InvoiceCreateRequest;
import se.stonepath.framework.magento.network.requests.LoginRequest;
import se.stonepath.framework.magento.network.requests.MagentoCall;
import se.stonepath.framework.magento.network.requests.OrderInfoRequest;
import se.stonepath.framework.magento.network.requests.ShipmentCreateRequest;
import se.stonepath.framework.xmlrpc.XmlRpcConnection;
import se.stonepath.framework.xmlrpc.XmlRpcRespond;
import se.stonepath.framework.xmlrpc.respond.XmlRpcCollectionRespond;
import se.stonepath.framework.xmlrpc.respond.value.XmlRpcStringRespond;


public class MagentoConnection extends XmlRpcConnection{

	public static final long serialVersionUID = 1L;
	
	private static final String URL_API = "/index.php/api/xmlrpc/";
	
	private String sessionKey;
	
	private String username,password;
	
	public MagentoConnection(String connectionUrl) {
		super(connectionUrl + URL_API);
		this.username = new String();
		this.password = new String();
	}
	public MagentoConnection(String connectionUrl,String username,String password) {
		super(connectionUrl + URL_API);
		this.username = username;
		this.password = password;
	}
	
	
	public void login(String _username,String _password) throws Exception{
		try{
			XmlRpcStringRespond returnSessionKey = sendRequest(new LoginRequest(_username, _password), XmlRpcStringRespond.class);
			sessionKey = returnSessionKey.getValue();
		
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception("Unable to login to host [" + e.getMessage() + "]");
		}
	}
	public void login() throws Exception{
		try{
			XmlRpcStringRespond returnSessionKey = sendRequest(new LoginRequest(username, password), XmlRpcStringRespond.class);
			sessionKey = returnSessionKey.getValue();
		}catch(Exception e){
			throw new Exception("Unable to login to host [" + e.getMessage() + "]");
		}
	}
	
	
	public String invoiceOrder(int incrementId) throws Exception{
		return invoiceOrder(incrementId, "");
	}
	public String shipOrder(int incrementId) throws Exception{
		return shipOrder(incrementId, "");
	}
	
	public String invoiceOrder(int incrementId,String comment) throws Exception{
		
		OrderInfoRequest orderInfoRequest = new OrderInfoRequest(incrementId);
		XmlRpcCollectionRespond orderInfoRespond = call(orderInfoRequest,XmlRpcCollectionRespond.class);
		
		HashMap<Integer,Double> invoiceQty = new HashMap<Integer,Double>();
		
		for(Object itemObject : (Object[])orderInfoRespond.get("items")){
			@SuppressWarnings("unchecked")
			HashMap<String,Object> itemData = (HashMap<String,Object>)itemObject;
	
			invoiceQty.put(Integer.parseInt((String)itemData.get("item_id")), Double.parseDouble((String)itemData.get("qty_ordered")));	
		}
		
		InvoiceCreateRequest invoiceCreateRequest = new InvoiceCreateRequest(incrementId, invoiceQty,comment);
		XmlRpcStringRespond invoiceCreateRespond = call(invoiceCreateRequest,XmlRpcStringRespond.class);

		return invoiceCreateRespond.getValue();
	}
	
	public boolean orderExists(int incrementId){
		OrderInfoRequest orderIntoRequest = new OrderInfoRequest(incrementId);
		try{
			call(orderIntoRequest, XmlRpcCollectionRespond.class);
		}catch(Exception e){
			if(e.getMessage().toLowerCase().equals("requested order not exists."))
				return false;
		}
		return true;
	}
	
	
	public String shipOrder(int incrementId,String comment) throws Exception{
		OrderInfoRequest orderInfoRequest = new OrderInfoRequest(incrementId);
		XmlRpcCollectionRespond orderInfoRespond = call(orderInfoRequest,XmlRpcCollectionRespond.class);
		
		HashMap<Integer,Double> invoiceQty = new HashMap<Integer,Double>();
		
		for(Object itemObject : (Object[])orderInfoRespond.get("items")){
			@SuppressWarnings("unchecked")
			HashMap<String,Object> itemData = (HashMap<String,Object>)itemObject;
	
			invoiceQty.put(Integer.parseInt((String)itemData.get("item_id")), Double.parseDouble((String)itemData.get("qty_ordered")));	
		}
		
		ShipmentCreateRequest shipmentCreateRequest = new ShipmentCreateRequest(incrementId, invoiceQty,comment);
		XmlRpcStringRespond shipmentCreateRespond = call(shipmentCreateRequest,XmlRpcStringRespond.class);

		return shipmentCreateRespond.getValue();
	}
	
	public <T extends XmlRpcRespond> T call(MagentoCall call,Class<T> respond) throws Exception{
		call.prepareCall(sessionKey);
		
		return sendRequest(call,respond);
	}
	
	
	
}
