package ClassWork.Jan10.Morning.p2;
import p1.A;


public class D{
	public void display(){
		A a1 = new A();
		System.out.println(a1.x);
		//System.out.println(a1.y);
		//System.out.println(a1.z);
		//System.out.println(a1.q);
	}
}

class E extends A{
	public void display(){
		System.out.println(x);
		//System.out.println(y);
		System.out.println(z);
		//System.out.println(q);
	}
}

class F extends E{
	public void display(){
		System.out.println(x);
		//System.out.println(y);
		System.out.println(z);
		//System.out.println(q);
	}
}