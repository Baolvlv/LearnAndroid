package com.example.bwx.preferenceactivity;


import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.support.annotation.Nullable;


/**
 * Created by bwx on 2017/3/17.
 */

public class MyPreferenceFragment extends PreferenceFragment  {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preference);
    }
}
