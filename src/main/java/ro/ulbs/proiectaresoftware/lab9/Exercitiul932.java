package ro.ulbs.proiectaresoftware.lab9;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Exercitiul932 {
    public static void main(String[] args) {
        String text = " Acesta este un program scris in java pentru expresii lambda ";

        List<String> cuvinte = Arrays.asList(text.trim().split("\\s+"));
        System.out.println("toate cuvintele: " + cuvinte);

        List<String> lungi = cuvinte.stream()
                .filter(c -> c.length() >= 5)
                .collect(Collectors.toList());
        System.out.println("am gasit " + lungi.size() + " cuvinte lungi");
        System.out.println("astea sunt: " + lungi);

        List<String> ordonate = lungi.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("in ordine alfabetica: " + ordonate);

        String incepeCuP = cuvinte.stream()
                .filter(c -> c.startsWith("p"))
                .findFirst()
                .orElse("nu am gasit");
        System.out.println("un cuvant cu p: " + incepeCuP);
    }
}