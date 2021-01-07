
package SlutMachiner;
import javax.swing.*;

/**
 *
 * @author w1546167
 */
public class Symbol implements ISymbol{
    private int value;
    private ImageIcon ImagePicture;
    
    public Symbol(){
        
    }
    public Symbol(int v, ImageIcon f){
        value = v;
        ImagePicture = f;
    }
    
    
    public void setImage(ImageIcon f){
        ImagePicture = f;
    }
    
    
    @Override
    public ImageIcon getImage(){
        return ImagePicture;
    }
    
    
    public void setValue(int v){
        value = v;
       
    }
    
    public int getValue(){
        return value;
    }
    
    public void WinOrLose(){
            boolean Out = false;
            int TotalWin = 0;
            boolean WinOrLose = false;

            //Checks whether the first, second and last reel match
            if (SlutMachiner.win[0].getValue() == SlutMachiner.win[1].getValue() && SlutMachiner.win[0].getValue() == SlutMachiner.win[2].getValue() && Out == false){
                TotalWin = SlutMachiner.win[0].getValue() * SlutMachiner.Bet;
                JOptionPane.showMessageDialog(SlutMachiner.slutmachine, "Congratz!!! You win! You have won " + TotalWin + " credits!");
                SlutMachiner.Credits = SlutMachiner.Credits + TotalWin;
                SlutMachiner.SM.CreditAreaLabel.setText("Credits = " + SlutMachiner.Credits);
                SlutMachiner.SM.TheStats.addAverage(TotalWin);
                WinOrLose = true;
                Out = true;
                SlutMachiner.SM.TheStats.addWin();
            }
            //Checks whether the first and second reel match
            if (SlutMachiner.win[0].getValue() == SlutMachiner.win[1].getValue() && Out == false){
                TotalWin = SlutMachiner.win[0].getValue() * SlutMachiner.Bet;
                JOptionPane.showMessageDialog(SlutMachiner.slutmachine, "Congratz!!! You win! You have won " + TotalWin + " credits");
                SlutMachiner.Credits = SlutMachiner.Credits + TotalWin;
                SlutMachiner.SM.CreditAreaLabel.setText("Credits = " + SlutMachiner.Credits);
                SlutMachiner.SM.TheStats.addAverage(TotalWin);
                WinOrLose = true;
                Out = true;
                SlutMachiner.SM.TheStats.addWin();
            }
            //Checks whether the first and third reel match
            if (SlutMachiner.win[0].getValue() == SlutMachiner.win[2].getValue() && Out == false){
                TotalWin = SlutMachiner.win[0].getValue() * SlutMachiner.Bet;
                JOptionPane.showMessageDialog(SlutMachiner.slutmachine, "Congratz!!! You win! You have won " + TotalWin + " credits");
                SlutMachiner.Credits = SlutMachiner.Credits + TotalWin;
                SlutMachiner.SM.CreditAreaLabel.setText("Credits = " + SlutMachiner.Credits);
                SlutMachiner.SM.TheStats.addAverage(TotalWin);
                WinOrLose = true;
                Out = true;
                SlutMachiner.SM.TheStats.addWin();
            }
            //Check whether the second and third reel match
            if (SlutMachiner.win[1].getValue() == SlutMachiner.win[2].getValue() && Out == false){
                TotalWin = SlutMachiner.win[1].getValue() * SlutMachiner.Bet;
                JOptionPane.showMessageDialog(SlutMachiner.slutmachine, "Congratz!!! You win! You have won " + TotalWin + " credits");
                 SlutMachiner.SM.TheStats.addAverage(TotalWin);
                SlutMachiner.Credits = SlutMachiner.Credits + TotalWin;
                SlutMachiner.SM.CreditAreaLabel.setText("Credits = " + SlutMachiner.Credits);
                WinOrLose = true;
                Out = true;
                SlutMachiner.SM.TheStats.addWin();
            }
            //If my variable WinOrLose is still false after checking all the reels, this means you have lost and it will do this code
            if (WinOrLose == false){
                JOptionPane.showMessageDialog(SlutMachiner.slutmachine, "Sorry! You did not win. You have lost " + SlutMachiner.Bet + " credits");
                //Multiply Bet by -1 to make my average count negative
                SlutMachiner.SM.TheStats.addAverage(SlutMachiner.Bet*-1);
                SlutMachiner.SM.TheStats.addLose();

            }  
    }
    
    
}

