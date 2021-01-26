import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class C {
    public static void main(String[] args) throws InterruptedException {
        // This code demonstrates a LiveLock

        // Create two participants - both will have last word
        Participant chattyCathy = new Participant("Cathy", true);
        Participant windbagWill = new Participant("Will", true);

        // Create the shared resource, with an active participant
        Chat frustratingConversation = new Chat(chattyCathy);

        // Create two threads one for each participant
        Thread cathy = new Thread( () -> chattyCathy.converse(frustratingConversation, windbagWill));
        Thread will = new Thread( () -> windbagWill.converse(frustratingConversation, chattyCathy));

        // Kick off each thread
        cathy.start();
        will.start();
    }
}

// The Chat represents the 'object' that will be shared
class Chat {
    private Participant participant;

    public Chat(Participant participant) {
        this.participant = participant;
    }

    public Participant getParticipant() {
        return participant;
    }

    // will pass the word to another person
    public synchronized void setParticipant(Participant d) {
        participant = d;
    }
}

// Participant in the chat
class Participant {

    private String name;

    // Chat will get passed back and forth while a Participant
    // irritated.
    private boolean irritated = true;

    // Some Participant's must have the last word
    private boolean mustHaveLastWord;

    public Participant(String name, boolean mustHaveLastWord) {
        this.name = name;
        this.mustHaveLastWord = mustHaveLastWord;
    }

    public boolean isIrritated() {
        return irritated;
    }

    public void setIrritated(boolean irritated) {
        this.irritated = irritated;
    }

    public String getName() {
        return name;
    }

    public synchronized void converse(Chat conversation, Participant respondent) {

        // While the participant is irritated and has something to say
        while (isIrritated()) {
            // if other person talking, wait patiently...
            if (conversation.getParticipant() != this) {
                try {
                    wait(250);
                } catch (InterruptedException e) {
                    throw new RuntimeException("Something interrupted");
                }
                continue;
            }
            // Get the word in
            System.out.println(getName() +
                    " : This is what I have to say to that, " +
                    respondent.getName());

            // Allow other person to respond...
            conversation.setParticipant(respondent);

            // If the participant is one of those people, there is
            // no way to change this...
            this.irritated = mustHaveLastWord;

        }
        // If one of the participant's does not need last word,
        // Conversation can end.
        System.out.println(getName() +
                " :Catch you later, " + respondent.getName());
        respondent.setIrritated(false);
    }
}