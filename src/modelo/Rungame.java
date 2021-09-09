package modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Rungame {

    Random rnd;

    public Rungame() {
        this.rnd = new Random();
    }

    public ArrayList<Territorio> setTerritorios(){

        ArrayList<Territorio> territorios = new ArrayList<>();

        //Se crea cada uno de los territorios con su nombre y la ubicación del territorio en x y y.

        territorios.add(new Territorio("Alaska", 40,85)); //0
        territorios.add(new Territorio("Northwest Territory", 150,85)); //1
        territorios.add(new Territorio("Greenland", 300, 40)); //2
        territorios.add(new Territorio("Alberta",100,120)); //3
        territorios.add(new Territorio("Ontario", 180, 120)); //4
        territorios.add(new Territorio("Quebec", 235, 120)); //5
        territorios.add(new Territorio("Western United States", 136,164)); //6
        territorios.add(new Territorio("Eastern United States", 179, 184));  //7
        territorios.add(new Territorio("Central America", 140, 224)); //8
        territorios.add(new Territorio("Venezuela", 156,281 ));  //9
        territorios.add(new Territorio("Peru", 140,330));  //10
        territorios.add(new Territorio("Brazil", 238, 338)); //11
        territorios.add(new Territorio("Argentina", 178, 416)); //12
        territorios.add(new Territorio("North Africa", 337, 273)); //13
        territorios.add(new Territorio("Egypt", 388, 253)); //14
        territorios.add(new Territorio("Congo", 385, 346)); //15
        territorios.add(new Territorio("East Africa", 417, 303)); //16
        territorios.add(new Territorio("South Africa", 383, 411)); //17
        territorios.add(new Territorio("Madagascar", 446, 410)); //18
        territorios.add(new Territorio("W. Europe", 329, 200)); //19
        territorios.add(new Territorio("Great Britain", 328,139)); //20
        territorios.add(new Territorio("Iceland", 327, 100)); //21
        territorios.add(new Territorio("Scandinavia", 365, 105)); //22
        territorios.add(new Territorio("Ukraine", 442, 122)); //23
        territorios.add(new Territorio("N. Europe", 372, 148)); //24
        territorios.add(new Territorio("S. Europe", 378, 201)); //25
        territorios.add(new Territorio("Middle East", 449, 232)); //26
        territorios.add(new Territorio("Afghanistan", 501,191)); //27
        territorios.add(new Territorio("Ural", 519, 110)); //28
        territorios.add(new Territorio("Siberia", 569, 91)); //29
        territorios.add(new Territorio("India", 536, 256)); //30
        territorios.add(new Territorio("China", 574, 202)); //31
        territorios.add(new Territorio("Siam", 597, 266)); //32
        territorios.add(new Territorio("Mongolia", 648, 160)); //33
        territorios.add(new Territorio("Irkutsk", 628, 124)); //34
        territorios.add(new Territorio("Yakursk", 645, 75)); //35
        territorios.add(new Territorio("Japan", 697, 185)); //36
        territorios.add(new Territorio("Kamchatka", 727, 85)); //37
        territorios.add(new Territorio("Indonesia", 624, 324)); //38
        territorios.add(new Territorio("New Guinea", 701, 340)); //39
        territorios.add(new Territorio("Western Australia", 618, 391)); //40
        territorios.add(new Territorio("Eastern Australia", 693, 412)); //41


        // Se asignan los vecinos

        territorios.get(0).setVecino(territorios.get(37));
        territorios.get(0).setVecino(territorios.get(1));
        territorios.get(0).setVecino(territorios.get(3));
        territorios.get(1).setVecino(territorios.get(3));
        territorios.get(1).setVecino(territorios.get(4));
        territorios.get(1).setVecino(territorios.get(2));
        territorios.get(2).setVecino(territorios.get(5));
        territorios.get(2).setVecino(territorios.get(4));
        territorios.get(2).setVecino(territorios.get(21));
        territorios.get(3).setVecino(territorios.get(6));
        territorios.get(3).setVecino(territorios.get(4));
        territorios.get(4).setVecino(territorios.get(5));
        territorios.get(4).setVecino(territorios.get(6));
        territorios.get(4).setVecino(territorios.get(7));
        territorios.get(5).setVecino(territorios.get(7));
        territorios.get(6).setVecino(territorios.get(8));
        territorios.get(6).setVecino(territorios.get(7));
        territorios.get(7).setVecino(territorios.get(8));
        territorios.get(8).setVecino(territorios.get(9));
        territorios.get(9).setVecino(territorios.get(10));
        territorios.get(9).setVecino(territorios.get(11));
        territorios.get(10).setVecino(territorios.get(11));
        territorios.get(10).setVecino(territorios.get(12));
        territorios.get(11).setVecino(territorios.get(12));
        territorios.get(11).setVecino(territorios.get(13));
        territorios.get(13).setVecino(territorios.get(14));
        territorios.get(13).setVecino(territorios.get(15));
        territorios.get(13).setVecino(territorios.get(16));
        territorios.get(13).setVecino(territorios.get(19));
        territorios.get(13).setVecino(territorios.get(25));
        territorios.get(14).setVecino(territorios.get(16));
        territorios.get(14).setVecino(territorios.get(25));
        territorios.get(14).setVecino(territorios.get(26));
        territorios.get(15).setVecino(territorios.get(16));
        territorios.get(15).setVecino(territorios.get(17));
        territorios.get(16).setVecino(territorios.get(18));
        territorios.get(16).setVecino(territorios.get(17));
        territorios.get(16).setVecino(territorios.get(26));
        territorios.get(17).setVecino(territorios.get(18));
        territorios.get(19).setVecino(territorios.get(20));
        territorios.get(19).setVecino(territorios.get(24));
        territorios.get(19).setVecino(territorios.get(25));
        territorios.get(20).setVecino(territorios.get(21));
        territorios.get(20).setVecino(territorios.get(22));
        territorios.get(20).setVecino(territorios.get(24));
        territorios.get(20).setVecino(territorios.get(25));
        territorios.get(21).setVecino(territorios.get(22));
        territorios.get(22).setVecino(territorios.get(23));
        territorios.get(22).setVecino(territorios.get(24));
        territorios.get(23).setVecino(territorios.get(24));
        territorios.get(23).setVecino(territorios.get(25));
        territorios.get(23).setVecino(territorios.get(26));
        territorios.get(23).setVecino(territorios.get(27));
        territorios.get(23).setVecino(territorios.get(28));
        territorios.get(24).setVecino(territorios.get(25));
        territorios.get(25).setVecino(territorios.get(26));
        territorios.get(26).setVecino(territorios.get(27));
        territorios.get(26).setVecino(territorios.get(30));
        territorios.get(27).setVecino(territorios.get(28));
        territorios.get(27).setVecino(territorios.get(30));
        territorios.get(27).setVecino(territorios.get(31));
        territorios.get(28).setVecino(territorios.get(29));
        territorios.get(28).setVecino(territorios.get(31));
        territorios.get(29).setVecino(territorios.get(31));
        territorios.get(29).setVecino(territorios.get(33));
        territorios.get(29).setVecino(territorios.get(34));
        territorios.get(29).setVecino(territorios.get(35));
        territorios.get(30).setVecino(territorios.get(31));
        territorios.get(30).setVecino(territorios.get(32));
        territorios.get(31).setVecino(territorios.get(32));
        territorios.get(31).setVecino(territorios.get(33));
        territorios.get(32).setVecino(territorios.get(38));
        territorios.get(33).setVecino(territorios.get(34));
        territorios.get(33).setVecino(territorios.get(36));
        territorios.get(33).setVecino(territorios.get(37));
        territorios.get(34).setVecino(territorios.get(35));
        territorios.get(34).setVecino(territorios.get(37));
        territorios.get(35).setVecino(territorios.get(37));
        territorios.get(36).setVecino(territorios.get(37));
        territorios.get(38).setVecino(territorios.get(39));
        territorios.get(38).setVecino(territorios.get(40));
        territorios.get(39).setVecino(territorios.get(40));
        territorios.get(39).setVecino(territorios.get(41));
        territorios.get(40).setVecino(territorios.get(41));

        //Se reordena la lista de manera Aleatoria con Collections.shuffle.

        Collections.shuffle(territorios);

        for (int i = 0; i < territorios.size(); i++) {
            if (i % 2 ==0 ){
                territorios.get(i).setPertenece('r');
            }
            else{
                territorios.get(i).setPertenece('a');
            }
        }

        //Se reparten 100 tropas por color de manera aleatoria.

        int soldadosRojos =100;
        int soldadosAzules = 100;


        while (soldadosRojos>0){
            int random = rnd.nextInt(42);
            if(territorios.get(random).getPertenece()=='r'){
                territorios.get(random).setSoldados(territorios.get(random).getSoldados()+1);
                soldadosRojos--;
            }
        }

        while(soldadosAzules>0){
            int random = rnd.nextInt(42);
            if(territorios.get(random).getPertenece()=='a'){
                territorios.get(random).setSoldados(territorios.get(random).getSoldados()+1);
                soldadosAzules--;
            }

        }

        return territorios;

    }

}
