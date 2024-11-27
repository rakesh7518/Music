package music;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
	private static ArrayList<Album> albums = new ArrayList<>();

	public static void main(String[] args) 
	{
	  Album album = new Album( "Album1",  "AC/DC");	
	 
	 album.addSong( "TNT", 3.5);
	 album.addSong("Highway to hell", 4.0);
	 album.addSong( "ThunderStruck", 4.5);
     albums.add(album);
     
     album = new Album( "Album2",  "Eminem");
     
	 album.addSong( "Rap god",4.5);
	 album.addSong( "Not Afraid",5.5);
	 album.addSong("Lose yourself", 2.5);
	 
	 albums.add(album);
	 
	 LinkedList<Song> playList_1 = new LinkedList<>();
	 
	 albums.get(0).addToPlayList( "TNT", playList_1);
	 albums.get(0).addToPlayList( "Highway to hell", playList_1);
	 albums.get(1).addToPlayList( "Rap god", playList_1);
	 albums.get(1).addToPlayList( "Lose yourself", playList_1);
	 
	 play(playList_1);
	 
	}
      private static void play(LinkedList<Song> playList) {
    	  Scanner sc = new Scanner(System.in);
    	  boolean quit = false;
    	  boolean forword = true;
    	  ListIterator<Song> listIterator = playList.listIterator();
    	  if(playList.size()==0)
    	  {
    		  System.out.println("This playlist have no song");
    	  }else {
    		  System.out.println("Not playing" + listIterator.next().toString());
    	      printMenu();
    	      }
    	  while(!quit) {
    		  int action = sc.nextInt();
    		   sc.nextLine();
    		   
    		   switch(action) {
    		   
    		   case 0:
    		   System.out.println("Playlist complete");
    		   quit = true;
    		   break;
    		   
    		   case 1:
    			   if(!forword) {
    				   if(listIterator.hasNext()) {
    					   listIterator.next();
    				   }
    				    forword = true;
    			   }
    			   if(listIterator.hasNext()) {
    				   System.out.println("Now playing"+listIterator.next().toString());
    			   }else {
    				   System.out.println("no song availalbe, reached to the end of the list");
    				   forword = false;
    			   }
    			   break;
    		   case 2:
    			   if(forword) {
    				   if(listIterator.hasPrevious()) {
    					   listIterator.previous();
    			  }
    				   forword = false;
    			   }
    			   if(listIterator.hasPrevious()) {
    				   System.out.println("Now playing"+listIterator.previous().toString());
    			   }else {
    				   System.out.println("we are the first song");
    				   forword = false;
    			   }
    			   break;
    			   
    		 
    		   case 3:
    			   if(forword) {
    				   if(listIterator.hasPrevious()) {
    					   System.out.println("Now playing"+listIterator.previous().toString());
    					   forword = false;
    				   }else {
    					   System.out.println("we are the start of the list");
    		 			   }
    			   }else {
    				      if(listIterator.hasNext()) {
    				    	  System.out.println("now playing"+listIterator.next().toString());
    				  }
    			   }
    			   break;
    			   
    			   
    		   case 4:
    			   printList(playList);
    			   break;
    		   case 5:
    			   printMenu();
    			   break;
    			   
    		   case 6:
    			   if(playList.size() >0) {
    				   listIterator.remove();
    				   if(listIterator.hasNext()) {
    					   System.out.println("now playing"+listIterator.next().toString());
    					   forword = true;
    					   
    				   }
    				   else {
    					   if(listIterator.hasPrevious())
    						   System.out.println("now playing"+listIterator.previous().toString());
    						   
    				   }
    			   }
    			   }
    	  }
      }
    	  private static void printMenu() {
    	  System.out.println("Available option\npress");
    	  System.out.println("0-to quit\n"+
    	             "1 - to play next song\n"+
    			     "2 - to play privious song\n"+
    	             "3 - to replay the current song\n"+
    			     "4-  List of all song\n"+
    	             "5 - Print all available options\n"+
    			     "6 -delete current song");
    	  }
      
      
      private static void printList(LinkedList<Song> playList) {
    	  Iterator<Song> iterator = playList.iterator();
    	  
    	  System.out.println("------------------");
    	  
    	  while(iterator.hasNext()) {
    		  System.out.println(iterator.next());
    	  }
    	  System.out.println("---------------");
      }
}











