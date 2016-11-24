package com.myownapps.yasser.secrets;

import android.graphics.Bitmap;

/**
 * Created by Yasser on 9/25/2016.
 */

public class Message {
    public static final int type_message=0;
    public static final int type_log=1;
    public static final int type_action=2;
    private int mType;
    private String mMessage;
    private Bitmap mImage;

    public int getmType() {
        return mType;
    }

    public String getmMessage() {
        return mMessage;
    }

    public Bitmap getmImage() {
        return mImage;
    }
    public static class builder{


        private int mType;
        private String mMessage;
        private Bitmap mImage;

        public builder(int mType) {
            this.mType = mType;
        }

        public builder message(String mMessage) {
            this.mMessage = mMessage;
            return this;
        }

        public builder image(Bitmap mImage) {
            this.mImage = mImage;
            return this;
        }
        public Message build(){
            Message message =new Message();
            message.mType=mType;
            message.mImage=mImage;
            message.mMessage=mMessage;
            return message;
        }
    }
}
