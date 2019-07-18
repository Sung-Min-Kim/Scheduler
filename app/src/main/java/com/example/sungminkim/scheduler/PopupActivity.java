package com.example.sungminkim.scheduler;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;

public class PopupActivity extends Activity {

//    TextView txtText;
    EditText editStoreName, editDescription ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //타이틀바 없애기
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.popup_activity);

        editStoreName = (EditText)findViewById(R.id.et_name) ;
        editDescription = (EditText)findViewById(R.id.et_desc) ;

//        //UI 객체생성
//        txtText = (TextView)findViewById(R.id.txtText);
//
//        //데이터 가져오기
//        Intent intent = getIntent();
//        String data = intent.getStringExtra("data");
//        txtText.setText(data);
    }

    //확인 버튼 클릭
    public void mOnClose(View v){
        String storeName = editStoreName.getText().toString() ;
        String storeDesc = editDescription.getText().toString() ;

        //데이터 전달하기
        Intent intent = new Intent();
        intent.putExtra("name", storeName);
        intent.putExtra("description", storeDesc) ;
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
