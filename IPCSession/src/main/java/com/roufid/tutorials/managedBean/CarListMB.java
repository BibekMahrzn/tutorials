package com.roufid.tutorials.managedBean;

import java.util.List;

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
 * Listing cars.
 * @author Radouane ROUFID
 *
 */
@ManagedBean
@ViewScoped
public class CarListMB {

	/**
	 * List of cars.
	 */
	private List<Car> cars;

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
        cars = service.getCars();
    }
 
	/**
	 * Store the car's identifier in the session.
	 * @param carId Car's identifier.
	 */
	public void selectCar(final String carId) {
	
		System.out.println("Selected car id = " + carId);
		
		// Getting the faces context.
		FacesContext fc = FacesContext.getCurrentInstance();
		
		// Getting the portlet request.
		PortletRequest request = (PortletRequest) fc.getExternalContext().getRequest();
		
		// Getting the portlet session.
		PortletSession portletSession = request.getPortletSession();
		
		// Setting the car identifier in the portlet session. 
		portletSession.setAttribute("carId", carId, PortletSession.APPLICATION_SCOPE);
	}
	
	
	/**
	 * @return the cars
	 */
	public List<Car> getCars() {
		return cars;
	}

	/**
	 * @param cars
	 *            the cars to set
	 */
	public void setCars(List<Car> cars) {
		this.cars = cars;
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
