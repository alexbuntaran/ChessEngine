package main;

public class Game implements Runnable {

    private Thread thread;
    private boolean running;

    public Game() {
        
    }

    private void init() {

    }

    private void update() {

    }

    private void render() {

    }

    @Override
    public void run() {
        init();
        while (running) {
            update();
            render();
        }

        stop();
    }

    public synchronized void start() {
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}
