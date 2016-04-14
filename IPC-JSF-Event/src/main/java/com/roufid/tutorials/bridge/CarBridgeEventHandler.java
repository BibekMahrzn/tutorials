package com.roufid.tutorials.bridge;

import javax.el.ELContext;
import javax.el.ValueExpression;
import javax.faces.context.FacesContext;
import javax.portlet.Event;
import javax.portlet.faces.BridgeEventHandler;
import javax.portlet.faces.event.EventNavigationResult;

import com.roufid.tutorials.managedBean.CarInformationMB;

/**
 * Event handler which will process all Portlet events.
 * 
 * @author Radouane ROUFID.
 *
 */
public class CarBridgeEventHandler implements BridgeEventHandler {

	@Override
	public EventNavigationResult handleEvent(FacesContext facesContext, Event event) {

		EventNavigationResult eventNavigationResult = null;

		String eventQName = event.getQName().toString();

		// Processing the selectCarEvent.
		if (eventQName.equals("{http://www.roufid.com}selectCarEvent")) {
			
			// Getting the event value.
			String carId = (String) event.getValue();
			
			// Getting the managed bean : carInformationMB and setting the carId.
			CarInformationMB carInformationMB = getCarInformationMB(facesContext);
			carInformationMB.selectCarById(carId);
		}

		return eventNavigationResult;
	}

	/**
	 * Getting the managed bean CarInformation from the facesContext.
	 * 
	 * @param facesContext
	 *            JSF faces context.
	 * @return The carInformation managed bean.
	 */
	private CarInformationMB getCarInformationMB(FacesContext facesContext) {

		ELContext elContext = facesContext.getELContext();
		ValueExpression valueExpression = facesContext.getApplication().getExpressionFactory()
				.createValueExpression(elContext, "#{carInformationMB}",CarInformationMB.class);

		return (CarInformationMB) valueExpression.getValue(elContext);
	}

}
