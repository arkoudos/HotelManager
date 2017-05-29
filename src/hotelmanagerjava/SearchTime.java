package hotelmanagerjava;

import java.util.List;

import javax.swing.JOptionPane;

import java.util.*;

public class SearchTime {
	
	public static void IDSearchTime(){
		//generate 1000 random ids 
		StringBuilder sb = new StringBuilder();
		//FileManager mFile= new FileManager();
		List<Integer> randoms = new ArrayList<Integer>();
		Random randomGenerator = new Random();
	    for (int idx = 1; idx <= 1000; ++idx){    
	      int randomInt = randomGenerator.nextInt(1000);
	      randoms.add(FileManager.hotelList.get(randomInt).getId());
	    }
	    
	    
	    long startTime = System.nanoTime(); //start counting the execution time
	    for (int x: randoms)
	    FileManager.SearchByID(x); //search 1000 numbers
	    long elapsedTime=System.nanoTime()-startTime; //stop the counting
        sb.append("Elapsed time for Linear searching "+elapsedTime/1000 + " ns \n");
        
        BinarySearch temp= new BinarySearch(); 
	    startTime = System.nanoTime(); //start counting the execution time
	    for (int x : randoms)
	    temp.binarySearch(x); //search 1000 numbers
	    elapsedTime=System.nanoTime()-startTime; //stop counting
	    sb.append("Elapsed time for Binary searching "+elapsedTime/1000 + " ns \n");
        
        startTime = System.nanoTime(); //start counting the execution time
        for (int x: randoms)
        	InterpolationSearch.interpolationSearch(x);
        	elapsedTime=System.nanoTime()-startTime; //stop counting
        	sb.append("Elapsed time for Interpolation searching "+elapsedTime/1000 + " ns \n");
            
       startTime = System.nanoTime(); //start execution time
         for (int x: randoms)
            FileManager.avlTree.search(x);
            elapsedTime=System.nanoTime()-startTime; //stop execution time
            sb.append("Elapsed time for AVL searching "+elapsedTime/1000 + " ns \n");
            JOptionPane.showMessageDialog(null, sb, "InfoBox: " + "Results", JOptionPane.INFORMATION_MESSAGE);
        
	}
	public static void SurnnameSearchTime(){
		StringBuilder sb = new StringBuilder();
		List<String> randoms = new ArrayList<String>();
		Random randomGenerator = new Random();
	    for (int idx = 1; idx <= 1000; ++idx){
	      int randomInt = randomGenerator.nextInt(1000); //create a random list with 1000 namaes from the file
	      for (Reservation x:FileManager.hotelList.get(randomInt).getReservations()){
	    	  randoms.add(x.getName());
	    	  break;
	      }
	    }
	    
	    long startTime = System.nanoTime(); //start the counting for exec time
        for (String x: randoms)
        	 FileManager.SearchBySur(x);
           long elapsedTime=System.nanoTime()-startTime; //stop counting for exec time
           sb.append("Elapsed time for Linear searching "+elapsedTime/1000 + " ns \n");
           
        startTime = System.nanoTime(); //start the counting for exec time
           for (String x: randoms)
           FileManager.tr.search(x);
             elapsedTime=System.nanoTime()-startTime; //stop the counting
             sb.append("Elapsed time for Digital Trie searching "+elapsedTime/1000 + " ns \n");
             JOptionPane.showMessageDialog(null, sb, "InfoBox: " + "Results", JOptionPane.INFORMATION_MESSAGE);
	   
	}
}