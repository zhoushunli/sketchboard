package com.zhousl.sketchboard;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.zhousl.sketchboard.shape.RoundRectShape;
import com.zhousl.sketchboard.view.PanelView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final PanelView panelView = (PanelView) findViewById(R.id.draw_panel);
        findViewById(R.id.cicle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                panelView.setShape(new RoundRectShape(panelView));
            }
        });
    }
}
