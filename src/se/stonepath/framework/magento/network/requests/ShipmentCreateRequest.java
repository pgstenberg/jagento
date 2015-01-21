package se.stonepath.framework.magento.network.requests;

import java.util.ArrayList;
import java.util.HashMap;

import se.stonepath.framework.magento.network.MagentoConnection;

public class ShipmentCreateRequest extends MagentoCall{

	private static final long serialVersionUID = MagentoConnection.serialVersionUID;
	
	private int incrementId;
	private HashMap<Integer, Double> invoiceQty;
	private String comment;
	
	public ShipmentCreateRequest(int incrementId,HashMap<Integer,Double> invoiceQty,String comment) {
		this.incrementId = incrementId;
		this.invoiceQty = invoiceQty;
		this.comment = comment;
	}
	public ShipmentCreateRequest(int incrementId,HashMap<Integer,Double> invoiceQty) {
		this(incrementId,invoiceQty,"");
	}
	
	
	@Override
	public String callName() {
		return "order_shipment.create";
	}

	@Override
	public ArrayList<Object> getParameters() {
		ArrayList<Object> params = new ArrayList<Object>();
		params.add(incrementId);
		params.add(invoiceQty);
		
		if(!comment.equals(""))
			params.add(comment);
		
		return params;
	}

}
