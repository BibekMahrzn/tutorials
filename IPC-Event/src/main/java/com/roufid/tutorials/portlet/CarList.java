package com.roufid.tutorials.portlet;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.xml.namespace.QName;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.roufid.tutorials.bean.Car;
import com.roufid.tutorials.service.CarService;

/**
 * Listing cars.
 * @author Radouane ROUFID
 *
 */
public class CarList extends MVCPortlet {
 
	/**
	 * Singleton carService bean injection.
	 */
	private CarService service = CarService.getInstance();
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

		List<Car> cars = service.getCars();
		renderRequest.setAttribute("cars", cars);

		super.doView(renderRequest, renderResponse);
	}
	
	/**
	 * Process the Portlet action URL. 
	 * @param actionRequest The ActionRequest.
	 * @param actionResponse The ActionReponse.
	 * @throws IOException
	 * @throws PortletException
	 */
	public void selectCarAction(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException {
		
		// Getting the carId from the submitted form.		
		String carId = ParamUtil.getString(actionRequest,"carId");

		// Firing the event : selectCarEvent with the carId.
		QName qname = new QName("http://www.roufid.com", "selectCarEvent", "event");
		actionResponse.setEvent(qname, carId);
	}

	
	/**
	 * @return the service
	 */
	public CarService getService() {
		return service;
	}

	/**
	 * @param service the service to set
	 */
	public void setService(CarService service) {
		this.service = service;
	}

}
