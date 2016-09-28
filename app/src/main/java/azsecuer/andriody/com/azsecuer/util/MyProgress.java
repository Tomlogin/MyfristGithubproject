package azsecuer.andriody.com.azsecuer.util;

import android.content.Context;
import android.widget.ProgressBar;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 8/15 0015.
 */
public class MyProgress extends ProgressBar{
    public MyProgress(Context context) {
        super(context);
    }
    public void move(final int targetprogress){
       final Timer timer=new Timer();
        TimerTask timerTask=new TimerTask() {
           int movestate=getProgress()>targetprogress? 1:2;
            @Override
            public void run() {
                switch (movestate){
                    case 1:
                        setProgress(getProgress()-1);
                        break;
                    case 2:
                        setProgress(getProgress()+1);
                        break;
                }
                if(getProgress()==targetprogress){
                    timer.cancel();
                }

            }
        };
         timer.schedule(timerTask,50,50);
    }
}
