class A
{
	public class B
	{
		public class C
		{
			public void demo()
			{
				System.out.println("I am coming from the innermost class method");
			}
		}
	}
	// Inner class method can be static only if the inner class is static
	static class D{
		class E{
			static void demo(){
				System.out.println("I am coming from the innermost class method");
			}
		}
	}
}
public class InnerClasses
{
	public static void main(String args[])
	{
		// Three line 
		A a1 = new A();
		A.B b1 = a1.new B();
		A.B.C c1 = b1.new C();
		c1.demo();
		// Single line
		// new A().new B().new C().demo();
		// if demo is static
		//A.D.E.demo();
		// if demo is not static
		// new A.D.E().demo();
		new A.D().new E().demo();
	}
}
