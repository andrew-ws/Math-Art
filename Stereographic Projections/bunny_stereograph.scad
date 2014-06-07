intersection(){
  difference(){
    sphere(r=100);
    sphere(r=95);
    translate([0,0,100]){
      sphere(r=23);
    }
  }
  difference(){
  linear_extrude(height=200, center=true, scale=0.0001){
    scale([25,25,0]){
      import("bunny.dxf");
    }
  }/*
  linear_extrude(height=200, center=true, scale=0.0001){
    scale([3,3,0]){
      import("bunny.dxf");
    }
  }*/
  }
}
