import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CleanUpCodeUsingLambdaAndStreamsTest {

    List<String> names=new ArrayList<>();

    @Before
    public void getListNames(){
        names.add("certification");
        names.add("test");
        names.add("JAVA");
        names.add("clean code");
    }

    @Test
    public void compareAndReorderListValuesTest() {
       List<String> expected= CleanUpCodeUsingLambdaAndStreams.compareAndReorderListValues(names);
        Assert.assertArrayEquals(expected.toArray(),names.toArray());
    }

    @Test
    public void getNameContainsCharacterATest() {
        List<String> filteredNames=CleanUpCodeUsingLambdaAndStreams.getNameContainsCharacterA(names);
        Assert.assertEquals(1,filteredNames.size());
    }
}