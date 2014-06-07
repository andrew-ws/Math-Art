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

void setup(){
  x0 = 1;
  y0 = 2;
  z0 = 100;
  step = 15000;
  stepSize = 0.01;
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

void draw(){
  
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


