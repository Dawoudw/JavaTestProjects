package JavaCore;

public class Child extends Parent {

	public Child() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Print() {
		System.out.println(this.getClass().toString());
	}

	static Child getChild() {
		return new Child();
	}

	public int Age;

}
