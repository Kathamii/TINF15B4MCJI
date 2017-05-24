package com.factracing.validation;


public interface Validator<T>
{

	public T validate(T ob);
}
