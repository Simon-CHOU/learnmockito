package vogella.learnmock;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

//@RunWith(MockitoJUnitRunner.class)
public class MockitoTest {

    @Mock
    MyDatabase databaseMock;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Test
    public void testQuery()  {
        ClassToTest t  = new ClassToTest(databaseMock);
        boolean check = t.query("* from t");
        assertEquals(false, check);
        verify(databaseMock).query("* from t");
    }
}
