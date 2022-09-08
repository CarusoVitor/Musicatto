package MusicBLL;

import org.jfugue.midi.MidiFileManager;
import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;
import java.io.File;
import java.io.IOException;

public class MusicPlayer {
    public static void play(String musicSheet){
        Player player = new Player();
        player.play(musicSheet);
    }

    public static void download(String musicSheet, String filePath){
        try {
            File file = new File(filePath);
            Pattern pattern = new Pattern(musicSheet);
            MidiFileManager.savePatternToMidi(pattern, file);
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
