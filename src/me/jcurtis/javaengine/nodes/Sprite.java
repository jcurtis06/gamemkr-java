package me.jcurtis.javaengine.nodes;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class Sprite extends Node {
    private BufferedImage sprite;

    public Sprite(String resPath) {
        loadImage(resPath);
    }

    private void loadImage(String resPath) {
        try {
            sprite = ImageIO.read(new File(resPath));
        } catch (IOException exc) {
            System.out.println("Error opening image file: " + exc.getMessage());
        }
    }

    public void draw(Graphics g, ImageObserver observer) {
        g.drawImage(
                sprite,
                pos.x,
                pos.y,
                observer
        );
    }

    @Override
    public void onTreeEnter() {
        super.onTreeEnter();
        System.out.println("with the type Sprite");
    }
}
