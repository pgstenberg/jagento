package se.stonepath.framework.magento.network.requests;

import java.util.ArrayList;

import se.stonepath.framework.magento.network.MagentoConnection;

public class OrderListRequest extends MagentoCall{

	private static final long serialVersionUID = MagentoConnection.serialVersionUID;

	@Override
	public String callName() {
		return "sales_order.list";
	}

	@Override
	public ArrayList<Object> getParameters() {
		
		return new ArrayList<Object>();
	}

}
