package movingshapes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
//主程序
public class PaintProgram extends JFrame implements ActionListener {
   private JComboBox shapeChoice;
   private JButton load, store, color;
   private PaintPanel painter; //绘图板

   public PaintProgram()
   {
   	//创建用户界面
      super( "Moving Shapes Painting Application" );

      Container c = getContentPane();
      JPanel controls = new JPanel();
      painter = new PaintPanel();
      c.add( painter, BorderLayout.CENTER );

      shapeChoice = new JComboBox();
      shapeChoice.addItem( "Line" );
      shapeChoice.addItem( "Rectangle" );
      shapeChoice.addItem( "Oval" );
      shapeChoice.addActionListener( this );
      controls.add( shapeChoice );

      color = new JButton( "Color" );
      color.addActionListener(
         new ActionListener() {
            public void actionPerformed( ActionEvent e )
            {
               Color col = JColorChooser.showDialog(
                            null, "Select a Color", Color.black );
               color.setBackground( col );
               painter.setCurrentColor( col );
            }
         }
      );

      controls.add( color );

      c.add(controls, BorderLayout.NORTH );
   }

   public void actionPerformed( ActionEvent e ) 
   {
   	//设置当前绘图类型
      painter.setCurrentShapeType( "movingshapes."+shapeChoice.getSelectedItem().toString() );
      //等待鼠标操作，在PaintPanel类中处理
   }

   public static void main( String[] args )
   {
      // create application Frame and resize
      PaintProgram app = new PaintProgram();

      app.addWindowListener(
         new WindowAdapter() {
           public void windowClosing( WindowEvent e )
           {
              System.exit( 0 );
           }
         }
      );

      app.setSize( 400, 400 );
      app.setLocation(300,200);
      app.show();
   }
}










