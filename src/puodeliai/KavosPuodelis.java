package puodeliai;

import produktai.Produktai;

public class KavosPuodelis extends Puodelis {

    private Produktai produktai;
    private String pavadinimas;
    private boolean arKavaPagaminta;

    @Override
    public String toString() {
        return "Pavadinimas: " + getPavadinimas() + " | ar pagaminta: " + isArKavaPagaminta() + " | " + rodykInformacija() + " | Produktai: " + produktai.toString();
    }

    public Produktai getProduktai() {
        return produktai;
    }

    public void setProduktai(Produktai produktai) {
        this.produktai = produktai;
    }

    public boolean isArKavaPagaminta() {
        return arKavaPagaminta;
    }

    public void setArKavaPagaminta(boolean arKavaPagaminta) {
        this.arKavaPagaminta = arKavaPagaminta;
    }

    public String getPavadinimas() {
        return pavadinimas;
    }

    public void setPavadinimas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }
}