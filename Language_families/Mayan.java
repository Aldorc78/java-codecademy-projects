public class Mayan extends Language
{
  public int yearInvented;
  public Mayan(String languageName, int speakers,int yearInvented)
  {
    super(languageName, speakers,"Central America","verb-object-subject");
    this.yearInvented = yearInvented; 

    //this.regionsSpoken = "Central America";
    //this.wordOrder = "verb-object-subject";
  }

    //overriding a method in the following lines 
    
    @Override 
    public void getInfo()
    {
      System.out.println(this.name+" is spoken by "+this.numSpeakers+" people mainly in "+this.regionsSpoken+".");
      System.out.println("The language follows the word order: "+this.wordOrder+".");
      System.out.println("Fun fact: " + this.name +" is an ergative language."+ " Also, was invented in: "+this.yearInvented);
    }
    
    
    
  
}
