import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

public class DBConnection {
	
	@PostConstruct
	public List<Students> allstudents(){
		List<Students> list=new ArrayList<Students>();
		list.add(new Students(1,"Aymen1","Farhani1"));
		list.add(new Students(2,"Aymen2","Farhani2"));
		list.add(new Students(3,"Aymen3","Farhani3"));
		list.add(new Students(4,"Aymen4","Farhani4"));
		list.add(new Students(5,"Aymen5","Farhani5"));
		list.add(new Students(6,"Pierre","Luis"));
		list.add(new Students(7,"Aymen7","Farhani7"));
		list.add(new Students(8,"Aymen8","Farhani8"));
		list.add(new Students(9,"Aymen9","Farhani9"));
		list.add(new Students(10,"Aymen10","Farhani10"));
		list.add(new Students(11,"Aymen11","Farhani11"));
		list.add(new Students(12,"Aymen12","Farhani12"));
		return list;
		
	}

}
