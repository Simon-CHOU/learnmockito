package vogella.learnmock.basic;

import org.junit.Test;

import java.util.Properties;

import static junit.framework.TestCase.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestE {
    @Test
    public void q(){
        Properties properties = mock(Properties.class);

        when(properties.get("Anddroid")).thenThrow(new IllegalArgumentException());

        try {
            properties.get("Anddroid");
            fail("Anddroid is misspelled");
        } catch (IllegalArgumentException ex) {
            // good!
        }
    }
}
