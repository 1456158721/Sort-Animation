import javafx.application.Platform;
import javafx.scene.layout.Pane;
import java.util.ArrayList;
import java.util.Random;

class BubbleSortPane extends Pane {
    private ArrayList<Integer> num;
    private int finalI;

    BubbleSortPane (){
        num = new ArrayList<>();
        while (num.size() != 50) {
            Random random = new Random();
            int n = random.nextInt( 51 );
            if (n == 0 || num.contains( n )) {
                continue;
            }
            num.add( n );
        }
        Thread thread = new thread();
        thread.start();
    }
    void reDrew (int i){
        Drew.reDrew( "冒泡排序",i,this,num );
    }
    private void endDrew (long ms){
        Drew.reDrew( "冒泡排序完成\n耗时：" + ms + "ms",0,this,num );
    }
    class thread extends Thread{
        public void run () {
            long startTime = System.currentTimeMillis();
            for(int i = 0; i < num.size()-1; i++){
                for(int j = 0; j < num.size() - i - 1; j++){
                    if(num.get( j ) > num.get( j+1 )){
                        int t = num.get( j );
                        num.set( j,num.get( j+1 ) );
                        num.set( j + 1,t );
                    }
                    finalI = j;
                }
                try {
                    sleep( 300 );
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Platform.runLater( () -> reDrew( finalI ) );
            }
            System.out.println("1");
            long overTime = System.currentTimeMillis()-startTime;
            Platform.runLater( () -> endDrew(overTime) );
        }
    }
}
