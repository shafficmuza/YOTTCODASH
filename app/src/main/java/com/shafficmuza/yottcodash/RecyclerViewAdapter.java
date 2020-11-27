package com.shafficmuza.yottcodash;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    Context mContext;
    List<ServiceProvider> mData;
    Dialog myDialog;

    public RecyclerViewAdapter(Context mContext, List<ServiceProvider> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.service_provider_list, parent, false);
        final MyViewHolder vHolder = new MyViewHolder(v);

        //get to dialog layout attributes
        myDialog = new Dialog(RecyclerViewAdapter.this.mContext);
        myDialog.setContentView(R.layout.dialog_service_prodiver);
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        vHolder.item_sp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                TextView dialog_sp_name = (TextView) myDialog.findViewById(R.id.dialog_sp_name);
                TextView dialog_sp_phone = (TextView) myDialog.findViewById(R.id.dialog_sp_phone);
                //ImageView dialog_sp_img = (ImageView) myDialog.findViewById(R.id.dialog_sp_img);
                dialog_sp_name.setText(mData.get(vHolder.getAdapterPosition()).getTitle());
                dialog_sp_phone.setText(mData.get(vHolder.getAdapterPosition()).getPhone());
                //dialog_sp_img.setImageResource(mData.get(vHolder.getAdapterPosition()).getPhoto());

                */
                //create intent to parse selected phone number to dialog
              //  Intent phoneIntent = new Intent(Intent.ACTION_VIEW);
               // phoneIntent.setData(Uri.parse("tel:" + mData.get(vHolder.getAdapterPosition()).getPhone()));
               // mContext.startActivity(phoneIntent);

                Toast.makeText(mContext, "Text Clicked " + vHolder.getAdapterPosition() + mData.get(vHolder.getAdapterPosition()).getPhone(), Toast.LENGTH_SHORT).show();
                //myDialog.show();

            }
        });
        return vHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.tv_title.setText(mData.get(position).getTitle());
        holder.tv_desc.setText(mData.get(position).getDesc());
       // holder.img.setImageResource(mData.get(position).getPhoto());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout item_sp;
        private TextView tv_title;
        private TextView tv_desc;
        private ImageView img;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            item_sp = (LinearLayout) itemView.findViewById(R.id.sp_item_id);
            tv_title = (TextView) itemView.findViewById(R.id.sp_name);
            tv_desc = (TextView) itemView.findViewById(R.id.sp_desc);
            img = (ImageView) itemView.findViewById(R.id.sp_img);
        }
    }
}
