package com.linc.howtopreferenceactivity;

import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.PreferenceActivity;

public class Setting extends PreferenceActivity implements OnSharedPreferenceChangeListener {
	
    private EditTextPreference mEtPreference;
    private ListPreference mListPreference;
    private CheckBoxPreference mCheckPreference;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.preferences);
        initPreferences();
    }
    
    private void initPreferences() {
    	mEtPreference = (EditTextPreference)findPreference(Consts.EDIT_KEY);
    	mListPreference = (ListPreference)findPreference(Consts.LIST_KEY);
    	mCheckPreference = (CheckBoxPreference)findPreference(Consts.CHECKOUT_KEY);
    }
    
    @Override
    protected void onResume() {
        super.onResume();

        // Setup the initial values
        SharedPreferences sharedPreferences = getPreferenceScreen().getSharedPreferences();
        mListPreference.setSummary(sharedPreferences.getString(Consts.LIST_KEY, ""));
        mEtPreference.setSummary(sharedPreferences.getString(Consts.EDIT_KEY, "linc"));
        
        // Set up a listener whenever a key changes
        sharedPreferences.registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Unregister the listener whenever a key changes
        getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener(this);
    }    
    
	@Override
	public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if (key.equals(Consts.EDIT_KEY)) {
        	mEtPreference.setSummary(
                    sharedPreferences.getString(key, "20"));
        } else if(key.equals(Consts.LIST_KEY)) {
        	mListPreference.setSummary(sharedPreferences.getString(key, ""));
        }
	}
}
