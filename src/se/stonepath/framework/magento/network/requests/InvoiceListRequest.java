package se.stonepath.framework.magento.network.requests;

import java.util.ArrayList;
import java.util.HashMap;

public class InvoiceListRequest extends MagentoCall{

	private static final long serialVersionUID = -733263851908944035L;

	@Override
	public String callName() {
		// TODO Auto-generated method stub
		return "sales_order_invoice.list";
	}

	@Override
	public ArrayList<Object> getParameters() {
		ArrayList<Object> parameters = new ArrayList<Object>();
		
		ArrayList<HashMap<String,HashMap<String,Object>>> filters = new ArrayList<HashMap<String,HashMap<String,Object>>>();
		HashMap<String,HashMap<String,Object>> filter = new HashMap<String,HashMap<String,Object>>();
		HashMap<String,Object> filter2 = new HashMap<String,Object>();
		filter2.put("eq", "100000001");
		filter.put("order_id", filter2);
		filters.add(filter);
		
		parameters.add(filter);
		
		
		return parameters;
	}

}
