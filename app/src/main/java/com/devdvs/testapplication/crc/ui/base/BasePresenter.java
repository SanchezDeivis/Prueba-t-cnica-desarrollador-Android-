package com.devdvs.testapplication.crc.ui.base;

public class BasePresenter<V extends MVPView> implements MVPPresenter<V> {

    private V mvpView;

    @Override
    public void onAttach(V mvpView) {
        this.mvpView = mvpView;
    }

    public V getMvpView() {
        return mvpView;
    }
}
