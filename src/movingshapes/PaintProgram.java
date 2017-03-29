package movingshapes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
//������
public class PaintProgram extends JFrame implements ActionListener {
   private JComboBox shapeChoice;
   private JButton load, store, color;
   private PaintPanel painter; //��ͼ��

   public PaintProgram()
   {
   	//�����û�����
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
   	//���õ�ǰ��ͼ����
      painter.setCurrentShapeType( "movingshapes."+shapeChoice.getSelectedItem().toString() );
      //�ȴ�����������PaintPanel���д���
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










