package com.sk89q.jinglenote.bukkit;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import com.sk89q.jinglenote.Instrument;
import com.sk89q.jinglenote.JingleNotePlayer;
import com.sk89q.jinglenote.JingleSequencer;
import com.sk89q.jinglenote.JingleSequencer.Note;

public class BukkitJingleNotePlayer extends JingleNotePlayer {

    public BukkitJingleNotePlayer (String player, JingleSequencer seq) {
        super(player, seq);
    }

    Player p = null;

    @Override
    public void play (Note note)  {

        if (p == null || !p.isOnline())
            p = Bukkit.getPlayerExact(player);

        if (p == null || !p.isOnline() || note == null)
            return;

        p.playSound(p.getLocation(), toSound(note.getInstrument()), note.getVelocity(), note.getNote());
    }

    public Sound toSound(Instrument instrument) {
        switch(instrument) {
            case PIANO:
                return Sound.BLOCK_NOTE_HARP;
            case GUITAR:
                return Sound.BLOCK_NOTE_GUITAR;
            case BASS:
                return Sound.BLOCK_NOTE_BASS;
            case BASS_GUITAR:
                return Sound.BLOCK_NOTE_BASS;
            case STICKS:
                return Sound.BLOCK_NOTE_HAT;
            case BASS_DRUM:
                return Sound.BLOCK_NOTE_BASEDRUM;
            case SNARE_DRUM:
                return Sound.BLOCK_NOTE_SNARE;
            case BELL:
                return Sound.BLOCK_NOTE_BELL;
            case CHIME:
                return Sound.BLOCK_NOTE_CHIME;
            case FLUTE:
                return Sound.BLOCK_NOTE_FLUTE;
            case XYLOPHONE:
                return Sound.BLOCK_NOTE_XYLOPHONE;
            default:
                return Sound.BLOCK_NOTE_HARP;
        }
    }
}