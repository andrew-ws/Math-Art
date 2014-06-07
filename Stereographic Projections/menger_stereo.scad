intersection(){
  difference(){
    cube(200, center = true);
    cube(190, center = true);
    translate([0,0,100]){
      sphere(r=23);
    }
  }
  difference(){
  linear_extrude(height=200, center=true, scale=0.0001){
    scale([8,8,0]){
      import("simple_menger.dxf");
    }
  }
}}