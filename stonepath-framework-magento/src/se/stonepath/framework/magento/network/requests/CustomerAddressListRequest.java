package se.stonepath.framework.magento.network.requests;

import java.util.Vector;

import se.stonepath.framework.magento.network.MagentoConnection;



public class CustomerAddressListRequest extends MagentoCall{

	private static final long serialVersionUID = MagentoConnection.serialVersionUID;
	
	private int customerId;
	public CustomerAddressListRequest(int customerId) {
		this.customerId = customerId;
	}
	
	@Override
	public String callName() {
		// TODO Auto-generated method stub
		return "customer_address.list";
	}

	@Override
	public Vector<Object> getParameters() {
		Vector<Object> parameters = new Vector<Object>();
		parameters.add(customerId);
		return parameters;
	}
	/*
	private String customerId;
	public CustomerAddressRequest(MagentoConnection connection,String customerId) {
		super(connection);
		this.customerId = customerId;
	}

	protected Object[] getContent(String sessionKey) {
		Object[] arguments = new Object[1];
		arguments[0] = customerId;
		return MagentoCall.createContent(sessionKey, "customer_address.list", arguments);
	}

	protected MagentoRespond handleRespond(Object data) {
		Object[] addressCollection = (Object[]) data;
		
		
		CollectionRespond respond = new CollectionRespond();
		
		for(Object address : addressCollection){
			
			@SuppressWarnings("unchecked")
			HashMap<Object,Object> addressData = (HashMap<Object,Object>) address;
			HashMap<String,String> inputData = new HashMap<String, String>();
			
		
			inputData.put("address_id", (String)addressData.get("customer_address_id"));
			inputData.put("country_id", (String)addressData.get("country_id"));
			inputData.put("company", (String)addressData.get("company"));
			inputData.put("city", (String)addressData.get("city"));
			inputData.put("street", (String)addressData.get("street"));
			inputData.put("postcode", (String)addressData.get("postcode"));
			inputData.put("telephone", (String)addressData.get("telephone"));
			
			inputData.put("is_default_billing", String.valueOf(addressData.get("is_default_billing")));
			inputData.put("is_default_shipping", String.valueOf(addressData.get("is_default_shipping")));
			 
			
			respond.add(inputData);
			
		}
		
		return respond;
	}
	*/

}
