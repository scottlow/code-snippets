/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jukebox;

import java.util.List;

/**
 *
 * @author scottlow
 */
public class Album extends PlayableObject {

    int currentTrack = 0;
    
    List<Song> songs;
    
    Album(List<Song> s, String t, String a) {
        this.songs = s;
        this.title = t;
        this.artist = a;
    }
    
    @Override
    void play() {
        Song current = songs.get(currentTrack);
        
        current.play();
    }
    
    public Song getNextTrack() {
        
        Song song;
        
        try {
            song = songs.get(++currentTrack);
        } catch (IndexOutOfBoundsException e) {
            song = null;
        }
        
        return song;
    }
    
    
}
