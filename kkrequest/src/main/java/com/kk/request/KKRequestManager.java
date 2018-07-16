package com.kk.request;

import com.kk.request.Interceptor.KKBaseInterceptor;
import com.kk.request.convertor.KKBaseDecoder;
import com.kk.request.convertor.KKJsonDecoder;
import com.kk.request.enumaration.KKRequestMethod;
import com.kk.request.tools.ApplicationHelper;
import com.zhouyou.http.EasyHttp;

import java.util.HashSet;
import java.util.Set;

public class KKRequestManager
{
    Set<KKBaseRequest> set = new HashSet<KKBaseRequest>();
    private String baseUrl;
    private int timeout;
    private KKBaseDecoder defaultDecoder;

    private volatile static KKRequestManager mInstance;
    private KKBaseInterceptor interceptor;

    private int mRequestMethod = KKRequestMethod.POSTBODY;

    public static KKRequestManager getInstance()
    {
        if (mInstance == null)
        {
            synchronized (KKRequestManager.class)
            {
                if ( mInstance == null )
                {
                    mInstance = new KKRequestManager();
                    mInstance.defaultDecoder = new KKJsonDecoder();
                    EasyHttp.init(ApplicationHelper.getApplication());
                }
            }
        }

        return mInstance;
    }

    void add(KKBaseRequest request)
    {
        this.set.add(request);
    }

    void remove(KKBaseRequest request)
    {
        this.set.remove(request);
    }

    public KKBaseDecoder getDefaultDecoder()
    {
        return defaultDecoder;
    }

    public int getDefaultRequestMethod()
    {
        return mRequestMethod;
    }

    public KKRequestManager setDefaultDecoder(KKBaseDecoder defaultDecoder)
    {
        this.defaultDecoder = defaultDecoder;

        return this;
    }

    public String getBaseUrl()
    {
        return baseUrl;
    }

    public KKRequestManager setBaseUrl(String baseUrl)
    {
        this.baseUrl = baseUrl;
        EasyHttp.getInstance().setBaseUrl(baseUrl);

        return this;
    }

    public KKRequestManager setTimeOut(int seconds)
    {
        timeout = seconds;

        EasyHttp.getInstance().setReadTimeOut(timeout * 1000).setWriteTimeOut(timeout * 1000).setConnectTimeout(timeout * 1000);

        return this;
    }

    public KKBaseInterceptor getInterceptor()
    {
        return interceptor;
    }

    public KKRequestManager setInterceptor(KKBaseInterceptor interceptor)
    {
        this.interceptor = interceptor;

        return this;
    }

    public KKRequestManager setMethodGet()
    {
        mRequestMethod = KKRequestMethod.GET;

        return this;
    }

    public KKRequestManager setMethodPostQuery()
    {
        mRequestMethod = KKRequestMethod.POSTQUERY;

        return this;
    }

    public KKRequestManager setMethodPut()
    {
        mRequestMethod = KKRequestMethod.PUT;

        return this;
    }

    public KKRequestManager setMethodDelete()
    {
        mRequestMethod = KKRequestMethod.DELETE;

        return this;
    }

    public KKRequestManager setMethodDownload()
    {
        mRequestMethod = KKRequestMethod.DOWNLOAD;

        return this;
    }

    public KKRequestManager setMethodUpload()
    {
        mRequestMethod = KKRequestMethod.UPLOAD;

        return this;
    }
}
