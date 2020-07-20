package com.angie.test0714.ui.newspeed;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NewspeedViewModel extends ViewModel {
    // TODO: Implement the ViewModel

    private MutableLiveData<String> mText;

    public NewspeedViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Newspeed fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
