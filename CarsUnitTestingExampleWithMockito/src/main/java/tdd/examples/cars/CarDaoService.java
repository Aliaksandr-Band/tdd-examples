package tdd.examples.cars;

import java.util.List;

/**
 * @author Aliaksandr Bandarchyk
 */
public class CarDaoService {	
	public List<Car> getUnusedCars() {
		throw new RuntimeException(
				"CarDaoService not suitable for test");
	}		
}
