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
int rr;
int gg;
int bb;

void setup(){
  rr = 100;
  gg = 200;
  bb = 0;
  x0 = 1;
  y0 = 2;
  z0 = 1;
  step = 15000;
  stepSize = 0.01;
  sig = 0;
  roh = 0;
  bet = 0;
  size(1000,800,P3D);
  background(0);
  noStroke();
  xRot = PI/4;
  yRot = PI/4;
  zRot = 0;
  lights();
  fill(255,150);
  beginCamera();
  camera(0,0,1000,0,0,0,0,-1,0);
  rotateX(xRot);
  rotateY(yRot);
  rotateZ(zRot);
  endCamera();
}
//this is just generally messed up

void draw(){
  //sig = -mouseX/50.0;
  roh = mouseX/50.0;
  bet = mouseY/50.0;
  background(0);
  lor = new Lorentz(x0,y0,z0,step,stepSize,(sig%20)+10,(roh%40)+28,(bet%4)+3);
  coords = lor.get();
  for(float[] coords1 : coords){
    //print("|");
    //print(coords1[0]+","+coords1[1]+","+coords1[2]);
    pushMatrix();
    translate((coords1[0] - x0)*10,(coords1[1] - y0)*10,-10*(coords1[2] - z0));
    box(2);
    popMatrix();
  }
}
