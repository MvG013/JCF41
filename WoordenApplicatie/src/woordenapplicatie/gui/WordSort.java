/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package woordenapplicatie.gui;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author Marc
 */
public class WordSort {
    

//    Aantal
//Het tellen van het aantal verschillende woorden en het totaal aantal woorden in de tekst. 
public String aantal(String input)
{
        String output = "";
        String[] words = splitString(input);
        int wordCount = words.length;

        output += "Aantal woorden: " + String.valueOf(wordCount) + "\n";

        Set<String> uniqueWords = new HashSet<>();

        for (String w : words) {
            uniqueWords.add(filterWords(w));
        }

        output += "Aantal Unieke woorden: " + String.valueOf(uniqueWords.size());
        
        return output;
}

//Sorteer
//Laat in “omgekeerde” alfabetische ordening alle verschillende woorden zien. 
public String sorteer(String input){
        String output = "";
        String[] words = splitString(input);

        Set<String> uniqueWords = new TreeSet<String>().descendingSet();
        
        for (String w : words) {
            uniqueWords.add(filterWords(w));
        }
        
        return uniqueWords.toString().replace("[", "").replace("]", "");
}

//Frequentie
//Het bijhouden hoeveel keer een woord voorkomt in de tekst gesorteren op frequentie.
public String frequentie(String input){
        String[] words = splitString(input);
        String output = "";

        List<String> uniqWords = new LinkedList<>();
        for (String w : words) {
            uniqWords.add(filterWords(w));
        }

        Map<String, Integer> map = new HashMap<>();
        
        for (String w : uniqWords) {
            Integer n = map.get(w);
            if (n == null) {
                map.put(w, 1);
            } else {
                map.put(w, n + 1);
            }
        }
        
        List<Map.Entry<String, Integer>> gesorteerdeLijst = new LinkedList<>(map.entrySet());
        
        Collections.sort(gesorteerdeLijst, new Comparator<Map.Entry<String, Integer>>()
        {
            @Override
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2)
            {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        
        
    return gesorteerdeLijst.toString().replace(", ", "\n").replace("[", "").replace("]", "");
}

//Concordantie
//Een concordantie voor de gegeven tekst is een lijst van alle woorden die in een tekst voorkomen, 
//met de verwijzing naar de plaats waar ze staan. 
public String concordantie(String input){
        String[] rules = input.split("\n");
        String[] words = splitString(input);
        String output = "";

        Map<String, List<Integer>> map = new HashMap<>();
        for (String w : words) {
            map.put(filterWords(w), new LinkedList<>());
        }
        
        for (String key : map.keySet()) {
            List<Integer> list = new LinkedList<>();
            int ruleNumber = 1;
            
            for (String rule : rules) {
                if (rule.toLowerCase().contains(key)) {
                    list.add(ruleNumber);
                }
                ruleNumber++;
            }
            map.put(key, list);
        }
        
     output = map.toString().replaceAll(", (?!\\d)", "\n").replace("{", "").replace("}", "");
        
    return output;
}
    //maakt alle letters klein en vervangt é -> e + alle niet letters worden vervangen door niks
    public String filterWords(String word) {
        return word.toLowerCase().replaceAll("é", "e").replaceAll("\\W", "");
    }

    // \\s split op whitespaces + \\n split op nieuwe regel
    public String[] splitString(String string) {
        return string.split("\\s+|\\n");
    }
    
}
