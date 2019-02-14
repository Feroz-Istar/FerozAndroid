package sample.androido.com.myapplication.job_scheduler;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;

public class MyJobScheduler {


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public static void scheduleTasks(Context context){
        ComponentName serviceComponent = new ComponentName(context, NotificationJobService.class);
        JobInfo.Builder builder = new JobInfo.Builder(0, serviceComponent);

        builder.setPersisted(true);
        builder.setPeriodic(15000*60);
        builder.setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED);
        sendToScheduler(context,builder);

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public static void cancelJob(Context context, int job_id){
        JobScheduler jobScheduler = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            jobScheduler = context.getSystemService(JobScheduler.class);
        }else{
            jobScheduler = (JobScheduler) context.getSystemService(context.JOB_SCHEDULER_SERVICE);
        }
        jobScheduler.cancel(job_id);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private static  void sendToScheduler(Context context, JobInfo.Builder builder ){

        JobScheduler jobScheduler = null;

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            jobScheduler = context.getSystemService(JobScheduler.class);
        }else{
            jobScheduler = (JobScheduler) context.getSystemService(context.JOB_SCHEDULER_SERVICE);
        }
        jobScheduler.schedule(builder.build());

    }


}
