package aparatai;

import produktai.Produktai;
import puodeliai.KavosPuodelis;
import puodeliai.KavosTipai.CapuccinoPuodelis;
import puodeliai.KavosTipai.JuodosKavosPuodelis;
import puodeliai.KavosTipai.LattePuodelis;

public class KavosAparatas {
        /* Sukurti kavos aparatą:
    * Kuris turėtų atributus:
	* Cukraus kiekis
	* Kavos pupelių kiekis
	* Vandens kiekis
	* Panaudojimų skaičius
	* Panaudojimų skaičiaus riba – konstanta, kuri saugo, kas kiek panaudojimų reikia atlikti plovimą
	* Kuris mokėtų:
	*   Papildyti vandens/pupelių/cukraus
	*   Gaminti bent trijų rūšių kavą (nustatoma pagal String parametrą ir kuri naudotų skirtingus produktų kiekius),
	*       jeigu trūksta nors vieno produkto 0 atspausdintų atitinkamą pranešimą;
	*       Taip pat atspausditų pranešimą jeigu laikas plovimui
	*   Atlikti plovimą (apnulina panaudojimų skaičių)
	*   Pasakyti ar pasiruošęs (netrūksta produktų ir išsivalęs)
	*   Pasakytų kokia dabar produktų būsena – atspausdintų informaciją
	*   Pasakytų kokia yra aparato būsena (kiek liko produktų ir iki plovimo)
	*   Turėtų keletą konstruktorių
	*   Turėtų set ir get metodus laukams
	*/

    private static final int KADA_PLAUTI = 3;
    public static final String KAVA_JUODA = "Juoda";
    public static final String KAVA_LATTE = "Latte";
    public static final String KAVA_CAPUCCINO = "Capuccino";

    private Produktai produktai;

    private int panaudojimuSkaicius = 0;
    private boolean arPlauti = false;

    public void papildykCukru() {
        setCukrausKiekis(200);
    }

    public void papildykKava() {
        setKavosKiekis(1000);
    }

    public void papildykVandeni() {
        setVandensKiekis(10000);
    }

    public void uzpildykAparata() {
        papildykCukru();
        papildykKava();
        papildykVandeni();
    }

    public float getVandensKiekis() {
        return this.produktai.getVandensKiekis();
    }

    public void setVandensKiekis(float vandensKiekis) {
        this.produktai.setVandensKiekis(vandensKiekis);
    }

    public float getKavosKiekis() {
        return this.produktai.getKavosKiekis();
    }

    public void setKavosKiekis(float kavosKiekis) {
        this.produktai.setKavosKiekis(kavosKiekis);
    }

    public float getCukrausKiekis() {
        return this.produktai.getCukrausKiekis();
    }

    public void setCukrausKiekis(float cukrausKiekis) {
        this.produktai.setCukrausKiekis(cukrausKiekis);
    }

    public void parodykProduktuBusena() {
        System.out.println("\t==================================");
        System.out.println("\tKavos kiekis: " + getKavosKiekis());
        System.out.println("\tCukraus kiekis: " + getCukrausKiekis());
        System.out.println("\tVandens kiekis: " + getVandensKiekis());
        System.out.println("\t==================================");
    }

    public void parodykAparatoBusena() {
        System.out.println("\t###################################");
        System.out.println("\tPanaudojimu kiekis: " + getPanaudojimuSkaicius());
        System.out.println("\tIki plovimo liko: " + getUzKiekPlauti());
        System.out.println("\t###################################");
        parodykProduktuBusena();
    }

    public int getPanaudojimuSkaicius() {
        return panaudojimuSkaicius;
    }

    public int getUzKiekPlauti() {
        //          7               20                      7
        return KADA_PLAUTI - (getPanaudojimuSkaicius() % KADA_PLAUTI);
    }

    public void plauti() {
        arPlauti = false;
    }

    public void gaminkKava(String kavosRusis) {

        if (arGaliuGaminti()) {

            arPlauti = getUzKiekPlauti() == 1;

            KavosPuodelis puodelis = null;

            switch (kavosRusis) {
                case KAVA_JUODA:
                    puodelis = new JuodosKavosPuodelis();
                    break;
                case KAVA_LATTE:
                    puodelis = new LattePuodelis();
                    break;
                case KAVA_CAPUCCINO:
                    puodelis = new CapuccinoPuodelis();
                    break;
            }

            setVandensKiekis(getVandensKiekis() - puodelis.getProduktai().getVandensKiekis());
            puodelis.setDabartineTalpa(puodelis.getDabartineTalpa()+(int)puodelis.getProduktai().getVandensKiekis());
            setCukrausKiekis(getCukrausKiekis() - puodelis.getProduktai().getCukrausKiekis());
            puodelis.setDabartineTalpa(puodelis.getDabartineTalpa()+(int)puodelis.getProduktai().getCukrausKiekis());
            setKavosKiekis(getKavosKiekis() - puodelis.getProduktai().getKavosKiekis());
            puodelis.setDabartineTalpa(puodelis.getDabartineTalpa()+(int)puodelis.getProduktai().getKavosKiekis());
            panaudojimuSkaicius++;
            if (puodelis.getDabartineTalpa()==puodelis.getMaxPuodelioTalpa()){
                puodelis.setArKavaPagaminta(true);
            } else puodelis.setArKavaPagaminta(false);

            System.out.println(puodelis.toString());
        }



    }

    private boolean arGaliuGaminti() {
        boolean result = true;

        if (arPlauti) {
            result = false;
            System.out.println("\t REIKIA PLAUTI!");
        }

        if (getVandensKiekis() <= 0) {
            result = false;
            System.out.println("\t REIKIA VANDENS!");
            setVandensKiekis(0);
        }

        if (getCukrausKiekis() <= 0) {
            result = false;
            System.out.println("\t REIKIA CUKRAUS!");
            setCukrausKiekis(0);
        }
        if (getKavosKiekis() <= 0) {
            result = false;
            System.out.println("\t REIKIA KAVOS!");
            setKavosKiekis(0);
        }

        return result;
    }

    public void setProduktai(Produktai produktai) {
        this.produktai = produktai;
    }
}
