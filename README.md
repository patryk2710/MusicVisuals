# Music Visualiser Project

Name: Patryk Rojowiec

Student Number: C18437596

# Description of the assignment
A music visualiser made in processing. This program takes a soundfile as input and then reads the audio's properties in order to create a sound reactive animation. This creates multiple objects on the screen that work in harmony to make a great looking musical experience.

# Instructions
Clone the repository and then ./compile and ./run from inside the /java folder.
The program takes multiple inputs. To initially launch, and reset the music, press left mouse button anywhere on the screen.
- By pressing 1,2 or 3 on the keyboard the corresponding number of squares will appear on the screen.
- Pressing 4 will put you into square auto mode where the number of squares will adjust automatically according to the low frequencies.
- Pressing b will toggle the background squares on and off.

# How it works
The program begins doing things from the MyVisual class. Inside this class there is the setup function, which initialises all the separate renderer functions. There is also the interaction functions mousePressed() and keyPressed() along with function calls to run all the necessary renders and calculations.
When an object of for example, CubeVisual, is created in the setup function it is sent an argument referencing the myVisual class. This is the way we can call PApplet functions inside of a class that doesnt extend PApplet. In the constructor method we initialise an object of type MyVisual to be the reference to the argument MyVisual.
This way we can call mv.stroke(). This calls the PApplet function using the object mv. The other classes work on the same principle.
The calculations inside MyVisual are continuously called from the draw() function. This is how we can call the getter function from inside the render() function of the drawer classes and make the music animation happen in harmony.
The drawing methods CubeVisual, AudioBandsVisual and BackgroundMovement then use these values inside them to draw sound based graphics.
```Java 
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
``` 
Part of the code from inside the AudioBandsVisual class. This shows how the colour and height of the bottom ovals is adjusted based on the mv.getCurrentColor() value and mv.getSmoothedBands() value respectively.




# What I am most proud of in the assignment
I am most proud in this assignment is the harmony that using the low frequencies to change color and, if using setting 4, the square amount achieves. I feel that making the color and squares change whenever the bass drops to be a very satisfying experience. Looking at it for me is quite enjoyable. 
It took a bit of thinking and learning about the properties of sound to be able to implement this. It required me to make changes in the Visual class by creating a method "calculateCurrentColor" that will calculate whenever the lowest frequency band reaches a certain value. Whenever this value is exceeded, it would increment a
visual private counter integer that would then be accordingly called inside the render() functions in the cubeVisual and AudioBandsVisual classes. 
```Java
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
```
The code for the function is very simple but does the job nicely. Increment the counter whenever the value of band(0), the lowest frequency band, exceeds 75. If the value for the color is greater than the maximum hue value then it loops back around.

Another part that I am proud of is the squares themselves changing their different parameters based on different bands of the frequency spectrum. This creates a very nice visualisation of the cube where is changes thickness, width and height based around bands 0, 4 and 7. This makes the cube be very fluid and dynamic.
This is a youtube video of my visualisation :

[![YouTube](https://img.youtube.com/vi/MG2pDhNbrkU/0.jpg)](https://www.youtube.com/watch?v=MG2pDhNbrkU)

