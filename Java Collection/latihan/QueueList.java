package latihan;

import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Deque;

public class QueueList {
    public static void main(String[] args) {
        Queue<String> queues = new ArrayDeque<>(20);
        queues.offer("Cici");

        for(String nextQueue = queues.poll(); nextQueue != null; nextQueue = queues.poll()){
            System.out.println(nextQueue);
        }

        System.out.println(queues.size());
    }
}
