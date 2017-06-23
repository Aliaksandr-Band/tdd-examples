package tdd.examples.cars;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;

import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class NearestCarServiceTest {	
	@InjectMocks private NearestCarService nearestCarService;
	@Mock private CarDaoService carDaoService;
	@Mock private RouteService routeService;
	@Mock private Car car1;
	@Mock private Car car2;
	@Mock private Car car3;
	
	@Before	
	public void setUp() {
		when(car1.getPosition()).thenReturn(5);
		when(car2.getPosition()).thenReturn(2);
		when(car3.getPosition()).thenReturn(3);		
		when(carDaoService.getUnusedCars()).thenReturn(Arrays.<Car>asList(car1, car2, car3));		
		when(routeService.getDistance(anyInt(), anyInt())).thenAnswer(invocation -> Math.abs((int)invocation.getArgument(0) - (int)invocation.getArgument(1)));		
	}
	
	@Test
	public void testNearestCarAtPosition_0() {
		Car nearestCar = nearestCarService.getNearestCar(0);
		
		assertSame(car2, nearestCar);
		verify(carDaoService, times(1)).getUnusedCars();
		verify(routeService, atLeast(3)).getDistance(anyInt(), anyInt());
	}
	
	@Test
	public void testNearestCarAtPosition_6() {
		Car nearestCar = nearestCarService.getNearestCar(6);
		
		assertSame(car1, nearestCar);
		verify(carDaoService, times(1)).getUnusedCars();
		verify(routeService, atLeast(3)).getDistance(anyInt(), anyInt());
	}	
}
