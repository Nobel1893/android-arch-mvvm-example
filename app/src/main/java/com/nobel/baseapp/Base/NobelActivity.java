package com.nobel.baseapp.Base;

import android.arch.lifecycle.Observer;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Pair;
import android.view.View;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;

import com.nobel.baseapp.NobelProviders.PrefrencesProvider;
import com.nobel.baseapp.R;
import com.nobel.baseapp.ViewModels.Base.NobelViewModel;

import java.util.Locale;


/**
 * Created by Mohamed Nabil Mohamed (Nobel) on 4/14/2018.
 * byte code SA
 * m.nabil.fci2015@gmail.com
 */

public class NobelActivity extends AppCompatActivity{

   protected NobelActivity activity;
    MaterialDialog dialog;
    private NobelViewModel nobelViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activity=this;
    }

    @Override
    protected void onResume() {
        super.onResume();
        setLanguage();
    }
    public void setLanguage() {

        String lang = PrefrencesProvider.getInstance().get(PrefrencesProvider.LANG,PrefrencesProvider.defLang);

        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.setLocale(locale);
        config.setLayoutDirection(locale);

        getBaseContext().getResources().updateConfiguration(config,
                getBaseContext().getResources().getDisplayMetrics());

    }

    public void ShowBackButton() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar mActionBar = getSupportActionBar();
        mActionBar.setDisplayHomeAsUpEnabled(true);
        mActionBar.setDisplayShowHomeEnabled(true);
        // toolbar.setNavigationIcon(R.drawable.ic_action_back);
        String title = getIntent().getStringExtra("title");
        if (title != null)
            ((TextView) findViewById(R.id.title)).setText(title);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();  // to go back  finish() will do your work.
                //mActionBar.setDisplayHomeAsUpEnabled(true);
                //mActionBar.setDisplayShowHomeEnabled(true);
            }
        });
    }


    public void SubscribeBaseObservers(NobelViewModel viewModel){
        nobelViewModel=viewModel;
        if (nobelViewModel==null) return;
        nobelViewModel.getShoudldShowLoading().observe(activity, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                if (aBoolean==null) return;
                if (aBoolean)ShowProgressDialoge();
                else HideProgressDialog();
            }
        });

        nobelViewModel.getShoudldShowMessage().observe(activity, new Observer<Pair<Boolean, String>>() {
            @Override
            public void onChanged(@Nullable Pair<Boolean, String> booleanStringPair) {

                if(booleanStringPair==null)return;
                if (booleanStringPair.first)ShowMessage("",booleanStringPair.second);
            }
        });
    }

   public MaterialDialog ShowProgressDialoge(){

        if (dialog==null||!dialog.isShowing())
        dialog=new MaterialDialog.Builder(this)
                .title(R.string.loading)
                .content(R.string.please_wait)
                .progress(true, 0)
                .cancelable(false)
                .show();

        else return dialog;

         return dialog;
    }

    public void HideProgressDialog(){

       if (dialog!=null&& dialog.isShowing())dialog.dismiss();

    }

    public MaterialDialog ShowMessage(String title,String mess){

        dialog=new MaterialDialog.Builder(this)
                .title(title)
                .content(mess)
                .positiveText(R.string.ok)
                .show();
        return dialog;
    }

    public MaterialDialog ShowConfirmationDialog(String title, String mess, String posText, String negText,
                                                 MaterialDialog.SingleButtonCallback onPositiveClick){

        dialog=new MaterialDialog.Builder(this)
                .title(title)
                .content(mess)
                .positiveText(posText)
                .negativeText(negText)
                .onPositive(onPositiveClick)
                .show();

        return dialog;

    }



}
