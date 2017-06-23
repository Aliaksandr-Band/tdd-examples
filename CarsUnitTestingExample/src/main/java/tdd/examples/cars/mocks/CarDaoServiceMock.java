package tdd.examples.cars.mocks;

import tdd.examples.cars.Car;
import tdd.examples.cars.CarDaoService;

import java.util.List;


/**
 * @author Aliaksandr Bandarchyk
 */
public class CarDaoServiceMock implements CarDaoService {	
	private List<Car> unusedCars;
	
	public CarDaoServiceMock(List<Car> unusedCars) { this.unusedCars = unusedCars; }
	
	@Override
	public List<Car> getUnusedCars() { return unusedCars; }		
}
