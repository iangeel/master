import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory(InitializingTests.class)
@Suite.SuiteClasses(SpaceshipTest.class)
public class InitializingTestsSuite {
}
