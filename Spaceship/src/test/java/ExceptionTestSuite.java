import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory(ExceptionTests.class)
@Suite.SuiteClasses(SpaceshipTest.class)
public class ExceptionTestSuite {
}
