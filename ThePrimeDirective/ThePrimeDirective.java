// Import statement:
import java.util.ArrayList; 
public class ThePrimeDirective 
{
  
  // Add your methods here:
        public boolean isPrime(int number)//It checks if a number is prime and return the boolean status.
        {
          if(number==2)
          {
            return true;
          }
          else if(number<2)
          {
            return false;
          }
          
                for(int i=2;i<number;i++)
                {
                  if(number%i!=0)
                  {
                    return true; //if return keyword is run once the compiler gets out of the method right away; 
                  } 
                  return false; //that´s why we don't use "else" keyword
                } 
          return true;
        }

        public ArrayList<Integer> onlyPrimes(int[] checkAr)
        {
          ArrayList<Integer> primeAList = new ArrayList<Integer>();

           for(int i=0;i<checkAr.length;i++)
           {
            int num= checkAr[i];
              if (isPrime(num)==true)
              {
              primeAList.add(num);
              }
              continue;
           }
           return primeAList;
           
        }
        
  
    public static void main(String[] args) 
    {

      ThePrimeDirective pd = new ThePrimeDirective();
      int[] numbers = {6, 29, 28, 33, 11, 100, 101, 43, 89};

     // System.out.println(pd.isPrime(89));
      //onlyPrimes(numbers); //no funciona
      System.out.println(pd.onlyPrimes(numbers));


    }  

}