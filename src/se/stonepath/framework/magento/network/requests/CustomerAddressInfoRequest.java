package se.stonepath.framework.magento.network.requests;

import java.util.Vector;

import se.stonepath.framework.magento.network.MagentoConnection;

public class CustomerAddressInfoRequest extends MagentoCall{

	private static final long serialVersionUID = MagentoConnection.serialVersionUID;
	
	
	private int addressId;
	public CustomerAddressInfoRequest(int addressId) {
		this.addressId = addressId;
	}
	
	@Override
	public String callName() {
		// TODO Auto-generated method stub
		return "customer_address.info";
	}

	@Override
	public Vector<Object> getParameters() {
		Vector<Object> parameters = new Vector<Object>();
		parameters.add(addressId);
		return parameters;
	}

}
