package route.com.todoapp.API;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import route.com.todoapp.API.APIJSON.EventsJson;
import route.com.todoapp.API.APIJSON.uploadImageResponse;

/**
 * Created by Mohamed Nabil Mohamed (Nobel) on 4/24/2018.
 * byte code SA
 * m.nabil.fci2015@gmail.com
 */

public interface APICalls {

    @GET("Events/GetEventsLst")
    Call<EventsJson> getEvents(@Query("Lang") String Lang);

    //add-item.php
    @Multipart
    @POST("add-item.php")
    Call<uploadImageResponse> uploadImage (

            @Part MultipartBody.Part image ,
            @Part("name_en") RequestBody name_en,
            @Part("name_ar") RequestBody name_ar,
            @Part("desc_en") RequestBody desc_en,
            @Part("desc_ar") RequestBody desc_ar,
            @Part("price") RequestBody price,
            @Part("cat_id") RequestBody cat_id,
            @Part("tab_id") RequestBody tab_id,
            @Part("user_id") RequestBody user_id
    );
}
