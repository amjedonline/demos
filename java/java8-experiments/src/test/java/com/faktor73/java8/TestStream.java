package com.faktor73.java8;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestStream {

    @Test
    public void testAdd() {
        final App app = new App();
        final List<String> list = new ArrayList<String>();
        list.add("Amjed");
        list.add("Java");
        list.add("Zalando");
        final List<Integer> lengths = app.getLengths(list);

        final List<Integer> expected = new ArrayList<Integer>();
        expected.add(5);
        expected.add(4);
        expected.add(7);
        assertEquals(lengths, expected);
    }
}
