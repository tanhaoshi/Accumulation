package com.example.accumulation.mvp.base;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * create by tanhs on 2020/5/23 14:29
 */
public class UserBasePresenterImpl<V extends UserBaseView,M extends UserBaseModel> implements UserBasePresenter{

    protected V mView;
    protected M mModel;

    private CompositeDisposable mCompositeDisposable;

    public UserBasePresenterImpl(V view){
        this.mView = view;
    }

    @Override
    public void detach() {
        this.mView = null;
        this.mModel = null;
        unDisposable();
    }

    @Override
    public void addDisposable(Disposable subscription) {
        if (mCompositeDisposable == null || mCompositeDisposable.isDisposed()) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(subscription);
    }

    @Override
    public void unDisposable() {
        if (mCompositeDisposable != null) {
            mCompositeDisposable.dispose();
        }
    }

    protected <T> void subscribe(Observable<T> observable, Consumer<T> consumer) {
        subscribe(observable, consumer, true);
    }

    protected <T> void subscribe(Observable<T> observable, Consumer<T> consumer, boolean isShowExceptionMsg) {
        addDisposable(observable.subscribe(consumer, throwable -> {
            if (mView != null && isShowExceptionMsg) mView.showError(throwable.getMessage());
        }));
    }
}
