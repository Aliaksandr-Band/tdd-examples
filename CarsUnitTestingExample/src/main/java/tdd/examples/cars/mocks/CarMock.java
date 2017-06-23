package tdd.examples.cars.mocks;

import tdd.examples.cars.Car;


/**
 * @author Aliaksandr Bandarchyk
 */
public class CarMock implements Car {	
	private int position;
	
	public CarMock(int position) { this.position = position; }
	
	@Override
	public int getPosition() { return position; }
}
