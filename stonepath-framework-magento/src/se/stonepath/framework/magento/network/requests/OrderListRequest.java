package se.stonepath.framework.magento.network.requests;

import java.util.Vector;

import se.stonepath.framework.magento.network.MagentoConnection;

public class OrderListRequest extends MagentoCall{

	private static final long serialVersionUID = MagentoConnection.serialVersionUID;

	@Override
	public String callName() {
		return "sales_order.list";
	}

	@Override
	public Vector<Object> getParameters() {
		// TODO Auto-generated method stub
		return new Vector<Object>();
	}

	/*
	public OrderListRequest(MagentoConnection connection) {
		super(connection);
	}

	@Override
	protected Object[] getContent(String sessionKey) {
		return MagentoCall.createContent(sessionKey, "order.list");
	}

	@Override
	protected MagentoRespond handleRespond(Object data) {
		Object[] orderCollection = (Object[]) data;
		
		CollectionRespond respond = new CollectionRespond();
		
		for(Object order : orderCollection){
			@SuppressWarnings("unchecked")
			HashMap<Object,Object> orderData = (HashMap<Object,Object>) order;
			HashMap<String,String> orderInputData = new HashMap<String, String>();
			
			Iterator<Entry<Object, Object>> iterator = orderData.entrySet().iterator();
			
			while(iterator.hasNext()){
				Entry<Object,Object> entry = iterator.next();
				orderInputData.put((String)entry.getKey(), (String)entry.getValue());
			}
			
			
			
			respond.add(orderInputData);
		}
		
		return respond;
	}
	*/
}
