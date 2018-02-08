package puodeliai.KavosTipai;

import produktai.Produktai;
import puodeliai.KavosPuodelis;

public class CapuccinoPuodelis extends KavosPuodelis {

    public CapuccinoPuodelis(){
        super.setPavadinimas("Capuccino");
        super.setMaxPuodelioTalpa(250);
        super.setProduktai(new Produktai(20,30,200));
    }
}