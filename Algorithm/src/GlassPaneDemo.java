
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class GlassPaneDemo extends JFrame
{
 public GlassPaneDemo()
 {
  super("::GlassPaneDemo:");

  Container cp = getContentPane();
  cp.add(new JScrollPane(new JTextArea()));
 
  JComponent gp = (JComponent)getGlassPane();
  gp.setLayout(null);
 
  JPanel p1 = new JPanel(new GridLayout(0,1,5,5));
  gp.add(p1);
  p1.setBounds(200,10,80,100);

  JButton btNew = new JButton("NEW");
  btNew.setBackground(Color.blue);
  btNew.setForeground(Color.white);
  p1.add(btNew);

  JButton btCopy = new JButton("COPY");
  btCopy.setBackground(Color.red);
  btCopy.setForeground(Color.white);
  p1.add(btCopy);

  JButton btPaste = new JButton("PASTE");
  btPaste.setBackground(Color.yellow);
  btPaste.setForeground(Color.black);
  p1.add(btPaste);

  gp.setVisible(true); // GlassPane도 setVisible(true)를 줘야 나온다...
  p1.setOpaque(false); // 투명하게....
  btPaste.setOpaque(false);
 
  //윈도우 창닫기....
  addWindowListener(
   new WindowAdapter(){
 
    public void windowClosing(WindowEvent e){
     System.exit(0);
    } 
   }
  );
  }

 public static void main(String[] args)
 {
  GlassPaneDemo d = new GlassPaneDemo();
  d.setSize(500,500);
  d.setVisible(true);
 }
}