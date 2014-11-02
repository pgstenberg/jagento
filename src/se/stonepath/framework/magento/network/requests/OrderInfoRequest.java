package se.stonepath.framework.magento.network.requests;

import java.util.Vector;

import se.stonepath.framework.magento.network.MagentoConnection;



public class OrderInfoRequest extends MagentoCall{

	
	private static final long serialVersionUID = MagentoConnection.serialVersionUID;
	
	private int incrementId;
	
	public OrderInfoRequest(int incrementId){
		this.incrementId = incrementId;
	}

	@Override
	public String callName() {
		return "sales_order.info";
	}

	@Override
	public Vector<Object> getParameters() {
		Vector<Object> paramVector = new Vector<Object>();
		paramVector.add(incrementId);
		return paramVector;
	}



	/*
	private String orderNumber;
	public OrderInfoRequest(MagentoConnection connection,String orderNumber) {
		super(connection);
		this.orderNumber = orderNumber;
	}

	@Override
	protected Object[] getContent(String sessionKey) {
		Object[] arguments = new Object[1];
		arguments[0] = orderNumber;
		return MagentoRequest.createContent(sessionKey, "order.info", arguments);
	}

	@Override
	protected MagentoRespond handleRespond(Object data) {
		@SuppressWarnings("unchecked")
		HashMap<Object,Object> orderInfo = (HashMap<Object,Object>) data;
		
		GenericCollectionRespond collectionRespond = new GenericCollectionRespond();
		
		Iterator<Entry<Object, Object>> itr = orderInfo.entrySet().iterator();
		while(itr.hasNext()){	
				Entry<Object,Object> nextEntry = itr.next();
				collectionRespond.addData((String)nextEntry.getKey(), nextEntry.getValue());
		}
		
		return collectionRespond;
	}
	*/
}
