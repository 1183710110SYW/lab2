package number;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import number.*;

class numberTest {

	@Test
	void testNumber() {
		createNumber testNumber = new createNumber();
		assert(testNumber.getNumberOne() >= 0);
		assert(testNumber.getNumberOne() <= 100);
		assert(testNumber.getNumberTwo() >= 0);
		assert(testNumber.getNumberTwo() <= 100);
				
	}
	@Test
	void testRange() {
		createNumber testNumber = new createNumber();
		if(testNumber.getFlag() % 2 == 1) { // 减法
			assert(testNumber.getNumberOne() - testNumber.getNumberTwo() > 0);
			assert(testNumber.getNumberOne() - testNumber.getNumberTwo() < 100);
		}
		if(testNumber.getFlag() % 2 == 0) { // 加法
			assert(testNumber.getNumberOne() + testNumber.getNumberTwo() > 0);
			assert(testNumber.getNumberOne() + testNumber.getNumberTwo() < 100);
		}
	}
	@Test
	void testAnswer() {
		createNumber testNumber = new createNumber();
		if(testNumber.getFlag() % 2 == 1) { // 减法
			assert(testNumber.getNumberOne() - testNumber.getNumberTwo() == testNumber.getAnswer());
			
		}
		if(testNumber.getFlag() % 2 == 0) { // 加法
			assert(testNumber.getNumberOne() + testNumber.getNumberTwo() == testNumber.getAnswer());
		}
	}
}
