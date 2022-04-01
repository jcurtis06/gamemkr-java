package me.jcurtis.javaengine.engine.window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;

import me.jcurtis.javaengine.engine.JavaEngine;
import me.jcurtis.javaengine.engine.input.Input;
import me.jcurtis.javaengine.engine.nodes.Node;
import me.jcurtis.javaengine.engine.nodes.NodeType;
import me.jcurtis.javaengine.engine.nodes.Sprite;

public class Viewport extends JPanel implements ActionListener, KeyListener {
    private Timer timer;
    private JavaEngine engine;

    public Viewport(JavaEngine engine) {
        this.engine = engine;
        timer = new Timer(5, this);
        timer.start();

        setFocusable(true);
        requestFocus();
        addKeyListener(new Input());
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;



        AffineTransform at = new AffineTransform();
        at.scale(engine.mainCamera.scale.x, engine.mainCamera.scale.y);

        g2d.transform(at);

        for (Node node : JavaEngine.nodes) {
            if (node.getType() == NodeType.SPRITE) {
                Sprite sprite = (Sprite) node;
                sprite.draw(g, this);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        engine.update();
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        System.out.println("HELLO");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("HELLO");
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        System.out.println("HELLO");
    }
}
