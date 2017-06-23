package tdd.examples.cars;

/**
 * @author Aliaksandr Bandarchyk
 */
public class NearestCarService {
	
	private CarDaoService carDaoService;
	private RouteService routeService;
	
	public NearestCarService(CarDaoService carDaoService, RouteService routeService) {
		this.carDaoService = carDaoService;
		this.routeService = routeService;		
	}
	
	public Car getNearestCar(int currentPosition) {		
		return carDaoService.getUnusedCars()
				.stream().min(
						(car1, car2) ->
						routeService.getDistance(currentPosition, car1.getPosition()) -
						routeService.getDistance(currentPosition, car2.getPosition())).orElse(null);
	}
}
