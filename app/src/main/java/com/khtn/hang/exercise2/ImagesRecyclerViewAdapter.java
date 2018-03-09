package com.khtn.hang.exercise2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ImagesRecyclerViewAdapter extends RecyclerView.Adapter<ImagesRecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<Integer> playerList;
    private int positionCheck;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.contentPanel)
        public RelativeLayout contentPanel;

        @BindView(R.id.image)
        public ImageView image;

        public MyViewHolder(final View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public int getPositionCheck() {
        return positionCheck;
    }

    public ImagesRecyclerViewAdapter(Context mContext, List<Integer> playerList) {
        this.mContext = mContext;
        this.playerList = playerList;
        positionCheck = -1;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_image, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        if (position == positionCheck) {
            holder.contentPanel.setBackgroundResource(R.color.blue);
        } else {
            holder.contentPanel.setBackgroundResource(R.color.white);
        }
        Picasso.with(mContext).load(playerList.get(position))
                .fit()
                .centerCrop()
                .placeholder(android.R.drawable.ic_menu_report_image)
                .into(holder.image);
        holder.contentPanel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickItem(position);
            }
        });

        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickItem(position);
            }
        });
    }

    private void onClickItem(int position) {
        if (position == positionCheck) {
            positionCheck = -1;
        } else {
            positionCheck = position;
        }
        this.notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return playerList.size();
    }

}
