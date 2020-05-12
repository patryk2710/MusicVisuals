package C18437596;

import processing.core.*;

// This is an example of a visual that uses the audio bands
public class SongMenu
{
    MyVisual mv;

    public SongMenu(MyVisual mv)
    {
        this.mv = mv; 
    }

    public void render()
    {
        float x = mv.width - 200;
        float y = 50;
        float color = mv.getCurrentColor();
        mv.stroke(color , 255, 255);
        for(int i = 0; i < 3; i++) {
            mv.rect(x,(y * i)+50, 190, y);
        }
    }
}