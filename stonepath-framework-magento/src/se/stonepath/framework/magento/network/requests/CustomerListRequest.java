package se.stonepath.framework.magento.network.requests;

import java.util.Vector;

import se.stonepath.framework.magento.network.MagentoConnection;




public class CustomerListRequest extends MagentoCall{

	
	private static final long serialVersionUID = MagentoConnection.serialVersionUID;
	
	@Override
	public String callName() {
		return "customer.list";
	}

	@Override
	public Vector<Object> getParameters() {
		// TODO Auto-generated method stub
		return new Vector<Object>();
	}
/*
	private HashMap<String, String> filter;
	public CustomerListRequest(MagentoConnection connection,HashMap<String,String> filter) {
		super(connection);
		this.filter = filter;
	}

	protected Object[] getContent(String sessionKey) {
		return MagentoCall.createContent(sessionKey, "customer.list");
	}

	protected MagentoRespond handleRespond(Object data) {
		Object[] customerCollection = (Object[]) data;
		
		CollectionRespond respond = new CollectionRespond();
		
		for(Object customer : customerCollection){
			
			@SuppressWarnings("unchecked")
			HashMap<Object,Object> customerData = (HashMap<Object,Object>) customer;
			
			HashMap<String,String> inputData = new HashMap<String, String>();
			
			inputData.put("customer_id",(String)customerData.get("customer_id"));
			
			Iterator<Entry<String, String>> filterIterator = filter.entrySet().iterator();
			
			 while (filterIterator.hasNext()) {
				 Map.Entry<String,String> entry = (Map.Entry<String,String>)filterIterator.next();
				 
				 if(customerData.containsKey(entry.getValue()))
					 inputData.put(entry.getKey(), (String)customerData.get(entry.getValue()));
				 else
					 inputData.put(entry.getKey(), "");
			 }
			
			
			respond.add(inputData);
			
			
		}
		
		
		return respond;
	}
	
	*/

}
