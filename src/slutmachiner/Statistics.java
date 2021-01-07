
package SlutMachiner;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author w1546167
 */
public class Statistics extends SlutMachiner{
    int PlayerW = 0;
    int PlayerL = 0;
    double AverageC = 0;
    JLabel PlayerWins = new JLabel("");
    JLabel PlayerLoss = new JLabel("");
    JLabel AverageCredits = new JLabel("");
    JFrame stats;
     
    public Statistics(){
        
            stats = new JFrame("Statistics");        
            stats.setLayout(new BorderLayout());
            JLabel Empty = new JLabel("");
            JPanel panel = new JPanel();
            JButton WinGraph = new JButton();
            JButton LoseGraph = new JButton();
            JButton Save = new JButton("Save");
            PlayerWins = new JLabel("Wins: " + PlayerW);
            PlayerLoss = new JLabel("Loss: " + PlayerL);
            AverageCredits = new JLabel("Average Credits won/loss: " + AverageC);
            
           
            stats.add(Empty,BorderLayout.NORTH);
            stats.add(Empty,BorderLayout.EAST);
            stats.add(Save,BorderLayout.SOUTH);
            stats.add(Empty,BorderLayout.WEST);
            
            
            panel.add(PlayerWins);
            panel.add(PlayerLoss);
            panel.add(AverageCredits);


            stats.add(panel, BorderLayout.CENTER);          
           
            Save.addActionListener(new Save());      
            stats.setSize(350,350);
    }
    
    public void addWin(){
      this.PlayerW=this.PlayerW+1;
      this.PlayerWins.setText("Wins: " + PlayerW);
    }
    public void addLose(){
       this.PlayerL=this.PlayerL+1;
       this.PlayerLoss.setText("Loss: " + PlayerL);
    }
    public void addAverage(int x){
        this.AverageC = this.AverageC + x;
       
    }
    private class Save implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent evt){
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yy HH-mm-ss");
                Date date = new Date();
                try {
                    BufferedWriter logWriter = new BufferedWriter(new FileWriter(dateFormat.format(date) + ".txt", true));
                    logWriter.write("Wins: " +SlutMachiner. TheStats.PlayerW + "\r\n");
                    logWriter.write("Loss: " + SlutMachiner.TheStats.PlayerL+ "\r\n");
                    logWriter.write("Average Credits win/loss: " +SlutMachiner.TheStats.AverageC/(SlutMachiner.TheStats.PlayerW+SlutMachiner.TheStats.PlayerL));
                    logWriter.close();
                } catch (IOException ex) {
                    Logger.getLogger(Statistics.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("Could not save to a textfile!");
                }
            }
        }
}

