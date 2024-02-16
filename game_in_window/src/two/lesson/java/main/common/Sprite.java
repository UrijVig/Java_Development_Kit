package two.lesson.java.main.common;

import java.awt.*;

public abstract class Sprite implements Interactable{
    protected float x, y, halfWidth, halfHeight;

    protected float getLeft() {
        return x - halfWidth;
    }

    protected void setLeft(float left) {
        x = left + halfWidth;
    }

    protected float getRight() {
        return x + halfWidth;
    }

    protected void setRight(float right) {
        x = right - halfWidth;
    }

    protected float getTop() {
        return y - halfHeight;
    }

    protected void setTop(float top) {
        y = top + halfHeight;
    }

    protected float getBottom() {
        return y + halfHeight;
    }

    protected void setBottom(float bottom) {
        y = bottom - halfHeight;
    }

    protected float getWidth() {
        return 2f * halfWidth;
    }

    protected float getWHeight() {
        return 2f * halfHeight;
    }
    @Override
    public void update(MainCanvas canvas, float deltaTime) {
    }
    @Override
    public void render(MainCanvas canvas, Graphics g) {
    }

}
