package produktai;

public class Produktai {
    private float cukrausKiekis = 0;    // gramais
    private float kavosKiekis = 0;      // gramais
    private float vandensKiekis = 0;    // mililitrais

    public Produktai(float cukrus, float kava, float vanduo) {
        this.cukrausKiekis = cukrus;
        this.kavosKiekis = kava;
        this.vandensKiekis = vanduo;
    }
    public Produktai clone(Produktai orig){
        Produktai clo= new Produktai(orig.getCukrausKiekis(),orig.getKavosKiekis(),orig.getVandensKiekis());
        return clo;
    }

    public float getCukrausKiekis() {
        return cukrausKiekis;
    }

    public void setCukrausKiekis(float cukrausKiekis) {
        this.cukrausKiekis = cukrausKiekis;
    }

    public float getKavosKiekis() {
        return kavosKiekis;
    }

    public void setKavosKiekis(float kavosKiekis) {
        this.kavosKiekis = kavosKiekis;
    }

    public float getVandensKiekis() {
        return vandensKiekis;
    }

    public void setVandensKiekis(float vandensKiekis) {
        this.vandensKiekis = vandensKiekis;
    }

    public String toString(){
        return "Kava: "+this.kavosKiekis+" Cukrus: "+this.cukrausKiekis+" Vanduo: "+this.vandensKiekis;
    }
}
