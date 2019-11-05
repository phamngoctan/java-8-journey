package com.tanpham.java8.journey.exceptionhandling;

import java.util.function.Consumer;

@FunctionalInterface
public interface HandlingConsumer<Target, ExObj extends Exception> {
    void accept(Target target) throws ExObj;
    
    //in case you forgot, you can write static methods inside interfaces since Java 8
    static <Target> Consumer<Target> handlingConsumerBuilder(
            HandlingConsumer<Target, Exception> handlingConsumer) {
        return obj -> {
            try {
                handlingConsumer.accept(obj);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        };
    }
}