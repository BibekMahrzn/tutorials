package com.roufid.tutorials.managedBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.roufid.tutorials.bean.Car;
import com.roufid.tutorials.service.CarService;

/**
 * Car information ManagedBean.
 * 
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

	private String selectedCarId;


	/**
	 * @return the selectedCarId
	 */
	public String getSelectedCarId() {
		return selectedCarId;
	}

	/**
	 * This method will be called by the bridge when a car is selected
	 * 
	 * @param selectedCarId
	 *            the selectedCarId to set
	 */
	public void setSelectedCarId(String selectedCarId) {
		this.selectedCarId = selectedCarId;
		
		// Getting the car corresponding to the carId.
		car = service.getCarById(selectedCarId);
	}
	
	/**
	 * @return the car
	 */
	public Car getCar() {
		return car;
	}

	/**
	 * @param car
	 *            the car to set
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
	 * @param service
	 *            the service to set
	 */
	public void setService(CarService service) {
		this.service = service;
	}

}
