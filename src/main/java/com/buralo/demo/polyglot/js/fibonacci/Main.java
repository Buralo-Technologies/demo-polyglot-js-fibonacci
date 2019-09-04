package com.buralo.demo.polyglot.js.fibonacci;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Source;
import org.graalvm.polyglot.Value;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            Source source = Source.newBuilder("js", Main.class.getResource("fibonacci.js")).build();
            try (Context context = Context.create()) {
                Value value = context.eval(source);
                for (String arg : args) {
                    System.out.printf("fibonacci(%s) = %s\n", arg, value.execute(Integer.valueOf(arg)));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
