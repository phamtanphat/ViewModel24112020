package com.example.viewmodel24112020;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    MutableLiveData<Integer> mMutableInteger;

    public MyViewModel() {
        mMutableInteger = new MutableLiveData<>();
    }

    public void setCount(int count){
        mMutableInteger.setValue(count);
    }

    public LiveData<Integer> getCount(){
        return  mMutableInteger;
    }
}
