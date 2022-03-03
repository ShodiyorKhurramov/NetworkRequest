package com.example.networkrequest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.example.networkrequest.model.Poster
import com.example.networkrequest.model.PosterResp
import com.example.networkrequest.network.ret.servies.RetrofitHttp
import com.example.networkrequest.network.volley.VolleyHandler
import com.example.networkrequest.network.volley.VolleyHttp
import com.example.networkrequest.utils.Logger
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var text : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

       fun  initView(){
            text=findViewById(R.id.tv_ma)
           workWithRetrofit()
//           workWithVolley()


       }
    //Retrofit

    fun workWithRetrofit(){

        RetrofitHttp.posterService.listPost().enqueue(object : Callback<ArrayList<PosterResp>> {
            override fun onResponse(call: Call<ArrayList<PosterResp>>, response: Response<ArrayList<PosterResp>>) {
                Log.d("@@@", response.body().toString())
            }

            override fun onFailure(call: Call<ArrayList<PosterResp>>, t: Throwable) {
                Log.d("@@@", t.message.toString())
            }
        })


        val poster = Poster(1, 1, "PDP", "Online")

        RetrofitHttp.posterService.createPost(poster).enqueue(object : Callback<PosterResp> {
            override fun onResponse(call: Call<PosterResp>, response: Response<PosterResp>) {
                Log.d("@@@", response.body().toString())
            }

            override fun onFailure(call: Call<PosterResp>, t : Throwable) {
                Log.d("@@@", t.message.toString())
            }
        })

        RetrofitHttp.posterService.updatePost(poster.id, poster).enqueue(object : Callback<PosterResp> {
            override fun onResponse(call: Call<PosterResp>, response: Response<PosterResp>) {
                Log.d("@@@", response.body().toString())
            }

            override fun onFailure(call: Call<PosterResp>, t: Throwable) {
                Log.d("@@@", t.message.toString())
            }
        })

        RetrofitHttp.posterService.deletePost(poster.id).enqueue(object : Callback<PosterResp> {
            override fun onResponse(call: Call<PosterResp>, response: Response<PosterResp>) {
                Log.d("@@@", "" + response.body())
            }

            override fun onFailure(call: Call<PosterResp>, t: Throwable) {
                Log.d("@@@", "" + t.message)
            }
        })
    }






















    // Volley


//
//    val poster = Poster(1,1,"Shodiyor","Online")
//
//    VolleyHttp.post(VolleyHttp.API_CREATE_POST,VolleyHttp.paramsCreate(poster), object  : VolleyHandler
//    {
//        override fun onSuccess(response: String?) {
//            Logger.d("@@@",response!!)
//        }
//
//        override fun onError(error: String?) {
//            Logger.d("@@@",error!!)
//        }
//    })
//
//
//    VolleyHttp.put(VolleyHttp.API_UPDATE_POST + poster.id,VolleyHttp.paramsUpdate(poster), object  :
//        VolleyHandler{
//        override fun onSuccess(response: String?) {
//            Log.d("@@@",response!!)
//        }
//
//        override fun onError(error: String?) {
//            Log.d("@@@",error!!)
//
//        }
//
//    })
//
//    VolleyHttp.del(VolleyHttp.API_DELETE_POST + poster.id,object  :
//        VolleyHandler{
//        override fun onSuccess(response: String?) {
//            Log.d("@@@",response!!)
//        }
//
//        override fun onError(error: String?) {
//            Log.d("@@@",error!!)
//
//        }
//
//    })
//
//


//    fun workWithVolley(){
//        VolleyHttp.get(VolleyHttp.API_LIST_POST, VolleyHttp.paramsEmpty(),object  : VolleyHandler{
//            override fun onSuccess(response: String?) {
//                Logger.d("VolleyHttp",response!!)
//                text.text=response
//
//            }
//
//            override fun onError(error: String?) {
//                Logger.d("VolleyHttp",error!!)
//            }
//        })
//    }




}