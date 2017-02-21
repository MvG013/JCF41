/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package woordenapplicatie.gui;

import java.util.Arrays;
import java.util.Random;
import java.util.Timer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import woordenapplicatie.TimeStamp;

/**
 *
 * @author Marc
 */
public class WordSortTest {
    
    public WordSortTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of aantal method, of class WordSort.
     */
    @Test
    public void testAantal() {
        System.out.println("aantal");
        String input = "jens";
        WordSort instance = new WordSort();
        String expResult = "Aantal woorden: " + "1" + "\n" +"Aantal Unieke woorden: " + "1";
        String result = instance.aantal(input);
        assertEquals(expResult, result);
    }
               

    /**
     * Test of sorteer method, of class WordSort.
     */
    @Test
    public void testSorteer() {
        System.out.println("sorteer");
        String input = "aa bb cc";
        WordSort instance = new WordSort();
        String expResult = "cc, bb, aa";
        String result = instance.sorteer(input);
        assertEquals(expResult, result);
    }

    /**
     * Test of frequentie method, of class WordSort.
     */
    @Test
    public void testFrequentie() {
        System.out.println("frequentie");
        String input = "een twee drie \n twee drie \n drie";
        WordSort instance = new WordSort();
        String expResult = "een=1\ntwee=2\ndrie=3";
        String result = instance.frequentie(input);
        assertEquals(expResult, result);
    }

    /**
     * Test of concordantie method, of class WordSort.
     */
    @Test
    public void testConcordantie() {
        System.out.println("concordantie");
        String input = "Een, twee, drie, vier\n";
        WordSort instance = new WordSort();
        String expResult = "twee=[1]\n" + "drie=[1]\n" + "vier=[1]\n" + "een=[1]";
        String result = instance.concordantie(input);
        assertEquals(expResult, result);
    }

    /**
     * Test of filterWords method, of class WordSort.
     */
    @Test
    public void testFilterWords() {
        System.out.println("filterWords");
        String word = "!éen ";
        WordSort instance = new WordSort();
        String expResult = "een";
        String result = instance.filterWords(word);
        assertEquals(expResult, result);
    }

    /**
     * Test of splitString method, of class WordSort.
     */
    @Test
    public void testSplitString() {
        System.out.println("splitString");
        String string = "een twee drie";
        WordSort instance = new WordSort();
        String[] expResult = new String[3];
        expResult[0] = "een";
        expResult[1] = "twee";
        expResult[2] = "drie";
        String[] result = instance.splitString(string);
        assertArrayEquals(expResult, result);
    }
 
    
    
    public String generateRandomWords(int numberOfWords) {
        String[] randomStrings = new String[numberOfWords];
        Random random = new Random();
        for (int i = 0; i < numberOfWords; i++) {
            char[] word = new char[random.nextInt(8) + 3]; // words of length 3 through 10. (1 and 2 letter words are boring.)
            for (int j = 0; j < word.length; j++) {
                word[j] = (char) ('a' + random.nextInt(26));
            }
            randomStrings[i] = new String(word);
        }

        return Arrays.toString(randomStrings);
    }
    
    @Test
    public void performanceTestAantal(){
    String input = generateRandomWords(1000000);
    WordSort instance = new WordSort();
    TimeStamp t =  new TimeStamp();
    t.setBegin();
    instance.aantal(input);
    t.setEnd();
    System.out.println("Performace Aantal");
    System.out.println(t);
    }
    
    @Test
    public void performanceTestSorteer(){
    String input = generateRandomWords(1000000);
    WordSort instance = new WordSort();
    TimeStamp t =  new TimeStamp();
    t.setBegin();
    instance.sorteer(input);
    t.setEnd();
    System.out.println("Performace Sorteer");
    System.out.println(t);
    }
    
    @Test
    public void performanceTestFrequentie(){
    String input = generateRandomWords(1000000);
    WordSort instance = new WordSort();
    TimeStamp t =  new TimeStamp();
    t.setBegin();
    instance.sorteer(input);
    t.setEnd();
    System.out.println("Performace Frequentie");
    System.out.println(t);
    }
    
    @Test
    public void performanceTestConcordantie(){
    String input = generateRandomWords(1000000);
    WordSort instance = new WordSort();
    TimeStamp t =  new TimeStamp();
    t.setBegin();
    instance.sorteer(input);
    t.setEnd();
    System.out.println("Performace Concordantie");
    System.out.println(t);
    }
}
