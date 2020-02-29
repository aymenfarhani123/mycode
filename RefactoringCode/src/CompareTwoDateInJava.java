import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CompareTwoDateInJava {
    public static void main(String[] args) throws ParseException {
        List<Date> dates=new ArrayList<>();
        SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
        Date d1 = sdformat.parse("2019-04-15");
        Date d2 = sdformat.parse("2019-08-10");
        dates.add(d1);
        dates.add(d2);
        Comparator<Date> dateComparator=(d,dd)->d.compareTo(dd)>0?1:d.compareTo(dd)<0?-1:0;
        Collections.sort(dates,dateComparator);
        System.out.println(dates);
    }
}
