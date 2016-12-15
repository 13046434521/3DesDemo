package com.jtl.a3desdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{
    private TextView mTextView1;
    private TextView mTextView2;
    private EditText mEditText;
    private Button mButton;
    private Button mButton2;
    private  byte[] a;
    private byte[] bytes;
    DesUtils mDesUtils;
    Des3Utils mDes3Utils;
    String context=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }
    private void init(){
        mTextView1= (TextView) findViewById(R.id.textView);
        mTextView2= (TextView) findViewById(R.id.textView2);
        mEditText= (EditText) findViewById(R.id.editText);
        mButton= (Button) findViewById(R.id.button);
        mButton2= (Button) findViewById(R.id.button2);
        mDesUtils=new DesUtils();
        mDes3Utils=new Des3Utils();
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String b=mEditText.getText().toString();
                bytes=mDes3Utils.encriptMode(b);
//                a=mDesUtils.encryptMode(b.getBytes());
                mTextView1.setText(new String(bytes));

            }
        });
        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String a= mDes3Utils.decryptMode(context);
                String a=mDes3Utils.decryptMode(bytes);
//                String b=new String(mDesUtils.decryptMode(a)) ;
                mTextView2.setText(a);
            }
        });
    }
}