package RESTAndJunit.Extentions;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestInstancePreDestroyCallback;
import org.junit.jupiter.api.extension.TestInstances;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class DisplayPreDestroyedInstances implements TestInstancePreDestroyCallback {

    @Override
    public void preDestroyTestInstance(ExtensionContext ctx) throws Exception {

        List<Object> destroyedInstances =
                new ArrayList<>(ctx.getRequiredTestInstances().getAllInstances());
        for (Optional<ExtensionContext> current = ctx.getParent();
             current.isPresent();
             current = current.get().getParent()) {
            current.get().getTestInstances()
                    .map(TestInstances::getAllInstances)
                    .ifPresent(destroyedInstances::removeAll);
        }
        Collections.reverse(destroyedInstances);
        destroyedInstances.forEach(testInstance ->
                System.out.println("preDestroy: " + testInstance));
    }
}