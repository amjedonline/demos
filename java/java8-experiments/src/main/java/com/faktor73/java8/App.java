package com.faktor73.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        csv();
    }

    public static void csv() {
        String cartId = "second"; 
        List<String> cartItemIds = new ArrayList<String>();
        cartItemIds.add("item_uuid1");
        cartItemIds.add("pqr");
        cartItemIds.add("item_uuid_99");
        // String csv = cartItemIds
        // .stream()
        // .map(s -> "'" + s + "'")
        // .reduce("", (a, b) -> a != null ? a + "," + b : b,
        // (a, b) -> a != null ? a + "," + b : b);
//        String csv = cartItemIds.stream().map(s -> "'" + s + "'")
//                .reduce((a, b) -> a + ", " + b).get();
        
        final String cql = "select * from cart_items where cart_id='%s' and cart_item_id in (%s)";
        final String cartItemIdsCsv = StreamSupport.stream(cartItemIds.spliterator(), true)
                .map(s -> "'" + s + "'").reduce((a, b) -> a + ", " + b).get();

        final String cqlFilled = String.format(cql, cartId, cartItemIdsCsv);

        System.out.println(cqlFilled);
    }

    public List<Integer> getLengths(final List<String> strings) {
        return strings.stream().map(s -> s.length())
                .collect(Collectors.toCollection(new Supplier<List<Integer>>() {
                    @Override
                    public List<Integer> get() {
                        return new ArrayList<Integer>();
                    }
                }));
    }
}
