
public class StaticTry {
	
	  String a="Obed";
	static String b;
	
	public static void main(String aaa[])
	{
		StaticTry aa=new StaticTry();
		aa.run();
		System.out.println(aa.a);
		System.out.println(b);
		
	}
	
	void run2()
	{
		b=a;
	}
	
	 static void run()
	{
		 
		 StaticTry a1=new StaticTry();
		 a1.run2();
		System.out.println(b);
	}

}
