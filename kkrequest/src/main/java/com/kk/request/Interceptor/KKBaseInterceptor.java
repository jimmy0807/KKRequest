package com.kk.request.Interceptor;

import com.zhouyou.http.exception.ApiException;
import com.zhouyou.http.request.BaseRequest;

abstract public class KKBaseInterceptor<T>
{
    public boolean willStart() {return true;}
    public void willExecute(BaseRequest request) {}
    //public HashMap<String, String> canModifyParams(HashMap<String, String> params) { return params; }
    public KKBaseInterceptorResult onReceieve(T object) { return null; }
    public KKBaseInterceptorResult onError(ApiException e) { return null; }
    public void willShowLoadingView() {  }
    public void willShowToast(String message) {  }
}
