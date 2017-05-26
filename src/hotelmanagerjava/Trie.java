package hotelmanagerjava;

public class Trie {
    private TrieNode root;
    int counter =1;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(Reservation reservation,Hotel hotel) {
        TrieNode p = root;
        String word = reservation.getName();
        word = word.toLowerCase();
        for(int i=0; i<word.length(); i++)
        {
            char c = word.charAt(i); //return the i-th element of the string
            int index = (c-'a');       // 0-25 ,97- (97+25)=value range
            if(p.arr[index]==null){//if i does not exist 
                TrieNode temp = new TrieNode();//if does not exist create it on the root
                p.arr[index]=temp;
                p = temp;
            }else{
                p=p.arr[index];//if it exist makes the root a node and continue to the next letter and move further down on the tree
            }
        }
        p.isEnd=true;
        p.hotel[p.index] = hotel; //pass the hotel to the node
        p.reservation[p.index] =reservation; //pass the reservation to the node
        p.index++;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
    	

        TrieNode p = searchNode(word);
        if (p == null) {
            return false; //the word isn't in the tree
        } else {
            if (p.isEnd) {
            	CreateMenu.output.append("\n" + "The Reservations with the name " + word + " is:\n");
                for (int i = 0; i < p.index; i++)
                	
                	CreateMenu.output.append("Number of compares: "+counter+i + ": In The Hotel " + p.hotel[i].getName() + "\t Starts:" + p.hotel[i].getStars() + "\tDuration Days" + p.reservation[i].getStayDurationDays() + "\tDate:" + p.reservation[i].getCheckinDate() + "\n");
 
            	
            	
                return true;
            }

            return false;

        }
    }


    public TrieNode searchNode(String s){
        TrieNode p = root;
        s=s.toLowerCase();
        for(int i=0; i<s.length(); i++)
        {
            char c= s.charAt(i);//return the i-th character
            int index = c-'a';//get the ascii value of the letter
            if(p.arr[index]!=null)//if it exist makes the root a node and continue to the next letter and move further down on the tree
            {
                p = p.arr[index]; //new root
            }
            else
                return null;
            counter++;
        }

        if(p==root)
            return null;

        return p;
    }
}