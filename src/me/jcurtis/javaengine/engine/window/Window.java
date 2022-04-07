package me.jcurtis.javaengine.engine.window;

import javax.swing.*;
import me.jcurtis.javaengine.engine.JavaEngine;
import me.jcurtis.javaengine.engine.input.Input;


public class Window {
    String title;
    boolean resizeable;

    int width;
    int height;

    public static Viewport viewport;

    public Window(String title, boolean resizeable, int width, int height) {
        this.title = title;
        this.resizeable = resizeable;

        this.width = width;
        this.height = height;
    }

    public JFrame init(JavaEngine engine) {
        JFrame window = new JFrame(title);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        window.setSize(this.width, this.height);
        window.setResizable(this.resizeable);
        window.setLocationRelativeTo(null);
        window.setVisible(true);

        viewport = new Viewport(engine);
        window.add(viewport);
        window.addKeyListener(new Input());

        return window;
    }
}
