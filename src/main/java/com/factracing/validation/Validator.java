package com.factracing.validation;

/**
 * Created by Janik on 17.05.2017.
 */
public interface Validator <T>{
    public T validate(T ob);
}
