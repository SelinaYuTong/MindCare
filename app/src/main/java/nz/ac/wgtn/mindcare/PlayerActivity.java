package nz.ac.wgtn.mindcare;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

public class PlayerActivity extends AppCompatActivity {

    VideoView video;
    //Paste video url in string below
    String video_url="https://www.youtube.com/watch?v=aNXKjGFUlMs";
    ProgressDialog pd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        video =(VideoView)findViewById(R.id.video);
        pd=new ProgressDialog(this);
        pd.setMessage("Buffering video, please wait");
        pd.show();
        Uri uri=Uri.parse(video_url);
        video.setVideoURI(uri);
        video.start();
        video.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                pd.dismiss();
            }
        });

    }

}