package com.example.movieappservinformacion.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName


class BaseResponse<T> protected constructor(`in`: Parcel) : Parcelable {
    @SerializedName(BASE_RESPONSE_STATUS_CODE)
    var id: String? = `in`.readString()

    @SerializedName(BASE_RESPONSE_RESULT)
    var result: T? = null

    @SerializedName(BASE_RESPONSE_JSON)
    var jsonrcp: String? = `in`.readString()
    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(id)
        dest.writeString(jsonrcp)
    }

    override fun describeContents(): Int {
        return 0
    }

    @JvmName("setResult1")
    fun setResult(result: T) {
        this.result = result
    }

    companion object {
        const val BASE_RESPONSE_STATUS_CODE = "id"
        const val BASE_RESPONSE_RESULT = "result"
        private const val BASE_RESPONSE_JSON = "jsonrcp"
        val CREATOR: Parcelable.Creator<BaseResponse<*>> = object :
            Parcelable.Creator<BaseResponse<*>> {
            override fun createFromParcel(`in`: Parcel): BaseResponse<*> {
                return BaseResponse<Any?>(`in`)
            }

            override fun newArray(size: Int): Array<BaseResponse<*>?> {
                return arrayOfNulls(size)
            }
        }
    }

}