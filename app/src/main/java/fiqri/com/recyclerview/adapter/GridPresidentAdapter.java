package fiqri.com.recyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import fiqri.com.recyclerview.R;
import fiqri.com.recyclerview.model.President;

public class GridPresidentAdapter extends RecyclerView
        .Adapter<GridPresidentAdapter.GridViewHolder> {

    private Context context;
    private ArrayList<President> listPresident;


    public ArrayList<President> getListPresident() {
        return listPresident;
    }


    public void setListPresident(ArrayList<President> listPresident) {
        this.listPresident = listPresident;
    }


    public GridPresidentAdapter(Context context) {
        this.context = context;
    }


    @Override
    public GridViewHolder onCreateViewHolder
            (ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.grid, parent, false);

        return new GridViewHolder(v);

    }

    @Override
    public void onBindViewHolder(
            GridPresidentAdapter.GridViewHolder holder, int position) {

        President p = getListPresident().get(position);

        Glide.with(context)
                .load(p.getPhoto())
                .override(350, 350)
                .into(holder.imgPhoto);

    }


    @Override
    public int getItemCount() {
        return getListPresident().size();
    }


    public class GridViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgPhoto;

        public GridViewHolder(View v) {
            super(v);
            imgPhoto = v.findViewById(R.id.img_grid);

        }
    }
}
