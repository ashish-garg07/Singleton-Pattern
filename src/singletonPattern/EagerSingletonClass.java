package singletonPattern;

public class EagerSingletonClass {

	private static EagerSingletonClass singletonClass = new EagerSingletonClass();
	
	private EagerSingletonClass() {
		
	}
	
	//Eager initialization:
	//By making the constructor as private you are not allowing other class to create a new instance of the class 
	//you want to create the Singleton. Instead, you are creating one public static method (commonly name as 
	//for getInstance()) to provide the single entry point to create the new instance of the class.
	public static EagerSingletonClass getInstance() {
			return singletonClass;
	}
}
