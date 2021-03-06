package C18437596;

import processing.core.*;

// Audio Circles at the bottom to make an equalizer like animation
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
        
        mv.noStroke();
        for(int i = 1 ; i < mv.getBands().length-1 ; i ++)
        {
            mv.fill(color , 255, 200);
            mv.ellipse((i*gap)+gap2, mv.height, gap*1.5f, -mv.getSmoothedBands()[i] * 0.3f); 
        }
        mv.ellipse(gap2,mv.height, gap*1.5f, -mv.getSmoothedBands()[0] * 1.2f);
        mv.ellipse((gap*mv.getBands().length)-gap2, mv.height, gap*1.5f, -mv.getSmoothedBands()[mv.getBands().length-1] * 1.9f);
    }
}