package com.factracing.validation;


public class NameValidator implements Validator<String>
{

	CharSequence[] invalidCharacters;


	public NameValidator()
	{
		this(new CharSequence[] { "@", ".", ",", "!", "%", "$", " " });
	}


	public NameValidator(CharSequence[] invalidCharacters)
	{
		this.invalidCharacters = invalidCharacters;
	}


	@Override
	public String validate(String ob)
	{
		String name = ob;
		if (name != null && name.length() > 0)
		{
			for (CharSequence invalid : invalidCharacters)
				if (name.contains(invalid))
				{
					return null;
				}
			return name;
		}
		return null;
	}
}
