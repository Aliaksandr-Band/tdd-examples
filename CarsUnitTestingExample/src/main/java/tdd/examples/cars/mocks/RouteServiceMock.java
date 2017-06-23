package tdd.examples.cars.mocks;

import tdd.examples.cars.RouteService;


/**
 * @author Aliaksandr Bandarchyk
 */
public class RouteServiceMock implements RouteService {
	@Override
	public int getDistance(int a, int b) {
		return Math.abs(a - b);
	}
}
