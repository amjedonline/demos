package com.faktor73.guava.table;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public class ErrorMessagesMapper {

    private static Table<String, String, String> errors = HashBasedTable
            .create();

    static {
        errors.put("Customer", "log.invalid.credentials",
                "Username/Email is invalid.");
        errors.put("Payment", "cc.invalid.number",
                "Invalid credit card number.");
        errors.put("Payment", "cc.expired", "This is an expired Credit card.");
    }

    public static String getError(String topic, String userCase) {
        return errors.get(topic, userCase);
    }
}
