package com.roufid.tutorials.portlet;


import java.io.IOException;

import javax.portlet.Event;
import javax.portlet.EventRequest;
import javax.portlet.EventResponse;
import javax.portlet.PortletException;
import javax.portlet.ProcessEvent;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.roufid.tutorials.bean.Car;
import com.roufid.tutorials.service.CarService;

/**
 * Car information.
 * @author Radouane ROUFID.
 *
 */
public class CarInformation extends MVCPortlet {

	/**
	 * Singleton carService bean injection.
	 */
	private CarService service = CarService.getInstance();
	
	/**
	 * Processing the event fired from the CarList Portlet.
	 * @param eventRequest The Event request.
	 * @param eventReponse The event response.
	 * @throws PortletException
	 * @throws IOException
	 */
	@ProcessEvent(qname = "{http://www.roufid.com}selectCarEvent")
	public void carSelectionEvent(EventRequest eventRequest, EventResponse eventReponse)
			throws PortletException, IOException {
		
		// Getting the fired event from the event request.
		Event event = eventRequest.getEvent();
		
		// Getting the value of the sent parameter.
		String carId = (String) event.getValue();
		
		// Setting the result in the render parameter.
		eventReponse.setRenderParameter("carId", carId);
	}
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

		String carId = ParamUtil.getString(renderRequest,"carId");
		
		Car car = service.getCarWithId(carId);
		renderRequest.setAttribute("car", car);
		
		super.doView(renderRequest, renderResponse);
	}

}
