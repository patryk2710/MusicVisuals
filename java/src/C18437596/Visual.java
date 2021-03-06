package C18437596;

import processing.core.PApplet;
import ddf.minim.*;
import ddf.minim.analysis.FFT;

public abstract class Visual extends PApplet
{
	private int frameSize = 512;
	private int sampleRate = 44100;

	private float[] bands;
	private float[] smoothedBands;

	private Minim minim;
	private AudioPlayer ap;
	private AudioBuffer ab;
	private FFT fft;

	private float amplitude  = 0;
	private float smothedAmplitude = 0;
	private float currentcolor = 0;

	private int currentcubeno = 1;
	private int currentcubeamount = 1;
	private boolean backgroundonoff = false;
	
	public void startMinim() 
	{
		minim = new Minim(this);

		fft = new FFT(frameSize, sampleRate);

		bands = new float[(int) log2(frameSize)];
  		smoothedBands = new float[bands.length];

	}

	float log2(float f) {
		return log(f) / log(2.0f);
	}

	protected void calculateFFT() throws VisualException
	{
		fft.window(FFT.HAMMING);
		if (ab != null)
		{
			fft.forward(ab);
		}
		else
		{
			throw new VisualException("You must call startListening or loadAudio before calling fft");
		}
			
	}

	
	public void calculateAverageAmplitude()
	{
		float total = 0;
		for(int i = 0 ; i < ab.size() ; i ++)
		{
			total += abs(ab.get(i));
		}
		amplitude = total / ab.size();
		smothedAmplitude = PApplet.lerp(smothedAmplitude, amplitude, 0.1f);
	}

	protected void calculateFrequencyBands() {	
		for (int i = 0; i < bands.length; i++) {
			int start = (int) pow(2, i) - 1;
			int w = (int) pow(2, i);
			int end = start + w;
			float average = 0;
			for (int j = start; j < end; j++) {
				average += fft.getBand(j) * (j + 1);
			}
			average /= (float) w;
			bands[i] = average * 5.0f;
			smoothedBands[i] = lerp(smoothedBands[i], bands[i], 0.05f);
			}
	}

	public void calculateCurrentColor() {
		if(fft.getBand(0) > 75) {
			currentcolor = currentcolor + 25;
			currentcubeamount = currentcubeamount + 1;
			if(currentcubeamount > 3) {
				currentcubeamount = 1;
			}
			if(currentcolor > 255) {
				currentcolor = 0;
			}
		} 
	}

	public void loadAudio()
	{
		ap = minim.loadFile("K_K_Cruisin.mp3", frameSize);
		ab = ap.left;
	}

	public void cubeNumber(int x) {
		currentcubeno = x;
	}

	public void toggleBackground() {
		backgroundonoff = !backgroundonoff;
	}

	public int getFrameSize() {
		return frameSize;
	}

	public void setFrameSize(int frameSize) {
		this.frameSize = frameSize;
	}

	public int getSampleRate() {
		return sampleRate;
	}

	public void setSampleRate(int sampleRate) {
		this.sampleRate = sampleRate;
	}

	public float[] getBands() {
		return bands;
	}

	public float[] getSmoothedBands() {
		return smoothedBands;
	}

	public Minim getMinim() {
		return minim;
	}

	public AudioBuffer getAudioBuffer() {
		return ab;
	}

	public float getAmplitude() {
		return amplitude;
	}

	public float getSmoothedAmplitude() {
		return smothedAmplitude;
	}

	public AudioPlayer getAudioPlayer() {
		return ap;
	}

	public float getCurrentColor() {
		return currentcolor;
	}

	public int getCubeAmount() {
		return currentcubeno;
	}

	public int getCurrentCubeAmount() {
		return currentcubeamount;
	}

	public boolean getBackgroundOnOff() {
		return backgroundonoff;
	}
}
