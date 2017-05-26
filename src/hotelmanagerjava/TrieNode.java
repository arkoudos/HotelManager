package hotelmanagerjava;

public class TrieNode {
    TrieNode[] arr;//Array that has the characters
    boolean isEnd;
    Hotel[] hotel ;
    Reservation [] reservation;
    int index;


    // Initialize of my data
    public TrieNode() {
        this.arr = new TrieNode[26];
        this.hotel = new Hotel[10000];
        this.reservation = new Reservation[10000];
        this.index = 0;
    }
}