package tdd.examples.cars;

import java.util.List;


/**
 * @author Aliaksandr Bandarchyk
 */
public class CarDaoService {
	private ContextClass contextClass;
	public CarDaoService(ContextClass contextClass) {
		this.contextClass = contextClass;
	}

	public List<Car> getUnusedCars() {
		contextClass.doAction();
		return null;
	}
}
