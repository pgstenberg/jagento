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
		return new Vector<Object>();
	}


}
