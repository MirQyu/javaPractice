package movingshapes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Vector;

//��ͼ��
public class PaintPanel extends JPanel
                        implements MouseListener, MouseMotionListener,
                                   ActionListener {
   private Vector shapes;   // ͼ�μ���
   private Shape currentShape;
   private String currentShapeType = "movingshapes.Line";   // default
   private Color currentColor = Color.black;
   Timer timer = new Timer( 40, this );

   public PaintPanel()
   {
      shapes = new Vector();   // creates empty Vector
      addMouseListener( this );
      addMouseMotionListener( this );
      setBackground( Color.white );
      timer.start();
   }
   
//�ػ�������Ļ����Repaint��������
   public void paintComponent( Graphics g )
   {
      super.paintComponent( g );

      Shape current;

      for ( int i = 0; i < shapes.size(); i++ ) {
         current = ( Shape ) shapes.elementAt( i );
         current.draw( g );
      }
   }

   public void actionPerformed( ActionEvent e )
   {
      repaint();//�Զ�����paintComponent����
   }

   /*
      In the following method, we use features that have not been covered in
      the text. We could have used an if/else structure to choose which shape
      to create. Instead,

         Class c = Class.forName( currentShapeType );

      loads the class definition for the class with the String name stored in
      currentShapeType. The statement

         currentShape = (Shape) c.newInstance();

      creates a new instance of the class that was loaded. The next line adds
      the new shape to the Vector (at the end).

      The try/catch syntax is covered in chapter 14. It is required here
      because both the Class.forName method call and the c.newInstance method
      call can cause runtime exceptions (problems). In this case we are
      saying "if a runtime problem occurs, ignore it."
   */
   public void mousePressed( MouseEvent e )
   {
      try {        
      //ע�ⴴ��ʵ���ķ���,CurrentShapeType��һ�����͵ı���
      //���ּ�����Ϊ"����"
       
         Class c = Class.forName( currentShapeType );
         currentShape = (Shape) c.newInstance();
         currentShape.setX1( e.getX() );
         currentShape.setY1( e.getY() );
         currentShape.setX2( e.getX() );
         currentShape.setY2( e.getY() );
         currentShape.setColor( currentColor );
         //���뵽ͼ�μ�����
         shapes.addElement( currentShape );
      }
      catch (Exception ex) { ex.printStackTrace(); }
   }

   public void mouseReleased( MouseEvent e )
   {
      currentShape.setX2( e.getX() );
      currentShape.setY2( e.getY() );

      // NOTE: We should store these for termination later.
      MovingShape mover =
         new MovingShape( currentShape, this,
                          (int)(Math.random() * 5 + 1),
                          (int)(Math.random() * 5 + 1) );
      //���ö��߳�ִ�У�����Run����������ͼ�ε�����
      mover.start();

      repaint();
   }

   public void mouseClicked( MouseEvent e )
   {

   }

   public void mouseEntered( MouseEvent e )
   {

   }

   public void mouseExited( MouseEvent e )
   {

   }

   public void mouseMoved( MouseEvent e )
   {

   }

//������϶�ʱ���ػ�ͼ��
   public void mouseDragged( MouseEvent e )
   {
      currentShape.setX2( e.getX() );
      currentShape.setY2( e.getY() );
      repaint();
   }

   public void setCurrentShapeType( String s )
   {
      currentShapeType = s;
   }

   public void setCurrentColor( Color c )
   {
      currentColor = c;
   }
}


