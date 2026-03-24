package ro.ulbs.proiectaresoftware.lab3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import static java.lang.System.in;


public class Main {
    public static void main(String[] args) throws IOException {
        String fileName = "C:\\Users\\raulc\\IdeaProjects\\LaboratoareSoftware\\src\\main\\java\\ro\\ulbs\\proiectaresoftware\\lab3\\text.txt";
        Path path = Paths.get(fileName);
        List<String> text = citireFisier(path);
        modificari(text);



    }

    public static void modificari(List<String> ListaNoua) {

        for (int i = 0; i < ListaNoua.size(); i++) {
            String liniaCurenta = ListaNoua.get(i);
            ListaNoua.set(i, liniaCurenta + "\n");
        }
        System.out.println("Textul rezultat:");
        for (String linie : ListaNoua) {
            System.out.print(linie);
        }
    }

    public static List<String> citireFisier(Path path) {
        List<String> lines = new ArrayList<>();

        try {

            lines = Files.readAllLines(path);
        } catch (IOException e) {
            System.out.println("Eroare la citire: " + e.getMessage());
        }


        return lines;
    }
}