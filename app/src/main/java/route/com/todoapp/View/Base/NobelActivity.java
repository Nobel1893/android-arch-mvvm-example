package route.com.todoapp.View.Base;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Pair;

import com.afollestad.materialdialogs.MaterialDialog;

import route.com.todoapp.R;
import route.com.todoapp.ViewModels.Base.NobelViewModel;


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



    public String getSavedString(String key){
      String s=  getSharedPreferences(PrefName,MODE_PRIVATE)
                .getString(key,null);
      return s;
    }

    public void SaveString(String key,String value){

        getSharedPreferences(PrefName,MODE_PRIVATE).edit()
                .putString(key,value).apply();
    }



    public static final String PrefName="";
}
