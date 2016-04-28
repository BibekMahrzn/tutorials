package com.roufid.tutorials.service;

import java.util.ArrayList;
import java.util.List;

import com.roufid.tutorials.bean.Car;

/**
 * Car service.
 * 
 * @author Radouane ROUFID.
 *
 */
public class CarService {

	/**
	 * List of cars.
	 */
	List<Car> cars = new ArrayList<Car>();

	/**
	 * Private carService for Singleton instanciation.
	 */
	private static CarService carService = null;
	
	/**
	 * Private constructor for Singleton.
	 */
	private CarService() {
		// Creating random cars.
		Car bmw = new Car(
				"1203",
				"BMW",
				"2015",
				"Black",
				60000,
				true,
				"Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Phasellus viverra nulla ut metus varius laoreet. Quisqu",
				"https://upload.wikimedia.org/wikipedia/commons/thumb/4/44/BMW.svg/2000px-BMW.svg.png");
		Car volkswagen = new Car(
				"1976",
				"Volkswagen",
				"2016",
				"White",
				30000,
				false,
				"Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Phasellus viverra nulla ut metus varius laoreet. Quisqu",
				"https://upload.wikimedia.org/wikipedia/commons/1/1a/Volkswagen_Logo.png");
		Car ford = new Car(
				"4496",
				"Ford",
				"2010",
				"Blue",
				25000,
				false,
				"Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Phasellus viverra nulla ut metus varius laoreet. Quisqu",
				"https://upload.wikimedia.org/wikipedia/commons/thumb/a/a0/Ford_Motor_Company_Logo.svg/2000px-Ford_Motor_Company_Logo.svg.png");
		Car fiat = new Car(
				"9865",
				"Fiat",
				"2011",
				"Grey",
				15000,
				true,
				"Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Phasellus viverra nulla ut metus varius laoreet. Quisqu",
				"http://vignette4.wikia.nocookie.net/logopedia/images/1/1a/Fiat_logo_2006.png/revision/latest?cb=20100624111902");
		Car ferrari = new Car(
				"1121",
				"Ferrari",
				"2014",
				"Red",
				150000,
				false,
				"Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Phasellus viverra nulla ut metus varius laoreet. Quisqu",
				"http://img3.wikia.nocookie.net/__cb20131015194817/nfs/de/images/c/ce/Ferrari_Logo.png");

		cars.add(ferrari);
		cars.add(volkswagen);
		cars.add(ford);
		cars.add(fiat);
		cars.add(bmw);
	}

	/**
	 * Instance the singleton CarService. 
	 * @return
	 */
	public static CarService getInstance() {
		
		if(carService == null) {
			carService = new CarService();
		}
		
		return carService;
	}
	
	/**
	 * Get car by identifier.
	 * 
	 * @param id
	 *            Car identifier.
	 * @return Car by identifier.
	 */
	public Car getCarWithId(String id) {

		Car car = new Car();
		car.setId(id);

		int index = cars.indexOf(car);

		return index != -1 ? cars.get(index) : null;
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
}
