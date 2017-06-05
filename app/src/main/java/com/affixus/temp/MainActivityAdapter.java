package com.affixus.temp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.affixus.pojos.Post;

import java.util.Collections;
import java.util.List;

/**
 * Created by santosh on 6/3/17.
 */

public class MainActivityAdapter extends RecyclerView.Adapter<MainActivityAdapter.MainActivityAdapterHolder> {

    private List<Post> datalist;
    public MainActivityAdapter(List<Post> datalist) {
        Collections.reverse(datalist);
        this.datalist = datalist;
    }

    @Override
    public MainActivityAdapter.MainActivityAdapterHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.layout, parent, false);

        MainActivityAdapterHolder holder = new MainActivityAdapterHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(MainActivityAdapter.MainActivityAdapterHolder holder, int position) {
        holder.post.setText(datalist.get(position).getPost());
        //holder.descr.setText(datalist.get(position).getDescr());
    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }




    public static class MainActivityAdapterHolder extends RecyclerView.ViewHolder{
        TextView post;
        TextView like_count;

        public MainActivityAdapterHolder(View itemView) {
            super(itemView);

            post = (TextView) itemView.findViewById(R.id.textView);
            //like_count = (TextView) itemView.findViewById(R.id.textView6);
        }
    }
}
