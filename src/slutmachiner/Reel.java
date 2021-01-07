package SlutMachiner;
import java.util.*;
import java.awt.*;
import javax.swing.*;


public class Reel {
    String url = "E:\\DOWNLOADS\\Second year stuff\\Second Year Computer Science Projects\\SlutMachiner";
    
   int Fruits = 0;
   
   //Making all my images an appropriate size so that it displays nicely in my window
   private ImageIcon Cherry2 = new ImageIcon("cherry.png");
   private Image CherryImage = Cherry2.getImage().getScaledInstance(100, 100 , java.awt.Image.SCALE_SMOOTH);
   private ImageIcon CherryImage3 = new ImageIcon(CherryImage);
   
   private ImageIcon Lemon3 = new ImageIcon("lemon.png");
   private Image LemonImage = Lemon3.getImage().getScaledInstance(100, 100 , java.awt.Image.SCALE_SMOOTH);
   private ImageIcon LemonImage3 = new ImageIcon(LemonImage);
   
   private ImageIcon Plum4 = new ImageIcon("plum.png");
   private Image PlumImage = Plum4.getImage().getScaledInstance(100, 100 , java.awt.Image.SCALE_SMOOTH);
   private ImageIcon PlumImage3 = new ImageIcon(PlumImage);

   private ImageIcon Watermelon5 = new ImageIcon("watermelon.png");
   private Image WatermelonImage = Watermelon5.getImage().getScaledInstance(100, 100 , java.awt.Image.SCALE_SMOOTH);
   private ImageIcon WatermelonImage3 = new ImageIcon(WatermelonImage);
   
   
   private ImageIcon Bell6 = new ImageIcon("bell.png");
   private Image BellImage = Bell6.getImage().getScaledInstance(100, 100 , java.awt.Image.SCALE_SMOOTH);
   private ImageIcon BellImage3 = new ImageIcon(BellImage);
      
   private ImageIcon Seven7 = new ImageIcon("redseven.png");
   private Image SevenImage = Seven7.getImage().getScaledInstance(100, 100 , java.awt.Image.SCALE_SMOOTH);
   private ImageIcon SevenImage3 = new ImageIcon(SevenImage);
   
   
   
   
   
   
   
   
   private Symbol Cherry = new Symbol(2, CherryImage3);
   private Symbol Lemon = new Symbol(3, LemonImage3);
   private Symbol Plum = new Symbol(4, PlumImage3);
   private Symbol Watermelon = new Symbol(5, WatermelonImage3);
   private Symbol Bell = new Symbol(6, BellImage3);
   private Symbol Seven = new Symbol(7, SevenImage3);
   
   ArrayList<Symbol> fruits=new ArrayList<Symbol>() ;

   
   public Reel(){
     fruits.add(Cherry);
     fruits.add(Lemon);
     fruits.add(Plum);
     fruits.add(Watermelon);
     fruits.add(Bell);
     fruits.add(Seven);
   }
   public ImageIcon getCherry(){
       return CherryImage3;
   }

    public Symbol spin(){

     Symbol f = fruits.get(Fruits);
     Fruits++;
     if (Fruits == 6){
         Fruits = 0;
     }
     return f;
   }
   
}

