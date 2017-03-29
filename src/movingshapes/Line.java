package movingshapes;

import java.awt.*;

public class Line extends Shape {
   public Line()
   {
      super();
   }

   public Line( int x1, int y1, int x2, int y2 )
   {
      super( x1, y1, x2, y2 );
   }

   public void draw( Graphics g )
   {
      Color c = g.getColor();  // get previous color
      g.setColor( this.getColor() );
      g.drawLine( getX1(), getY1(), getX2(), getY2() );
      g.setColor( c );         // reset previous color
   } 
}

