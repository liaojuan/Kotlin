package com.example.pc.kotlin.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pc.kotlin.MainActivity;
import com.example.pc.kotlin.R;
import com.example.pc.kotlin.ui.contract.TestMvpContract;
import com.example.pc.kotlin.ui.presenter.TestMvpPresenter;

public class TestMvpActivity extends AppCompatActivity implements TestMvpContract.View , View.OnClickListener{
    private EditText et_username;
    private EditText et_password;
    private Button btn_clean;
    private Button btn_login;

    private TestMvpPresenter testMvpPresenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_testmvp);
        et_username = (EditText) findViewById(R.id.editText_user);
        et_password = (EditText) findViewById(R.id.editText_pass);

        btn_clean = (Button) findViewById(R.id.button_clean);
        btn_login = (Button) findViewById(R.id.button_login);

        testMvpPresenter = new TestMvpPresenter(this);

        btn_login.setOnClickListener(this);
        btn_clean.setOnClickListener(this);
    }

    @Override
    public void doClean() {
        et_username.setText("");
        et_password.setText("");
    }

    @Override
    public void loginResult(boolean isSuccess, String messing) {
        if (isSuccess) {
            Toast.makeText(TestMvpActivity.this, "登陆成功：" + messing, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(TestMvpActivity.this, "登陆失败", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_clean:
                testMvpPresenter.clean();
                break;
            case R.id.button_login:
                testMvpPresenter.doLogin(et_username.getText().toString(), et_password.getText().toString());
                break;
        }
    }
}
