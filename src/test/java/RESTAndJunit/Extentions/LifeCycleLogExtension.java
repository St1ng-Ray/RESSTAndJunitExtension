package RESTAndJunit.Extentions;

import org.junit.jupiter.api.extension.*;

public class LifeCycleLogExtension implements TestInstancePostProcessor, ParameterResolver, BeforeAllCallback,
        BeforeEachCallback, BeforeTestExecutionCallback, AfterEachCallback, AfterTestExecutionCallback, AfterAllCallback,
        TestExecutionExceptionHandler {
    @Override
    public void postProcessTestInstance(Object testInstance, ExtensionContext context) {
        System.out.println("Test Instance Post-processing called");
    }

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
            throws ParameterResolutionException {
        System.out.println("Parameter Resolver Supports called");
        return parameterContext.getParameter().getType().equals(String.class);
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext)
            throws ParameterResolutionException {
        System.out.println("Resolver called");
        return "Hello World";
    }

    @Override
    public void beforeAll(ExtensionContext context) {
        System.out.println("Before All called " + context.getTestClass().get());
    }

    @Override
    public void beforeEach(ExtensionContext context) throws Exception {
        System.out.println("Before Each called");
    }

    @Override
    public void beforeTestExecution(ExtensionContext context) {
        System.out.println("Before Test Execution called");
    }

    @Override
    public void afterEach(ExtensionContext context) {
        System.out.println("After Each called");
    }

    @Override
    public void afterTestExecution(ExtensionContext context) {
        System.out.println("After Test Execution called");
    }

    @Override
    public void afterAll(ExtensionContext context) {
        System.out.println("After All called");
    }

    @Override
    public void handleTestExecutionException(ExtensionContext context, Throwable throwable) throws Throwable {
        System.out.println("Test Execution Exception called");
        throw throwable;
    }
}
