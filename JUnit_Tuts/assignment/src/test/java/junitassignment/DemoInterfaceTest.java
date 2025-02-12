package junitassignment;

//import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;

class DemoInterfaceTest {

	@Test
	void testXyz() {
		DemoInterface di = mock(DemoInterface.class);
		di.xyz();
		di.xyz();
		di.xyz();
		verify(di, times(3)).xyz();
	}

}
