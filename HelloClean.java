package cleanCode;

import static java.lang.System.out;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class HelloClean {

	public static void main(String[] args) {

		Customer customer = new Customer();

		double discount = customer.getProfileOpt().map(Profile::getGoldCar).map(GoldCar::getDiscount).orElse(0d);
		out.println("discount= " + discount);
		
		filteredAndSortedListNames();
	}

	private static void filteredAndSortedListNames() {
		List<String> myList = Arrays.asList("a1", "a2", "b1", "b2", "c1", "c2");
		myList.stream().filter(s -> s.startsWith("c")).map(String::toUpperCase).sorted().forEach(out::println);
		myList.stream().findFirst().ifPresent(out::println);
		IntStream.range(1, 4).forEach(out::println);

	}

}
class Person{
	private int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
}
class Customer {
	private Profile profile;

	public Profile getProfile() {
		return profile;
	}

	public Optional<Profile> getProfileOpt() {
		return Optional.ofNullable(profile);
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

}

class Profile {
	private GoldCar goldCar;

	public GoldCar getGoldCar() {
		return goldCar;
	}

	public void setGoldCar(GoldCar goldCar) {
		this.goldCar = goldCar;
	}

}

class GoldCar {
	private double discount;

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

}