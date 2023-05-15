/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cz.itnetwork.spravapojistenych;

import java.time.LocalDate;
import java.time.Period;

/**
 * Záznam pojištěnce
 * @author sabin
 */
public class Zaznam implements Comparable<Zaznam>{
    
    /**
     * jméno pojištěnce 
     */
    private String jmeno;
    /**
     * příjmení pojištěnce
     */
    private String prijmeni;
    /**
     * věk pojištěnce
     * private int vek;
     */
    private LocalDate datumNarozeni;
    /**
     * telefonní číslo pojištěnce
     */
    private String telefon;
    
    /**
     * Vytvoření konstruktoru
     * @param jmeno
     * @param prijmeni
     * @param datumNarozeni
     * @param telefon 
     */
    public Zaznam(String jmeno, String prijmeni, LocalDate datumNarozeni, String telefon){
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.datumNarozeni = datumNarozeni;
        this.telefon = telefon;
    }

    /**
     * @return the jmeno
     */
    public String getJmeno() {
        return jmeno;
    }

    /**
     * @return the prijmeni
     */
    public String getPrijmeni() {
        return prijmeni;
    }

    /**
     * @return the datumNarozeni
     */
    public LocalDate getDatumNarozeni() {
        return datumNarozeni;
    }

    /**
     * @return the telefon
     */
    public String getTelefon() {
        return telefon;
    }

    @Override
    public String toString(){
        return "Pan/paní " + jmeno + " " + prijmeni + "  " + getVek() + "  " + telefon;
    }
    
    /**
     * Porovná podle data narození, pokud se jméno a příjmení bude shodovat s jiným
     * @param other
     * @return 
     */
    @Override
    public int compareTo(Zaznam other){
        if(jmeno.equals(other.jmeno) && prijmeni.equals(other.prijmeni)){
            if(datumNarozeni.isBefore(datumNarozeni)){
                return -1;
            } if (datumNarozeni.isAfter(datumNarozeni)){
                return 1;
            }
            return 0;
        }
        return prijmeni.compareTo(other.prijmeni);
    }
    
    /**
     * vrátí věk pojištěného z data narození
     * @return 
     */
    public int getVek(){
        return Period.between(getDatumNarozeni(), LocalDate.now()).getYears();
    }

}
