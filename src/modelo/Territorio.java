package modelo;

import java.util.ArrayList;

public class Territorio {

    private String nombre;
    private int soldados;
    private char pertenece;
    private int x;
    private int y;
    private ArrayList<Territorio> vecinos;
    private boolean visitado;

    public Territorio(String nombre, int x, int y){
        this.nombre = nombre;
        this.soldados = 1;
        this.pertenece = '0';
        this.vecinos = new ArrayList<Territorio>();
        this.visitado = false;
        this.x = x;
        this.y = y;
    }

    //Prueba

    public void setVecino(Territorio vecino){
        vecino.vecinos.add(this);
        this.vecinos.add(vecino);
    }

    public ArrayList<String> buscarCaminos(){
        this.visitado = true;

        ArrayList<String> caminos = new ArrayList<>();

        for (int i = 0; i <this.getVecinos().size() ; i++) {
            if(this.getVecinos().get(i).getPertenece() == this.getPertenece()
                    && !this.getVecinos().get(i).isVisitado()){
                this.getVecinos().get(i).setVisitado(true);
                caminos.add(this.getVecinos().get(i).getNombre());
                caminos.addAll(this.getVecinos().get(i).buscarCaminos());
            }
        }

        return caminos;

    }

    //Getters y Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSoldados() {
        return soldados;
    }

    public void setSoldados(int soldados) {
        this.soldados = soldados;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public char getPertenece() {
        return pertenece;
    }

    public void setPertenece(char pertenece) {
        this.pertenece = pertenece;
    }

    public ArrayList<Territorio> getVecinos() {
        return vecinos;
    }

    public void setVecinos(ArrayList<Territorio> vecinos) {
        this.vecinos = vecinos;
    }

    public boolean isVisitado() {
        return visitado;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }


}
