package org.aludratest.tutorial.ikea;

import org.aludratest.testcase.Suite;
import org.aludratest.tutorial.ikea.testcase.IkeaSearchTest;

/**
 * The main test suite. It must be empty and define all contained test classes in its @Suite annotation. This class is referenced
 * in the pom.xml as the test suite to be executed.
 * 
 * @author falbrech
 * 
 */
@Suite({ IkeaSearchTest.class })
public class IkeaTestSuite {

}
