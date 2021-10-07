package tetrisgame;
import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
public class TetrisGame extends JFrame {
    JLabel statusbar;
    public TetrisGame() {
        statusbar = new JLabel(" 0");
        add(statusbar, BorderLayout.SOUTH);
        Board board = new Board(this);
        add(board);
        board.start();
        setResizable(false);
        setSize(200, 400);
        setTitle("TetrisGame");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
   }

   public JLabel getStatusBar() {
       return statusbar;
   }

    public static void main(String[] args) throws FileNotFoundException, IOException {

     
                InputStream in = null;
                in = new FileInputStream(new File("permit.txt"));//parental
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                String s=reader.readLine();
                int flag=1;
                if(s!=null){
                flag=Integer.parseInt(s);
                }
                    
                if(flag==1){
                    
                    InputStream in1 = null;
                    in1 = new FileInputStream(new File("timelimit.txt"));//restriction
                    BufferedReader reader1 = new BufferedReader(new InputStreamReader(in1));
                    String s1=reader1.readLine();
                    int flag1=0;
                    if(s1!=null)
                    { 
                        flag1=Integer.parseInt(s1);
                    
                        
                    if(flag1>0){
                    
                    
                    InputStream in2 = null;
                    in2 = new FileInputStream(new File("count.txt"));//usage count
                    BufferedReader reader2 = new BufferedReader(new InputStreamReader(in2));
                    String s2=reader2.readLine();
                    int flag2=0;
                    if(s2!=null){
                    flag2=Integer.parseInt(s2);
                    }
                    flag2=flag2+1;
                    
                    
                    DataOutputStream dataOut = new DataOutputStream(new FileOutputStream("count.txt"));
                    dataOut.writeBytes(Integer.toString(flag2));  
                    
                    
                    //new Reminder(flag1);
                    System.out.println(flag1);
                    Date sd=new Date();
                    String sdate=sd.toString();
                    DataOutputStream data = new DataOutputStream(new FileOutputStream("history.txt",true));
                    data.writeBytes(sdate);  
                    data.writeBytes("\n");
                   TetrisGame game = new TetrisGame();
        game.setLocationRelativeTo(null);
        game.setVisible(true);    }
                  
                    }
                    else
                    {
                        Date sd=new Date();
                     
                        String sdate=sd.toString();
                    DataOutputStream data = new DataOutputStream(new FileOutputStream("history.txt",true));
                    data.writeBytes(sdate);  
                    data.writeBytes("\n");
                   
                   TetrisGame game = new TetrisGame();
        game.setLocationRelativeTo(null);
        game.setVisible(true);    
                    }    
                }
                else
                {
              //      JOptionPane.showMessageDialog(null, "Parental Mode is Enabled");
                new parentsound();    
                }
    } 
}

//class Reminder 
//{
//    java.util.Timer timer;
//
//    public Reminder(int seconds) 
//    {
//        timer = new java.util.Timer();
//        timer.schedule(new RemindTask(), seconds*1000);
//    }
//
//    class RemindTask extends TimerTask 
//    {
//        @Override
//        public void run() {
//              
//            Date d=new Date();
//            DataOutputStream dataOut = null;
//            try {
//                dataOut = new DataOutputStream(new FileOutputStream("history.txt",true));
//            } catch (FileNotFoundException ex) {
//                Logger.getLogger(Reminder.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            try {  
//                dataOut.writeBytes(d.toString());
//                dataOut.writeBytes("\n");
//                
//            } catch (IOException ex) {
//                Logger.getLogger(Reminder.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            timer.cancel();
//            new timeframe();        
//            System.exit(1);
//     }
//    }
//  }