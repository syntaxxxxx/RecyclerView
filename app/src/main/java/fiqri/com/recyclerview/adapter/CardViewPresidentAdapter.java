package fiqri.com.recyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import fiqri.com.recyclerview.R;
import fiqri.com.recyclerview.model.President;

public class CardViewPresidentAdapter extends RecyclerView
        .Adapter<CardViewPresidentAdapter.CardViewHolder> {

    private Context context;
    private ArrayList<President> listPresident;

    public ArrayList<President> getListPresident() {
        return listPresident;
    }


    public void setListPresident(ArrayList<President> listPresident) {
        this.listPresident = listPresident;
    }


    public CardViewPresidentAdapter(Context context) {
        this.context = context;
    }


    @Override
    public CardViewHolder onCreateViewHolder
            (ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.card_view, parent, false);

        return new CardViewHolder(v);

    }


    @Override
    public void onBindViewHolder(CardViewPresidentAdapter
                                         .CardViewHolder holder, final int position) {

        President p = getListPresident().get(position);

        Glide.with(context)
                .load(p.getPhoto())
                .override(350, 550)
                .into(holder.imgPhoto);

        holder.tvName.setText(p.getName());
        holder.tvRemarks.setText(p.getRemarks());

        holder.btnFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(context, "Favorite "
                                + getListPresident().get(position).getName(),
                        Toast.LENGTH_SHORT).show();
            }
        });


        holder.btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(context, "Share "
                                + getListPresident().get(position).getName(),
                        Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return getListPresident().size();
    }


    public class CardViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgPhoto;
        private TextView tvName, tvRemarks;
        private Button btnFavorite, btnShare;

        public CardViewHolder(View v) {
            super(v);

            imgPhoto = v.findViewById(R.id.img_item_photo);
            tvName = v.findViewById(R.id.tv_item_name);
            tvRemarks = v.findViewById(R.id.tv_item_remarks);
            btnFavorite = v.findViewById(R.id.btn_favorite);
            btnShare = v.findViewById(R.id.btn_share);

        }
    }
}
