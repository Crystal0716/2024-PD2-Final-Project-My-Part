import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.*;

public class GuiRecover extends MainGame
{
    public static JFrame major , win ,lose , wrongMore , wrongLess;
    private JLabel lb1, lb2 ,lbWin ,lbLose ,lbWrongMore , lbWrongLess;
    private static JTextField enter;
    private JTextArea textArea;
    private JButton guess;
    private StringBuilder previousText = new StringBuilder();
    private int A,B ;
    public GuiRecover()
    {
        major = new JFrame("4 digits");
        major.setLayout(null);

        lb1 = new JLabel("Please enter 4 different numbers ");
        lb1.setBounds(5, 5, 250, 20);
        major.add(lb1);

        enter = new JTextField("");
        enter.setBounds(260, 5, 100, 20);
        major.add(enter);

        textArea = new JTextArea();
        textArea.setEditable(false); 
        JScrollPane scrollPane = new JScrollPane(textArea); 
        scrollPane.setBounds(5, 80, 370, 200); 
        major.add(scrollPane);

        lb2 = new JLabel("Yoou have 10 chance");
        lb2.setBounds(5, 60, 200, 20);
        major.add(lb2);

        guess = new JButton("Guess");
        guess.setBounds(5, 27, 100, 20);
        guess.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                String input = getInputValue();
                String inputs[] = input.split("");
                if(inputs.length > 4)
                {
                    wrongMore.setVisible(true);
                    updateTextArea2(Recover.time);
                }
                else if(inputs.length < 4)
                {
                    wrongLess.setVisible(true);
                    updateTextArea2(Recover.time);
                }
                else if(Recover.time <= 10 && (!Recover.isFinish))
                {
                    A = Recover.howManyA(inputs, MainGame.rightAnswer);
                    B = Recover.howManyB(inputs, MainGame.rightAnswer);
                    updateTextArea1(Recover.time, input, A, B);
                }
                enter.setText("");
                Recover.time++ ;
                Recover.winORlose();
                if(Recover.time==11)
                {
                    guess.setVisible(false);
                }
            }
        });
        major.add(guess);

        major.setSize(400, 450);
        major.setVisible(true);
        major.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        win = new JFrame("Win");
        win.setSize(400, 100);
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lbWin = new JLabel("You win the game");
        lbWin.setVisible(true);
        win.add(lbWin);

        win.setLayout(null);
        lbWin.setBounds(5, 30, 200, 20);

        lose = new JFrame("Lose");
        lose.setSize(400, 100);
        lose.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lbLose = new JLabel("You fail the game");
        lbLose.setVisible(true);
        lose.add(lbLose);

        lose.setLayout(null);
        lbLose.setBounds(5, 30, 200, 20);

        wrongMore = new JFrame("Wrong");
        wrongMore.setSize(400, 100);
        wrongMore.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        lbWrongMore = new JLabel("You enter more than 4 numbers");
        lbWrongMore.setVisible(true);
        wrongMore.add(lbWrongMore);

        wrongLess = new JFrame("Wrong");
        wrongLess.setSize(400, 100);
        wrongLess.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        lbWrongLess = new JLabel("You enter more than 4 numbers");
        lbWrongLess.setVisible(true);
        wrongLess.add(lbWrongLess);

    }

    public void updateTextArea1(int playTime , String input , int A , int B) 
    {
        if(A != 4)
        {
            previousText.append("Play times ").append(playTime).append(" : ").append(input).append("    ").append(A).append(" A ").append(B).append(" B\n");
            textArea.setText(previousText.toString());
        }
        else
        {
            Recover.isWin = true ;
        }
                
    }

    public void updateTextArea2(int playTime) 
    {
        previousText.append("Play times ").append(playTime).append(" : You eneter wrong \n" );
        textArea.setText(previousText.toString());       
    }


    public static String getInputValue() 
    {
        return enter.getText();
    }

}
