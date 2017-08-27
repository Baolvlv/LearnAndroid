package com.example.bwx.preferenceactivity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.preference.CheckBoxPreference;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.PreferenceActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Setting extends Activity implements SharedPreferences.OnSharedPreferenceChangeListener {

    private ListPreference lp;
    private EditTextPreference etp;
    private CheckBoxPreference cp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //PreferenceActivity继承自ListActivity,没有ListView,不能调用setContentView
        //setContentView(R.layout.activity_setting);

        getFragmentManager().beginTransaction().replace(android.R.id.content,new MyPreferenceFragment())
                .commit();
        //addPreferencesFromResource(R.xml.preference);
        initPreference();


    }
    private void initPreference(){
//        lp = (ListPreference) findPreference(Keys.LIST_KEY);
//        etp = (EditTextPreference) findPreference(Keys.EDIT_KEY);
//        cp = (CheckBoxPreference) findPreference(Keys.CHECK_KEY);

    }


    //Activity恢复时执行，用于刷新的操作
    @Override
    protected void onResume() {
        super.onResume();

        //设置summary的值
        SharedPreferences sp = this.getPreferences(Activity.MODE_PRIVATE);
//          lp.setSummary(sp.getString(Keys.LIST_KEY,""));
 //           etp.setSummary(sp.getString(Keys.EDIT_KEY,"text"));


        //只要activity恢复时，重注册sharedPreferenceChangeListener
        sp.registerOnSharedPreferenceChangeListener(this);

    }

    @Override
    protected void onPause() {
        super.onPause();
        //Activity停止时，解除Listener
        this.getPreferences(Activity.MODE_PRIVATE)
                .unregisterOnSharedPreferenceChangeListener(this);
    }

    //任何key的值改变时，更新Summery的值
    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if(key.equals(Keys.EDIT_KEY)){
            etp.setSummary(sharedPreferences.getString(key,"text"));
        }else if(key.equals(Keys.LIST_KEY)){
            lp.setSummary(sharedPreferences.getString(key,""));

        }
    }
}
