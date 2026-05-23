package ro.ulbs.proiectaresoftware.lab9;

import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Exercitiul931 {
    public static void main(String[] args) {
        Random random = new Random();

        List<Integer> numere = IntStream.range(0, 10)
                .map(i -> 5 + random.nextInt(21))
                .boxed()
                .collect(Collectors.toList());

        System.out.println("numere la intamplare: " + numere);

        int suma = numere.stream().mapToInt(Integer::intValue).sum();
        System.out.println("suma lor e: " + suma);

        int max = numere.stream().max(Comparator.naturalOrder()).orElse(0);
        int min = numere.stream().min(Comparator.naturalOrder()).orElse(0);
        System.out.println("cel mai mare: " + max);
        System.out.println("cel mai mic: " + min);

        List<Integer> filtrate = numere.stream()
                .filter(n -> n >= 10 && n <= 20)
                .collect(Collectors.toList());
        System.out.println("doar alea intre 10 si 20: " + filtrate);

        List<Double> doubleList = numere.stream()
                .map(Integer::doubleValue)
                .collect(Collectors.toList());
        System.out.println("lista cu virgula: " + doubleList);

        boolean are12 = numere.stream().anyMatch(n -> n == 12);
        System.out.println("are 12 in ea: " + are12);
    }
}