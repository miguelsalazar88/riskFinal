package modelo;

import vista.Ventana;

import javax.swing.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class Modelo {

    private Ventana ventana;
    private Rungame rungame;
    ArrayList<Territorio> territoriosModelo;
    private Random rnd = new Random();

    public Modelo(Ventana ventana) {
        this.ventana = ventana;
        this.rungame = new Rungame();
        this.territoriosModelo = rungame.setTerritorios();
    }

    public void setGame() {
        this.ventana.getPanel().setTerritoriosVista(territoriosModelo);
    }

    public void moverTropas(String origen, String destino, int num) {

        int idOrigen = -1;
        int idDestino = -1;

        for (int i = 0; i < territoriosModelo.size(); i++) {
            if(territoriosModelo.get(i).getNombre().equals(origen)){
                idOrigen = i;
            }
            else if(territoriosModelo.get(i).getNombre().equals(destino)){
                    idDestino = i;
            }

        }

        if(territoriosModelo.get(idOrigen).getSoldados()==1){
            if (territoriosModelo.get(idOrigen).getPertenece()=='r'){
                JOptionPane.showMessageDialog(null, "No puedes dejar terrotorios sin tropas");
                this.ventana.getPanel().setTerritoriosVista(territoriosModelo);
                this.ventana.getPanel().repaint();
            }

        }

        else {

            territoriosModelo.get(idOrigen).setSoldados(territoriosModelo.get(idOrigen).getSoldados() - num);
            this.ventana.setCboMoverNumero(territoriosModelo.get(idOrigen).getSoldados());
            territoriosModelo.get(idDestino).setSoldados(territoriosModelo.get(idDestino).getSoldados() + num);
            this.ventana.getPanel().setTerritoriosVista(territoriosModelo);
            this.ventana.getPanel().repaint();
            this.ventana.setMensaje("Se han movido " + num + " tropas de " +origen + " a " + destino);
        }

        territoriosModelo.stream().forEach(t -> t.setVisitado(false));
        this.ventana.getPanel().setTerritoriosVista(territoriosModelo);
        this.ventana.getPanel().repaint();

    }

    public Integer setMoverNumero(String origen){

        Integer n = 0;

        for (int i = 0; i < this.territoriosModelo.size(); i++) {
            if(this.territoriosModelo.get(i).getNombre().equals(origen)){
                 n = this.territoriosModelo.get(i).getSoldados()-1;
            }
        }

        return n;
    }

    //Setea el comboBox de la ventana para que vea las opciones de origen

    public ArrayList<String> setOrigen() {
        ArrayList<String> nombresRojos = new ArrayList<String>();

        for (int i = 0; i < territoriosModelo.size(); i++) {
            if (territoriosModelo.get(i).getPertenece() == 'r' && (territoriosModelo.get(i).getSoldados() > 1)) {
                nombresRojos.add(territoriosModelo.get(i).getNombre());
            }
        }
        return nombresRojos;
    }

    public ArrayList<String> setMoverDestino(String origen){
        ArrayList<String> moverDestino = new ArrayList<>();

        for (int i = 0; i < territoriosModelo.size(); i++) {
            if(territoriosModelo.get(i).getNombre().equals(origen)){
                moverDestino.addAll(territoriosModelo.get(i).buscarCaminos());
            }
        }

        return moverDestino;

    }

    //Setea el comboBox de la ventana para que se vean las opciones de ataque posibles.

    public ArrayList<String> setAtacarDestino(String origen) {
        ArrayList<String> atacarDestino = new ArrayList<>();


        for (int i = 0; i < territoriosModelo.size(); i++) {
            if (territoriosModelo.get(i).getNombre().equals(origen)) {
                for (int j = 0; j < territoriosModelo.get(i).getVecinos().size(); j++) {
                    if (territoriosModelo.get(i).getVecinos().get(j).getPertenece() == 'a') {
                        atacarDestino.add(territoriosModelo.get(i).getVecinos().get(j).getNombre());
                    }
                }
            }
        }

        return atacarDestino;

    }

    public void atacar(String nombreAtacante, String nombreAtacado) {

        this.ventana.setMensaje(nombreAtacante + " ha atacado a " + nombreAtacado);

        int soldadosAtacante = -1;
        int soldadosAtacado = -1;
        int idAtacante = -1;
        int idAtacado = -1;

        for (int i = 0; i < territoriosModelo.size(); i++) {
            if (territoriosModelo.get(i).getNombre().equals(nombreAtacante)) {
                soldadosAtacante = territoriosModelo.get(i).getSoldados();
                idAtacante = i;
            } else if (territoriosModelo.get(i).getNombre().equals(nombreAtacado)) {
                soldadosAtacado = territoriosModelo.get(i).getSoldados();
                idAtacado = i;
            }
        }

        if(territoriosModelo.get(idAtacante).getSoldados()<=1){
            JOptionPane.showMessageDialog(null, "No puedes atacar con una sola tropa.");
            this.ventana.getComboAtacarDestino().removeAllItems();
            this.ventana.setCboOrigen(this.setOrigen());
        }


        else{
            int totalSoldados = soldadosAtacante + soldadosAtacado;
            int dado = rnd.nextInt(totalSoldados) + 1;

            if (dado > soldadosAtacado) {
                territoriosModelo.get(idAtacado).setSoldados(soldadosAtacado - 1);
                this.ventana.setMensaje(nombreAtacado + " ha perdido un soldado!");
            } else {
                territoriosModelo.get(idAtacante).setSoldados(soldadosAtacante - 1);
                this.ventana.setMensaje(nombreAtacante + " ha perdido un soldado!");
            }


            if (territoriosModelo.get(idAtacado).getSoldados() < 1) {
                char ganador = territoriosModelo.get(idAtacante).getPertenece();
                territoriosModelo.get(idAtacado).setPertenece(territoriosModelo.get(idAtacante).getPertenece());
                territoriosModelo.get(idAtacado).setSoldados(territoriosModelo.get(idAtacante).getSoldados() - 1);
                territoriosModelo.get(idAtacante).setSoldados(1);
                this.ventana.getComboAtacarDestino().removeAllItems();
                this.ventana.setCboOrigen(this.setOrigen());

                if (ganador == 'r') {
                    this.ventana.setMensaje(nombreAtacado + " pertenece ahora a los rojos");
                } else {
                    this.ventana.setMensaje(nombreAtacado + " pertenece ahora a los azules");
                }

            }
        }
        this.ventana.getPanel().setTerritoriosVista(territoriosModelo);
        this.ventana.getPanel().repaint();

    }

    //Esta parte del código tiene el turno de la máquina.

    public int masGrande(){
        int tMasGrande = 0;

        for (int i=0; i<territoriosModelo.size(); i++) {
            if(tieneEnemigos(buscarTerritorio(territoriosModelo.get(i).getNombre()))
                    && territoriosModelo.get(i).getPertenece()=='a'
                    && territoriosModelo.get(i).getSoldados() >= territoriosModelo.get(tMasGrande).getSoldados()){
                    tMasGrande = i;
            }
        }

        return tMasGrande;
    }

    //Mueve las tropas hacia el territorio más grande.

    public void moverTropasMaquina(int tmasGrande){

        ArrayList<String> vecinos = territoriosModelo.get(tmasGrande).buscarCaminos();

        for (String v: vecinos) {
            moverTropas(v,territoriosModelo.get(tmasGrande).getNombre()
                    ,territoriosModelo.get(buscarTerritorio(v)).getSoldados()-1);

            this.ventana.getPanel().setTerritoriosVista(territoriosModelo);
            this.ventana.getPanel().repaint();
        }

    }

    public void ataqueMaquina(int tMasGrande){
    	if(tieneEnemigos(tMasGrande))
    	{
    		try{
                while(territoriosModelo.get(masGrande()).getSoldados()>1){
                    atacar(territoriosModelo.get(masGrande()).getNombre(),territoriosModelo.get(masGrande()).enemigos());
                }
            }
            catch (Exception e){
                System.out.println("Oh my god, funciona");
                if(!tieneEnemigos(masGrande())){
                    for (int i = 0; i < territoriosModelo.size(); i++) {
                        if(territoriosModelo.get(i).getPertenece()=='a'
                        && (tieneEnemigos(i))){
                            moverTropas(territoriosModelo.get(tMasGrande).getNombre(),
                                    territoriosModelo.get(i).getNombre(),territoriosModelo.get(tMasGrande).getSoldados()-1);
                        }
                    }
                }
            }
    	}
    	else
    	{
    		for(int i=0;i<territoriosModelo.size();i++)
    		{
    			if (territoriosModelo.get(i).getPertenece()=='a'
    				&& tieneEnemigos(i)
    				&& territoriosModelo.get(i).buscarCaminos().contains
    				(territoriosModelo.get(tMasGrande).getNombre()))
    			{
    				moverTropas(territoriosModelo.get(tMasGrande).getNombre(),
    						territoriosModelo.get(i).getNombre(),
    						territoriosModelo.get(tMasGrande).getSoldados()-1);
    				break;
    			}
    		}
    	}
        

    }

    public int contarTropas(char pertenece){

        int num = 0;

        for (int i = 0; i < territoriosModelo.size(); i++) {
            if(territoriosModelo.get(i).getPertenece() == pertenece){
                num += territoriosModelo.get(i).getSoldados();
            }
        }
        return num;
    }

    //Busca el territorio en el arreglo y retorna su indice.

    public int buscarTerritorio(String nombre){
        int id = -1;

        for (int i = 0; i < territoriosModelo.size(); i++) {
            if (territoriosModelo.get(i).getNombre().equals(nombre)){
                id = i;
            }
        }
        return id;
    }

    //Revisa si el territorio tiene vecinos enemigos

    public boolean tieneEnemigos(int id){
        boolean tiene = false;

        for (Territorio t: territoriosModelo.get(id).getVecinos()){
            if(territoriosModelo.get(id).getPertenece() != t.getPertenece()){
                tiene = true;
            }
        }
        return tiene;
    }

    //Getters y Setters


    public ArrayList<Territorio> getTerritoriosModelo() {
        return territoriosModelo;
    }

    public void setTerritoriosModelo(ArrayList<Territorio> territoriosModelo) {
        this.territoriosModelo = territoriosModelo;
    }
}
