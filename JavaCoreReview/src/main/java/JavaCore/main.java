package JavaCore;

import java.awt.peer.LabelPeer;
import java.text.BreakIterator;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TimeZone;
import java.util.TreeSet;
import java.util.concurrent.DelayQueue;
import java.util.function.Function;

import javax.xml.parsers.FactoryConfigurationError;

public class main {

	public main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String... args)
			throws InterruptedException, InstantiationException, IllegalAccessException {
		// TODO Auto-generated method stub
		finaltest ft = new finaltest(0, null); // We can't inherit the final class
		// AbstractTest ab = new AbstractTest() ; // Error , we can't instanctiate the
		// Abstract class

		// Collection test
		int[] array = new int[5];
		int i = 0;
		while (i < 5) {
			array[i] = ++i;
			i++;
		}
		Arrays.sort(array);
		for (int x : array) {
			System.out.println(x);

		}
		System.out.println(array.toString() + "end of array");

		ArrayList<String> ar = new ArrayList<String>();

		ar.add("Str1");
		ar.add("Str2");
		ar.add("Str3");
		ar.add("Str4");
		ar.add("Str2");
		ar.add("Str4");
		System.out.println(ar.get(1));
		Collections.sort(ar);
		Iterator it = ar.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());

		}

		Parent p1 = new Parent(5, "P1",
				Date.from(LocalDate.of(1990, 01, 20).atStartOfDay(ZoneId.systemDefault()).toInstant()));
		Parent p2 = new Parent(1, "P2",
				Date.from(LocalDate.of(1994, 10, 20).atStartOfDay(ZoneId.systemDefault()).toInstant()));
		Parent p3 = new Parent(4, "P2",
				Date.from(LocalDate.of(1990, 02, 20).atStartOfDay(ZoneId.systemDefault()).toInstant()));
		Parent p4 = new Parent(7, "P7",
				Date.from(LocalDate.of(1991, 12, 20).atStartOfDay(ZoneId.systemDefault()).toInstant()));

		ArrayList<Parent> parr = new ArrayList<Parent>();
		parr.add(p2);
		parr.add(p1);
		parr.add(p3);
		parr.add(p4);
		Comparator<Parent> comDOB = new Comparator<Parent>() {

			@Override
			public int compare(Parent o1, Parent o2) {
				// TODO Auto-generated method stub
				return o1.DOB.compareTo(o2.DOB);
			}
		};
		System.out.println(parr.get(2));
		Collections.sort(parr);
		Collections.sort(parr, comDOB);
		Collections.sort(parr, Comparator.comparing(Parent::getName).thenComparing(Comparator.comparing(Parent::getId))
				.thenComparing(comDOB).reversed());

		parr.forEach((p) -> System.out.println(p));

		Parent c = Child.getChild();// we are using what in the parent class only
		((Child) c).Age = 10;
		p1.Print();

		((Parent) c).Print();
		c.Print();
		System.out.println("-----------------------Linked List-------------------------");
		LinkedList<Parent> linkd = new LinkedList<Parent>();
		linkd.addAll(parr);

		it = linkd.descendingIterator();
		// linkd.addAll(parr);//Exception in thread "main"
		// java.util.ConcurrentModificationException

		while (it.hasNext()) {

			System.out.println(it.next());
		}
		System.out.println("-----------------------Synchronized List-------------------------");
		List<String> starr = Collections.synchronizedList(new ArrayList<String>());

		starr.addAll(ar);

		synchronized (starr) {
			it = starr.iterator();

			while (it.hasNext()) {

				System.out.println(it.next());
			}

		}
		System.out.println("-----------------------HashSet-------------------------");
		HashSet<String> haset = new HashSet<String>();
		haset.addAll(starr);
		haset.add(null);
		haset.add(null);
		haset.add("9");
		haset.add("9");
		it = haset.iterator();

		while (it.hasNext()) {

			System.out.println(it.next());
		}

		HashSet<String> shallowSet = new HashSet<String>();

		shallowSet = haset;

		Set<String> deepSet = new HashSet<String>();
		deepSet.addAll(haset);

		haset.add("NewIem");

		System.out.println("-----------------------Shallow CopyHashSet-------------------------");
		it = shallowSet.iterator();
		while (it.hasNext()) {

			System.out.println(it.next());
		}
		System.out.println("-----------------------Deep CopyHashSet-------------------------");
		it = deepSet.iterator();

		while (it.hasNext()) {

			System.out.println(it.next());
		}

		System.out.println("----------------------- Tree Set -------------------------");
		Comparator<Parent> comName = new Comparator<Parent>() {

			@Override
			public int compare(Parent o1, Parent o2) {
				// TODO Auto-generated method stub
				return o1.getName().compareTo(o2.getName());
			}
		};
		TreeSet<Parent> tree = new TreeSet<Parent>(comName.thenComparing(comDOB).reversed());
		tree.addAll(parr);
		// tree.add(null);//java.lang.NullPointerException
		tree.forEach((tr) -> System.out.println(tr));

		System.out.println("----------------------- Hash MAP   -------------------------");
		HashMap<Integer, String> hashmap = new HashMap<>();
		hashmap.put(1, "Key1");
		hashmap.put(2, "Key2");
		hashmap.put(null, "Key3");
		hashmap.put(6, "Key6");
		hashmap.put(5, null);
		hashmap.put(4, null);
		hashmap.replace(4, "Key4");
		System.out.println("HashMap  keySet: " + hashmap.keySet());
		System.out.println("HashMap  values: " + hashmap.values());
		System.out.println("HashMap  entrySet: " + hashmap.entrySet());
		System.out.println(hashmap.get(2));
		it = hashmap.entrySet().iterator();

		System.out.println("----------------------- Runnable -------------------------");
		Runnable r = new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				tree.forEach((tr) -> System.out.println(tr));

			}
		};
		// r.wait(5000); java.lang.IllegalMonitorStateException
		// r.run();

		hashmap.entrySet().forEach((k) -> System.out.println(k.getKey()));
		Thread th = new Thread(r);

		th.run();

		ArrayList<Integer> barray = new ArrayList<Integer>();
		int tempnum = 32;
		while (tempnum > 0) {
			barray.add(0, (tempnum % 2));
			tempnum = tempnum / 2;
		}
		System.out.println("sdsd");
		System.out.println(barray);
		int maxrep = 0;
		int counter = 0;

		for (int v = 1; v < barray.size(); v++) {
			if ((int) barray.get(v) == 0) {
				++counter;

			}
			if ((int) barray.get(v) == 1) {
				if (counter > maxrep) {

					maxrep = counter;

				}
				System.out.println(counter);
				counter = 0;
			}
		}
		System.out.println(maxrep);

		System.out.println("----------------------- Lambda Test -------------------------");
		Lambda lambda1 = (yy, xx) -> yy / xx;
		System.out.println("lambda Expr: " + clac(lambda1, 15000, 150));

		System.out.println("Method Ref: " + clac(Math::floorDiv, 15000, 150));

		Lambda2 lambda2 = Math::addExact; /// method reference == (x,y)->x+y;
		System.out.println("lambda Expr: " + lambda2.math(10, 2));

		System.out.println("Method Ref: " + clac(lambda2::math, 10, 2));

		List<Parent> parents = new ArrayList<Parent>();
		PrentFactory fac = (int Id, String Name, Date DOB) -> new Parent(Id, Name, DOB);

		parents.add(fac.create(2, "Wael2", new Date()));
		filllist(parents, Parent::new, 13, "Wael", new Date());
		parents.forEach((x) -> System.out.println(x.Name));
		Function<Integer, Integer> cxx = new Function<Integer, Integer>() {

			@Override
			public Integer apply(Integer t) {
				// TODO Auto-generated method stub
				return t;
			}
		};

		Function<Integer, Void> printout = new Function<Integer, Void>() {

			@Override
			public Void apply(Integer t) {
				// TODO Auto-generated method stub
				System.out.println(t);
				return null;
			}
		};
		printout.apply(ForEach(parents, cxx))		 ;

	}

	static <T> void filllist(List<T> list, PrentFactory factory, int Id, String Name, Date DOB) {

		// factory.create( class1.newInstance());

		list.add((T) factory.create(Id, Name, DOB));
	}

	static int clac(Lambda lambda1, int x, int y) {
		return lambda1.math(x, y);
	}

	static final Integer ForEach(List<Parent> plist, Function<Integer, Integer> function) {
		Integer result = null;
		for (Parent p : plist) {
			result = function.apply(p.getId());
		}
		return result;
	}

}

//functional interface
@FunctionalInterface
interface Lambda {
	// single abstract method (SAM)
	public int math(int x, int y);

}

interface Lambda2 extends Lambda {
	// single abstract method (SAM)
	// public int calc(int x, int y);// compile error
}

interface PrentFactory {
	Parent create(int Id, String Name, Date DOB);
	// Parent create();
}
