package utils;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class JsonReaderTest {

    @Test
    public void testReadJsonFile() {
        List<String> expected = Arrays.asList("A", "B", "C", "D", "E");
        Optional<List<String>> actual = JsonReader.readJsonFile("strings.json", obj -> obj.getString("value"));
        Assert.assertTrue(actual.isPresent());
        Assert.assertEquals(expected, actual.get());
    }
}
