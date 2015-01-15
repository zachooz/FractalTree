import java.lang.*;
private double fractionLength = .8; 
private int smallestBranch = 2; 
private double branchAngle = 0;  
private float theWeight = 1;
private int theLength = 1;
private float incrementer = 1.4;
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
	if(theLength<185){
		theLength++;
		theWeight+=.05;
		if(bL)
			branchAngle+=0.1;
		else
			branchAngle-=0.1;
	} else {
		noLoop();
	}
} 
public void drawBranches(int x,int y, double branchLength, double angle, float weight) {  
	strokeWeight(weight);
	weight=(float)(weight/1.5);   
	if(branchLength > smallestBranch){
		line(x, y, (float)(x + (branchLength*Math.cos(angle))), (float)(y + (branchLength*Math.sin(angle))));
		drawBranches((int)(x + (branchLength*Math.cos(angle))),(int)(y + (branchLength*Math.sin(angle))), branchLength/incrementer, angle+branchAngle+Math.random(),weight);
		drawBranches((int)(x + (branchLength*Math.cos(angle))),(int)(y + (branchLength*Math.sin(angle))), branchLength/incrementer, angle-branchAngle-Math.random()/5,weight); 
	}
} 
