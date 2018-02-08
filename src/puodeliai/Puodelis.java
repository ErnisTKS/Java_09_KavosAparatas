package puodeliai;

public class Puodelis {

    private int maxPuodelioTalpa;
    private int dabartineTalpa;

    public int getMaxPuodelioTalpa() {
        return maxPuodelioTalpa;
    }

    public void setMaxPuodelioTalpa(int maxPuodelioTalpa) {
        this.maxPuodelioTalpa = maxPuodelioTalpa;
    }

    public int getDabartineTalpa() {
        return dabartineTalpa;
    }

    public void setDabartineTalpa(int dabartineTalpa) {
        this.dabartineTalpa = dabartineTalpa;
    }

    public String rodykInformacija() {
        return "Puodelio talpa: " + maxPuodelioTalpa;
    }
}
