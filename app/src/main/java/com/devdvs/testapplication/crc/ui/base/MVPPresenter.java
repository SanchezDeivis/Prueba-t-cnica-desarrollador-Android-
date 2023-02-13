package com.devdvs.testapplication.crc.ui.base;

public interface MVPPresenter<V extends MVPView> {

    void onAttach(V mvpView);

}
