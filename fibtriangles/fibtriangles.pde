import processing.pdf.*;

double phi = 1.6180339887498948482044586834;
double angle = Math.PI/5;
double rotangle = angle/2 + Math.PI/2;
int triScale = 300;

void drawTri(){
  triangle(0,0,(float) -phi*triScale/2,(float) (Math.sqrt(Math.pow(((phi+1)*triScale), 2)-(phi*phi*triScale*triScale/4))),
               (float) phi*triScale/2, (float) (Math.sqrt(Math.pow(((phi+1)*triScale), 2)-(phi*phi*triScale*triScale/4))));
}

void setup() {
  size(1000,1000);
  background(255);
  beginRecord(PDF, "triangles.pdf");
}

void draw(){
  translate(500,100);
  fill(200);
  for(int i = 1; i <= 10; i++) {
    stroke(0);
    drawTri();
    rotate((float) (-angle/2));
    translate(0.0,(float) (phi+1)*triScale);
    rotate((float) (rotangle+angle/2));
    scale((float) (1/phi));
  }
  endRecord();
}
