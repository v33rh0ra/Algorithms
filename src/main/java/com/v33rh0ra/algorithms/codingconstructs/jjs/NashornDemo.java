package com.v33rh0ra.algorithms.codingconstructs.jjs;
import java.io.*;
import java.nio.file.Paths;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class NashornDemo {



    public static void main(String[] args) throws Throwable {
        ScriptEngineManager engineManager = new ScriptEngineManager();
        ScriptEngine engine = engineManager.getEngineByName("nashorn");
        String filesDir = Paths.get(".").toRealPath()+"/src/main/java/com/v33rh0ra/algorithms/codingconstructs/jjs";

        engine.eval("function p(s) { print(s) }");
        engine.eval("p('Hello Nashorn');");
        engine.eval(new FileReader(filesDir+"/hello.js"));
        engine.eval(new FileReader(filesDir+"/sum2.js"));
        engine.eval(new FileReader(filesDir+"/imports.js"));

        Invocable inv = (Invocable) engine;
        inv.invokeFunction("p", "hello");
        JPrinter printer = inv.getInterface(JPrinter.class);
        printer.p("Hello again!");

    }
    public static interface JPrinter {
        void p(String s);
    }

}
