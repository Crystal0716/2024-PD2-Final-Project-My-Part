import java.util.Scanner;
import java.util.Random;

public class MainGame 
{
    public static int recoverORnot = 0;
    public static void main(String[] args) 
    {
        String input = null;
        int answer = Recover.randomNumber();
        int playTime = 0 ;

        GuiRecover GuiRecover = new GuiRecover();
        boolean getOneMoreChance = false;
        if(recoverORnot == 0 )
        {
            Recover.getNewChance(input,answer,playTime);
        }
        else if(recoverORnot == 1)
        {
            getOneMoreChance = true ;
        }

        System.out.println("finish");
    }

    
}


