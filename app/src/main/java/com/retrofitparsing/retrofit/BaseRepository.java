package com.retrofitparsing.retrofit;


import com.retrofitparsing.retrofit.exception.BaseException;

public abstract class BaseRepository {
    public interface Callback<T>{
        void onSuccess(T result);
        void onError(BaseException error);
    }
}
