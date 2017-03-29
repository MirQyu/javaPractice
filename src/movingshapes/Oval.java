package movingshapes;

import java.awt.*;

public class Oval extends BoundedShape {
   public Oval()
   {
      super();
   }

   public Oval( int x1, int y1, int x2, int y2 )
   {
      super( x1, y1, x2, y2 );
   }

   public void draw( Graphics g )
   {
      Color c = g.getColor();
      g.setColor( this.getColor() );
      g.fillOval( getUpperLeftX(), getUpperLeftY(),
                  getWidth(), getHeight() );
      g.setColor( c );
   }
}

