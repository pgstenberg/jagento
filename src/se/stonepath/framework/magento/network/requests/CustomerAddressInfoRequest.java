package se.stonepath.framework.magento.network.requests;

import java.util.ArrayList;

public class CustomerAddressInfoRequest extends MagentoCall{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3243827152241620754L;
	
	
	private int addressId;
	public CustomerAddressInfoRequest(int addressId) {
		this.addressId = addressId;
	}
	
	@Override
	public String callName() {
		return "customer_address.info";
	}

	@Override
	public ArrayList<Object> getParameters() {
		ArrayList<Object> parameters = new ArrayList<Object>();
		parameters.add(addressId);
		return parameters;
	}

}
