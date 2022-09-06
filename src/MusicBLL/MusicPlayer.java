package MusicBLL;

import org.jfugue.player.Player;

public class MusicPlayer {
    private final String musicSheet;

    public MusicPlayer(String musicSheet){
        this.musicSheet = musicSheet;
    }
// WIP
//    private InstructionPreprocessor initInstructionPreprocessor(){
//        InstructionPreprocessor instructionPreprocessor = InstructionPreprocessor.getInstance();
//
//        instructionPreprocessor.addInstruction("set volume to", new Instruction.LastIsValue(":CE(7, $)"));
//        instructionPreprocessor.addInstruction("change instrument to", new Instruction.LastIsValue("I[$]"));
//
//        return instructionPreprocessor;
//    }

    public void play(){
        Player player = new Player();
        player.play(musicSheet);
    }
}
