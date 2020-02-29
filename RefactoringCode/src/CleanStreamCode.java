import static java.lang.System.*;
import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class CleanStreamCode {
    public static void main(String[] args) {
        int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<String> names = listOfMemberNames();
        out.println(calculSumOfArray(values));
        out.println(calculMaxOfArray(values));
        out.println(calculMinOfArray(values));
        out.println(calculMoyenneOfArray(values));
        out.println(usingReduceMethodWithStream(values));
        out.println(referencedMethodWithStream(names));
        out.println(calculWordsInArray(names));
        out.println(separateListValuesWithCustomerPattern(names));
        out.println(findFirstNameStartWithCharacter(names));
        out.println(findAnyNameStartWithCharacter(names));
        //parallelStreamToIntegerArray();
        flatIntegerArrays();
        out.println(flatStringTwaDimensionArrays());


    }

    private static List<String> listOfMemberNames() {
        List<String> names = new ArrayList<>();
        names.add("OCJA");
        names.add("Stream");
        names.add("Java");
        names.add("Spring");
        names.add("Aymen");
        return names;


    }

    private static int calculSumOfArray(int[] values) {
        return Arrays.stream(values).sum();
    }

    private static int calculMaxOfArray(int[] values) {
        return Arrays.stream(values).max().getAsInt();
    }

    private static int calculMinOfArray(int[] values) {
        return Arrays.stream(values).min().getAsInt();
    }

    private static double calculMoyenneOfArray(int[] values) {
        return Arrays.stream(values).average().getAsDouble();
    }

    private static int usingReduceMethodWithStream(int[] values) {
        return Arrays.stream(values).reduce(0, (subtotal, element) -> subtotal + element);
    }

    private static List<String> referencedMethodWithStream(List<String> memberNames) {
        return memberNames.stream().filter(name -> name.startsWith("S")).map(String::toUpperCase).collect(toList());
    }

    private static long calculWordsInArray(List<String> values) {
        return values.stream().filter(s -> s.startsWith("S")).count();
    }

    private static String separateListValuesWithCustomerPattern(List<String> values) {
        return values.stream().reduce((s1, s2) -> s1 + "#" + s2).get();
    }

    private static String findFirstNameStartWithCharacter(List<String> names) {
        return names.stream().filter(s -> s.startsWith("S")).findFirst().get();
    }

    private static String findAnyNameStartWithCharacter(List<String> names) {
        return names.stream().filter(s -> s.startsWith("S")).findAny().get();
    }

    private static void parallelStreamToIntegerArray() {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i < 10; i++) {
            list.add(i);
        }
        Stream<Integer> stream = list.parallelStream();
        Integer[] evenNumbersArr = stream.filter(i -> i % 2 == 0).toArray(Integer[]::new);
        out.println(evenNumbersArr.toString());
    }

    private static void flatIntegerArrays() {
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(4, 5, 6);
        List<Integer> list3 = Arrays.asList(7, 8, 9);

        List<List<Integer>> listOfLists = Arrays.asList(list1, list2, list3);

        List<Integer> listOfAllIntegers = listOfLists.stream()
                .flatMap(x -> x.stream())
                .collect(toList());

        System.out.println(listOfAllIntegers);
    }

    private static Set<String> flatStringTwaDimensionArrays() {
        String[][] values = {{"a", "b","e"}, {"c", "d","b"}, {"e", "f"}};
        Set<String> characterValues = Arrays.stream(values).flatMap(x -> Arrays.stream(x)).collect(toSet());
        return characterValues;
    }
}
