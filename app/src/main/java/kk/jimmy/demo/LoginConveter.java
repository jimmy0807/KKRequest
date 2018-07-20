package kk.jimmy.demo;


import com.kk.request.convertor.KKBaseConveter;

import java.util.ArrayList;
import java.util.List;

public class LoginConveter extends KKBaseConveter<String, List<Integer>>
{
    @Override
    public List<Integer> onReceieve(String object)
    {
        List b  = new ArrayList();
        b.add(1);
        b.add(3);
        b.add(5);
        return b;
    }
}
