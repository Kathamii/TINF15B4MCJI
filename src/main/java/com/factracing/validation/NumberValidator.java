package com.factracing.validation;


public class NumberValidator implements Validator<Integer>
{

	private int min, max;


	public NumberValidator(int min, int max)
	{
		this.min = min;
		this.max = max;
	}


	@Override
	public Integer validate(Integer number)
	{
		if (number < min || number > max)
			return null;
		return number;
	}
}
