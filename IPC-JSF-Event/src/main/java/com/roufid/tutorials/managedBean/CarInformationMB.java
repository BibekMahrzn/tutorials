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
	private CarService carService;

	/**
	 * Set the car according to the given carId.
	 * 
	 * @param carId
	 *            Car identifier.
	 */
	public void selectCarById(String carId) {
		car = carService.getCarById(carId);
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
	 * @return the carService
	 */
	public CarService getCarService() {
		return carService;
	}

	/**
	 * @param carService
	 *            the carService to set
	 */
	public void setCarService(CarService carService) {
		this.carService = carService;
	}
}
