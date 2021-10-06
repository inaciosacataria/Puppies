package com.decode.usingrestapi.repositories

import com.google.gson.annotations.SerializedName

class DogResponse(@SerializedName("status") var status:String,
                  @SerializedName("message")var images:List<String>) {
}