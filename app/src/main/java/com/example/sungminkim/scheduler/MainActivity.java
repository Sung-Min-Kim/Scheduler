package com.example.sungminkim.scheduler;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private LinearLayout parentLinearLayout;
    TextView txtName, txtDesc, txtCategory;
    private int viewCount = 0 ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        parentLinearLayout = (LinearLayout)findViewById(R.id.parent_linear_layout) ;

    }

    //버튼
    public void mOnPopupClick(View v){
        //데이터 담아서 팝업(액티비티) 호출
        Intent intent = new Intent(this, PopupActivity.class);
//        intent.putExtra("data", "Test Popup");
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==1){
            if(resultCode==RESULT_OK){
                //데이터 받기
                String storeName = data.getStringExtra("name");
                String storeDesc = data.getStringExtra("description");
                String storeCategory = data.getStringExtra("category");



                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View rowView = inflater.inflate(R.layout.field, null);
                // Add the new row before the add field button.
                parentLinearLayout.addView(rowView, parentLinearLayout.getChildCount() - 2);
                viewCount += 1 ;


                txtName = (TextView)parentLinearLayout.getChildAt(viewCount-1).findViewById(R.id.storeName) ;
                txtCategory = (TextView)parentLinearLayout.getChildAt(viewCount-1).findViewById(R.id.storeCategory) ;
                txtDesc = (TextView)parentLinearLayout.getChildAt(viewCount-1).findViewById(R.id.storeDesc) ;

                txtName.setText(storeName);
                txtCategory.setText(storeCategory);
                txtDesc.setText(storeDesc);
            }
        }
    }

    public void onDelete(View v){
        parentLinearLayout.removeView((View) v.getParent());
        viewCount -= 1 ;
    }


}

