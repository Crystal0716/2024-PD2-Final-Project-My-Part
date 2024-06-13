import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GuiRecover extends MainGame
{
    private JFrame jFrame , jFrame2 ;
    private JLabel lb1, lb2 ,lbWrong;
    private static JTextField tf1;
    private JTextArea textArea;
    private JButton btn1 , btn2;
    private int playTime , A , B;  
    private int answer;
    private StringBuilder previousText = new StringBuilder();

    public GuiRecover() 
    {
        jFrame = new JFrame("Recover Game");
        jFrame.setLayout(null);

        lb1 = new JLabel("Please enter 4 different numbers ");
        lb1.setBounds(5, 5, 250, 20);
        jFrame.add(lb1);

        tf1 = new JTextField("");
        tf1.setBounds(260, 5, 100, 20);
        jFrame.add(tf1);

        btn1 = new JButton("Guess");
        btn1.setBounds(5, 27, 100, 20);
        jFrame.add(btn1);

        textArea = new JTextArea();
        textArea.setEditable(false); 
        JScrollPane scrollPane = new JScrollPane(textArea); 
        scrollPane.setBounds(5, 80, 370, 200); 
        jFrame.add(scrollPane);

        playTime = 1;
        answer = Recover.randomNumber();

        lb2 = new JLabel("Yoou have 10 chance");
        lb2.setBounds(5, 60, 200, 20);
        jFrame.add(lb2);



        btn1.addActionListener(new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent e) 
            {
                String input = getInputValue();
                lb2.setVisible(false);
                if (playTime <= 10) 
                {
                    Recover.getNewChance(input, answer, playTime);
                    updateLb2(playTime,input,A,B);
                    playTime++;  
                } 
                else 
                {
                    JFrame jFrame2 = new JFrame("Fail"); 
                    jFrame2.setSize(450, 100);
                    jFrame2.setLayout(null);
                    JLabel lbWrong = new JLabel("You have exceeded the maximum number of guesses.");
                    lbWrong.setBounds((jFrame2.getWidth() - 400) / 2, (jFrame2.getHeight() - 50) / 2, 400, 50);
                    jFrame2.add(lbWrong); 
                    jFrame2.setVisible(true); 
                    btn1.setVisible(false);

                    javax.swing.Timer timer = new javax.swing.Timer(2000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            jFrame.setVisible(false); 
                            lb2.setVisible(false); 
                        }
                    });
                    timer.setRepeats(false); 
                    timer.start(); 

                }
            }
        });
        

        jFrame.setSize(400, 400);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void updateLb2(int playTime , String input , int A , int B) 
    {
        String[] inputs = input.split("");
        String[] answers = Integer.toString(answer).split("");
        if(answer < 1000 )
        {
            String[] newAnswers = {"0", answers[0],answers[1],answers[2]};
            answers = newAnswers;
        }
        A = Recover.howManyA(inputs, answers);
        B = Recover.howManyB(inputs, answers);
        if(A != 4)
        {
            previousText.append("Play times ").append(playTime).append(" : ").append(input).append("    ").append(A).append(" A ").append(B).append(" B\n");
            textArea.setText(previousText.toString());
        }
        else
        {
            JFrame jFrame2 = new JFrame("Win"); 
            JLabel lbWrong = new JLabel("You get one more chance");
            jFrame2.setSize(450, 100);
            lbWrong.setBounds((jFrame2.getWidth() - 400) / 2, (jFrame2.getHeight() - 50) / 2, 400, 50);
            jFrame2.add(lbWrong); 
            jFrame2.setVisible(true);
            lbWrong.setVisible(true); 
            btn1.setVisible(false);
            
            javax.swing.Timer timer = new javax.swing.Timer(2000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    jFrame.setVisible(false); 
                    lb2.setVisible(false); 
                }
            });
            timer.setRepeats(false); 
            timer.start(); 
        }
                
    }

    public static String getInputValue() 
    {
        return tf1.getText();
    }
    
    
}
