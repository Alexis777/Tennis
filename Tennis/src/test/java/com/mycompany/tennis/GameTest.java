/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tennis;
import junit.framework.TestCase;
/**
 *
 * @author Alexis Bariteau
 */
public class GameTest extends TestCase {
    
    Game game = new Game("Boris Becker" , "Bjørn Borg");
    
    // Fonction creeScore
    private void creerScore(int ballesJ1, int ballesJ2 ) {
        for (int i = 0; i < ballesJ1; i++)
            game.scoreJ1();
        for (int i = 0; i < ballesJ2; i++)
            game.scoreJ2();
    }
    
    // Test Nouveau Jeu Retour Zéro Partout
    public void testNouveauJeuRetourZeroPartout() {
        String score = game.getScore();
        assertEquals("Zéro partout", score);
    }
    
    // Test Joueur 1 Gagne 1ère Balle
    public void testJoueurUnGagnePremiereBalle() {
        game.scoreJ1();
        String score = game.getScore();
        assertEquals("Quinze, Zéro", score);		
    }
    
    // Test Joueur 2 Gagne 2ème Balle
    public void testJoueurDeuxGagneDeuxiemeBalles() {
        creerScore(0, 2);
        String score = game.getScore();
        assertEquals("Zéro, Trente", score);
    }

    // Test Joueur 1 Gagne 3ème Balle
    public void testJoueurUnGagneTroisiemeBalle() {
        creerScore(3, 0);
        String score = game.getScore();
        assertEquals("Quarante, Zéro", score);
    }
    
    // Test 15 partout
    public void testQuinzePartout() {
        game.scoreJ1();
        game.scoreJ2();
        String score = game.getScore();
        assertEquals("Quinze partout", score);
    }
    
    // Test Egalité
    public void testJoueursEgalite() {
        creerScore(3, 3);
        String score = game.getScore();
        assertEquals("Egalité", score);		
    }
    
    // Test Egalité 4
    public void testJoueursEgaliteQuatre() {
        creerScore(4, 4);
        String score = game.getScore();
        assertEquals("Egalité", score);		
    }

    // Test Joueur 1 gagne Jeu
    public void testJoueurUnGagneJeu() {
        creerScore(4, 0);
        String score = game.getScore();
        assertEquals("Boris Becker gagne", score);
    }
    
    // Test Joueur 2 gagne Jeu
    public void testJoueurDeuxGagneJeu() {
        creerScore(1, 4);
        String score = game.getScore();
        assertEquals("Bjørn Borg gagne", score);
    }
    
    // Test Joueur 1 Avantage
    public void testJoueurUnAvantage() {
        creerScore(5, 4);
        String score = game.getScore();
        assertEquals("Avantage Boris Becker", score);
    }
    
    // Test Joueur 2 Avantage
    public void testJoueurDeuxAvantage() {
        creerScore(4, 5);
        String score = game.getScore();
        assertEquals("Avantage Bjørn Borg", score);
    }
    
    // Test Joueur 1 gagne après avantage
    public void testJoueurUnGagneApresAvantage() {
        creerScore(8, 6);
        String score = game.getScore();
        assertEquals("Boris Becker gagne", score);
    }
    
    // Test Joueur 2 gagne après avantage
    public void testJoueurDeuxGagneApresAvantage() {
        creerScore(6, 8);
        String score = game.getScore();
        assertEquals("Bjørn Borg gagne", score);
    }
}
