package com.easyhome.jrconsumer.mvp.contract

import com.jess.arms.mvp.IModel
import com.easyhome.jrconsumer.app.base.IView
import com.easyhome.jrconsumer.mvp.model.entity.HttpResult
import io.reactivex.Observable
import okhttp3.RequestBody


interface RetrievePasswordContract {
    //对于经常使用的关于UI的方法可以定义到IView中,如显示隐藏进度条,和显示文字消息
    interface View : IView

    //Model层定义接口,外部只需关心Model返回的数据,无需关心内部细节,即是否使用缓存
    interface Model : IModel{
        fun alter(requestBody: RequestBody): Observable<HttpResult<Boolean>>
        fun smsCode(mobile: String, genre: String, type: String): Observable<HttpResult<Any>>
    }

}
