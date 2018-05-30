package com.example.ronaldbenjamin.saarthironald.apicalls;
import com.example.ronaldbenjamin.saarthironald.models.ChatResonse;
import com.example.ronaldbenjamin.saarthironald.models.histroyChat;
import com.example.ronaldbenjamin.saarthironald.models.ChatResonse;
import com.example.ronaldbenjamin.saarthironald.models.histroyChat;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public class SaarthiAPI {

    public static final String url="https://saarthi.localtunnel.me/";

    public static PostService postService=null;

    public static PostService getService()
    {
       if(postService == null)
       {
        Retrofit retrofit=new Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build();
        postService=retrofit.create(PostService.class);
       }
    return postService;
    }
    public interface PostService
{

         @POST("chat/home_page/")
         @Headers("Content-Type:application/json")
    Call<ChatResonse> getChatResponse(@Body PostObject postObject);

    @POST("chat/message_chat/")
    @Headers("Content-Type:application/json")
    Call<ChatResonse> getChatHistroy(@Body histroyChat histroyChat1);

}

}
