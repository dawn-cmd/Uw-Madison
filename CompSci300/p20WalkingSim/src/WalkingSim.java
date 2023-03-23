import java.util.Random;
import java.io.File;
import processing.core.PImage;

public class WalkingSim {

    private static Random randGen;
    private static int bgColor;
    private static PImage[] frames;
    private static Walker[] walkers;


    public static void mousePressed() {
        for (int i = 0; i < 8; ++i) {
            if (walkers[i] == null) {
                continue;
            }
            if (walkers[i].getPositionX() - frames[walkers[i].getCurrentFrame()].width / 2 < Utility.mouseX() &&
                    walkers[i].getPositionX() + frames[walkers[i].getCurrentFrame()].width / 2 > Utility.mouseX() &&
                    walkers[i].getPositionY() - frames[walkers[i].getCurrentFrame()].height / 2 < Utility.mouseY() &&
                    walkers[i].getPositionY() + frames[walkers[i].getCurrentFrame()].height / 2 > Utility.mouseY()) {
                walkers[i].setWalking(true);
            }
        }
    }

    public static void keyPressed(char option) {
        if (option == 'a' || option == 'A') {
            for (int i = 0; i < 8; ++i) {
                if (walkers[i] != null) {
                    continue;
                }
                walkers[i] = new Walker(randGen.nextInt(Utility.width()), randGen.nextInt(Utility.height()));
                return;
            }
        }
        if (option == 's' || option == 'S') {
            for (int i = 0; i < 8; ++i) {
                if (walkers[i] == null) {
                    continue;
                }
                walkers[i].setWalking(false);
            }
        }
    }

    public static void setup() {
        randGen = new Random();
        bgColor = randGen.nextInt();
        frames = new PImage[Walker.NUM_FRAMES];
        for (int i = 0; i < Walker.NUM_FRAMES; ++i) {
            frames[i] = Utility.loadImage("images" + File.separator + "walk-" + i + ".png");
        }
        walkers = new Walker[8];
        int numOfWalkers = randGen.nextInt(1, 8);
        for (int i = 0; i < numOfWalkers; ++i) {
            walkers[i] = new Walker(randGen.nextInt(Utility.width()), randGen.nextInt(Utility.height()));
        }
    }

    public static void draw() {
        Utility.background(bgColor);
        for (int i = 0; i < 8; i ++) {
            if (walkers[i] == null) {
                continue;
            }
            Utility.image(frames[walkers[i].getCurrentFrame()], walkers[i].getPositionX(), walkers[i].getPositionY());
            if (walkers[i].isWalking()) {
                walkers[i].setPositionX((walkers[i].getPositionX() + 3) % Utility.width());
                walkers[i].update();
            }
        }
    }

    public static void main(String[] args) {
        Utility.runApplication();
    }
}