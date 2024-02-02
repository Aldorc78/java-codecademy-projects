import java.util.ArrayList;

class Playlist 
{
  
  public static void main(String[] args) 
  {
    ArrayList<String> desertIslandPlaylist = new ArrayList<String>(); 

    desertIslandPlaylist.add("Always-Bon Jovi");
    desertIslandPlaylist.add("Bad Medicine-Bon Jovi");
    desertIslandPlaylist.add("First Date-Blink-182");
    desertIslandPlaylist.add("Robbers-The 1975");
    desertIslandPlaylist.add("Poppin' Champagne-All Time Low");
    desertIslandPlaylist.add("What's my age again-Blink-182");
    //System.out.println(desertIslandPlaylist.toString());
    System.out.println("\n"+ desertIslandPlaylist);

    System.out.println("\n I added "+desertIslandPlaylist.size()+ " songs.");

    desertIslandPlaylist.remove(0);
    System.out.println("\nAfter removing now i have "+desertIslandPlaylist.size()+ " songs.");

     //After this line im gonna change the order of two songs. 

     int a = desertIslandPlaylist.indexOf("Poppin' Champagne-All Time Low");

     int b = desertIslandPlaylist.indexOf("Bad Medicine-Bon Jovi");

     
    desertIslandPlaylist.set(a,"Bad Medicine-Bon Jovi");
    desertIslandPlaylist.set(b,"Poppin' Champagne-All Time Low");
    System.out.println(desertIslandPlaylist);

/*
String tempA = "Poppin' Champagne-All Time Low";

desertIslandPlaylist.set(a,"Bad Medicine-Bon Jovi");
desertIslandPLaylist.set(b, tempA);
System.out.println(desertIslandPlaylist);
*/


    
  }
  
}