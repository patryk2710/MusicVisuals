package C18437596;

import processing.core.*;

// This is an example of a visual that uses the audio bands
public class BackgroundMovement
{
    MyVisual mv;

    public BackgroundMovement(MyVisual mv)
    {
        this.mv = mv; 
    }
    
    public void render()
    {
        float amplitude = 20*mv.getAmplitude();
        int currentamp = (int)amplitude;
        mv.stroke(mv.getCurrentColor() , 255, 150);
        float gap = 25;
        float x = 25;
        float y = 25;
        float w = mv.width-25;
        float h = mv.height-25;
        for(int i = 0; i < currentamp; i++) {
            // System.out.println(w);
            // mv.rect(x, y, w, h);
            // mv.rect(-x,-y, w, h);
            // System.out.println(w);
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