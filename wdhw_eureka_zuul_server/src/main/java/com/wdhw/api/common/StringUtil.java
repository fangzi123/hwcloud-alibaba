package com.wdhw.api.common;

/**
 * Created by admin on 2017/2/16.
 */
public class StringUtil {
    public   static  boolean IsNullOrEmpty(Object obj){
        if(obj==null) return true;
        else if(obj.toString().isEmpty()) return true;
        return  false;
    }
}
