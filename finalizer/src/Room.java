import java.lang.ref.Cleaner;

public class Room implements AutoCloseable {
    private static final Cleaner cleaner = Cleaner.create();


    // The state of this room, shared with our cleanable
    private final State state;

    private final Cleaner.Cleanable cleanable;
    public Room(int numJunkPiles) {
        state = new State(numJunkPiles);
        cleanable = cleaner.register(this, state);
    }

    @Override
    public void close() throws Exception {
        cleanable.clean();
    }


    // Room has subclass State
    private static class State implements Runnable {
        int numJunkPiles; // Number of junk piles in this room

        public State(int numJunkPiles) {
            this.numJunkPiles = numJunkPiles;
        }

        @Override
        public void run() {
            System.out.println("Cleaning room");
            numJunkPiles = 0;
        }
    }

}