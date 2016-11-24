package com.myownapps.yasser.secrets;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
String ImageDecodeDablestring;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        Log.d("onCreateOptionsMenu","create menu");
        MenuInflater inflater =getMenuInflater();
        inflater.inflate(R.menu.socket_activity_actions,menu);


        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.action_attach:
                Log.d("onOptionsItemSelected","action Attach");
                openGallery();
                return true;
            case R.id.action_capture:
                Log.d("onOptionsItemSelected","action capture");
                default:
                    return super.onOptionsItemSelected(item);


        }
    }
    public void openGallery(){

        Intent gallaryintent=new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(gallaryintent,1);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

    if(requestCode==1&&resultCode==RESULT_OK&&data!=null){

        Uri selectedImage=data.getData();
        String[]filepathcolumn={MediaStore.Images.Media.DATA};
        Cursor cursor=getContentResolver().query(selectedImage,filepathcolumn,null,null,null);
        cursor.moveToFirst();
        int columnindex=cursor.getColumnIndex(filepathcolumn[0]);
        ImageDecodeDablestring=cursor.getString(columnindex);
        cursor.close();

       ChatFragment fragmen = (ChatFragment) getFragmentManager().findFragmentById(R.id.chat);
        fragmen.sendImage(ImageDecodeDablestring);
    }
    }
}
