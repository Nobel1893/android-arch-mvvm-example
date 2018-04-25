package route.com.todoapp.ViewModels;

import android.app.Application;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.google.gson.Gson;

import java.io.File;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import route.com.todoapp.API.APIJSON.EventsJson;
import route.com.todoapp.API.APIJSON.uploadImageResponse;
import route.com.todoapp.Model.Event;
import route.com.todoapp.ViewModels.Base.NobelViewModel;

/**
 * Created by Mohamed Nabil Mohamed (Nobel) on 4/23/2018.
 * byte code SA
 * m.nabil.fci2015@gmail.com
 */

public class EventListViewModel extends NobelViewModel {

    MutableLiveData<List<Event>> events;


    String Lang;

    public EventListViewModel(Application application){
        super(application);
        Lang="en";

        events=new MutableLiveData<>();

    }

    public void FetchEvents(){
        
        shoudldShowLoading.postValue(true);

        apiCalls.getEvents(Lang).enqueue(new Callback<EventsJson>() {
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
    public void testUpload(){

        shoudldShowLoading.postValue(true);

        File file = new File("/storage/emulated/0/Pictures/Etathaker/Riva/mohamed  726924.png");
        RequestBody image = RequestBody.create(MediaType.parse("image/*"), file);
        RequestBody name_en =RequestBody.create(MediaType.parse("text/plain"), "نبيل222");
        RequestBody name_ar =RequestBody.create(MediaType.parse("text/plain"), "nabil222");
        RequestBody desc_en =RequestBody.create(MediaType.parse("text/plain"), "وصف");
        RequestBody desc_ar =RequestBody.create(MediaType.parse("text/plain"), "desc");
        RequestBody price =RequestBody.create(MediaType.parse("text/plain"), "12.5");
        RequestBody tab_id =RequestBody.create(MediaType.parse("text/plain"), "1");
        RequestBody cat_id =RequestBody.create(MediaType.parse("text/plain"), "1");
        RequestBody user_id =RequestBody.create(MediaType.parse("text/plain"), "5");

        Log.e("filename",file.getName());
        MultipartBody.Part body = MultipartBody.Part.createFormData("image[]", file.getName(), image);

        apiCalls.uploadImage(body,name_en,name_ar,desc_en,desc_ar,price,cat_id,tab_id,user_id).enqueue(new Callback<uploadImageResponse>() {
            @Override
            public void onResponse(Call<uploadImageResponse> call, Response<uploadImageResponse> response) {

                Log.e("image","uploaded success");
                Gson gson=new Gson();
                Log.e("image response",gson.toJson(response.body()));
            }

            @Override
            public void onFailure(Call<uploadImageResponse> call, Throwable t) {

                Log.e("image","uploaded fail");
                Gson gson=new Gson();
                Log.e("image response",gson.toJson(t.getMessage()));
            }
        });


    }
    public MutableLiveData<List<Event>> getEvents(){
        return events;
    }

}
