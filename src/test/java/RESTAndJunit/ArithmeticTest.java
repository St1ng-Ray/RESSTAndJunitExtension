package RESTAndJunit;

import RESTAndJunit.Extentions.DisplayPreDestroyedInstances;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Iterator;

import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class ArithmeticTest {
    private int result = 5;

    @ExtendWith(DisplayPreDestroyedInstances.class)
    @Test
    void test_Multiply() {


        result = Calculate.multiple(result, 5);
        System.out.println("test_Multiply(5,5) => "+ result);
        Assertions.assertEquals(25, result);

    }

    @TestFactory
    Iterator<DynamicTest> positiveAssertions(){
        return Arrays.asList(
                dynamicTest("Niganese!",
                        ()->Assertions.assertTrue(1 > 0))
        ).iterator();
    }
}