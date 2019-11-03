package com.eng.elfarsisy.bloodbank.ui.activity.ui.usinginstruction;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class UsingInstructionViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public UsingInstructionViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}