package com.roufid.tutorials.portlet;


import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

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
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

		// Getting the public render parameter.
		String carId = renderRequest.getParameter("carId");
		
		Car car = service.getCarWithId(carId);
		renderRequest.setAttribute("car", car);
		
		super.doView(renderRequest, renderResponse);
	}

}
