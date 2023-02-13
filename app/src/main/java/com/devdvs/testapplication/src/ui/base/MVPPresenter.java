package com.devdvs.testapplication.src.ui.base;

public interface MVPPresenter<V extends MVPView> {

    void onAttach(V mvpView);

}
