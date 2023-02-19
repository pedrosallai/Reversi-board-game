import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * This class runs the game and controls the menu
 * 
 * @author Peter Sallai
 * @version 1.2
 */
public class Director extends GameBoard
{
    static int choice;
    static boolean game;
    
    public Director()
    {
    }
    
    /** 
     * getInteger() returns an integer value. Exception handling is used to trap
     * invalid data - including floating point numbers, non-numeric characters
     * and no data. In the event of an exception, the user is prompted to enter
     * the correct data in the correct format.
     * 
     * @return validated int value 
     */
    public static int getInteger()
    {
        int input = 0;
        boolean ok = false;
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        do 
        {
            try
            {
                input = Integer.parseInt(reader.readLine());
                ok = true;
            }

            catch (Exception e)
            {
                if (e instanceof NumberFormatException) 
                {
                    System.out.print("Integer value needed: ");
                }
                else
                {
                    System.out.println("Error: " + e.toString());
                }
            }
          
        } while(ok == false);
        
        return(input);
    }
    
    /** 
      * getString() returns a String entered at the keyboard.
      * @return String value
      */
     
    public static String getString()
    {
        String input = "";
        
        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            input = reader.readLine();
        }
        catch (Exception e)
        {
            System.out.println("Error: " + e.toString());
        }
        
        return(input);
    }

    public static void main(String[] args)
    {
        game = true; 
        
        while (game == true)
        {
            System.out.println("#####################################################################"); 
            System.out.println("#####################################################################");
            System.out.println("###                                                               ###");
            System.out.println("###                      »»»» MazeRunner ««««                     ###");        
            System.out.println("###                       1. Start new game                       ###");
            System.out.println("###                       2. Load game                            ###");
            System.out.println("###                       3. Exit                                 ###");
            System.out.println("###                                                               ###");
            System.out.println("#####################################################################");
            System.out.println("#####################################################################"); 
            
            choice = getInteger();
        
            if (choice == 3)
            {
                game = false;
            }
        
            if (choice == 1)
            {
                System.out.print('\f');
            
                Director game = new Director();        
                play = true;
                
                game.displayBoard();
                whitePlayer = false;
        
                System.out.println("   The game started.");
            
                while (play == true)
                {
                    game.gameMove();
                    game.gameOver();
                    
                    if (play == true) 
                    {
                        game.displayBoard();
                    }     
                    
                    if ((play == false) && (save == true))
                    {
                        break;
                    }
                    
                    if (play == false)
                    {
                        game.gameOverScreen();
                    }
                }
            }
            
            if (choice == 2)
            {
                System.out.print('\f');
                System.out.println("Saved game successfully loaded.\n");
            
                Director game = new Director();        
                play = true;
                
                game.loadGame();
                game.displayBoard();
                
                while (play == true)
                {
                    game.gameMove();
                    game.gameOver();
                    
                    if (play == true) 
                    {
                        game.displayBoard();
                    }
                    
                    if ((play == false) && (save == true))
                    {
                        break;
                    }
                    
                    if (play == false)
                    {
                        game.gameOverScreen();
                    }    
                }
            }
        }
        
        System.out.print('\f');
        System.out.print("Thanks for playing. See you later.");
    }     
} 