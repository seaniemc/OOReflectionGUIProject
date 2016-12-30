package ie.gmit.sw;

public class Car {
	
	String Reg;
	String Make;
	String Model;
	int doors;
	int milage;
	int age;
	
	public Car(){
		super();
	}
	
	public Car(String reg, String make, String model, int doors, int milage, int age) {
		super();
		Reg = reg;
		Make = make;
		Model = model;
		this.doors = doors;
		this.milage = milage;
		this.age = age;
	}
	
	public String getReg() {
		return Reg;
	}
	public void setReg(String reg) {
		Reg = reg;
	}
	public String getMake() {
		return Make;
	}
	public void setMake(String make) {
		Make = make;
	}
	public String getModel() {
		return Model;
	}
	public void setModel(String model) {
		Model = model;
	}
	public int getDoors() {
		return doors;
	}
	public void setDoors(int doors) {
		this.doors = doors;
	}
	public int getMilage() {
		return milage;
	}
	public void setMilage(int milage) {
		this.milage = milage;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getAge() {
		return age;
	}

}
