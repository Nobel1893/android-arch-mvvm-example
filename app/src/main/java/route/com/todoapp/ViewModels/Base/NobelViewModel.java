package route.com.todoapp.ViewModels.Base;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.util.Pair;

import route.com.todoapp.API.APICalls;
import route.com.todoapp.API.ApiManager;

/**
 * Created by Mohamed Nabil Mohamed (Nobel) on 4/25/2018.
 * byte code SA
 * m.nabil.fci2015@gmail.com
 */

public class NobelViewModel extends AndroidViewModel {

    protected MutableLiveData<Pair<Boolean,String>> shoudldShowMessage;
    protected MutableLiveData<Boolean> shoudldShowLoading;
    protected APICalls apiCalls;


    public NobelViewModel(Application application){
        super(application);
        shoudldShowLoading=new MutableLiveData<>();
        shoudldShowMessage=new MutableLiveData<>();
        shoudldShowLoading.postValue(false);
        shoudldShowMessage.postValue(null);
        apiCalls= ApiManager.getApiService();
    }



    public MutableLiveData<Pair<Boolean, String>> getShoudldShowMessage() {
        return shoudldShowMessage;
    }

    public void setShoudldShowMessage(MutableLiveData<Pair<Boolean, String>> shoudldShowMessage) {
        this.shoudldShowMessage = shoudldShowMessage;
    }

    public MutableLiveData<Boolean> getShoudldShowLoading() {
        return shoudldShowLoading;
    }

    public void setShoudldShowLoading(MutableLiveData<Boolean> shoudldShowLoading) {
        this.shoudldShowLoading = shoudldShowLoading;
    }

}
