package C18437596;

public class MyVisual extends Visual
{    
    BackgroundMovement bm;
    AudioBandsVisual abv;
    CubeVisual cv;

    public void settings()
    {
        // Using fullscreen and p3d graphics
        fullScreen(P3D, SPAN); 
    }

    public void setup()
    {
        startMinim();
                
        // Call loadAudio to load an audio file to process 
        loadAudio();   
         
        colorMode(HSB);

        abv = new AudioBandsVisual(this);
        cv = new CubeVisual(this);
        bm = new BackgroundMovement(this);
    }

    public void mousePressed() {
        getAudioPlayer().cue(0);
        getAudioPlayer().play();
    }

    public void keyPressed() {
        if(key == '1') {
            cubeNumber(1);
        }
        if(key == '2') {
            cubeNumber(2);
        }
        if(key == '3') {
            cubeNumber(3);
        }
        if(key == '4') {
            cubeNumber(4);
        }
        if(key == 'b') {
            toggleBackground();
        }
    }

    public void draw()
    {
        background(0);
        try
        {
            // Call this if you want to use FFT data
            calculateFFT(); 
        }
        catch(VisualException e)
        {
            e.printStackTrace();
        }
        // Call this is you want to use frequency bands
        calculateFrequencyBands(); 

        // Call this is you want to get the average amplitude
        calculateAverageAmplitude();     
        
        // Called to change color based on low value
        calculateCurrentColor();

        bm.render();
        abv.render();
        cv.render();
    }
}
