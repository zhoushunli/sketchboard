package com.zhousl.sketchboard;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.zhousl.sketchboard.shape.CircleShape;
import com.zhousl.sketchboard.shape.LineShape;
import com.zhousl.sketchboard.shape.OvalShape;
import com.zhousl.sketchboard.shape.PolygonShape;
import com.zhousl.sketchboard.shape.RectShape;
import com.zhousl.sketchboard.shape.RoundRectShape;
import com.zhousl.sketchboard.view.PanelView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, PopupMenu.OnMenuItemClickListener {

    private PanelView panelView;
    private View floating_button;
    private PopupMenu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        initPopMenu();
        setListeners();
    }

    private void initPopMenu() {
        menu = new PopupMenu(this,floating_button, Gravity.BOTTOM);
        menu.inflate(R.menu.pop_menu);
    }

    private void setListeners() {
        floating_button.setOnClickListener(this);
        menu.setOnMenuItemClickListener(this);
    }

    private void findViews() {
        panelView = (PanelView) findViewById(R.id.draw_panel);
        floating_button = findViewById(R.id.floating_button);
    }

    @Override
    public void onClick(View v) {
        menu.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        menu.dismiss();
        switch (item.getItemId()){
            case R.id.paint:
                break;
            case R.id.line_shape:
                panelView.setShape(new LineShape(panelView));
                break;
            case R.id.oval_shape:
                panelView.setShape(new OvalShape(panelView));
                break;
            case R.id.polygon_shape:
                panelView.setShape(new PolygonShape(panelView));
                break;
            case R.id.rect_shape:
                panelView.setShape(new RectShape(panelView));
                break;
            case R.id.roundrec_shape:
                panelView.setShape(new RoundRectShape(panelView));
                break;
            case R.id.star_shape:
//                panelView.setShape(new StarShape(panelView));
                Toast.makeText(this, "别急，正在开发中...", Toast.LENGTH_SHORT).show();
                break;
            case R.id.circle_shape:
                panelView.setShape(new CircleShape(panelView));
                break;
        }
        return true;
    }
}
