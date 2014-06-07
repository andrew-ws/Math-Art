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
  
  float[] lGet(){
    x += stepSize*sigma * (y-x);
    y += stepSize*(x * (roh - z) - y);
    z += stepSize*(x * y - beta * z);
    float[] coords1 = new float[3];
    coords1[0] = x;
    coords1[1] = y;
    coords1[2] = z;
    return coords1;
  }
  
  float[][] get(){
    return coords;
  }
  
  void display(){
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
