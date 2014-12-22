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

}
