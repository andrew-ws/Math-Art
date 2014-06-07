import processing.pdf.*;

double phi = 1.6180339887498948482044586834;
int rectScale = 600;
float[] rrr;
float[] ggg;
float[] bbb;
int its;

void drawRect() {
  rect(0,0, (float) phi*rectScale, rectScale);
}

void setup(){
  its = 15;
  size((int) (phi*rectScale),rectScale);
  background(230);
  rrr = new float[its];
  ggg = new float[its];
  bbb = new float[its];
  for(int j = 0; j<its;j++){
    rrr[j] = random(255);
    ggg[j] = random(255);
    bbb[j] = random(255);
  }
  beginRecord(PDF, "squares.pdf");
}

void draw(){
  float rr;
  float gg;
  float bb;
  for(int i = 0; i<its;i++){
    rr = rrr[i];
    gg = ggg[i];
    bb = bbb[i];
    //fill((200 - i*12),(15-i)*(15-i)*0.5,i*i*7);
    fill(rr,gg,bb);
    drawRect();
    translate(rectScale,rectScale);
    rotate(radians(-90));
    scale((float) (1/phi));
  }
  endRecord();
}
