package empapp;

public class Address {
	private String city;
	private String state;
	private int pin;
	
	public Address() {
		System.out.println("Address Object Created");
	}
	

	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public int getPin() {
		return pin;
	}


	public void setPin(int pin) {
		this.pin = pin;
	}


	public Address(String city, String state, int pin) {
		this.city = city;
		this.state = state;
		this.pin = pin;
		System.out.println("Address Object Created using Initialization");
	}


	@Override
	public String toString() {
		return "Address [city=" + city + ", state=" + state + ", pin=" + pin + "]";
	}
}

