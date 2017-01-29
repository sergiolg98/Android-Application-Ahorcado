package com.example.sergio.ahorcado;

/**
 * Created by sergio on 26/01/17.
 */

import java.util.*;
public class Grilla {

    //Atributos
    public char[] letras; //un array de char que contiene la palabra con la que jugamos y va quitando las letras que el usuario
                          //de manera que no hay repeticiones
    public char[] adivina; //Un array de char que se llena de ceros y se va actualizando conforme el usuario adivina
    public String palabra; //La palabra que recibimos y con la que jugaremos
    public int intentos = 7; //Cabeza - Cuerpo - Brazos (x2) - Piernas (x2) - Cuerda


    //Constructor principal
    public Grilla(String n){
        palabra = n;
        llenarGrilla();
        creaEspacios();
    }

    public String getPalabra(){
        return palabra;
    }

    public int getNumIntentos(){
        return intentos;
    }

    public String getIntentos(){
        return intentos + "";
    }

    //Método privado para llenar la palabra
    private void llenarGrilla(){
        letras = new char[palabra.length()];
        for(int i = 0; i < palabra.length(); i++){
            letras[i] = palabra.charAt(i);
        }
    }

    //Método para crear espacios para palabra
    private void creaEspacios(){
        adivina = new char[palabra.length()];
        for(int i = 0; i < adivina.length; i++){
            adivina[i] = '0'; //Arranca en ceros iniciales que el usuario no verá jamás
        }
    }


    public ArrayList<Integer> devuelvePosiciones(char c){

        ArrayList<Integer> indices = new ArrayList<Integer>();
        int index = -1; //Arrancamos en -1 para el caso que no lo encuentre

        for(int i = 0; i < letras.length; i++){
            if(letras[i] == c){
                index = i;
                indices.add(i);
            }
        }
        if(index == -1){
            indices.add(-1);
        }
        return indices;
    }

    //Modifica la grilla adivinar
    public void modificaGrilla(ArrayList<Integer> indices){

        //Primera condición para que funcione todo
        if(!indices.contains(-1)){
            int posicion;

            for(int i = 0; i < indices.size(); i++){
                posicion = indices.get(i);
                adivina[posicion] = letras[posicion];
                letras[posicion] = '0'; //Esto para que el usuario si intenta repetir algo, no pueda, pues esa letra ya no existirá

            }
        }
        else{
            intentos--; //Si el usuario no atina, se le disminuira un intento
        }


    }
    public boolean yaGano(){

        for(int i = 0; i < adivina.length; i++){
            if(adivina[i] == '0') {
                return false;
            }
        }
        return true;

    }
}