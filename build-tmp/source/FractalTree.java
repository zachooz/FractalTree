import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.lang.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class FractalTree extends PApplet {


private double fractionLength = .8f; 
private int smallestBranch = 2; 
private double branchAngle = 0;  
private float theWeight = 1;
private int theLength = 1;
private float incrementer = 1.4f;
private boolean bL= true;
public void setup(){   
	size(600,600);    
	frameRate(30); 
} 
public void draw(){   
	background(0);   
	stroke(255);
	if(branchAngle>1)
		bL=false;
	if(branchAngle<-1)
		bL=true;
	drawBranches(width/2,height, theLength, -Math.PI/2, theWeight);
	if(theLength<178){
		theLength++;
		theWeight+=.05f;
		if(bL)
			branchAngle+=0.1f;
		else
			branchAngle-=0.1f;
	} else {
		noLoop();
	}
} 
public void drawBranches(int x,int y, double branchLength, double angle, float weight) {  
	strokeWeight(weight);
	weight=(float)(weight/1.5f);   
	if(branchLength > smallestBranch){
		line(x, y, (float)(x + (branchLength*Math.cos(angle))), (float)(y + (branchLength*Math.sin(angle))));
		drawBranches((int)(x + (branchLength*Math.cos(angle))),(int)(y + (branchLength*Math.sin(angle))), branchLength/incrementer, angle+branchAngle+Math.random(),weight);
		drawBranches((int)(x + (branchLength*Math.cos(angle))),(int)(y + (branchLength*Math.sin(angle))), branchLength/incrementer, angle-branchAngle-Math.random()/5,weight); 
	}
} 
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "FractalTree" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
