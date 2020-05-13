package C18437596;

public class MyVisual extends Visual
{    
    BackgroundMovement bm;
    AudioBandsVisual abv;
    CubeVisual1 cv;

    public void settings()
    {
        //size(1024, 500);
        
        // Use this to make fullscreen
        //fullScreen();

        // Use this to make fullscreen and use P3D for 3D graphics
        fullScreen(P3D, SPAN); 
    }

    public void setup()
    {
        startMinim();
                
        // Call loadAudio to load an audio file to process 
        loadAudio();   
        //loadAudio("heroplanet.mp3");
        
        // Call this instead to read audio from the microphone
        //startListening(); 
        colorMode(HSB);
        //wf = new WaveForm(this);
        abv = new AudioBandsVisual(this);
        cv = new CubeVisual1(this);
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
