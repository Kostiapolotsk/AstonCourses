import org.testng.Assert;
import org.testng.annotations.Test;
import school.lesson12.Factorial;

public class FactorialTestNG {
    @Test
    public void testFactorialZero() {
        Assert.assertEquals(Factorial.factorial(0), 1);
    }

    @Test
    public void testFactorialPositive() {
        Assert.assertEquals(Factorial.factorial(5), 120);
    }

    @Test
    public void testFactorialLargeNumber() {
        Assert.assertEquals(Factorial.factorial(10), 3628800);
    }

}
