package com.trackmyfamily.commons.exceptionhandler

import com.google.gson.JsonObject

data class CommonException(
    val status: Int,
    val errCode: String,
    val errorMsg: String?,
    val attrs: JsonObject? = null
)