import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;

public class Main {
    public static void main(String[] args){
        Player player = new Player();
        Pattern vocals = new Pattern().setTempo(160);
        vocals.add("V0 I[Guitar] C3q E3q E4qq | D3q Gb3q Gb4qq | E3q G3q G4qq | E3q G3q G4qq");
        vocals.add("V1 I[Piano] A4w | B4w | Gb4w | G4w");
        vocals.add("V2 I[Guitar] A5h A5h | B5h B5h | Gb5h Gb5h | G5h G5h");

        player.play(vocals);
    }
}
