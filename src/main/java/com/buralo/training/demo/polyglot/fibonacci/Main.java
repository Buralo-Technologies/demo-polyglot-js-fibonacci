package com.buralo.training.demo.polyglot.fibonacci;

import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Source;
import org.graalvm.polyglot.Value;
import org.graalvm.polyglot.management.ExecutionListener;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try {
            runScript("js", "/fibonacci.js");
            runScript("python", "/fibonacci.py");
            //runScript("ruby", "/fibonacci.rb");
            runScript("R", "/fibonacci.R");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void runScript(final String language, final String script) throws IOException {
        final Source source = Source.newBuilder(language, Main.class.getResource(script)).build();
        try (Context context = Context.newBuilder().allowAllAccess(true).build()) {
            context.eval(source);
            final Value fn = context.getBindings(language).getMember("fibonacci");
            System.out.printf("%s.fibonacci(10)=%d\n", language, fn.execute(10).asInt());
        }
    }
}

