/**
 * 
 */
package com.roufid.tutorials.managedBean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;

import com.roufid.tutorials.bean.Car;
import com.roufid.tutorials.service.CarService;

/**
 * Car information ManagedBean.
 * @author Radouane ROUFID.
 *
 */
@ManagedBean
@ViewScoped
public class CarInformationMB {

	/**
	 * Car.
	 */
	private Car car;
	
	/**
	 * Car service.
	 */
	@ManagedProperty("#{carService}")
	private CarService service;
	
	/**
	 * Initialize the managedBean.
	 */
	@PostConstruct
	public void init() {
		
		//Getting the portet session.
		FacesContext fc = FacesContext.getCurrentInstance();
		PortletRequest request = (PortletRequest) fc.getExternalContext().getRequest();
		PortletSession portletSession = request.getPortletSession();
		
		//Getting the carId attribute.
		String carId = (String) portletSession.getAttribute("carId",PortletSession.APPLICATION_SCOPE);
		
		//Getting the car corresponding to the carId.
		car = service.getCarWithId(carId);
		
		//Removing the session attribute.
		portletSession.removeAttribute("carId",PortletSession.APPLICATION_SCOPE);
	}

	/**
	 * @return the car
	 */
	public Car getCar() {
		return car;
	}

	/**
	 * @param car the car to set
	 */
	public void setCar(Car car) {
		this.car = car;
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
