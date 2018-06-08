package game.background;

import base.GameObject;
import renderer.BackgroundRenderer;

import javax.swing.*;
import java.awt.*;

public class Background extends GameObject {

    public Background() {
        this.renderer = (renderer.Renderer) new BackgroundRenderer(1024, 600, Color.BLACK);
    }
}