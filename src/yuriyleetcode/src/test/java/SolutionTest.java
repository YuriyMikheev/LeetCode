import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @Test
    public void RomanToIntTest(){

        System.out.println(Solution.romanToInt("MCMXCIV"));
        assertTrue(Solution.romanToInt("MCMXCIV") == 1994);

    }

}