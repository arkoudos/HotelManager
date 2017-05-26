package hotelmanagerjava;

public class InterpolationSearch
{
    public static int interpolationSearch (int toFind)
    {
        int low = 0;

        int high = FileManager.hotelList.size() - 1; //the end of my list of hotels

        int mid;

        while (FileManager.hotelList.get(low).getId() <= toFind && FileManager.hotelList.get(high).getId() >= toFind) 
        //check if the id is in bounds of my list
        {
            if (FileManager.hotelList.get(high).getId() - FileManager.hotelList.get(low).getId() == 0)
            //this means i have only one object in list
                return (low + high)/2;
            //set mid to be 0+(my id to find - the first id of my list) * (end of list - 0)/ (last hotel id- first hotel id)
            mid = low + ((toFind - FileManager.hotelList.get(low).getId()) * (high - low)) / (FileManager.hotelList.get(high).getId() - FileManager.hotelList.get(low).getId());  
            
            if (FileManager.hotelList.get(mid).getId() < toFind)
            {
                low = mid + 1;
            } //if the middle hotel id is < of what i am looking search in the first half of my list
            else if (FileManager.hotelList.get(mid).getId() > toFind)
            {
                high = mid - 1;
            } //if the middle hotel id is > of what i am looking search in the second half of my list
            else{
                return mid; //else the hottel is in the middle
            }
        }
        if (FileManager.hotelList.get(low).getId() == toFind)
        {
            return low;
        } //if the hotel i am looking for is the first element of my list
        //if not found
        else
        {
            return -1;
        }
        }    
}