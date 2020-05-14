package C18437596;

import processing.core.*;

// Background squares to make a background animation if on
public class BackgroundMovement
{
    MyVisual mv;

    public BackgroundMovement(MyVisual mv)
    {
        this.mv = mv; 
    }
    
    public void render()
    {
        boolean background = mv.getBackgroundOnOff();
        if(background == true) {
            float amplitude = 20*mv.getAmplitude();
            int currentamp = (int)amplitude;
            mv.stroke(mv.getCurrentColor() , 255, 200);
            float gap = 25;
            float x = 25;
            float y = 25;
            float w = mv.width-25;
            float h = mv.height-25;
            for(int i = 0; i < currentamp; i++) {
                mv.line(x,y,w,y);
                mv.line(x,y,x,h);
                mv.line(w,y,w,h);
                mv.line(x,h,w,h);
                x = x + gap;
                y = y + gap;
                w = w - gap;
                h = h - gap;
            }
        }
    }
}