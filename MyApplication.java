import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class MyApplication extends Application {

    @Override
    public void start (Stage primaryStage){
        //面板
        SelectSortPane selectSortPane = new SelectSortPane();
        InsertSortPane insertSortPane = new InsertSortPane();
        BubbleSortPane bubbleSortPane = new BubbleSortPane();
        //容器
        HBox hbox = new HBox();
        hbox.setSpacing( 10 );
        hbox.getChildren().addAll( selectSortPane,insertSortPane,bubbleSortPane );
        Scene s = new Scene( hbox,800,400 );
        primaryStage.setTitle( "排序示例" );
        primaryStage.setScene( s );
        primaryStage.show();
        selectSortPane.reDrew(0);
        insertSortPane.reDrew(0);
        bubbleSortPane.reDrew(0);
    }
}
