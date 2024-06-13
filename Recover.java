import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Recover extends MainGame
{
    public static void getNewChance(String input , int answer ,int playTime )
    {
        JFrame jFrame2;
        JLabel lbWrong;
        
        int A ,B ;
        System.out.println("plaese enter different 4 numbers , you have 10 chance can guess");
        String inPutNumber = input ;
        try 
        {
            String inPutNumbers[] = inPutNumber.split("");            
            String answers[] = Integer.toString(answer).split("");
            
                if(answer < 1000 )
                {
                    String[] newAnswers = {"0", answers[0],answers[1],answers[2]};
                    answers = newAnswers;
                }
                
                if((Integer.parseInt(inPutNumber)/1000) < 1 && !inPutNumbers[0].equals("0"))
                {   
                    jFrame2 = new JFrame("Wrong"); 
                    jFrame2.setSize(450, 100);
                    jFrame2.setLayout(null);                
                    lbWrong = new JLabel("You enter less than 4 numbers");
                    lbWrong.setBounds((jFrame2.getWidth() - 400) / 2, (jFrame2.getHeight() - 50) / 2, 400, 50);
                    jFrame2.add(lbWrong);
                    jFrame2.setVisible(true);
                    lbWrong.setVisible(true);
                    System.out.println("you enter less than 4 numbers");
                }
                else if((Integer.parseInt(inPutNumber)/1000) > 9 )
                {
                    jFrame2 = new JFrame("Wrong"); 
                    jFrame2.setSize(450, 100);
                    jFrame2.setLayout(null);
                    lbWrong = new JLabel("You enter more than 4 numbers");
                    lbWrong.setBounds((jFrame2.getWidth() - 400) / 2, (jFrame2.getHeight() - 50) / 2, 400, 50);
                    jFrame2.add(lbWrong);
                    jFrame2.setVisible(true);
                    lbWrong.setVisible(true);
                    System.out.println("you enter more than 4 numbers");
                }
                else if(inPutNumbers[0].equals(inPutNumbers[1])||inPutNumbers[0].equals(inPutNumbers[2])||inPutNumbers[0].equals(inPutNumbers[3])||inPutNumbers[1].equals(inPutNumbers[2])||inPutNumbers[1].equals(inPutNumbers[3])||inPutNumbers[2].equals(inPutNumbers[3]))
                {
                    jFrame2 = new JFrame("Wrong"); 
                    jFrame2.setSize(450, 100); 
                    jFrame2.setLayout(null);
                    lbWrong = new JLabel("You enter repeat number");
                    lbWrong.setBounds((jFrame2.getWidth() - 400) / 2, (jFrame2.getHeight() - 50) / 2, 400, 50);
                    jFrame2.add(lbWrong);
                    jFrame2.setVisible(true);
                    lbWrong.setVisible(true);
                    System.out.println("you enter repeat number");
                }
                else
                {
                    if(inPutNumbers[0].equals(answers[0])&&inPutNumbers[1].equals(answers[1])&&inPutNumbers[2].equals(answers[2])&&inPutNumbers[3].equals(answers[3]))
                    {
                        System.out.println("You get one more chance");
                        MainGame.recoverORnot = 1 ;
                    }
                    else
                    {
                        A = howManyA(inPutNumbers , answers);
                        B = howManyB(inPutNumbers , answers);
                        
                        System.out.println( " " +inPutNumber+" : "+A+" A "+B+" B ");
                        if(playTime == 11)
                        {
                            System.out.println("You fail");
                            MainGame.recoverORnot = 2;
                        }
                        
                    }
                }
            
        }
        catch (NumberFormatException e) 
        {
                    
            System.out.println("You enter wrong " + inPutNumber);
        
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

