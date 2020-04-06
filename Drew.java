import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import java.util.ArrayList;

class Drew {
    static void reDrew (String sortName,int j,Pane me,ArrayList<Integer> num){
        me.getChildren().clear();
        Text sort = new Text( sortName );
        sort.setX( me.getWidth() / 3 );
        sort.setY( 100 );
        me.getChildren().add( sort );
        drew(j,me,num);
    }
    private static void drew (int j,Pane me,ArrayList<Integer> num){
        for (int i = 0;i<num.size();i++) {
            double w = 5.2;
            double h = num.get( i ) * 5;
            Rectangle rectangle = new Rectangle( w,h );
            rectangle.setX( i * w );
            rectangle.setY( me.getHeight() - h );
            rectangle.setFill( Color.BLACK);
            rectangle.setStroke( Color.WHITE );
            if (i == j){
                rectangle.setFill( Color.RED );
            }
            me.getChildren().add(rectangle);
        }
    }
}
