package study.study.study.common.dto

import study.study.study.common.status.ResultCode

data class BaseResponse<T> (
    val resultCode: String = ResultCode.SUCCES.name,
    val data: T? = null,
    val message: String = ResultCode.SUCCES.msg,
)