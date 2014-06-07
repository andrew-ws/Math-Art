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
}
