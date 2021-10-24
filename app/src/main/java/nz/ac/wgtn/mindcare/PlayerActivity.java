package nz.ac.wgtn.mindcare;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class PlayerActivity extends AppCompatActivity {

    VideoView vvLongBreathing;
    //Paste video url in string below
    String video_url="https://www.youtube.com/watch?v=aNXKjGFUlMs";
    ProgressDialog pd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        vvLongBreathing =findViewById(R.id.vvLongBreathing);
        String videoLongBreathingPath = "android.resource://"+getPackageName()+"/"+R.raw.deep_breath_video;
        pd=new ProgressDialog(this);
        pd.setMessage("Buffering video, please wait");
        pd.show();
        Uri uri=Uri.parse(videoLongBreathingPath);
        vvLongBreathing.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        vvLongBreathing.setMediaController(mediaController);
        mediaController.setAnchorView(vvLongBreathing);
        vvLongBreathing.start();
        vvLongBreathing.setOnPreparedListener(mp -> pd.dismiss());
    }

    public void backOnBreathClick(View view){
        Intent intent = new Intent(this, BreathingActivity.class);
        startActivity(intent);
    }
    public void resetOnClick(View view){
        vvLongBreathing.resume();
    }
}