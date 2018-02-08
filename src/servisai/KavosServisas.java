package servisai;

import aparatai.KavosAparatas;
import produktai.Produktai;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class KavosServisas {


    public KavosAparatas sukurkAparata() {
        KavosAparatas result = new KavosAparatas();
        return result;
    }

    public void isplaukAparata(KavosAparatas aparatas) {
        aparatas.plauti();
    }

    public ArrayList<KavosAparatas> sukurkNAparatu(int n) {
        ArrayList<KavosAparatas> sarasas = new ArrayList<KavosAparatas>();
        for (int i = 0; i < n; i++) {
            sarasas.add(this.sukurkAparata());
        }
        return sarasas;
    }

    public void isvalykAparatuProduktus(ArrayList<KavosAparatas> sarasas) {
        Produktai isvalytiProduktai = new Produktai(0, 0, 0);
        float isvalytaKava = 0;
        for (int i = 0; i < sarasas.size(); i++) {
            KavosAparatas aparatas = sarasas.get(i);

            isvalytiProduktai.setCukrausKiekis(isvalytiProduktai.getCukrausKiekis() + aparatas.getCukrausKiekis());
            aparatas.setCukrausKiekis(0);


            isvalytiProduktai.setKavosKiekis(isvalytiProduktai.getKavosKiekis() + aparatas.getKavosKiekis());
            aparatas.setKavosKiekis(0);

            isvalytiProduktai.setVandensKiekis(isvalytiProduktai.getVandensKiekis() + aparatas.getVandensKiekis());
            aparatas.setVandensKiekis(0);
        }
        System.out.println("Isvalem: " + isvalytiProduktai);
    }

    public void isplaukVisus(ArrayList<KavosAparatas> sarasas) {
        for (int i = 0; i < sarasas.size(); i++) {
            KavosAparatas aparatas = sarasas.get(i);
            isplaukAparata(aparatas);
        }
    }

    public void priskirkBendra(ArrayList<KavosAparatas> sarasas) {
        Produktai bendras = new Produktai(0, 0, 0);
        for (int i = 0; i < sarasas.size(); i++) {
            KavosAparatas aparatas = sarasas.get(i);
            aparatas.setProduktai(bendras);
        }
    }

    public void priskirkSkirtinga(ArrayList<KavosAparatas> sarasas) {

        for (int i = 0; i < sarasas.size(); i++) {
            Produktai skirtingas = new Produktai(0, 0, 0);
            KavosAparatas aparatas = sarasas.get(i);
            aparatas.setProduktai(skirtingas);
        }
    }

    public ArrayList<KavosAparatas> nustatykKavosAparatus() {
        ArrayList<KavosAparatas> sarasas = new ArrayList<KavosAparatas>();
        try {
            Scanner sc = new Scanner(new File("duomenys.txt"));

            while (sc.hasNextLine()) {
                Produktai produktas = new Produktai(sc.nextFloat(), sc.nextFloat(), sc.nextFloat());
                KavosAparatas aparatas = this.sukurkAparata();
                aparatas.setProduktai(produktas);
                sarasas.add(aparatas);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return sarasas;
    }

    public void issaugokAparatus(ArrayList<KavosAparatas> sarasas) {
        // atidarom faila
        try {
            FileWriter writer = new FileWriter("duomenys2.txt");
            // paleisti cikla kad pereiti per visus elementus
            for (int i = 0; i < sarasas.size(); i++) {
                //      pasiimti saraso elementa pagal raide i
                KavosAparatas aparatas = sarasas.get(i);
                float cukrus;
                float kava;
                float vanduo;
                cukrus = aparatas.getCukrausKiekis();
                kava = aparatas.getKavosKiekis();
                vanduo = aparatas.getVandensKiekis();
                //      suformuot ka parasyt
                String eilute = cukrus + " " + kava + " " + vanduo + "\n";
                //      ""+aaa+" "+bbb+" "+ccc+"\n"
                //      irasyti eilute i faila
                writer.write(eilute);
            }
            // uzdaryti faila
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

