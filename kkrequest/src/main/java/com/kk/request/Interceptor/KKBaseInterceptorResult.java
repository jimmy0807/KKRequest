package com.kk.request.Interceptor;

public class KKBaseInterceptorResult<T>
{
    public static int NextSuccess = 0;
    public static int NextFailed = -1;
    public static int NextComplete = 1;

    private int code;
    private int nextStep;
    private String message;
    private T data;

    public int getCode()
    {
        return code;
    }

    public void setCode(int code)
    {
        this.code = code;
    }

    public String getMessage()
    {
        return ( message != null ? message : "" );
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public T getData()
    {
        return data;
    }

    public void setData(T data)
    {
        this.data = data;
    }

    public int getNextStep()
    {
        return nextStep;
    }

    public void setNextStep(int nextStep)
    {
        this.nextStep = nextStep;
    }
}
