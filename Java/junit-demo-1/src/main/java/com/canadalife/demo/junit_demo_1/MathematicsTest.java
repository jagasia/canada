package com.canadalife.demo.junit_demo_1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class MathematicsTest {
	Mathematics maths;

	@BeforeEach
	void setup() {
		maths = new Mathematics();
		maths.setNo1(2);
		maths.setNo2(3);
	}

	@Test
	void addTest() {
		maths.add();
		assertEquals(5, maths.getResult());
	}

	@Test
	void multiplyTest() {
		maths.multiply();
		assertEquals(6, maths.getResult());
	}
}