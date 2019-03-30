package com.example.pc.kotlin.ui.presenter;

import com.example.pc.kotlin.ui.activity.TestMvpActivity;
import com.example.pc.kotlin.ui.contract.TestMvpContract;

public class TestMvpPresenter implements TestMvpContract.Presenter {

    private TestMvpActivity testMvpActivity;

    public TestMvpPresenter(TestMvpActivity testMvpActivity){
        this.testMvpActivity = testMvpActivity;
    }

    @Override
    public void clean() {
        testMvpActivity.doClean();
    }

    @Override
    public void doLogin(String username, String password) {
        if ("wangjitao".equals(username) && "123".equals(password)) {
            testMvpActivity.loginResult(true, "user:" + username + ",pass:" + password);
        }else {
            testMvpActivity.loginResult(false, "user:" + username + ",pass:" + password);
        }
    }
}
