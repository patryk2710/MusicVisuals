package C18437596;

import processing.core.*;

public class CubeVisual1
{
    MyVisual mv;

    public CubeVisual1(MyVisual mv)
    {
        this.mv = mv;
    }
    float angle = 0;

    public void render()
    {
        int cubeAmount = mv.getCubeAmount();
        mv.stroke(mv.getCurrentColor() , 255, 255);
        int CurrentCubeAmount = mv.getCurrentCubeAmount();
        mv.strokeWeight(4);
        mv.noFill();
        mv.lights();
        
        if(cubeAmount == 4) {
            if(CurrentCubeAmount == 1) {
                mv.pushMatrix();
                mv.camera(0, 0, 0, 0, 0, -1, 0, 1, 0);
                mv.translate(0, 0, -200);
                mv.rotateX(angle);
                mv.rotateZ(angle);       
                float boxSizeW = 0.6f*mv.getSmoothedBands()[0];
                float boxSizeH = 0.2f*mv.getSmoothedBands()[4];
                float boxSizeD = 0.3f*mv.getSmoothedBands()[7];
                if(boxSizeW > 125) {
                    boxSizeW = 125;
                }
                if(boxSizeH > 125) {
                    boxSizeH = 125;
                }
                if(boxSizeD > 125) {
                    boxSizeD = 125;
                } 
                mv.box(boxSizeW,boxSizeH,boxSizeD);
                mv.popMatrix();
            } else {
                float gap = 150;
                for(int i = -1; i < 3-1; i++) {
                    mv.pushMatrix();
                    mv.camera(0, 0, 0, 0, 0, -1, 0, 1, 0);
                    mv.translate(gap*i, 0, -200);
                    mv.rotateX(angle);
                    mv.rotateZ(angle);       
                    float boxSizeW = 0.3f*mv.getSmoothedBands()[0];
                    float boxSizeH = 0.05f*mv.getSmoothedBands()[4];
                    float boxSizeD = 0.15f*mv.getSmoothedBands()[7];
                    if(boxSizeW > 125) {
                        boxSizeW = 125;
                    }
                    if(boxSizeH > 125) {
                        boxSizeH = 125;
                    }
                    if(boxSizeD > 125) {
                        boxSizeD = 125;
                    } 
                    mv.box(boxSizeW,boxSizeH,boxSizeD);  
                    mv.popMatrix();
                }
            }
        } else if(cubeAmount == 1) {
            mv.pushMatrix();
            mv.camera(0, 0, 0, 0, 0, -1, 0, 1, 0);
            mv.translate(0, 0, -200);
            mv.rotateX(angle);
            mv.rotateZ(angle);       
            float boxSizeW = 0.6f*mv.getSmoothedBands()[0];
            float boxSizeH = 0.2f*mv.getSmoothedBands()[4];
            float boxSizeD = 0.3f*mv.getSmoothedBands()[7];
            if(boxSizeW > 125) {
                boxSizeW = 125;
            }
            if(boxSizeH > 125) {
                boxSizeH = 125;
            }
            if(boxSizeD > 125) {
                boxSizeD = 125;
            } 
            mv.box(boxSizeW,boxSizeH,boxSizeD);   
            mv.popMatrix();
        } else {
            float gap = 150;
            for(int i = -1; i < cubeAmount-1; i++) {
                mv.pushMatrix();
                mv.camera(0, 0, 0, 0, 0, -1, 0, 1, 0);
                mv.translate(gap*i, 0, -200);
                mv.rotateX(angle);
                mv.rotateZ(angle);       
                float boxSizeW = 0.3f*mv.getSmoothedBands()[0];
                float boxSizeH = 0.05f*mv.getSmoothedBands()[4];
                float boxSizeD = 0.15f*mv.getSmoothedBands()[7];
                if(boxSizeW > 125) {
                    boxSizeW = 125;
                }
                if(boxSizeH > 125) {
                    boxSizeH = 125;
                }
                if(boxSizeD > 125) {
                    boxSizeD = 125;
                } 
                mv.box(boxSizeW,boxSizeH,boxSizeD);
                mv.popMatrix();
            }
        }
        angle += 0.01f;
    }
}