/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.itnetwork.spravapojistenych;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


/**
 * 
 * @author sabin
 */
public class Databaze {
    
    /**
     * Deklarace ArrayListu, kam se budou pojištěnci ukládat
     */
    ArrayList<Zaznam> pojistenci;
    
    /**
     * Vytvoření konstruktoru a inicializace ArrayListu
     */
    public Databaze(){
        pojistenci = new ArrayList<>();
    }
    
    /**
     * Přidá pojištěnce do ArrayListu
     * @param jmeno
     * @param prijmeni
     * @param datumNarozeni
     * @param telefon 
     */
    public void pridejZaznam(String jmeno, String prijmeni, LocalDate datumNarozeni, String telefon){
        pojistenci.add(new Zaznam(jmeno, prijmeni, datumNarozeni, telefon));
    }
    
    
    /**
     * Najde pojištěnce
     * @param jmeno
     * @param prijmeni
     * @return 
     */
    public List<Zaznam> najdiZaznamy(String jmeno, String prijmeni){
        return pojistenci.stream()
                         .filter(z -> jmeno.equals(z.getJmeno()) && prijmeni.equals(z.getPrijmeni()))
                         .collect(Collectors.toList());
    }

    /**
     * Vymaže pojištěnce    
     * @param jmeno
     * @param prijmeni 
     */
    public void vymazZaznamy(String jmeno, String prijmeni){
        pojistenci.removeIf(z -> {
            return jmeno.equals(z.getJmeno()) && prijmeni.equals(z.getPrijmeni());
        });
    }

    /**
     * vrátí seznam pojištěnců
     * @return 
     */
    public List<Zaznam> vratZaznamy(){
        Collections.sort(pojistenci);
        return Collections.unmodifiableList(pojistenci);
    }

}
