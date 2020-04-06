import javafx.application.Platform;
import javafx.scene.layout.Pane;
import java.util.ArrayList;
import java.util.Random;
class SelectSortPane extends Pane {
    private ArrayList<Integer> num;

    SelectSortPane (){
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
        Drew.reDrew( "选择排序",i,this,num );
    }
    private void endDrew (long ms){
        Drew.reDrew( "选择排序完成\n耗时：" + ms + "ms",0,this,num );
    }
    class thread extends Thread{
        public void run () {
            long startTime = System.currentTimeMillis();
            for (int i = 0;i<num.size();i++) {
                int minIndex = i;
                for (int j = i + 1;j<num.size();j++) {
                    if (num.get(j) < num.get(minIndex)) {
                        minIndex = j;
                    }
                }
                if (minIndex != i) {
                    int t = num.get(minIndex);
                    num.set(minIndex,num.get( i ));
                    num.set(i,t);
                }
                try {
                    sleep( 300 );
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                int finalI = i;
                Platform.runLater( () -> reDrew( finalI ) );
            }
            System.out.println("3");
            long overTime = System.currentTimeMillis()-startTime;
            Platform.runLater( () -> endDrew(overTime) );
        }
    }
}
