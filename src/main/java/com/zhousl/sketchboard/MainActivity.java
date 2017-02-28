package com.zhousl.sketchboard;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.zhousl.sketchboard.shape.CircleShape;
import com.zhousl.sketchboard.shape.LineShape;
import com.zhousl.sketchboard.shape.OvalShape;
import com.zhousl.sketchboard.shape.PolyLineShape;
import com.zhousl.sketchboard.shape.PolygonShape;
import com.zhousl.sketchboard.shape.RectShape;
import com.zhousl.sketchboard.shape.RoundRectShape;
import com.zhousl.sketchboard.shape.Shape;
import com.zhousl.sketchboard.shape.StraitLineShape;
import com.zhousl.sketchboard.view.PanelView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private PanelView panelView;
    private View floating_button;
    private PopupMenu menu;
    private Shape mShape;
    private PopupWindow configPP;
    private PopupMenu editMenu;
    private View edit_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        initPopMenu();
        setListeners();
    }

    private void initPopMenu() {
        menu = new PopupMenu(this, floating_button, Gravity.BOTTOM);
        menu.inflate(R.menu.pop_menu);

        editMenu = new PopupMenu(this, edit_button, Gravity.BOTTOM);
        editMenu.inflate(R.menu.edit_pop_menu);
    }

    private void setListeners() {
        floating_button.setOnClickListener(this);
        menu.setOnMenuItemClickListener(onMenuItemClickListener);
        edit_button.setOnClickListener(this);
        editMenu.setOnMenuItemClickListener(editMenuClick);
    }

    private void findViews() {
        panelView = (PanelView) findViewById(R.id.draw_panel);
        floating_button = findViewById(R.id.floating_button);
        edit_button = findViewById(R.id.edit_shape);
    }

    @Override
    public void onClick(View v) {
        if (v == edit_button) {
            editMenu.show();
        } else {
            menu.show();
        }
    }

    private PopupMenu.OnMenuItemClickListener onMenuItemClickListener=new PopupMenu.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem item) {
            menu.dismiss();
            switch (item.getItemId()) {
                case R.id.paint:
                    break;
                case R.id.line_shape:
                    LineShape lineShape = new LineShape(panelView);
                    panelView.setShape(lineShape);
                    mShape = lineShape;
                    break;
                case R.id.oval_shape:
                    OvalShape ovalShape = new OvalShape(panelView);
                    panelView.setShape(ovalShape);
                    mShape = ovalShape;
                    break;
                case R.id.polygon_shape:
                    PolygonShape polygonShape = new PolygonShape(panelView);
                    panelView.setShape(polygonShape);
                    mShape = polygonShape;
                    break;
                case R.id.rect_shape:
                    RectShape rectShape = new RectShape(panelView);
                    panelView.setShape(rectShape);
                    mShape = rectShape;
                    break;
                case R.id.roundrec_shape:
                    RoundRectShape roundRectShape = new RoundRectShape(panelView);
                    panelView.setShape(roundRectShape);
                    mShape = roundRectShape;
                    break;
                case R.id.star_shape:
//                panelView.setShape(new StarShape(panelView));
                    Toast.makeText(MainActivity.this, "别急，正在开发中...", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.circle_shape:
                    CircleShape circleShape = new CircleShape(panelView);
                    panelView.setShape(circleShape);
                    mShape = circleShape;
                    break;
                case R.id.straight_line:
                    StraitLineShape straitLineShape = new StraitLineShape(panelView);
                    panelView.setShape(straitLineShape);
                    mShape = straitLineShape;
                    break;
                case R.id.poly_line:
                    PolyLineShape polyLineShape = new PolyLineShape(panelView);
                    panelView.setShape(polyLineShape);
                    mShape = polyLineShape;
                    break;
            }
            return true;
        }
    };
    private PopupMenu.OnMenuItemClickListener editMenuClick=new PopupMenu.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem item) {
            editMenu.dismiss();
            return true;
        }
    };
}
