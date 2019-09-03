
public class constructorEX extends A{

	public static void main(String[] args) {
		
		constructorEX o=new constructorEX();
	}

}



class A extends B
{
	A()
	{
		System.out.println("In A");
	}
}

class B extends C
{
	B()
	{
		System.out.println("In B");
	}
	
}

class C
{
	C()
	{
		System.out.println("In C");
	}
}