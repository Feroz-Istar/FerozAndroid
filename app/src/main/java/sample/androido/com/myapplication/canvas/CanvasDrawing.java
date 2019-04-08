package sample.androido.com.myapplication.canvas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import sample.androido.com.myapplication.R;

public class CanvasDrawing extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new AudioDraw(this));
    }
}
