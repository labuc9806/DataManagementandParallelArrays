/*
 * Launa Bucher-Austin
 * This program allos the user to input data, and creates new data based on the existing data. It also outputs existing data. 
 * May 22 2020
 */
package datamanagementandparallelarrays;

import java.util.Scanner;

/**
 *
 * @author launa
 */
public class DataManagementandParallelArrays {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     Scanner keyedInput = new Scanner (System.in);
     String userInput;
     int entries=0;
     int choices=0;
     boolean invalid = true;
     
     while(invalid)
     {
         System.out.println("Enter the number of movies : "); 
         userInput = keyedInput.nextLine();
         
         
        try 
        {
         entries = Integer.parseInt(userInput);
         invalid = false;
        }
        catch (NumberFormatException e)
         {
           System.out.println("Sorry that was not a valid input.");
         }
         
     }
     
     String movieName [] = new String [entries];
     int likes [] = new int [entries];
     int dislikes [] = new int [entries];
     double likePerc [] = new double [entries];
     int i;
     for (i = 0; i < entries; i = i + 1)
     {
         System.out.println("Enter the name for movie"+ (i+1)+": ");
         movieName[i] = keyedInput.nextLine();
         
         invalid = true;
         while (invalid)
         {
             System.out.println("Enter how many people liked " + movieName[i]+"");
             userInput = keyedInput.nextLine();
             
             try 
             {
                 likes[i] = Integer.parseInt(userInput);
                 invalid = false;
             }
             catch (NumberFormatException e)
             {
                 System.out.println("Sorry, that was not a valid input. ");
             }
         }
         
         invalid = true;
         while (invalid)
         {
             System.out.println("Enter the number of people who disliked " + movieName[i] +"");
             userInput = keyedInput.nextLine();
             try 
             {
             dislikes [i] = Integer.parseInt(userInput);
             invalid = false;
             }
             catch (NumberFormatException e)
             {
                 System.out.println("Sorry, that was not a valid input.");
             }
         }
         
     }
     
     for (i = 0; i < entries; i = i +1 )
         {
          likePerc[i] = ((double)dislikes[i]/(double)(likes[i]+dislikes[i]))*100;
          likePerc[i] = likePerc[i]*100;
          likePerc[i] = Math.round(likePerc[i]);
          likePerc[i] = likePerc[i]/100;
         }
     
     while (choices != 3)
     {
       invalid = true;
       while (invalid)
       {
           System.out.println("Select an option : ");
           System.out.println("1. Output original data");
           System.out.println("2. Output like percentage of movies");
           System.out.println("3. Exit.");
           System.out.println("Enter your choice :");
           userInput = keyedInput.nextLine();
           
           try 
           {
               choices = Integer.parseInt(userInput);
               invalid = false;
           }
           catch (NumberFormatException e)
           {
               System.out.println("Sorry, that was not a valid input.");
           }
           
           switch (choices)
           {
               case 1:
               {
                   for (i = 0; i < entries; i = i+1)
                   {
                       System.out.println("The movie " + movieName[i]+ "is liked by " +likes[i]+" people and is disliked by "+dislikes[i]+" people.");
                   }
                   break;
               }
               
               case 2 :
               {
               for (i = 0; i < entries; i = i+1)
               {
                   System.out.println("The movie " +movieName[i]+" has a like percentage of "+likePerc[i]+" percent");
               }
               break;
               }
               case 3 :
               {
                   System.out.println("Thank you for using this program!");   
               }
           }
           
       }
     }
         
       
    }
    
}
