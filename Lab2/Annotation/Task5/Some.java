package Lab2.Annotation.Task5;

@ToDo(message="add some fields and constructor")
public class Some
{
	@ToDo(message="change type of key to guid")
	private String key;
	private int value;
	
	@ToDo(message="need new format")
	public String getEntry()
	{
		return key + " => " + value;
	}
	
	public static void main(String[] args)
	{
		
	}
}