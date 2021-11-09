package com.example.flickerretrofit

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyVM(application: Application): AndroidViewModel(application) {
    private var contents: MutableLiveData<List<Photo>> = MutableLiveData()

    var apiInterface = APIClient().getClient()?.create(APIInterface::class.java)
    fun getContents() = contents

    fun getData(s:String){

            apiInterface?.getPhoto(s)?.enqueue(object:Callback<FlickerDetails?> {
                override fun onResponse(
                    call: Call<FlickerDetails?>,
                    response: Response<FlickerDetails?>
                ) {

                    var list= response.body()!!.photos.photo

                    contents.postValue(list)

                }

                override fun onFailure(call: Call<FlickerDetails?>, t: Throwable) {
                    println(t.message)
                }
            })

    }



}

