package app;

import controlador.Controller;
import modelo.Modelo;
import vista.Ventana;

import javax.swing.*;
import java.util.ArrayList;

public class App {

    public static void main(String[] args) {

        Ventana v = new Ventana();
        Modelo m = new Modelo(v);
        Controller c = new Controller(v,m);

    }

}
