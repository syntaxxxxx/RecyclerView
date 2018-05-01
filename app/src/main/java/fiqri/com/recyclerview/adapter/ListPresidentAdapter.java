package fiqri.com.recyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import fiqri.com.recyclerview.R;
import fiqri.com.recyclerview.model.President;


public class ListPresidentAdapter extends RecyclerView.Adapter
        <ListPresidentAdapter.CategoryViewHolder> {

    private Context context;
    private ArrayList<President> listPresident;


    // getter dari dari model president
    public ArrayList<President> getListPresident() {
        return listPresident;
    }


    // setter dari dari model president
    public void setListPresident(ArrayList<President> listPresident) {
        this.listPresident = listPresident;
    }


    // constructor dari class
    public ListPresidentAdapter(Context context) {
        this.context = context;
    }


    @Override
    public CategoryViewHolder onCreateViewHolder(
            ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_president, parent, false);

        return new CategoryViewHolder(v);
    }


    @Override
    public void onBindViewHolder(CategoryViewHolder holder, int position) {

        holder.tvName.setText(getListPresident().get(position).getName());
        holder.tvRemarks.setText(getListPresident().get(position).getRemarks());

        President p = getListPresident().get(position);

        // asynchronous get data dari URL
        Glide.with(context)
                .load(p.getPhoto())
                .override(55, 55)
                .crossFade()
                .into(holder.imgPhoto);

    }


    @Override
    public int getItemCount() {
        return getListPresident().size();
    }


    class CategoryViewHolder extends RecyclerView.ViewHolder {

        private TextView tvName, tvRemarks;
        private ImageView imgPhoto;

        CategoryViewHolder(View v) {
            super(v);

            tvName = v.findViewById(R.id.tv_name);
            tvRemarks = v.findViewById(R.id.tv_remarks);
            imgPhoto = v.findViewById(R.id.img_photo);

        }
    }
}
