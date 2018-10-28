import org.junit.jupiter.api.Test;

import static java.lang.Math.max;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumTest {
	final int[] test = {-7, 4, -3, 6, 3, -8, 3, 4};

	@Test
	public void solution() {
		int actualValue = inefficientMaxSum(test);
		assertEquals(10, actualValue);
	}

	private int inefficientMaxSum(int[] test) {
		int N = test.length, ret = 0;
		for (int i = 0; i < N; ++i) {
			for (int j = i; j < N; ++j) {
				int sum = 0;
				for (int k = i; k < j; ++k) sum += test[k];

				ret = max(ret, sum);
			}
		}
		return ret;
	}

}
