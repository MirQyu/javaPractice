package movingshapes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
//Ö÷´°Ìå
public class MovingShapes extends JFrame implements ActionListener {
   private JComboBox shapeChoice;
   private JButton load, store, color;
   private PaintPanel painter;

   public MovingShapes()
   {
      super( "Moving Shapes" );

      Container c = getContentPane();
      JPanel controls = new JPanel();
      painter = new PaintPanel();
	   painter.setCurrentColor( Color.GRAY );
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
      painter.setCurrentShapeType( "movingshapes."+shapeChoice.getSelectedItem().toString() );
   }

   public static void main( String[] args )
   {
      // create application Frame and resize
      MovingShapes app = new MovingShapes();

      app.addWindowListener(
         new WindowAdapter() {
           public void windowClosing( WindowEvent e )
           {
              System.exit( 0 );
           }
         }
      );

      app.setSize( 400, 200 );
      app.show();
   }
}


 /**************************************************************************
  * (C) Copyright 1992-2004 by Deitel & Associates, Inc. and               *
  * Pearson Education, Inc. All Rights Reserved.                           *
  *                                                                        *
  * DISCLAIMER: The authors and publisher of this book have used their     *
  * best efforts in preparing the book. These efforts include the          *
  * development, research, and testing of the theories and programs        *
  * to determine their effectiveness. The authors and publisher make       *
  * no warranty of any kind, expressed or implied, with regard to these    *
  * programs or to the documentation contained in these books. The authors *
  * and publisher shall not be liable in any event for incidental or       *
  * consequential damages in connection with, or arising out of, the       *
  * furnishing, performance, or use of these programs.                     *
  **************************************************************************/



