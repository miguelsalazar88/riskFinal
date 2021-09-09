package controlador;

import modelo.Modelo;
import modelo.Territorio;
import vista.Ventana;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class Controller implements ActionListener, ItemListener {

    private Ventana vista;
    private Modelo modelo;

    public Controller(Ventana vista, Modelo modelo) {
        this.vista = vista;
        this.modelo = modelo;
        this.vista.setController(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(this.vista.getBotonIniciarJuego())) {
            this.modelo.setGame();
            this.vista.getPanel().repaint();
            this.vista.setMensaje("Inicia el juego!");
            this.vista.setCboOrigen(modelo.setOrigen());
        }

        if (e.getSource().equals(this.vista.getBotonAtacar())) {
            this.modelo.atacar(this.vista.getComboAtacarOrigen().getSelectedItem().toString()
                    ,this.vista.getComboAtacarDestino().getSelectedItem().toString());

        }

        if(e.getSource().equals(this.vista.getBotonMoverTropas())){

            String origen = this.vista.getComboMoverOrigen().getSelectedItem().toString();
            String destino = this.vista.getComboMoverDestino().getSelectedItem().toString();
            int num = Integer.valueOf(this.vista.getComboMoverNumero().getSelectedItem().toString());

            this.modelo.moverTropas(origen, destino, num);
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {

        if (e.getSource().equals(this.vista.getComboAtacarOrigen())) {

            if (this.vista.getComboAtacarOrigen().getSelectedItem() == null) {
                this.vista.getComboAtacarDestino().removeAllItems();
            }
            else {
                this.vista.setCboAtacarDestino(modelo.setAtacarDestino(
                        this.vista.getComboAtacarOrigen().getSelectedItem().toString()));
            }
        }

        if (e.getSource().equals(this.vista.getComboMoverOrigen())) {

            if (this.vista.getComboMoverOrigen().getSelectedItem() == null) {
                this.vista.getComboMoverDestino().removeAllItems();
            }
            else {

                this.vista.setCboMoverDestino(modelo.setMoverDestino(this.vista.getComboMoverOrigen().getSelectedItem().toString()));


                this.vista.setCboMoverNumero(modelo.setMoverNumero(
                        this.vista.getComboMoverOrigen().getSelectedItem().toString()));
                this.vista.getComboMoverNumero().setSelectedIndex(
                        this.vista.getComboMoverNumero().getItemCount()-1);
            }
        }


    }
}
