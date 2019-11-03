package com.eng.elfarsisy.bloodbank.ui.activity.ui.PersonalInfo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PerInfoViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public PerInfoViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}