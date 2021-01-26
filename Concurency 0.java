import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Scratch {
    public static void main(String[] args) {
        // This example shows a Race Conditioning example
        // It suppose to return 100 ball hits by 100 players, but ir does not.
        // All because a single object 'sharedBall' is modified by multiple threads at the same time.
        // In the 'Concurency 1.java' we will look at how to fix this.

        // Set up players
        String[] players = {"Jane", "Mary", "Ralph", "Joe"};
        Random r = new Random();
        // random list of player names, representing their turn to hit ball
        List<String> playerTurns = Stream.generate(() -> players[r.nextInt(4)])
                        .limit(100)
                        .collect(Collectors.toList());

        ExecutorService executorService = null;
        SharedBall sharedBall = new SharedBall(); // This is a shared object that can be modified by multiple threads

        try {
            executorService = Executors.newFixedThreadPool(5);

            // create a thread for each player, who will touch the ball
            for (String player : playerTurns) {
                executorService.submit(() -> sharedBall.addHit(player));
            }

        } finally {
            if (executorService != null) {
                executorService.shutdown();
                try {
                    // Wait no longer than 1 second for completion confirmation
                    executorService.awaitTermination(1, TimeUnit.SECONDS);
                    System.out.println(sharedBall);

                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            }
        }
    }
}

class SharedBall {

    // Total number of hits on the ball
    private int hit;

    // Map of players and their hits..
    private Map<String, Integer> players = new TreeMap<>();

    // Method called by threads, adds player to map if not found or increments value in map
    // Here we have two variables that can be modified at the same time by multiple threads
    // 1. hit - although the increment looks as a single operation, in reality it's not
    // 2. players - we aggregate each players hits in this Dictionary, but again because this is not an atomic operation
    // (you check the containsKey first and only then compute or put) multiple threads can see intermediate results.
    public int addHit(String player) {
        // increment is a multi-part operation: read the value, alter value, execute a write.
        this.hit++;

        // this is a more obvious multipart operation
        if (players.containsKey(player)) {
            players.computeIfPresent(player, (key, val) -> ++val);
        } else {
            players.put(player, 1);

        }
        return this.hit;
    }

    // Present writeable output
    public String toString() {
        return "Total ball hits: " + this.hit
                + ", Player hits: " + players.values().stream().mapToInt(s -> s).sum()
                + "\nPlayers List: " + players;
    }
}