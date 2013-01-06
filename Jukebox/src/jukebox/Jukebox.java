/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jukebox;

import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 * @author scottlow
 */
public class Jukebox {
    
    static Queue<PlayableObject> playlist = new LinkedList<PlayableObject>();
    PlayableObject current;
    
    Jukebox() {
        List<Song> tracks = new ArrayList<Song>();
        
        Song track1 = new Song("Track 1", "Artist 1");
        
        Song aTrack1 = new Song("Album Track 1", "Artist 2");
        Song aTrack2 = new Song("Album Track 2", "Artist 2");
        
        tracks.add(aTrack1);
        tracks.add(aTrack2);
        
        Album album1 = new Album(tracks, "Album Title 1", "Artist 2");
        
        playlist.add(track1);
        playlist.add(album1);
        playlist.add(track1);
        playlist.add(album1);
        playlist.add(album1);
        playlist.add(track1);
        playlist.add(track1);
    }
    
    public void play() {
        current = playlist.poll();
        if(current != null) {
            current.play();
        }
    }
    
    public void playNext() {

        PlayableObject next;
        
        if(current instanceof Song) {
            // If we are currently playing a song, get the next one
            getNextSong();
        } else {
            // Otherwise, get the next song from the currently playing album
            next = ((Album)current).getNextTrack();
            if(next != null) {
                next.play();
            } else {
                // If there are no more songs in the album, time to get the next song from the jukebox master playlist
                ((Album)current).currentTrack = 0;
                getNextSong();
            }
            
        }
    }
    
    public void getNextSong() {
        current = playlist.poll();
        if(current != null) {
            current.play();
        }
    }
}
