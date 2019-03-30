package com.example.pc.kotlin.ui.contract;

public interface TestMvpContract {
    interface Model {
    }

    interface View {
        void doClean();

        void loginResult(boolean isSuccess, String messing);
    }

    interface Presenter {
        void clean();

        void doLogin(String username, String password);
    }
}
