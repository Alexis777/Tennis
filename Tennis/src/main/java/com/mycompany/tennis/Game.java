/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tennis;

/**
 *
 * @author Alexis Bariteau
 */
public class Game {
    
    // Variables score et nom de chaque joueur
    private int scoreJ1 = 0;
    private int scoreJ2 = 0;
    private String nameJ1;
    private String nameJ2;

    // Fonction constructeur de la classe Game
    public Game(String nameJ1, String nameJ2) {
        this.nameJ1 = nameJ1;
        this.nameJ2 = nameJ2;
    }

    // Fonction retour score
    public String getScore() {
        if (joueurGagne())
            return joueurMeilleurScore() + " gagne";
        if (joueurAvantage()) 
            return "Avantage " + joueurMeilleurScore();
        if (joueursEgalite())
            return "Egalité";
        if(scoreJ1 == scoreJ2)
            return traductionScore(scoreJ1) + " partout";
        return traductionScore(scoreJ1) + ", " + traductionScore(scoreJ2);
    }

    // Fonction retour égalité joueurs
    private boolean joueursEgalite() {
        return scoreJ1 >= 3 && scoreJ2 == scoreJ1;
    }

    // Fonction retour le nom du joueur ayant le meilleur score
    private String joueurMeilleurScore() {
        if (scoreJ1 > scoreJ2)
            return nameJ1;
        else
            return nameJ2;
    }
    
    // Fonction joueur gagne sinon false
    private boolean joueurGagne() {
        if(scoreJ2 >= 4 && scoreJ2 >= scoreJ1 + 2 )
            return true;
        if(scoreJ1 >= 4 && scoreJ1 >= scoreJ2 + 2)
            return true;
        return false;
    }
    
    // Fonction avantage joueur sinon false
    private boolean joueurAvantage() {
        if (scoreJ2 >= 4 && scoreJ2 == scoreJ1 + 1)
            return true;
        if (scoreJ1 >= 4 && scoreJ1 == scoreJ2 + 1)
            return true;
        return false;
    }
    
    // Fonction ajoutant 1 au score du Joueur 1
    public void scoreJ1() {
        scoreJ1++;
    }
    
    // Fonction ajoutant 1 au score du Joueur 2
    public void scoreJ2() {
        scoreJ2++;
    }
    
    // Fonction retour score en lettres
    private String traductionScore(int score) {
        switch (score) {
            case 3:
                return "Quarante";
            case 2:
                return "Trente";
            case 1: 
                return "Quinze";
            case 0:
                return "Zéro";
        }
        throw new IllegalArgumentException("Score illégal: " + score);
    }
}
