import java.util.*;
import java.util.List;
import java.awt.*;
import java.awt.event.*;

 
public class Triangle extends Frame {
 
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  int x = 100;
	
public Polygon mypolygon = new Polygon();
     
  public void paint(Graphics g) {
	 super.paintComponents(g);
	 
     Graphics2D ga = (Graphics2D)g;
     
     ga.setPaint(Color.red);
     ga.drawPolygon(mypolygon);
     ga.drawOval(200, 200, 100, 100);
     
    while(x> 0){ 
    	 ga.drawString(String.valueOf(x), 100, 10+(x*25));
    	 x--;
    }
     
  }
   
       
  public static void main(String args[]) {
     List< Integer > srcpoints = new ArrayList< Integer >();
     srcpoints.add(1);srcpoints.add(20);
     srcpoints.add(30);srcpoints.add(40);
     srcpoints.add(50);srcpoints.add(60);
     srcpoints.add(srcpoints.get(0));
     srcpoints.add(srcpoints.get(1));
      
     Triangle frame = new Triangle();
     for(int i = 0; i < srcpoints.size(); i++)
     {
         int x = srcpoints.get(i++);
         int y = srcpoints.get(i);
         frame.mypolygon.addPoint(x, y);
         
     }
      
     frame.addWindowListener(
      new WindowAdapter()
      {
         public void windowClosing(WindowEvent we)
         {
            System.exit(0);
         }
      }
     );
      
   frame.setSize(400, 400);
   frame.setVisible(true);
  }
}
