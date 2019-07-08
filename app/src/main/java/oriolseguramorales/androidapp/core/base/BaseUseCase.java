package oriolseguramorales.androidapp.core.base;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public abstract class BaseUseCase<T, Params> {

    private final CompositeDisposable disposables;
    private Scheduler observeOnScheduler;


    public BaseUseCase(Scheduler observeOnScheduler) {
        this.disposables = new CompositeDisposable();
        this.observeOnScheduler = observeOnScheduler;
    }

    public abstract Observable<T> buildUseCaseObservable(Params params);


    public void execute(DisposableObserver<T> observer, Params params) {
        if(observer != null) {
            final Observable<T> observable = this.buildUseCaseObservable(params)
                    .subscribeOn(observeOnScheduler)
                    .observeOn(AndroidSchedulers.mainThread());
            addDisposable(observable.subscribeWith(observer));
        }
    }

    public void dispose() {
        if (!disposables.isDisposed()) {
            disposables.dispose();
        }
    }


    private void addDisposable(Disposable disposable) {
        if(disposable != null) {
            disposables.add(disposable);
        }
    }

}
