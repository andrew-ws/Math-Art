import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class threeddotter extends PApplet {

float x0;
float y0;
float z0;
Lorentz lor;
int step;
float stepSize;
float sig;
float roh;
float bet;
float[][] coords;
float xRot;
float yRot;
float zRot;

public void setup(){
  x0 = 1;
  y0 = 2;
  z0 = 100;
  step = 15000;
  stepSize = 0.01f;
  sig = 30;
  roh = 84;
  bet = 8;
  lor = new Lorentz(x0,y0,z0,step,stepSize,sig,roh,bet);
  coords = lor.get();
  size(1000,800,P3D);
  background(0);
  noStroke();
  xRot = 0;
  yRot = 0;
  zRot = PI;
  lights();
  fill(255,150);
}
//this is just generally messed up

public void draw(){
  
  //xRot += 0.1;
  //yRot += 0.1;
  //zRot += 0.1;
  zRot = mouseX*PI*2/width;
  xRot = mouseY*PI*2/height;
  background(0);
  beginCamera();
  camera(0,0,2000,0,0,0,0,-1,0);
  rotateX(xRot);
  rotateY(yRot);
  rotateZ(zRot);
  endCamera();
  //lor.display();
  
  for(float[] coords1 : coords){
    //print("|");
    //print(coords1[0]+","+coords1[1]+","+coords1[2]);
    pushMatrix();
    translate((coords1[0] - x0)*10,(coords1[1] - y0)*10,-10*(coords1[2] - z0));
    box(3);
    popMatrix();
  }
}


class Lorentz{
  float x;
  float y;
  float z;
  float sigma;
  float roh;
  float beta;
  float[][] coords;
  float stepSize;
  
  Lorentz(float x0,float y0,float z0,int stepIn,float stepSizeIn,float sigmaIn,float rohIn,float betaIn){
    x = x0;
    y = y0;
    z = z0;
    stepSize = stepSizeIn;
    sigma = sigmaIn;
    roh = rohIn;
    beta = betaIn;
    coords = new float[stepIn][3];
    for(int i = 0; i<stepIn; i++){
      coords[i] = this.lGet();
    }
  }
  
  /*
  float[] getNoEval(){
    float[] coords1 = new float[3];
    coords1[0] = x;
    coords1[1] = y;
    coords1[2] = z;
    return coords1;
  }
  */
  
  public float[] lGet(){
    x += stepSize*sigma * (y-x);
    y += stepSize*(x * (roh - z) - y);
    z += stepSize*(x * y - beta * z);
    float[] coords1 = new float[3];
    coords1[0] = x;
    coords1[1] = y;
    coords1[2] = z;
    return coords1;
  }
  
  public float[][] get(){
    return coords;
  }
  
  public void display(){
    //int rr = 0;
    //int gg = 0;
    //int bb = 0;
    for(float[] coords1 : coords){
      //fill((rr % 200)+56, (gg % 200)+56, (bb % 200)+56);
      //print("|");
      //print(coords1[0]+","+coords1[1]+","+coords1[2]);
      pushMatrix();
      translate((coords1[0] - x0)*10,(coords1[1] - y0)*10,-10*(coords1[2] - z0));
      box(3);
      popMatrix();
      //rr++;
      //gg++;
      //bb++;
    }
  }
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--full-screen", "--bgcolor=#666666", "--stop-color=#cccccc", "threeddotter" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
