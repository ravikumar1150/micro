package demo.sample.emp;

public abstract class Car {

	abstract void startEngine();
	
	abstract void accelerate();
	
	public void brake() {
		System.out.println("Car slow Down brake applide :");
	}


}

class Sift extends Car {

	@Override
	void startEngine() {
		System.out.println("Engine Start ");
	}

	@Override
	void accelerate() {
		System.out.println("Car Moving Fast ");
		
	}

	
	
	
	

}
