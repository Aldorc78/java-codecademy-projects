import java.util.ArrayList;//Import arraylist class
import java.util.Scanner; 
public class Language
{
  protected String name;
  protected int numSpeakers;
  protected String regionsSpoken;
  protected String wordOrder; 

  public Language(String name, int numSpeakers, String regionsSpoken, String wordOrder)
  {
    this.name =name;
    this.numSpeakers = numSpeakers;
    this.regionsSpoken = regionsSpoken;
    this.wordOrder = wordOrder;
  }

  public void getInfo()
  {
    System.out.println(this.name+" is spoken by "+this.numSpeakers+" people mainly in "+this.regionsSpoken+".");
    System.out.println("The language follows the word order: "+this.wordOrder+".");
  }

  //Creating a new method that lets change number of speakers 
  public void changeNumSpeakers()
  {
    Scanner obj = new Scanner(System.in);

    System.out.println("Type the new number of speakers for "+this.name+ " language:");
    this.numSpeakers = obj.nextInt();
    System.out.println("The new number of speakers is: "+ this.numSpeakers);

  }
  //Creating a new method that lets change modify the word order
    public void changeWordOrder()
  {
    Scanner obj = new Scanner(System.in);

    System.out.println("Type the new word order for "+this.name+ " language:");
    this.wordOrder = obj.nextLine();
    System.out.println("The new word order is: "+ this.wordOrder);

  }
  //Creating a new method that lets change set an specific region.
   public void changeRegion()
  {
    Scanner obj = new Scanner(System.in);

    System.out.println("Type the new region for "+this.name+ " language:");
    this.regionsSpoken = obj.nextLine();
    System.out.println("The new word order is: "+ this.regionsSpoken);

  }





  public static void main(String[] args)
  {
    Language spanish = new Language("Spanish",555000000,"Spain, Latin America, and Equatorial Guinea", "Subject-verb-object" );

   // spanish.getInfo();

    //intantiating a mayan language
    Mayan tzotzil = new Mayan("tzotzil",550274,1302);
    //tzotzil.getInfo();

    SinoTibetan burmese = new SinoTibetan("Burmese",550274);
    //burmese.getInfo();
    

    SinoTibetan mandarinChinese = new SinoTibetan("Mandarin Chinese",550274);
   // mandarinChinese.getInfo();

    //Building an arrayList of several language objects and looping trogh them to call getInfo().

    //#1. Creating objects
    Mayan chontal = new Mayan("Chontal",60563,1302);
    Mayan chuj = new Mayan("Chuj",61630,1302);
    Mayan ixil = new Mayan("Ixil",60563,1302);
    Mayan mam = new Mayan("Mam",488500,1302);
    Mayan achi = new Mayan("Achi",82600,1302);
    
    //achi.changeNumSpeakers();
    //achi.getInfo();
    achi.changeRegion();
    achi.getInfo();

    //#2. Putting objects into an arraylist
    ArrayList<Mayan> mayanLanguages= new ArrayList<Mayan>();
    mayanLanguages.add(chontal);
    mayanLanguages.add(chuj);
    mayanLanguages.add(ixil);
    mayanLanguages.add(mam);
    mayanLanguages.add(achi);

    //Iterating between mayan objects
    //Inside for each loop i created a temporary varaible Mayan type
    //called languageObject to store a Mayan object. 
   // for(Mayan languageObject:mayanLanguages)
   // {
    //  languageObject.getInfo();
    //}

   English english = new English("English",550274);
   english.getInfo();
    
  }
}
