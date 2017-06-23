package tdd.examples.cars;

import org.junit.Before;
import org.junit.Test;
import tdd.examples.cars.mocks.CarDaoServiceMock;
import tdd.examples.cars.mocks.CarMock;
import tdd.examples.cars.mocks.RouteServiceMock;

import java.util.Arrays;

import static org.junit.Assert.assertSame;


public class NearestCarServiceTest {	
	private NearestCarService nearestCarService;
	private CarDaoService carDaoService;
	private Car car1;
	private Car car2;
	private Car car3;
	
	@Before	
	public void setUp() {
		car1 = new CarMock(5);
		car2 = new CarMock(2);
		car3 = new CarMock(3);
		carDaoService = new CarDaoServiceMock(Arrays.<Car>asList(car1, car2, car3));		
		nearestCarService = new NearestCarService(carDaoService, new RouteServiceMock());
	}
	
	@Test
	public void testNearestCarAtPosition_0() {
		Car nearestCar = nearestCarService.getNearestCar(0);
		
		assertSame(car2, nearestCar);
	}
	
	@Test
	public void testNearestCarAtPosition_6() {
		Car nearestCar = nearestCarService.getNearestCar(6);
		
		assertSame(car1, nearestCar);
	}	
}
