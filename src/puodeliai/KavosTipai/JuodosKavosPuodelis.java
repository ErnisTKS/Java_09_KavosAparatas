package puodeliai.KavosTipai;

import produktai.Produktai;
import puodeliai.KavosPuodelis;

public class JuodosKavosPuodelis extends KavosPuodelis {

    public JuodosKavosPuodelis(){
        super.setPavadinimas("Juoda Kava");
        super.setMaxPuodelioTalpa(200);
        super.setProduktai(new Produktai(5,45,150));
    }
}