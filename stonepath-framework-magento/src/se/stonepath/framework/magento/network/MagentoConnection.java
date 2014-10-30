package se.stonepath.framework.magento.network;

import java.util.HashMap;

import se.stonepath.framework.magento.network.requests.InvoiceCreateRequest;
import se.stonepath.framework.magento.network.requests.LoginRequest;
import se.stonepath.framework.magento.network.requests.MagentoCall;
import se.stonepath.framework.magento.network.requests.OrderInfoRequest;
import se.stonepath.framework.magento.network.requests.ShipmentCreateRequest;
import se.stonepath.framework.rpcxml.XmlRpcConnection;
import se.stonepath.framework.rpcxml.XmlRpcException;
import se.stonepath.framework.rpcxml.XmlRpcRespond;
import se.stonepath.framework.rpcxml.respond.XmlRpcCollectionRespond;
import se.stonepath.framework.rpcxml.respond.value.XmlRpcStringRespond;


public class MagentoConnection extends XmlRpcConnection{

	public static final long serialVersionUID = 1L;
	
	private String sessionKey;
	
	public MagentoConnection(String connectionUrl) {
		super(connectionUrl + "/index.php/api/xmlrpc/");
	}
	
	public void login(String username,String password) throws InstantiationException, IllegalAccessException, XmlRpcException{
			XmlRpcStringRespond returnSessionKey = sendRequest(new LoginRequest(username, password), XmlRpcStringRespond.class);
			sessionKey = returnSessionKey.getValue();
	}
	
	public String invoiceOrder(int incrementId){
		return invoiceOrder(incrementId, "");
	}
	public String shipOrder(int incrementId){
		return shipOrder(incrementId, "");
	}
	
	public String invoiceOrder(int incrementId,String comment){
		
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
	
	
	public String shipOrder(int incrementId,String comment){
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
	
	public <T extends XmlRpcRespond> T call(MagentoCall call,Class<T> respond){
		
		try {
			call.prepareCall(sessionKey);
			return sendRequest(call,respond);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (XmlRpcException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	
}
