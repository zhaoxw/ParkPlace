import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Yang Xing
 * Date: 12-12-16
 * Time: 上午9:51
 * To change this template use File | Settings | File Templates.
 */
public class ParkingDirector {
    private ArrayList<ParkingManager> parkingManagers;
    private int iTotalParkedNum = 0;
    private int iTotalAvailableNum = 0;
    public ParkingDirector(ArrayList<ParkingManager> parkingManagers) {
        this.parkingManagers = parkingManagers;
    }

    public void ShowParkingLotInfoFromDirector()
    {
        for (int i=0; i< parkingManagers.size(); i++)
        {
            parkingManagers.get(i).ShowParkingLotInfoFromManagerSelf();
            parkingManagers.get(i).ShowParkingLotInfoFromManagedParkingBoy();
            iTotalParkedNum += parkingManagers.get(i).iTotalParkedNum;
            iTotalAvailableNum += parkingManagers.get(i).iTotalAvailableNum;
        }
        System.out.println("Total车位数:"+iTotalParkedNum);
        System.out.println("Total空位数:"+iTotalAvailableNum);
    }
}
