package se.stonepath.framework.magento.network.requests;

import java.util.Vector;

import se.stonepath.framework.magento.network.MagentoConnection;




public class ProductListRequest extends MagentoCall{

	private static final long serialVersionUID = MagentoConnection.serialVersionUID;
	
	@Override
	public String callName() {
		return "catalog_product.list";
	}

	@Override
	public Vector<Object> getParameters() {
		return new Vector<Object>();
	}

	/*
	public ProductListRequest(MagentoConnection connection) {
		super(connection);
	}

	@Override
	protected Object[] getContent(String sessionKey) {
		Object[] filter = new Object[1];
		Object[] filter1 = new Object[2];
		filter[0] = filter1;
		filter1[0] = "type";
		Object[] filterParams = new Object[2];
		filterParams[0] = "in";
		filterParams[1] = "simple";
		filter1[1] = filterParams;
		
		return MagentoCall.createContent(sessionKey, "catalog_product.list");
	}

	@Override
	protected MagentoRespond handleRespond(Object data) {
		
		Object[] productCollection = (Object[]) data;
		
		CollectionRespond respond = new CollectionRespond();
		
		for(Object product : productCollection){
			
			@SuppressWarnings("unchecked")
			HashMap<Object,Object> productData = (HashMap<Object,Object>) product;
			
			HashMap<String,String> inputData = new HashMap<String, String>();
			

			inputData.put("sku", (String)productData.get("sku"));
			inputData.put("type", (String)productData.get("type"));
			
			respond.add(inputData);
		}
		
		
		
		return respond;
	}
	*/

}
