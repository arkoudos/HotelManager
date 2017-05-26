package hotelmanagerjava;

public class BinarySearch {
    public int binarySearch(int searchID) {
        int start = 0;
        int end = FileManager.hotelList.size() - 1; //end of my list
        while (start <= end) {
            int mid = (start + end) / 2; //my mid is the start of the list + the end divided by 2
            if (searchID == FileManager.hotelList.get(mid).getId()) {
                return mid; //if the id i want to find equals the middle element return that element
            }
            if (searchID < FileManager.hotelList.get(mid).getId()) {
                end = mid - 1; //if the id i want to find < the middle element take the first half of my list
            } else {
                start = mid + 1; //id the id i want to find > the middle element take the second half of my list
            }
        }
        return -1;
    }
}