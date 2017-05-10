package hotelmanagerjava;

import java.util.*;

public class FileSorter implements Comparator<Hotel>
{
    @Override
    public int compare(Hotel one, Hotel another)
    {
        int returnID = 0;
        
        if(one.getId() < another.getId())
        {
            return returnID = -1;
        }else if(one.getId() > another.getId())
        {
            return returnID = 1;
        }
        System.out.println("Debug");
        return returnID;
    }
    
   public void sortList(List<Hotel>hotelList,FileSorter sort)
   {
       Collections.sort(hotelList,sort);
   }
   
}
