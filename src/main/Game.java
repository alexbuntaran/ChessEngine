package main;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import utils.Board;
import utils.Constants;
import utils.Display;
import utils.PieceManager;

public class Game implements Runnable {

    private final long DELTA_TIME = 1000;

    private Thread thread;
    private boolean running;

    private Display display;
    private BufferStrategy bs;
    private Graphics g;

    private Board board;
    private PieceManager pm;

    public Game() {
        display = new Display();
        board = new Board();
        pm = new PieceManager();
        running = false;
    }

    private void init() {
        display.initialize();
        display.getCanvas().createBufferStrategy(Constants.NUMBER_OF_BUFFERS);
        bs = display.getCanvas().getBufferStrategy();
        pm.addPieces();
    }

    private void update() {
        // update
        pm.update();
    }

    private void render() {
        g = bs.getDrawGraphics();
        g.clearRect(0, 0, Constants.FRAME_WIDTH, Constants.FRAME_HEIGHT);
        // draw board
        board.drawBoard(g);
        pm.render(g);
        // draw pieces
        bs.show();
        g.dispose();
    }

    @Override
    public void run() {
        init();
        long target = System.currentTimeMillis() + DELTA_TIME;
        while (running) {
            if (System.currentTimeMillis() - target > 0) {
                update();
                render();
                target = System.currentTimeMillis() + DELTA_TIME;
            }
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
