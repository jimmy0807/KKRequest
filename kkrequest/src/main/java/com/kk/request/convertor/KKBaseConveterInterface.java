package com.kk.request.convertor;

public interface KKBaseConveterInterface<U,V>
{
    V onReceieve(U object);
}
