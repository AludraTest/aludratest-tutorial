/**
 * Copyright (C) 2010-2014 Hamburg Sud. All rights reserved.
 */


import org.aludratest.junit.AludraTestJUnitSuite;
import org.junit.runner.RunWith;

/**
 * Hook class to execute tests with Eclipse's JUnit runner. Create a JUnit Run Configuration and reference this as the test class.
 * Then, as a program parameter, add
 * 
 * <pre>
 * -Dsuite=${java_type_name}
 * </pre>
 * 
 * This will execute the currently open test class in Eclipse when running the Run Configuration. <br>
 * See <a href="http://aludratest.github.io/aludratest/run-a-test.html">http://aludratest.github.io/aludratest/run-a-test.html
 * (section "Run a test in Eclipse")</a> for details.
 * 
 */
@RunWith(AludraTestJUnitSuite.class)
public class AludraJUnitTest extends org.aludratest.testcase.AludraTestCase {
	
}
