package puodeliai.KavosTipai;

import produktai.Produktai;
import puodeliai.KavosPuodelis;

public class LattePuodelis extends KavosPuodelis {

    public LattePuodelis(){
        super.setPavadinimas("Latte");
        super.setMaxPuodelioTalpa(200);
        super.setProduktai(new Produktai(10,10,180));
    }
}