import static java.lang.System.*;
import static java.util.stream.Collectors.*;

import java.util.*;
import java.util.stream.Collectors;

public class CleanUpCodeUsingLambdaAndStreams {

    public static void main(String[] args) {
        List<String> names=getListStrings();
        List<String> reorderAlphabetiqueNames=compareAndReorderListValues(names);
        out.println(reorderAlphabetiqueNames);
        List<String> filteredNames=getNameContainsCharacterA(reorderAlphabetiqueNames);
        out.println(filteredNames);
    }

    //get names array list
    public static List<String> getListStrings(){
        List<String> names=new ArrayList<>();
        names.add("Aymen");
        names.add("Spring");
        names.add("Java");
        names.add("OCJA");
        return names;
    }
    //Reorder alphabétique names
    public static List<String> compareAndReorderListValues(List<String> names){
        Comparator<String> comparatorWithNames=(name1,name2)->name1.compareTo(name2)>0?1:name1.compareTo(name2)<0?-1:0;
        Collections.sort(names, comparatorWithNames);
        return names;
    }
    //Filtered names
    public static List<String> getNameContainsCharacterA(List<String> names){
       return names.stream().filter(name->name.contains("A")).collect(toList());
    }

    //refactor lambda expression
    public Set<String> refactoringLambdaExpression(List<String> orders){
        return orders.stream().filter(s -> s.length()>4)
                .collect(toList()).stream()
                .filter(s->!s.isEmpty())
                .map(s->s.toUpperCase())
                .collect(toSet());
    }
}
