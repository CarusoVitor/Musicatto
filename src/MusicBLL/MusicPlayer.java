package MusicBLL;

import org.jfugue.midi.MidiFileManager;
import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;
import org.staccato.Instruction;
import org.staccato.InstructionPreprocessor;

import java.io.File;
import java.io.IOException;

public class MusicPlayer {
// WIP
//    private InstructionPreprocessor initInstructionPreprocessor(){
//        InstructionPreprocessor instructionPreprocessor = InstructionPreprocessor.getInstance();
//
//        instructionPreprocessor.addInstruction("set volume to", new Instruction.LastIsValue(":CON(935,$)"));
//        instructionPreprocessor.addInstruction("change instrument to", new Instruction.LastIsValue("I[$]"));
//
//        return instructionPreprocessor;
//    }

    public static void play(String musicSheet){
        Player player = new Player();
        player.play(musicSheet);
    }

    public static void record(String musicSheet, String filePath){
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
