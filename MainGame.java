import java.util.Arrays;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MainGame 
{
    
    public static String rightAnswer[] = getAnswer.answer();
    public static void main(String args[])
    {
        GuiRecover GuiRecover = new GuiRecover();
    }
}

class getAnswer 
{
    public static String[] answer()
    {
        int computerAnswer  = Recover.randomNumber();
        String computerAnswers[] = Integer.toString(computerAnswer).split("");
        if(computerAnswers.length <4)
        {
            String[] newAnswers = {"0", computerAnswers[0],computerAnswers[1],computerAnswers[2]};
            computerAnswers= newAnswers;
        }
        return computerAnswers;
    }
}
