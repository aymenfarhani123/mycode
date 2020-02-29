package cleanCode;
import static java.lang.System.*;
import static java.util.stream.Collectors.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaAndStreamCleanUp {
	
	public static void main(String[] args) {
		List<String> names=listOfNames();
		List<String> orderedNames=reordonnerListOfString(names);
		out.println(orderedNames);
		List<String> filteredNames=filteredListNames(orderedNames);
		out.println(filteredNames);
		}
	
	private static List<String> listOfNames(){
		List<String> names=new ArrayList<String>();
		names.add("Spring");
		names.add("Java");
		names.add("OCJA");
		names.add("Certification");
		names.add("Lambda");
		return names;
	}
	
	private static List<String> reordonnerListOfString(List<String> inputList){
		Comparator<String> c=(s1,s2)->s1.compareTo(s2)>0?1:s1.compareTo(s2)<0?-1:0;
		Collections.sort(inputList, c);
		return inputList;
	}
	
	private static List<String> filteredListNames(List<String> values){
		return values.stream().filter(name->name.toLowerCase().startsWith("s")).collect(toList());
	}

}
