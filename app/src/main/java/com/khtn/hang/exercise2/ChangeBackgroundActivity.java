package com.khtn.hang.exercise2;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ChangeBackgroundActivity extends AppCompatActivity {
    private List<Integer> imgArrayList;
    private ImagesRecyclerViewAdapter imagesRecyclerViewAdapter;

    @BindView(R.id.rvImages)
    RecyclerView rvImages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_background);
        ButterKnife.bind(this);

        imgArrayList = Utils.getListImage();

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        rvImages.setLayoutManager(gridLayoutManager);
        rvImages.setHasFixedSize(true);
        rvImages.addItemDecoration(new GridSpacingItemDecoration(2, dpToPx(10), true));
        rvImages.setItemAnimator(new DefaultItemAnimator());

        imagesRecyclerViewAdapter = new ImagesRecyclerViewAdapter(this, imgArrayList);
        rvImages.setAdapter(imagesRecyclerViewAdapter);
    }

    @OnClick(R.id.btnSave)
    public void onClickSave(View v) {
        Intent intent = new Intent();
        intent.putExtra(Utils.INTENT_BACKGROUND, imagesRecyclerViewAdapter.getPositionCheck());
        setResult(Utils.RESULT_BACKGROUND, intent);
        finish();
    }

    private int dpToPx(int dp) {
        Resources resources = getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, resources.getDisplayMetrics()));
    }
}
