package org.example.multithreading.longeststr;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestStringFinderTest {

    private String[] strings;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testFindLongestString_General() {
        final String expectedResult = "qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq";
        strings = new String[] {
                "",
                "cewfwedwedwe",
                expectedResult,
                "rfrefref",
                ""
        };
        LongestStringFinder finder = new LongestStringFinder(strings);
        String result = finder.findLongestString();
        assertEquals(expectedResult, result);
    }

    @Test
    void testFindLongestString_containsNull() {
        final String expectedResult = "qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq";
        strings = new String[] {
                "",
                "cewfwedwedwe",
                expectedResult,
                null,
                ""
        };
        LongestStringFinder finder = new LongestStringFinder(strings);
        String result = finder.findLongestString();
        assertEquals(expectedResult, result);
    }

    @Test
    void testFindLongestString_arrayIsNull() {
        final String expectedMessage = "Array is null";
        strings = null;
        var expected = IllegalArgumentException.class;
        IllegalArgumentException exception = assertThrows(expected, () -> new LongestStringFinder(strings));
        assertEquals(expected, exception.getClass());
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void testFindLongestString_DoubleFinding() {
        final String expectedResult = "qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq";
        strings = new String[] {
                "",
                "cewfwedwedwe",
                expectedResult,
                expectedResult,
                "rfrefref",
                ""
        };
        LongestStringFinder finder = new LongestStringFinder(strings);
        String result = finder.findLongestString();
        assertEquals(expectedResult, result);

        result = finder.findLongestString();
        assertEquals(expectedResult, result);
    }

}