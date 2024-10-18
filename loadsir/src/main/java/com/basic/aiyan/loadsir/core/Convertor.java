package com.basic.aiyan.loadsir.core;

import com.basic.aiyan.loadsir.callback.Callback;

/**
 * 
 * Create Time:2017/9/4 8:58
 * Author:KingJA
 * Email:kingjavip@gmail.com
 */
public interface Convertor<T> {
   Class<?extends Callback> map(T t);
}
