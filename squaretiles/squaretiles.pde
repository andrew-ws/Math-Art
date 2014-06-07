import processing.pdf.*;

class Tile {
  int brightness;
  int xpos;
  int ypos;
  int orient;
  int size;
  
  Tile(int xin, int yin, int sizein, int orin, int brightin) {
    xpos = xin;
    ypos = yin;
    brightness = brightin;
    orient = orin;
    size = sizein;
  }
  
  void display(){
    rectMode(CORNER);
    fill(0);
    rect(xpos, ypos, size, size);
    fill(255);
    if (orient == 0) {
      quad(xpos,ypos,xpos+size,ypos,xpos+size/2+brightness,ypos+size/2+brightness,xpos,ypos+size);
    }
    if (orient == 1) {
      quad(xpos+size/2-brightness,ypos+size/2+brightness,xpos,ypos,xpos+size,ypos,xpos+size,ypos+size);
    }
    if (orient == 2) {
      quad(xpos,ypos,xpos+size/2+brightness,ypos+size/2-brightness,xpos+size,ypos+size,xpos,ypos+size);
    }
    if (orient == 3) {
      quad(xpos+size,ypos,xpos+size/2-brightness,ypos+size/2-brightness,xpos,ypos+size,xpos+size,ypos+size);
    }
  }
}

Tile[][] tileMatrix;
PImage img;
int sampleSize;
int tileSize;

int sampleAvg(int xCorn, int yCorn, int sSize) {
  int sampleSum = 0;
  for (int k = 0; k < sSize; k++){
    for (int l = 0; l < sSize; l++){
      int pNum = (yCorn+k) * img.width + xCorn + l;
      //print(brightness(img.pixels[pNum]));
      sampleSum += brightness(img.pixels[pNum]);
    }
  }
  return sampleSum/(sSize*sSize);
}

void setup() {
  tileSize = 30;
  sampleSize = 4;
  img = loadImage("nosferatu.jpg");
  size(tileSize * (int)(img.width / sampleSize), tileSize * (int)(img.height / sampleSize));
  tileMatrix = new Tile[img.width/sampleSize][img.height/sampleSize];
  img.loadPixels();
  int bright;
  for (int i = 0; i < img.width/sampleSize; i++){
    for (int j = 0; j < img.height/sampleSize; j++){
      bright = sampleAvg(i*sampleSize,j*sampleSize,sampleSize);
      tileMatrix[i][j] = new Tile(i*tileSize,j*tileSize,tileSize,(i%2 + (2 * (j%2))),((int) ((bright-127)*(tileSize*0.37)/127)));
    }
  }
  beginRecord(PDF, "nosferatu.pdf");
}

void draw() {
  background(100);
  for (Tile[] thisTileRow : tileMatrix){
    for (Tile thisTile : thisTileRow){
      thisTile.display();
    }
  }
  endRecord();
}
