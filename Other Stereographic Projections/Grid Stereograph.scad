intersection(){
	difference(){
		sphere(r=50);
		sphere(r=48);
		translate([0,0,50]){
			sphere(r=18);
		}
	}
	union(){
		for(i=[-10:10]){
			linear_extrude(height=100, center=true, scale=0.001){
				translate(v = [0,20*i,0]){
					square([400,5], center=true);
				}
			}
		}
		for(i=[-10:10]){
			linear_extrude(height=100, center=true, scale=0.001){
				translate(v = [20*i,0,0]){
					square([6,400], center=true);
				}
			}
		}
	}
}
