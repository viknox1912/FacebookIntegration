package com.example.viknox.facebookintegration;

import android.app.Activity;
import android.media.Image;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.ImageButton;


public class OverviewActivity extends Activity {
    ImageButton btn_search, btn_groups, btn_chat, btn_settings;


    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.overview_activity);
        initUI();
    }

    private void initUI() {
        btn_search = (ImageButton) findViewById(R.id.searchBtn);
        btn_groups = (ImageButton) findViewById(R.id.groupsBtn);
        btn_chat   = (ImageButton) findViewById(R.id.chatBtn);
        btn_settings = (ImageButton) findViewById(R.id.settingsBtn);


    }
}
