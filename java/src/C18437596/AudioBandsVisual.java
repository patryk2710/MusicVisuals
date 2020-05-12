package C18437596;

import processing.core.*;

// This is an example of a visual that uses the audio bands
public class AudioBandsVisual
{
    MyVisual mv;

    public AudioBandsVisual(MyVisual mv)
    {
        this.mv = mv; 
    }

    public void render()
    {
        float gap = mv.width / (float) mv.getBands().length;
        float gap2 = (mv.width / (float) mv.getBands().length) / 2;
        float color = mv.getCurrentColor();
        System.out.println(color);
        mv.noStroke();
        for(int i = 0 ; i < mv.getBands().length ; i ++)
        {
            mv.fill(color , 255, 255);
            mv.ellipse((i*gap)+gap2, mv.height, gap, -mv.getSmoothedBands()[i] * 0.5f); 
        }
    }
}