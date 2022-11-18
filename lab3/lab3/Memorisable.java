package lab3;
import java.util.HashMap;

public interface Memorisable {
    HashMap<String, Integer> memory = new HashMap<>();

    int getMemory(String s);
    void memorise(String s, Integer i);
}
