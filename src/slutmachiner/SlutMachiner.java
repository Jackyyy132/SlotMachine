package SlutMachiner;
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 *
 * @author w1546167
 */
public class SlutMachiner extends JFrame implements Runnable{
    
    JButton AddCoinButton;   
    JButton BetOneButton;
    JButton BetMaxButton;
    JButton ResetButton;
    JButton SpinButton;
    JButton StatisticsButton;
    JButton FirstReel;
    JButton SecondReel;
    JButton ThirdReel;
    JLabel BetLabel;
    

    static JLabel SlutMachine;
    static JFrame slutmachine;
    static Symbol[] win = new Symbol[3];
    static SlutMachiner SM;

  
    private int count = 0;
    public static int Credits = 10;
    public static int Bet = 0;
    private int Used = 0;
    boolean spin = false;
    Reel reel = new Reel();
    static Reel r1 =new Reel();
    static Reel r2 =new Reel();
    static Reel r3 =new Reel();
    static Statistics TheStats;
    static Thread t1 ;
    static Thread t2;
    static Thread t3;

   JLabel CreditAreaLabel = new JLabel("Credits = " + Credits);

    public SlutMachiner(){
        super("Slut Machine");
        //Setting the grid layout with 4 rows 3 colums
        
        setLayout(new GridLayout(4,3));
        
        //Starting the thread
        t1 = new Thread(this);
        t2 = new Thread(this);
        t3 = new Thread(this);
        
        //Adding action listeners to the following buttons
        AddCoinButton = new JButton("Add Coin");
        AddCoinButton.addActionListener(new AddCoin());
        BetOneButton = new JButton("Bet One");
        BetOneButton.addActionListener(new BetOne());
        BetMaxButton = new JButton("Bet Max");
        BetMaxButton.addActionListener(new BetMax());
        ResetButton = new JButton("Reset");
        ResetButton.addActionListener(new Reset());
        SpinButton = new JButton("Spin");
        SpinButton.addActionListener(new Spin());
        BetLabel = new JLabel("Bet = " + Bet);
        SlutMachine = new JLabel("                 Slut Machine");
        StatisticsButton = new JButton ("Statistics");
        StatisticsButton.addActionListener(new Statistic());
        
        //Giving all the reels an initial value of cherry
        FirstReel = new JButton();
        FirstReel.addActionListener(new Reeler1());
        FirstReel.setIcon(reel.getCherry());
        FirstReel.setEnabled(false);
        
        SecondReel = new JButton();
        SecondReel.setIcon(reel.getCherry());
        SecondReel.addActionListener(new Reeler2());
        SecondReel.setEnabled(false);
        
        ThirdReel = new JButton();
        ThirdReel.setIcon(reel.getCherry());
        ThirdReel.addActionListener(new Reeler3());
        ThirdReel.setEnabled(false);
        
        //Adding buttons to the slot machine
        add(StatisticsButton);
        add(SlutMachine);
        add(ResetButton);
        add(FirstReel);
        add(SecondReel);
        add(ThirdReel);
        add(CreditAreaLabel);
        add(SpinButton);
        add(BetLabel);
        add(AddCoinButton);
        add(BetOneButton);
        add(BetMaxButton);
        

       

    
    }
    private class Spin implements ActionListener{
        @Override     
        public void actionPerformed(ActionEvent evt){
            
            FirstReel.setEnabled(true);
            SecondReel.setEnabled(true);
            ThirdReel.setEnabled(true);
            if (Bet <= 0){    
            FirstReel.setEnabled(false);
            SecondReel.setEnabled(false);
            ThirdReel.setEnabled(false);
            JOptionPane.showMessageDialog(slutmachine, "HEY! You must bet first in order to play!");
            }            
            
            else{
                //Let my boolean spin be true so that my reels can spin
                SM.spin = true;
                StatisticsButton.setEnabled(false);
                ResetButton.setEnabled(false);
                BetOneButton.setEnabled(false);
                BetMaxButton.setEnabled(false);
                SpinButton.setEnabled(false);
            }
        }
    }
    
    private class Reeler1 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evt){
            int TotalWin = 0;
            //When user presses the ree1, it will make my boolean false in order to stop the thread
            spin = false;
            Used = 0;
            StatisticsButton.setEnabled(true);
            ResetButton.setEnabled(true);
            BetOneButton.setEnabled(true);
            BetMaxButton.setEnabled(true);
            SpinButton.setEnabled(true);
            Symbol MySymbol = new Symbol();
            //Go to the win or lose method in Symbol class to check whether we win or lose according to the reels pictures
            MySymbol.WinOrLose();
            //Update the window to show the latest wins and loss and average credits won/loss per game
            SlutMachiner.TheStats.PlayerWins.setText("Wins: " +SlutMachiner. TheStats.PlayerW);
            SlutMachiner.TheStats.PlayerLoss.setText("Loss: " + SlutMachiner.TheStats.PlayerL);
            SlutMachiner.TheStats.AverageCredits.setText("Average Credits win/loss: " +SlutMachiner.TheStats.AverageC/(SlutMachiner.TheStats.PlayerW+SlutMachiner.TheStats.PlayerL));
            Credits = Credits + TotalWin;
            CreditAreaLabel.setText("Credits = " + Credits);
            Bet = 0;
            BetLabel.setText("Bet = " + Bet);
            FirstReel.setEnabled(false);
            SecondReel.setEnabled(false);
            ThirdReel.setEnabled(false);
        }
    }
    private class Reeler2 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evt){
            boolean WinOrLose = false;
            int TotalWin = 0;
            spin = false;
            Used = 0;
            StatisticsButton.setEnabled(true);
            ResetButton.setEnabled(true);
            BetOneButton.setEnabled(true);
            BetMaxButton.setEnabled(true);
            SpinButton.setEnabled(true);
            Symbol MySymbol = new Symbol();
            MySymbol.WinOrLose();
            SlutMachiner.TheStats.PlayerWins.setText("Wins: " +SlutMachiner. TheStats.PlayerW);
            SlutMachiner.TheStats.PlayerLoss.setText("Loss: " + SlutMachiner.TheStats.PlayerL);
            SlutMachiner.TheStats.AverageCredits.setText("Average Credits win/loss: " +SlutMachiner.TheStats.AverageC/(SlutMachiner.TheStats.PlayerW+SlutMachiner.TheStats.PlayerL));
            Credits = Credits + TotalWin;
            CreditAreaLabel.setText("Credits = " + Credits);
            Bet = 0;
            BetLabel.setText("Bet = " + Bet);
            FirstReel.setEnabled(false);
            SecondReel.setEnabled(false);
            ThirdReel.setEnabled(false);
        }
    }
    private class Reeler3 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evt){
            boolean WinOrLose = false;
            int TotalWin = 0;
            spin = false;
            Used = 0;
            StatisticsButton.setEnabled(true);
            ResetButton.setEnabled(true);
            BetOneButton.setEnabled(true);
            BetMaxButton.setEnabled(true);
            SpinButton.setEnabled(true);
            Symbol MySymbol = new Symbol();
            MySymbol.WinOrLose();
            SlutMachiner.TheStats.PlayerWins.setText("Wins: " +SlutMachiner. TheStats.PlayerW);
            SlutMachiner.TheStats.PlayerLoss.setText("Loss: " + SlutMachiner.TheStats.PlayerL);
            SlutMachiner.TheStats.AverageCredits.setText("Average Credits win/loss: " +SlutMachiner.TheStats.AverageC/(SlutMachiner.TheStats.PlayerW+SlutMachiner.TheStats.PlayerL));
            Credits = Credits + TotalWin;
            CreditAreaLabel.setText("Credits = " + Credits);
            Bet = 0;
            BetLabel.setText("Bet = " + Bet);
            FirstReel.setEnabled(false);
            SecondReel.setEnabled(false);
            ThirdReel.setEnabled(false);
        }
    }

    @Override
    public void run() {
        int x = 0;
        //Putting my thread into an infinite loop so that it constantly keeps checking my run method
        while (x == 0){
        System.out.print("");
        while (SM.spin == true){
        if (Thread.currentThread() == t1){
            win[0]=r1.spin();
            SM.FirstReel.setIcon(win[0].getImage());
            }
        if (Thread.currentThread() == t2){
                win[1]=r2.spin();
                SM.SecondReel.setIcon(win[1].getImage());
        }
        if (Thread.currentThread() == t3){
                win[2]=r3.spin();
                SM.ThirdReel.setIcon(win[2].getImage());
        }
        }
        }

    }
    
    private class AddCoin implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evt){
            //Add credits by 1
            SM.Credits++;
            SM.CreditAreaLabel.setText("Credits = " + SM.Credits);
        }
    }
    private class BetOne implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evt){
            //Checks whether you have enough credits to bet, if its greater than 0 then you can bet and your credits will minus
            if (Credits > 0){
            Bet++;
            Credits--;
            CreditAreaLabel.setText("Credits = " + Credits);
            BetLabel.setText("Bet = " + Bet);
            }
            else {
                //else add more credits
            JOptionPane.showMessageDialog(slutmachine, "HEY! Add more credits to bet more!");
            }
        }
    }
    private class BetMax implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evt){
            Used++;
            if (Credits < 3){
                JOptionPane.showMessageDialog(slutmachine, "Hey! You need 3 or more credits in order to bet max");
                Used = 0;
            }
            if (Used == 1 && Credits > 2){
            Bet = Bet + 3;
            Credits = Credits - 3;
            CreditAreaLabel.setText("Credits = " + Credits);
            BetLabel.setText("Bet = " + Bet);
            } 
            if (Used > 1){                
            JOptionPane.showMessageDialog(slutmachine, "Hey! You can only bet max once");
            }
        }
    }
    private class Reset implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evt){
            if (Bet > 0){
                Credits = Credits + Bet;
                Bet = 0;
                Used = 0;
                CreditAreaLabel.setText("Credits = " + Credits);
                BetLabel.setText("Bet = " + Bet);
            }
        }
    }
    private class Statistic implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent evt){  
            //Set the size and visibility when statistics button is pressed
              TheStats.setSize(300,300);
              TheStats.stats.setVisible(true);           
        }
    }

    
    

    public static void main(String[] args) {
        SM = new SlutMachiner();   
        
        SM.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SM.setSize(500,500);
        SM.setVisible(true);
        TheStats = new Statistics();
        //Start the thread when the program starts
        t1.start();
        t2.start();
        t3.start();

     
    }
    
}

