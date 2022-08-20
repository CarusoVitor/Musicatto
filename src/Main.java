import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;

public class Main {
    public static void main(String[] args){
        Player player = new Player();
        Pattern pat = new Pattern("V0 I[Piano] Eq Ch. | Eq Ch. | Dq Eq Dq Cq | Dh   V1 I[Flute] Rw | Rw | GmajQQQ CmajQ | Dminh");
        player.play(pat);
    }
}
