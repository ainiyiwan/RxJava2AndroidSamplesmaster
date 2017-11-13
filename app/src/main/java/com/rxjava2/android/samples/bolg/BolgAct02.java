package com.rxjava2.android.samples.bolg;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

import com.rxjava2.android.samples.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class BolgAct02 extends AppCompatActivity {

    @BindView(R.id.rxjava)
    Button rxjava;

    private String TAG = "rx";
    /**
     * composite 复合的；合成的；
     */
    private CompositeDisposable disposable = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bolg_act01);
        ButterKnife.bind(this);


    }

    @OnClick(R.id.rxjava)
    public void onViewClicked() {
//        Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
//                Log.d(TAG, "Observable thread is : " + Thread.currentThread().getName());
//                Log.d(TAG, "emit 1");
//                emitter.onNext(1);
//            }
//        });
//
//        Consumer<Integer> consumer = new Consumer<Integer>() {
//            @Override
//            public void accept(Integer integer) throws Exception {
//                Log.d(TAG, "Observer thread is :" + Thread.currentThread().getName());
//                Log.d(TAG, "onNext: " + integer);
//            }
//        };
//
//        observable.subscribe(consumer);
        Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                Log.d(TAG, "Observable thread is : " + Thread.currentThread().getName());
                Log.d(TAG, "emit 1");
                emitter.onNext(1);
            }
        });

        Consumer<Integer> consumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                Log.d(TAG, "Observer thread is :" + Thread.currentThread().getName());
                Log.d(TAG, "onNext: " + integer);
            }
        };

        observable.subscribeOn(Schedulers.newThread())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.d(TAG, "After observeOn(mainThread), current thread is: " + Thread.currentThread().getName());
                    }
                })
                .observeOn(Schedulers.io())
                .doOnNext(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer integer) throws Exception {
                        Log.d(TAG, "After observeOn(io), current thread is : " + Thread.currentThread().getName());
                        Log.d(TAG, "dispose size is : " + disposable.size());
                    }
                })
                .subscribe(consumer);

    }

//    public Observable<List<Record>> readAllRecords() {
//        return Observable.create(new ObservableOnSubscribe<List<Record>>() {
//            @Override
//            public void subscribe(ObservableEmitter<List<Record>> emitter) throws Exception {
//                Cursor cursor = null;
//                try {
//                    cursor = getReadableDatabase().rawQuery("select * from " + TABLE_NAME, new String[]{});
//                    List<Record> result = new ArrayList<>();
//                    while (cursor.moveToNext()) {
//                        result.add(Db.Record.read(cursor));
//                    }
//                    emitter.onNext(result);
//                    emitter.onComplete();
//                } finally {
//                    if (cursor != null) {
//                        cursor.close();
//                    }
//                }
//            }
//        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
//    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        disposable.clear();
    }
}
