package singletonPattern;

import java.io.Serializable;

public class LazySingletonClass extends SuperClass implements Serializable{
	
	private static volatile LazySingletonClass lazySingletonClass;//using volatile keyword guranteed every thread will read it from main memory and not for cache
	
	private LazySingletonClass() {
		if(lazySingletonClass != null) {
			throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
		}
	}
	
	//Lazy initialization:
	public static LazySingletonClass getInstance() {
		if(lazySingletonClass == null) {
			synchronized (LazySingletonClass.class) {
				if(lazySingletonClass == null) lazySingletonClass = new LazySingletonClass();
			}
			
		}
		return lazySingletonClass;
	}
	
	protected Object readResolve() {
		return lazySingletonClass;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return lazySingletonClass;
	}
	/*
	 * Eager inintailization has a drawback. 
	 * it will create object if there is not required. It may be produce memory leak
	 * so we used lazy initailization*/

}
