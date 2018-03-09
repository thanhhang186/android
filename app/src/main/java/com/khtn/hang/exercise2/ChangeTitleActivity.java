package com.khtn.hang.exercise2;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChangeTitleActivity extends AppCompatActivity {

    @BindView(R.id.viewSample)
    View viewSample;

    @BindView(R.id.edt)
    EditText edt;

    @BindView(R.id.ivPink)
    ImageView iv1;

    @BindView(R.id.ivPurple)
    ImageView iv2;

    @BindView(R.id.ivIndigo)
    ImageView iv3;

    @BindView(R.id.ivBlue)
    ImageView iv4;

    @BindView(R.id.ivTeal)
    ImageView iv5;

    @BindView(R.id.ivGreen)
    ImageView iv6;

    @BindView(R.id.btnSave)
    Button btnSave;

    private String title = "";
    private int color = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_title);
        ButterKnife.bind(this);

        Bundle data = getIntent().getExtras();
        edt.setText(data.getString(Utils.INTENT_TITLE));
        int colorHexCode = data.getInt(Utils.INTENT_COLOR);
        color = colorHexCode;
        viewSample.setBackgroundColor(colorHexCode);
    }

    @OnClick(R.id.btnSave)
    void onClickSave(View v) {
        title = edt.getText().toString();
        Intent intent = new Intent();
        intent.putExtra(Utils.INTENT_COLOR, color);
        intent.putExtra(Utils.INTENT_TITLE, title);
        setResult(Utils.RESULT_TITLE, intent);
        finish();

    }

    @OnClick({R.id.ivPink, R.id.ivPurple, R.id.ivIndigo, R.id.ivBlue, R.id.ivTeal, R.id.ivGreen})
    void onClickListener(View v) {
        Drawable background = v.getBackground();
        color = ((ColorDrawable) background).getColor();
        switch (v.getId()) {
            case R.id.ivPink:
                viewSample.setBackgroundColor(ContextCompat.getColor(v.getContext(), R.color.pink));
                break;
            case R.id.ivPurple:
                viewSample.setBackgroundColor(ContextCompat.getColor(v.getContext(), R.color.purple));
                break;
            case R.id.ivIndigo:
                viewSample.setBackgroundColor(ContextCompat.getColor(v.getContext(), R.color.indigo));
                break;
            case R.id.ivBlue:
                viewSample.setBackgroundColor(ContextCompat.getColor(v.getContext(), R.color.blue));
                break;
            case R.id.ivTeal:
                viewSample.setBackgroundColor(ContextCompat.getColor(v.getContext(), R.color.teal));
                break;
            case R.id.ivGreen:
                viewSample.setBackgroundColor(ContextCompat.getColor(v.getContext(), R.color.green));
                break;
        }
    }
}
