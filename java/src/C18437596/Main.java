package C18437596;

import example.CubeVisual1;
import example.MyVisual;
import example.RotatingAudioBands;

public class Main
{	

	public void startUI()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new CubeVisual1());		
	}

	public static void main(String[] args)
	{
		Main main = new Main();
		main.startUI();			
	}
}