package com.luan.myfin.financeiro.base.util;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

public class LoggerInterceptor {
    private static final String LOG = "#MYFIN :: EXECUTANDO :: ";
    
    @AroundInvoke
    public Object log(InvocationContext context) throws Exception{
        System.out.println(LOG + context.getMethod().getName());
        
        return context.proceed();
    }
}
