import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Recover 
{
    public static boolean isWin = false;
    public static int time = 1 ;
    public static boolean isFinish = false;

    public static void winORlose()
    {
        if (isWin || time > 10) 
        {
            isFinish = true ;
        }
        if(isFinish)
        {
            if(isWin)
            {
                GuiRecover.win.setVisible(true);
            }
            else
            {
                GuiRecover.lose.setVisible(true);
            }
        }
        
    }

    public static int randomNumber()
    {
        Random random = new Random();
        int totalRandomNumbers = 0 ;
        int randomNumbers[] = new int[4];
        boolean usedNumber[] = new boolean[10];
        for(int i = 0 ; i < 4 ; i++ )
        {
            int newNumber ;
            do
            {
                newNumber = random.nextInt(10);
            }
            while(usedNumber[newNumber]);
            randomNumbers[i] = newNumber ;
            usedNumber[randomNumbers[i]] = true ;
        }
        totalRandomNumbers = (randomNumbers[0]*1000+randomNumbers[1]*100+randomNumbers[2]*10+randomNumbers[3]*1);
        return totalRandomNumbers ;
    }

    public static int howManyA(String inPutNumbers[] ,String answers[])
    {
        int a = 0 ;
        for(int i = 0 ; i < 4 ; i++)
        {
            if(inPutNumbers[i].equals(answers[i]))
            {
                a++ ;
            }
        }
        
        return a;
    }

    public static int howManyB(String inPutNumbers[] ,String answers[])
    {
        int b = 0 ;
        for(int i = 0 ; i < 4 ; i++)
        {
            for(int j = 0 ; j < 4 ; j++)
            {
                if( i != j && inPutNumbers[i].equals(answers[j]))
                {
                    
                    b++ ;
                }
            }
        }
        
        return b;
    }

}
