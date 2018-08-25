package oop.innerclasses;

import oop.interfaces.Pizza;

import java.util.Collection;

public class Display {

    private static final int DISPLAY_HIGHT = 1920;
    private static final int DISPLAY_WIDTH = 1280;

    public Display() {
        Pixel pixel = new Pixel(10, 10, Color.BLUE);
    }

    private class Pixel {
        private int x;
        private int y;
        private Color color;

        private Pixel(int x, int y, Color color) {
            if (x >= 0 && x <= DISPLAY_WIDTH && y >= 0 && y <= DISPLAY_HIGHT) {
                this.x = x;
                this.y = y;
                this.color = color;
                System.out.println("Creating " + color + " pixel at x:" + this.x + " y:" + this.y);
            } else {
                throw new IllegalArgumentException ("Coordinates X and Y should be between 0-"+DISPLAY_WIDTH +
                " and 0-"+DISPLAY_HIGHT);
            }
        }
    }

    public enum Color {
        RED, GREE, BLUE, CYAN, MAGENTA, YELLOW, BLACK
    }
}
