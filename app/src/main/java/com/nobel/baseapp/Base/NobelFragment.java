package com.nobel.baseapp.Base;

import android.arch.lifecycle.Observer;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Pair;

import com.afollestad.materialdialogs.MaterialDialog;

import com.nobel.baseapp.ViewModels.Base.NobelViewModel;

/**
 * Created by Mohamed Nabil Mohamed (Nobel) on 4/14/2018.
 * byte code SA
 * m.nabil.fci2015@gmail.com
 */

public class NobelFragment extends Fragment {

   protected NobelActivity activity;
   protected Fragment fragment;
   private NobelViewModel nobelViewModel;


    public void SubscribeBaseObservers(NobelViewModel viewModel){
        nobelViewModel=viewModel;
        if (nobelViewModel==null) return;
        nobelViewModel.getShoudldShowLoading().observe(fragment, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                if (aBoolean==null) return;
                if (aBoolean)ShowProgressDialoge();
                else HideProgressDialog();
            }
        });

        nobelViewModel.getShoudldShowMessage().observe(fragment, new Observer<Pair<Boolean, String>>() {
            @Override
            public void onChanged(@Nullable Pair<Boolean, String> booleanStringPair) {

                if(booleanStringPair==null)return;
                if (booleanStringPair.first)ShowMessage("",booleanStringPair.second);
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        activity=(NobelActivity)context;

    }

    public MaterialDialog ShowProgressDialoge(){
        return activity.ShowProgressDialoge();
    }

    public void HideProgressDialog(){
        activity.HideProgressDialog();
    }

    public MaterialDialog ShowMessage(String title,String mess){

     return activity.ShowMessage(title,mess);
    }

    public MaterialDialog ShowConfirmationDialog(String title, String mess, String posText, String negText,
                                                 MaterialDialog.SingleButtonCallback onPositiveClick){

        return activity.ShowConfirmationDialog(title,mess,posText,negText,onPositiveClick);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragment=this;
    }
}
