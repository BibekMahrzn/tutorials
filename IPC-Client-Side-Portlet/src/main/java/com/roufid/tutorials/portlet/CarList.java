package com.roufid.tutorials.portlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
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
	
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException {
		
		String carId = ParamUtil.getString(resourceRequest,"carId");
		Car car = service.getCarWithId(carId);
		
		JSONObject jsonCar = JSONFactoryUtil.createJSONObject();
		
		if(car != null){
			jsonCar.put("id", car.getId());
			jsonCar.put("imagePath",car.getImagePath());
			jsonCar.put("brand", car.getBrand());
			jsonCar.put("color",car.getColor());
			jsonCar.put("price",car.getPrice());
			jsonCar.put("year",car.getYear());
		}
		
		PrintWriter writer = resourceResponse.getWriter();
		writer.println(jsonCar);
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

