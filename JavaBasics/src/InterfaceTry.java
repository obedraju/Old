
public class InterfaceTry implements voilin, flute {

	public static void main(String[] args) {
				
		int i = 0;
		if(i==1) {
		
		voilin o=new InterfaceTry();
		o.music();
		System.out.print(o.a);
		
		
		}else
		{
			flute o=new InterfaceTry();
			o.music();
			System.out.print(o.a);
		}
	}

	
	public void music() {
		System.out.println("Implementing");
		
	}

}

interface voilin 
{
	void music();
	static String a="I am from voilin";
}

interface flute
{
	void music();
	static String a="I am from flute";
}

