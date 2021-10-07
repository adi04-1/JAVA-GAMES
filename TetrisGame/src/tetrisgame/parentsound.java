/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetrisgame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
public class parentsound extends JFrame 
{
    
    private final static int BUFFER_SIZE = 40000000;
    private static File soundFile;
    private static AudioInputStream audioStream;
    private static AudioFormat audioFormat;
    private static SourceDataLine sourceLine;
        //JButton =new JButton(new ImageIcon("registericon.jpg"));
        //JButton login=new JButton(new ImageIcon("loginicon.jpg"));
        JPanel pane=new JPanel();
        //ImageIcon pic = new ImageIcon("digitaldiet.png");
        Box vertical = Box.createVerticalBox();
    public parentsound()
    {
          playSound("boomclap0.wav");
        time("text", "logo");
      
    }
   public  void time (String title,String logo)
    {
         

        setTitle(title);
	setSize(100,100);
	setLocationRelativeTo(null);
	setDefaultCloseOperation(EXIT_ON_CLOSE);
	setVisible(false);
	setLayout(new BorderLayout());
	vertical.add(Box.createVerticalStrut(120));
        JOptionPane.showMessageDialog (null, "You are restricted to use this App,because it is under parental control", "AlertMessage", JOptionPane.WARNING_MESSAGE);
//        dispatchEvent(new WindowEvent(null,WindowEvent.WINDOW_CLOSING));
    }   
    /**
     * @param filename the name of the file that is going to be played
     */
    public static void playSound(String filename){

        String strFilename = filename;

        try {
            soundFile = new File(strFilename);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

        try {
            audioStream = AudioSystem.getAudioInputStream(soundFile);
        } catch (Exception e){
            e.printStackTrace();
            System.exit(1);
        }

        audioFormat = audioStream.getFormat();

        DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
        try {
            sourceLine = (SourceDataLine) AudioSystem.getLine(info);
            sourceLine.open(audioFormat);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
            System.exit(1);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

        sourceLine.start();

        int nBytesRead = 0;
        byte[] abData = new byte[BUFFER_SIZE];
        while (nBytesRead != -1) {
            try {
                nBytesRead = audioStream.read(abData, 0, abData.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (nBytesRead >= 0) {
                @SuppressWarnings("unused")
                int nBytesWritten = sourceLine.write(abData, 0, nBytesRead);
            }
        }

        sourceLine.drain();
        sourceLine.close();
    }
    public static void main(String []args)
    {
         
        //Finalimage f=new Finalimage();
        parentsound t=new parentsound();
        
        
    }
}
      