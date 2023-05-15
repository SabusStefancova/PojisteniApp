/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package cz.itnetwork.spravapojistenych;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author sabin
 */
public class SpravaPojistenych {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in, "Windows-1250");
        Databaze databaze = new Databaze();
        
        String volba = "";
        
        //nekonečný cyklus
        while(!volba.equals("5")) {
            //výpis úvodní obrazovky
            vypisObrazovku();
            System.out.println();
            
            //možnosti uživatele
            System.out.println("Vyberte si akci:");
            System.out.println("1 - Přidat nového pojištěnce");
            System.out.println("2 - Vypsat všechny pojištěné");
            System.out.println("3 - Vyhledat pojištěnce");
            System.out.println("4 - Vymazat pojištěnce");
            System.out.println("5 - Konec");
            
            //volba uživatele
            volba = sc.nextLine();
            System.out.println();
            
            //reakce na volbu
            switch(volba){
                case "1" -> {
                    String jmeno = zjistiUdaje(sc, "jméno");
                    String prijmeni = zjistiUdaje(sc, "příjmení");
                    String telefon = zjistiUdaje(sc, "telefon");
                    LocalDate datumNarozeni = zjistiDatumNarozeni(sc);
                    databaze.pridejZaznam(jmeno, prijmeni, datumNarozeni, telefon);
                    System.out.println("\nPojištěnec byl přidán.");
                }
                case "2" -> {
                    vypisNalezeny(databaze.vratZaznamy());
                }    
                case "3" -> {
                    String jmeno = zjistiUdaje(sc, "jméno");
                    String prijmeni = zjistiUdaje(sc, "příjmení");
                    List<Zaznam> nalezene = databaze.najdiZaznamy(jmeno, prijmeni);
                    vypisNalezeny(nalezene);
                }
                case "4" -> {
                    String jmeno = zjistiUdaje(sc, "jméno");
                    String prijmeni = zjistiUdaje(sc, "příjmení");
                    List<Zaznam> nalezene = databaze.najdiZaznamy(jmeno, prijmeni);
                    vypisNalezeny(nalezene);
                    if(!nalezene.isEmpty()){
                        System.out.println("Opravdu si přejete pojištěné/ho vymazat?");
                        String volbaVymazani = sc.nextLine().trim().toLowerCase();
                        if(volbaVymazani.equals("ano")){
                            databaze.vymazZaznamy(jmeno, prijmeni);
                            System.out.println("\nPojištěnec byl vymazán.");
                        } else {
                            System.out.println("\nPojištěnec nebyl vymazán.");
                        }
                    } 
                }
                case "5" -> System.out.println("Program ukončen.");
                default -> System.out.println("Neplatná volba, prosím stiskněte libovolnou klávesu a opakujte volbu.");
            }
        }
    }
    
    /**
     * Vypíše zda byli nalezeni nějací pojištěnci nebo ne
     * @param nalezeni
     * @return 
     */
    private static void vypisNalezeny(List<Zaznam> nalezeni){
        if(!nalezeni.isEmpty()){
            System.out.println("Nalezeni tito pojištěnci:");
            for(Zaznam z : nalezeni){
                System.out.println(z);
            }
        } else {
            System.out.println("Nebyli nalezeni žádní pojištěnci");
        }  
    }
    
   /**
    * Zjistí údaje o pojištěncích
    * @param sc
    * @return 
    */
    private static String zjistiUdaje(Scanner sc, String udaje){
        System.out.println("Zadejte " + udaje +  " pojištěného:");
        return sc.nextLine().trim();
    }
    
    /**
     * Zjistí datum narození pojištěného
     * @param sc
     * @return 
     */
    private static LocalDate zjistiDatumNarozeni(Scanner sc){
        System.out.println("Zadejte datum narození pojištěného (ve tvaru 01.01.2001):");
        LocalDate datumNarozeni = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("d'.'M'.'y"));
        return datumNarozeni;
    }
    
    /**
     * Vypíše úvodní obrazovku
     */
    public final static void vypisObrazovku(){
        System.out.println("-------------------------");
        System.out.println("  Evidence pojištěných");
        System.out.println("-------------------------\n\n");
    }
}

