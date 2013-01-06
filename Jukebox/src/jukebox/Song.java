/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jukebox;

/**
 *
 * @author scottlow
 */
public class Song extends PlayableObject {

    Song(String t, String a) {
        this.title = t;
        this.artist = a;
    }
    
    @Override
    void play() {
        System.out.println("Now playing " + this.title + " by " + this.artist + ".");
    }
}
