package RESTAndJunit;

import RESTAndJunit.Extentions.LifeCycleLogExtension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(LifeCycleLogExtension.class)
class EazyApplicationTest {
    @Test
    void sample_test(){
        System.out.println("Hello there!");
        Assertions.assertTrue(true);
    }
}