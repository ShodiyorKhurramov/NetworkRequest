package com.example.networkrequest.network.volley

interface VolleyHandler {

    fun onSuccess(response : String ?)
    fun onError(error : String?)
}