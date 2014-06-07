import processing.pdf.*;

int[][] brightMatrix;
int tileSize;
int sampleSize;
PImage img;

void setup() {
  size(1440, 900);
  tileSize = 6;
  sampleSize = 8;
  img = loadImage("desktop.jpg");
  size(tileSize * (int)(img.width / sampleSize), tileSize * (int)(img.height / sampleSize));
  brightMatrix = new int[img.width/sampleSize][img.height/sampleSize];
  img.loadPixels();
  int bright;
  for (int i = 0; i < img.width/sampleSize; i++){
    for (int j = 0; j < img.height/sampleSize; j++){
      bright = sampleAvg(i*sampleSize,j*sampleSize,sampleSize);
      brightMatrix[i][j] = bright;
    }
  }
  beginRecord(PDF, "desktop.pdf");
}

void draw() 
{
  noStroke();
  ellipseMode(CORNER);
  background(0);
  for (int i = 0; i < img.width/sampleSize; i++){
    for (int j = 0; j < img.height/sampleSize; j++){
      ellipse(i*tileSize,j*tileSize,0.05*brightMatrix[i][j],0.05*brightMatrix[i][j]);
    }
  }
  endRecord();
}

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
