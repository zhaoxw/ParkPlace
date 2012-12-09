import java.util.HashMap;
import java.util.Map;

public class ParkPlace {
    private Map<Ticket, Car> parkedCarList = new HashMap<Ticket, Car>();
    private Integer maxParkingNum;
    private Integer minParkingNum;
    public Integer GetAvailableNum() {
        return maxParkingNum - parkedCarList.size();
    }

    public ParkPlace(int maxParkingNum) {
        this.maxParkingNum = maxParkingNum;
    }

    public Ticket parking(Car c) throws NoPlaceException {
        if (GetAvailableNum() == 0) {
            throw new NoPlaceException("NoPlace!");
        }
        Ticket ticket = new Ticket();
        parkedCarList.put(ticket, c);
        return ticket;
    }

    public Car GetParkedCar(Ticket ticket) throws NoCarException {
        if (parkedCarList.containsKey(ticket)) {
            return parkedCarList.remove(ticket);
        }
        throw new NoCarException("No this car!");
    }
}
