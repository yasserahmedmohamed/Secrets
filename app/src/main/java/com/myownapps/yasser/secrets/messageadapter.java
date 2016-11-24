package com.myownapps.yasser.secrets;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Yasser on 9/25/2016.
 */

public class messageadapter extends RecyclerView.Adapter<messageadapter.ViewHolder> {


    private List<Message> mMessages;
    private int[]mUsernamecolors;

    public messageadapter(List<Message> mMessages) {
        this.mMessages = mMessages;
    }

    @Override
    public  ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_message,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        Message message=mMessages.get(position);
        viewHolder.setMessage(message.getmMessage());
        viewHolder.setImage(message.getmImage());



    }



    @Override
    public int getItemCount() {
        return mMessages.size() ;
    }

    @Override
    public int getItemViewType(int position) {
        return mMessages.get(position).getmType();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView mImageView;
        public TextView mMessageView;
        public ViewHolder(View itemView) {
            super(itemView);
            mImageView=(ImageView)itemView.findViewById(R.id.image);
            mMessageView=(TextView)itemView.findViewById(R.id.message);
        }
        public void setMessage(String message){
            if(mMessageView==null){return;}
            if (message==null){return;}
            mMessageView.setText(message);

        }
        public void setImage(Bitmap bmp){
            if(mImageView==null){return;}
            if(bmp==null){return;}
            mImageView.setImageBitmap(bmp);
        }
        private int getUserNameColors(String username){
            int hash=8;
            for(int i=0,len=username.length();i<len;i++){

                hash=username.codePointAt(i)+(hash<<5)-hash;
            }
            int index=Math.abs(hash%mUsernamecolors.length);
            return mUsernamecolors[index];
        }

    }
}
