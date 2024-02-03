/*
   Continents.java program that will print out a continent and the largest city in that continent, based on the value of an integer. 
*/
public class Continents
{
  int continent; 
  public Continents(int continent)
  {
    this.continent=continent; 
  }

  public void EvaluateContinent()
  {
    switch(continent)
    {
    case 1:
        System.out.println("North America: Mexico city, Mexico");
    break; 
    case 2:
        System.out.println("South America: Sao Paulo, Brazil");
    break;
    case 3:
        System.out.println("Europe: Moscow, Russia"); 
    break; 
    case 4:
        System.out.println("Africa: Lagos, Nigeria"); 
    break; 
    case 5: 
        System.out.println("Asia: Shangai, China");
    break; 
    case 6:
        System.out.println("Australia: Sydney, Australia"); 
    break;
    case 7: 
        System.out.println("Antarctica: McMurdo Station, US");
    break; 
    default: 
    System.out.println("Undefined continent!");
    }

  }

  public static void main(String[] args)
  { 
      Continents myContinent = new Continents(4);
      myContinent.EvaluateContinent();
      Continents myOtherContinent = new Continents(7);
      myOtherContinent.EvaluateContinent();

  }

}