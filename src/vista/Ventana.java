package vista;

import controlador.Controller;
import modelo.Territorio;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Ventana extends JFrame {

    private Panel panel = new Panel();
    private Controller controller;

    //JLabels

    private JLabel labelMoverOrigen = new JLabel("Origen:");
    private JLabel labelMoverDestino = new JLabel("Destino:");
    private JLabel labelMoverNumero = new JLabel("No. de Tropas");
    private JLabel labelAtacarOrigen = new JLabel("Origen:");
    private JLabel labelAtacarDestino = new JLabel("Destino:");
    private JLabel labelModuloAtaque = new JLabel("Modulo de Ataque");
    private JLabel labelModuloMover = new JLabel("Movimiento de Tropas");
    private JLabel labelEventos = new JLabel("Acciones:");

    //ComboBoxes

    private JComboBox<String> comboMoverOrigen = new JComboBox<String>();
    private JComboBox<String> comboMoverDestino = new JComboBox<String>();
    private JComboBox<Integer> comboMoverNumero = new JComboBox<Integer>();
    private JComboBox<String> comboAtacarOrigen = new JComboBox<String>();
    private JComboBox<String> comboAtacarDestino = new JComboBox<String>();

    //Botones

    private JButton botonMoverTropas = new JButton("Mover Tropas");
    private JButton botonAtacar = new JButton("Atacar!");
    private JButton botonTerminarTurno = new JButton("Terminar Turno");
    private JButton botonIniciarJuego = new JButton("Iniciar Juego");

    //Ventana de Eventos

    private JTextArea textoLogs = new JTextArea();
    private JScrollPane scrollPaneTexto = new JScrollPane(textoLogs);

    public Ventana(){

        this.setSize(1200,750);
        this.setTitle("Risk");
        this.initComponents();
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void initComponents() {

        this.add(panel);

        this.add(labelModuloMover);
        this.labelModuloMover.setBounds(50,525,200,30);

        this.add(labelMoverOrigen);
        this.labelMoverOrigen.setBounds(15,575,69,30);

        this.add(comboMoverOrigen);
        this.comboMoverOrigen.setBounds(100,575,150,30);

        this.add(labelMoverDestino);
        this.labelMoverDestino.setBounds(15,605,69,30);

        this.add(comboMoverDestino);
        this.comboMoverDestino.setBounds(100,605,150,30);

        this.add(labelMoverNumero);
        this.labelMoverNumero.setBounds(15,635,99,30);

        this.add(comboMoverNumero).setBounds(150,635,100,30);



        this.add(botonMoverTropas);
        this.botonMoverTropas.setBounds(40,680,150,30);

        this.add(labelModuloAtaque);
        this.labelModuloAtaque.setBounds(450,525,200,30);

        this.add(labelAtacarOrigen);
        this.labelAtacarOrigen.setBounds(415,575,69,30);

        this.add(labelAtacarDestino);
        this.labelAtacarDestino.setBounds(415,605,69,30);

        this.add(comboAtacarOrigen);
        this.comboAtacarOrigen.setBounds(485,575,150,30);

        this.add(comboAtacarDestino);
        this.comboAtacarDestino.setBounds(485,605,150,30);

        this.add(botonAtacar);
        this.botonAtacar.setBounds(440,680,150,30);

        this.add(labelEventos);
        this.labelEventos.setBounds(875,15,100,30);

        this.add(scrollPaneTexto);
        this.textoLogs.setEditable(false);
        this.scrollPaneTexto.setBounds(875,50,275,400);

        this.add(botonTerminarTurno);
        this.botonTerminarTurno.setBounds(675,635,150,75);

        this.add(botonIniciarJuego);
        this.botonIniciarJuego.setBounds(275,500,150,30);

    }

    public void setMensaje(String s){
        this.textoLogs.setText(this.textoLogs.getText() + "\n" + s);
    }

    public void setController(Controller controller){
        this.controller = controller;
        this.botonIniciarJuego.addActionListener(this.controller);

        //ActionListeners/ItemListeners Modulo Mover Tropas

        this.comboMoverOrigen.addItemListener(this.controller);
        this.comboMoverDestino.addItemListener(this.controller);
        this.comboMoverNumero.addItemListener(this.controller);
        this.botonMoverTropas.addActionListener(this.controller);

        //ActionListeners/ItemListeners Modulo de Ataque
        this.comboAtacarOrigen.addItemListener(this.controller);
        this.comboAtacarDestino.addItemListener(this.controller);
        this.botonAtacar.addActionListener(this.controller);

        //ActionListener Boton Terminar Turno

        this.botonTerminarTurno.addActionListener(this.controller);


    }

    public void setCboOrigen(ArrayList<String> nombresRojos){

        this.getComboAtacarOrigen().removeAllItems();
        this.getComboMoverOrigen().removeAllItems();

        for (int i = 0; i <nombresRojos.size() ; i++) {
            this.getComboAtacarOrigen().addItem(nombresRojos.get(i));
            this.getComboMoverOrigen().addItem(nombresRojos.get(i));
        }
    }

    public void setCboMoverDestino (ArrayList<String> destinos){

        if(destinos.isEmpty()){
        }

        else{
            this.comboMoverDestino.removeAllItems();
            for (int i = 0; i < destinos.size(); i++) {
                this.comboMoverDestino.addItem(destinos.get(i));
            }
        }

    }

    public void setCboAtacarDestino(ArrayList<String> nombresAzules){
        this.getComboAtacarDestino().removeAllItems();

        for (int i = 0; i <nombresAzules.size(); i++) {
            this.getComboAtacarDestino().addItem(nombresAzules.get(i));
        }
    }

    public void setCboMoverNumero(Integer n){
        this.getComboMoverNumero().removeAllItems();

        for (int i = 0; i <n; i++) {
            this.getComboMoverNumero().addItem(i+1);
        }
    }

    public Panel getPanel() {
        return panel;
    }

    public void setPanel(Panel panel) {
        this.panel = panel;
    }

    //Getters y Setters Botones

    public JButton getBotonMoverTropas() {
        return botonMoverTropas;
    }

    public void setBotonMoverTropas(JButton botonMoverTropas) {
        this.botonMoverTropas = botonMoverTropas;
    }

    public JButton getBotonAtacar() {
        return botonAtacar;
    }

    public void setBotonAtacar(JButton botonAtacar) {
        this.botonAtacar = botonAtacar;
    }

    public JButton getBotonTerminarTurno() {
        return botonTerminarTurno;
    }

    public void setBotonTerminarTurno(JButton botonTerminarTurno) {
        this.botonTerminarTurno = botonTerminarTurno;
    }

    public JButton getBotonIniciarJuego() {
        return botonIniciarJuego;
    }

    public void setBotonIniciarJuego(JButton botonIniciarJuego) {
        this.botonIniciarJuego = botonIniciarJuego;
    }

    //Getters y Setters ComboBoxes


    public JComboBox<String> getComboMoverOrigen() {
        return comboMoverOrigen;
    }

    public void setComboMoverOrigen(JComboBox<String> comboMoverOrigen) {
        this.comboMoverOrigen = comboMoverOrigen;
    }

    public JComboBox<String> getComboMoverDestino() {
        return comboMoverDestino;
    }

    public void setComboMoverDestino(JComboBox<String> comboMoverDestino) {
        this.comboMoverDestino = comboMoverDestino;
    }

    public JComboBox<String> getComboAtacarOrigen() {
        return comboAtacarOrigen;
    }

    public void setComboAtacarOrigen(JComboBox<String> comboAtacarOrigen) {
        this.comboAtacarOrigen = comboAtacarOrigen;
    }

    public JComboBox<String> getComboAtacarDestino() {
        return comboAtacarDestino;
    }

    public void setComboAtacarDestino(JComboBox<String> comboAtacarDestino) {
        this.comboAtacarDestino = comboAtacarDestino;
    }

    public JComboBox<Integer> getComboMoverNumero() {
        return comboMoverNumero;
    }

    public void setComboMoverNumero(JComboBox<Integer> comboMoverNumero) {
        this.comboMoverNumero = comboMoverNumero;
    }
}
