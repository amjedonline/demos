package com.faktor73.guava.table;

public class Demo {
    public static void main(String[] args) {
        System.out.println(ErrorMessagesMapper.getError("Customer",
                "log.invalid.credentials"));
        System.out.println(ErrorMessagesMapper
                .getError("Payment", "cc.expired"));
        System.out.println(ErrorMessagesMapper.getError("Payment",
                "cc.invalid.number"));
        System.out.println(ErrorMessagesMapper.getError("Return",
                "cc.invalid.number"));
        System.out.println(ErrorMessagesMapper.getError("Customer",
                "cc.invalid"));
        System.out.println(ErrorMessagesMapper.getError("Return",
                "nothing.toreturn"));
    }
}
