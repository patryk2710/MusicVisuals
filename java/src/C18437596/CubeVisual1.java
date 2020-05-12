package C18437596;

import processing.core.*;

public class CubeVisual1
{
    MyVisual mv;

    public CubeVisual1(MyVisual mv)
    {
        this.mv = mv;
    }
    float angle = 0;

    public void render()
    {
        mv.stroke(mv.getCurrentColor() , 255, 255);
        mv.strokeWeight(4);
        mv.noFill();
        mv.lights();
        mv.pushMatrix();

        mv.camera(0, 0, 0, 0, 0, -1, 0, 1, 0);
        mv.translate(0, 0, -200);
        mv.rotateX(angle);
        mv.rotateZ(angle);       
        float boxSize =(360 * mv.getSmoothedAmplitude());
        if(boxSize > 125) {
            boxSize = 125;
        } 
        mv.box(boxSize);   
        mv.popMatrix();

        angle += 0.01f;
    }


}