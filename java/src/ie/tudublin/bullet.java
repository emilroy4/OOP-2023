package ie.tudublin;

import processing.core.PApplet;
import processing.core.PVector;

public class bullet {
    PVector pos;
    float speed;
    PVector forward;
    PApplet p;
}

public bullet(float x, float y, PApplet p) {
    pos = new PVector(x, y);
    forward = new PVector(0, -1);
    speed = 5;
    this.p = p;
    this.rot = rot;
}

void render()   {
    p.pushMatrix();
    p.translate(pos.x,pos.y);
    p.rotate(rot);
    p.line(0,-5,-,5);
    p.popMatrix();
}