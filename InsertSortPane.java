import javafx.application.Platform;
import javafx.scene.layout.Pane;
import java.util.ArrayList;
import java.util.Random;

class InsertSortPane extends Pane {
    private ArrayList<Integer> num;

    InsertSortPane (){
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
        Drew.reDrew( "插入排序",i,this,num );
    }
    private void endDrew (long ms){
        Drew.reDrew( "插入排序完成\n耗时：" + ms + "ms",0,this,num );
    }
    class thread extends Thread{
        public void run () {
            long startTime = System.currentTimeMillis();
            for(int i = 1; i<num.size();i++){
                int t = num.get( i );
                int k;
                for(k = i;k>0 && t<num.get(k-1);k--){
                    num.set(k,num.get(k-1));
                }
                num.set(k,t);
                try {
                    sleep( 300 );
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int finalI = i;
                Platform.runLater( () -> reDrew( finalI ) );
            }
            System.out.println("2");
            long overTime = System.currentTimeMillis()-startTime;
            Platform.runLater( () -> endDrew(overTime) );
        }
    }
}
