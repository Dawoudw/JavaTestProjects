package JavaCore;

public interface D extends A , B {

	default void print()
	{
		System.out.println(" interface D");
	}
}
