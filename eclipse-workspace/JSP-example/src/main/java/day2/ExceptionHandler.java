package day2;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class ExceptionHandler {

	List<Method> list = new ArrayList<>();
	
	public void addObject(Method method) {
		list.add(method);
	}
	
	public void removeObject(Method method) {
		list.remove(method);
	}
	
}
