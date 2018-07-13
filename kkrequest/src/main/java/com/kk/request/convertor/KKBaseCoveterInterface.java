package com.kk.request.convertor;

public interface KKBaseCoveterInterface<U,V>
{
    V onReceieve(U object);
}
