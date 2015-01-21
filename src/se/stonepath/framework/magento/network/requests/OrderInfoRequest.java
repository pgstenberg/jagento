package se.stonepath.framework.magento.network.requests;

import java.util.ArrayList;

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
	public ArrayList<Object> getParameters() {
		ArrayList<Object> paramVector = new ArrayList<Object>();
		paramVector.add(incrementId);
		return paramVector;
	}

}
