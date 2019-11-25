package com.buralo.training.demo.polyglot.fibonacci;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Source;
import org.graalvm.polyglot.Value;
import org.graalvm.polyglot.management.ExecutionListener;

import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Arrays.stream(args)
                .map(Integer::parseInt)
                .forEach(n -> {
                    runScript("js", "/fibonacci.js", n);
                    runScript("python", "/fibonacci.py", n);
                    //runScript("ruby", "/fibonacci.rb", n);
                    runScript("R", "/fibonacci.R", n);
                });
    }

    private static void runScript(final String language, final String script, final int n)  {
        try {
            final Source source = Source.newBuilder(language, Main.class.getResource(script)).build();
            try (Context context = Context.newBuilder().allowAllAccess(true).build()) {
                context.eval(source);
                final Value fn = context.getBindings(language).getMember("fibonacci");
                System.out.printf("%s.fibonacci(%d)=%d\n", language, n, fn.execute(n).asInt());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

