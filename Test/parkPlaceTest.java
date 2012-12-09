import org.junit.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA 10.5.
 * User: zhaoxw
 * Date: 12-12-10
 * Time: 下午3:10
 * To change this template use File | Settings | File Templates.
 */
public class parkPlaceTest {

    @Test
    public void parkPlace_Parking_HavePlace(){

        ParkPlace  PP = new  ParkPlace(15);
        Car C = new Car("GS1221760");
        Ticket proof = PP.parking(C) ;
        Assert.assertNotNull(proof);
    }

    @Test ( expected = NoPlaceException.class)
    public void parkPlace_Parking_NoPlace()   {
        ParkPlace  PP = new  ParkPlace(1);
        PP.parking( new Car("GS1221760")) ;
        Ticket proof = PP.parking( new Car("GS1221760")) ;
        Assert.assertFalse(true);
    }

    @Test
    public void parkPlace_GetCar(){

        ParkPlace  PP = new  ParkPlace(15);
        Car car = new Car("GS1221760");
        Ticket proof =  PP.parking(car) ;

        Assert.assertSame(car, PP.GetParkedCar(proof));

    }
    @Test    ( expected = NoCarException.class)
    public void parkPlace_GetCar_NoThisCar() {

        ParkPlace  PP = new  ParkPlace(15);
        Ticket proof =  PP.parking( new Car("GS1221760")) ;
        PP.GetParkedCar(proof);
        PP.GetParkedCar(proof);
        PP.GetParkedCar(proof);

    }
    @Test
    public void parkPlace_ShowAvailableNum()  {
        int maxParkingNum = 15;
        ParkPlace  PP = new  ParkPlace(maxParkingNum);
        PP.parking( new Car("GS1221760")) ;
        PP.parking( new Car("GS1221364")) ;
        Assert.assertEquals(Integer.valueOf(maxParkingNum-2),PP.GetAvailableNum());
    }

}
