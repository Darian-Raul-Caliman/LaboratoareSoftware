package ro.ulbs.proiectaresoftware.lab1;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String alfabet = "";
        ArrayList<String> listaGrupuri = new ArrayList<String>();
        String vocale = "aeiou";

        for(char c = 'a' ; c <= 'z' ; c++){
            alfabet = alfabet + c;
        }

        System.out.println(alfabet.toLowerCase());
        System.out.println(alfabet.toUpperCase());


        alfabet = alfabet.toLowerCase();

        String grupCurent = "";

        for(int i = 0; i < alfabet.length(); i++){

            grupCurent = grupCurent + alfabet.substring(i, i+1);
            if (i < alfabet.length() - 1) {

                if (vocale.contains(alfabet.substring(i+1, i+2))) {
                    listaGrupuri.add(grupCurent);
                    grupCurent = "";
                }
            }
        }

        listaGrupuri.add(grupCurent);
        System.out.println(listaGrupuri);
    }
}