package p1;

public class A{
	//public static void main(String[] args){
	//	System.out.println("Hello I'm coming out of package p1.");
	//}
	public int x = 10;
	private int y = 20;
	protected int z = 30;
	int q = 40;

	public void display(){
		System.out.println(x);
		System.out.println(y);
		System.out.println(z);
		System.out.println(q);
	}
}

class B extends A{
	public void display(){
		System.out.println(x);
		//System.out.println(y);
		System.out.println(z);
		System.out.println(q);
	}
}

class C{
	public void display(){
		A a1 = new A();
		System.out.println(a1.x);
		//System.out.println(a1.y);
		System.out.println(a1.z);
		System.out.println(a1.q);
	}
}