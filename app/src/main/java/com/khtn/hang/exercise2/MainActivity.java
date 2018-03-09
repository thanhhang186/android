package com.khtn.hang.exercise2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.tv)
    TextView tv;

    @BindView(R.id.imgBackground)
    ImageView imgBackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnChangeTitle)
    public void onClickChangeTitle() {
        Intent intent = new Intent(MainActivity.this, ChangeTitleActivity.class);
        intent.putExtra(Utils.INTENT_TITLE, tv.getText().toString());
        intent.putExtra(Utils.INTENT_COLOR, tv.getCurrentTextColor());
        startActivityForResult(intent, Utils.REQUEST_CODE);
    }

    @OnClick(R.id.btnChangeBackground)
    public void onClickChangeBackground(View v) {
        Intent intent = new Intent(MainActivity.this, ChangeBackgroundActivity.class);
        startActivityForResult(intent, Utils.REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null && requestCode == Utils.REQUEST_CODE) {
            switch (resultCode) {
                case Utils.RESULT_TITLE:
                    String title = data.getStringExtra(Utils.INTENT_TITLE);
                    int color = data.getIntExtra(Utils.INTENT_COLOR, R.color.pink);
                    tv.setText(title);
                    tv.setTextColor(color);
                    break;
                case Utils.RESULT_BACKGROUND:
                    int background = data.getIntExtra(Utils.INTENT_BACKGROUND, -1);
                    if (background != -1) {
                        Picasso.with(this).load(Utils.getListImage().get(background))
                                .fit()
                                .centerCrop()
                                .placeholder(android.R.drawable.ic_menu_report_image)
                                .into(imgBackground);
                    }
                    break;
            }
        }
    }
}

