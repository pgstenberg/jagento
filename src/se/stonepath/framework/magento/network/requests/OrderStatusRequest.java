package se.stonepath.framework.magento.network.requests;

import java.util.ArrayList;

import se.stonepath.framework.magento.network.MagentoConnection;

public class OrderStatusRequest extends MagentoCall{

	private static final long serialVersionUID = MagentoConnection.serialVersionUID;
	
	private int incrementId;
	private String status;
	private String message;
	private boolean notify;
	
	public OrderStatusRequest(int incrementId,String status,String message,boolean notify) {
		this.incrementId = incrementId;
		this.status = status;
		this.message = message;
		this.notify = notify;
	}
	public OrderStatusRequest(int incrementId,String status) {
		this(incrementId,status,"",false);
	}
	public OrderStatusRequest(int incrementId,String status,String message) {
		this(incrementId,status,message,false);
	}
	public OrderStatusRequest(int incrementId,String status,boolean notify) {
		this(incrementId,status,"",notify);
	}
	
	@Override
	public String callName() {
		return "sales_order.addComment";
	}

	@Override
	public ArrayList<Object> getParameters() {
		ArrayList<Object> params = new ArrayList<Object>();
		params.add(incrementId);
		params.add(status);
		
		if(!message.equals(""))
			params.add(message);
		if(notify)
			params.add(notify);
		
		return params;
	}

}
