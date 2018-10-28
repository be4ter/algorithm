import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.lang.Math.max;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumTest {
	private static final Logger log = LoggerFactory.getLogger(SumTest.class);
	final int[] test = {-7, 4, -3, 6, 3, -8, 3, 4};

	@Test
	public void solution1() {
		Long start = System.nanoTime();
		log.error("시작 시간 : " + start);
		int actualValue1 = inefficientMaxSum1(test);
		assertEquals(10, actualValue1);
		Long end = System.nanoTime();
		log.error("종료 시간 : " + end);
		log.error("걸린 시간 : " + (end - start));
	}

	@Test
	public void solution2() {
		Long start = System.nanoTime();
		log.error("시작 시간 : " + start);
		int actualValue2 = inefficientMaxSum2(test);
		assertEquals(10, actualValue2);
		Long end = System.nanoTime();
		log.error("종료 시간 : " + end);
		log.error("걸린 시간 : " + (end - start));
	}

	@Test
	public void solution3() {
		Long start = System.nanoTime();
		log.error("시작 시간 : " + start);
		int actualValue3 = inefficientMaxSum3(test);
		assertEquals(10, actualValue3);
		Long end = System.nanoTime();
		log.error("종료 시간 : " + end);
		log.error("걸린 시간 : " + (end - start));
	}

	@Test
	public void solution4() {
		Long start = System.nanoTime();
		log.error("시작 시간 : " + start);
		int actualValue4 = inefficientMaxSum4(test);
		assertEquals(10, actualValue4);
		Long end = System.nanoTime();
		log.error("종료 시간 : " + end);
		log.error("걸린 시간 : " + (end - start));
	}

	// O(N 세제곱)
	private int inefficientMaxSum1(int[] test) {
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

	// 0(N 제곱)
	private int inefficientMaxSum2(int[] test) {
		int N = test.length, ret = 0;
		for (int i = 0; i < N; ++i) {
			int sum = 0;
			for (int j = i; j < N; ++j) {
				sum += test[j];
				ret = max(ret, sum);
			}
		}
		return ret;
	}

	// O(NlogN)
	private int inefficientMaxSum3(int[] test) {
		int N = test.length, ret = 0;
		for (int i = 0; i < N; ++i) {
			ret = fastMaxSum(test, 0, N - 1);
		}
		return ret;
	}

	// O(N)
	private int inefficientMaxSum4(int[] test) {
		int N = test.length, ret = 0, psum = 0;
		for (int i = 0; i < N; ++i) {
			psum = max(psum, 0) + test[i];
			ret = max(psum, ret);
		}
		return ret;
	}


	private int fastMaxSum(int[] arrays, int low, int high) {
		if (low == high) {
			return arrays[low];
		}
		int mid = ((low + high) / 2);
		int left = 0, right = 0, sum = 0;
		for (int i = mid; i >= low; --i) {
			sum += arrays[i];
			left = max(left, sum);
		}
		for (int i = mid + 1; i <= high; ++i) {
			sum += arrays[i];
			right = max(right, sum);
		}
		int single = max(fastMaxSum(test, low, mid), fastMaxSum(test, mid + 1, high));
		return max(left + right, single);
	}


}
