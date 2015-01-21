package se.stonepath.framework.magento.network.requests;

import java.util.ArrayList;

import se.stonepath.framework.magento.network.MagentoConnection;

public class ShipmentAddTrackerRequest extends MagentoCall{

	private static final long serialVersionUID = MagentoConnection.serialVersionUID;
	
	private int shipmentIncrementId;
	private String carrier;
	private String trackNumber;
	private String title;
	
	public ShipmentAddTrackerRequest(int shipmentIncrementId,String carrier,String title,String trackNumber) {
		this.shipmentIncrementId = shipmentIncrementId;
		this.carrier = carrier;
		this.trackNumber = trackNumber;
		this.title = title;
	}
	
	@Override
	public String callName() {
		// TODO Auto-generated method stub
		return "order_shipment.addTrack";
	}

	@Override
	public ArrayList<Object> getParameters() {
		ArrayList<Object> params = new ArrayList<Object>();
		params.add(shipmentIncrementId);
		params.add(carrier);
		params.add(title);
		params.add(trackNumber);
		
		return params;
	}

}
