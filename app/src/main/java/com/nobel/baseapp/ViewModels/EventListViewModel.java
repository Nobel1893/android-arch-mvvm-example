package com.nobel.baseapp.ViewModels;

import android.app.Application;
import android.arch.lifecycle.MutableLiveData;

import com.nobel.baseapp.API.APIJSON.EventsJson;
import com.nobel.baseapp.Model.Event;
import com.nobel.baseapp.ViewModels.Base.NobelViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Mohamed Nabil Mohamed (Nobel) on 4/23/2018.
 * byte code SA
 * m.nabil.fci2015@gmail.com
 */

public class EventListViewModel extends NobelViewModel {

    MutableLiveData<List<Event>> events;

    public EventListViewModel(Application application){
        super(application);

        events=new MutableLiveData<>();

    }

    public void FetchEvents(){
        
        shoudldShowLoading.postValue(true);

        apiCalls.getEvents("en").enqueue(new Callback<EventsJson>() {
            @Override
            public void onResponse(Call<EventsJson> call, Response<EventsJson> response) {
                shoudldShowLoading.setValue(false);
                events.postValue(response.body().getResult().getEvents());

            }

            @Override
            public void onFailure(Call<EventsJson> call, Throwable t) {
                shoudldShowLoading.postValue(false);

            }
        });
    }
    public MutableLiveData<List<Event>> getEvents(){
        return events;
    }

}
