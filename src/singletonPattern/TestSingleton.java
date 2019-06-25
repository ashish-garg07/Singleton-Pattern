package singletonPattern;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class TestSingleton {

	public static void main(String[] args) {
		//create an refernce and get object by getInstance method
//		LazySingletonClass lazySingletonClass1 = LazySingletonClass.getInstance();
//		LazySingletonClass lazySingletonClass2 = LazySingletonClass.getInstance();
//		
//		System.out.println(lazySingletonClass1.hashCode());
//		System.out.println(lazySingletonClass2.hashCode());
		
		
		//its show java reflection issue with singleton pattern
		
//		LazySingletonClass lazySingletonClass = LazySingletonClass.getInstance();
//		
//		LazySingletonClass lazySingletonClass2 = null;
//		
//		try {
//			
//			Class<LazySingletonClass> clazz = LazySingletonClass.class;
//			Constructor<LazySingletonClass> cons = clazz.getDeclaredConstructor();
//			cons.setAccessible(true);
//			lazySingletonClass2 = cons.newInstance();
//		}catch(NoSuchMethodException | InvocationTargetException | IllegalAccessException | InstantiationException e) {
//			e.printStackTrace();
//		}
//		
//		System.out.println(lazySingletonClass.hashCode());
//		System.out.println(lazySingletonClass2.hashCode());
		
		//If multiple thread try to access object then singleton pattern will be break
		
		//thread 1
//		Thread thread1 = new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				
//				LazySingletonClass lazySingletonClass = LazySingletonClass.getInstance();
//				System.out.println("Hash Code for lazySingletonClass: "+lazySingletonClass.hashCode());
//			}
//		});
//
//		//Thread 2
//		
//		Thread thread2 = new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				
//				LazySingletonClass lazySingletonClass2 = LazySingletonClass.getInstance();
//				System.out.println("Hash code for lazySingletonClass2: "+lazySingletonClass2.hashCode());
//			}
//		});
//		
//		thread1.start();
//		thread2.start();
		
		//singleton class maintain in serilazation of class or not
//		try {
//		LazySingletonClass lazySingletonClass = LazySingletonClass.getInstance();
//		//Serialize an object
//		ObjectOutput out = null;
//		
//		out = new ObjectOutputStream(new FileOutputStream("filename.ser"));
//		out.writeObject(lazySingletonClass);
//		out.close();
//		
//		//Deserialize an object from file to object
//		
//		ObjectInput in = new ObjectInputStream(new FileInputStream("filename.ser"));
//		LazySingletonClass instance2 = (LazySingletonClass)in.readObject();
//		
//		in.close();
//		
//		System.out.println("Hashcode for lazySingletonClass: "+lazySingletonClass.hashCode());
//		
//		System.out.println("Hashcode for instance2: "+instance2.hashCode());
//		
//		}catch(IOException | ClassNotFoundException e) {
//			e.printStackTrace();
//		}
		
		//break singlton pattern by clone 
		
		try {
			LazySingletonClass instance = LazySingletonClass.getInstance();
			LazySingletonClass instance2 = (LazySingletonClass) instance.clone();
			
			System.out.println("instance hash code: "+instance.hashCode());
			System.out.println("instance2 hash code: "+instance2.hashCode());
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
