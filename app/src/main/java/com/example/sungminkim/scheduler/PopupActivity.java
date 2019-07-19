package com.example.sungminkim.scheduler;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class PopupActivity extends Activity {

    EditText editStoreName, editDescription ;
    Spinner category ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //타이틀바 없애기
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.popup_activity);

        editStoreName = (EditText)findViewById(R.id.et_name) ;
        editDescription = (EditText)findViewById(R.id.et_desc) ;
        category = (Spinner)findViewById(R.id.type_spinner) ;
    }

    //확인 버튼 클릭
    public void mOnClose(View v){
        String storeName = editStoreName.getText().toString() ;
        String storeDesc = editDescription.getText().toString() ;
        String storeCategory = category.getSelectedItem().toString() ;

        //데이터 전달하기
        Intent intent = new Intent();
        intent.putExtra("name", storeName);
        intent.putExtra("description", storeDesc) ;
        intent.putExtra("category", storeCategory) ;

        setResult(RESULT_OK, intent);

        //액티비티(팝업) 닫기
        finish();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //바깥레이어 클릭시 안닫히게
        if(event.getAction()==MotionEvent.ACTION_OUTSIDE){
            return false;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        //안드로이드 백버튼 막기
        return;
    }
}
