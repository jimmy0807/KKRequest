package com.kk.request.convertor;

public interface KKDecoderInterface<T>
{
    T decode(String value);
}
