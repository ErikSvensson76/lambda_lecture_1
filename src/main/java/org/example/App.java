package org.example;

import org.example.interfaces.Action;
import org.example.interfaces.SingleStringOperator;
import org.example.interfaces.StringOperation;
import org.example.interfaces.StringTester;
import org.example.model.StringCombiner;

import java.util.*;

/*
    1. Understand Functional Interfaces - Done
    2. Anonymous inner classes and Functional Interfaces (Legacy) - Done
    3. Lambda Expression
        - Relate to Functional Interfaces
        - Structure and syntax
        
 */
public class App {

    static StringOperation getLongestString = (s1, s2) -> s1.length() > s2.length() ? s1 : s2;

    static StringOperation concat = (str1, str2) -> str1.concat(" ").concat(str2);

    static Action print = string -> System.out.println(string);

    public static void main( String[] args ) {
        print.execute(doStringStuff("Yay", "Lambda Expression!", concat));
        System.out.println(doStringStuff("ABC", "DEFGHIJKL", getLongestString));

        StringTester isJava = name -> name.equalsIgnoreCase("Java");

        System.out.println(testString("C#", isJava));

        System.out.println(
                testString("Hello", str -> str.length() < 7)
        );

        List<String> words = Arrays.asList(
            "C#", "Java", "Javascript"
        );

        System.out.println(
                hideProfanity(words, word -> word.equals("Javascript"), s -> s.replaceAll(s, "**CENSORED**"))
        );


    }

    public static List<String> hideProfanity(List<String> source, StringTester stringTester, SingleStringOperator operator){
        List<String> strings = new ArrayList<>();
        for(String string : source){
            if(stringTester.testString(string)){
                strings.add(operator.operate(string));
            }else {
                strings.add(string);
            }
        }
        return strings;
    }

    public static boolean testString(String str, StringTester conditional){
        return conditional.testString(str);
    }

    public static String doStringStuff(String str1, String str2, StringOperation operation){
        return operation.operate(str1, str2);
    }

}
