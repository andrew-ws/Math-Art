__author__ = 'Andrew'


#definition for the model itself
class SCADModel:
    def __init__(self, filename):
        self.filename = filename
        self.file = open(self.filename, 'w')

    def __enter__(self, filename):
        self.filename = filename + ".scad"
        self.file = open(self.filename, 'w')

    def __exit__(self, exc_type, exc_val, exc_tb):
        self.file.flush()
        self.file.close()

    def write(self, scad_object):
        self.file.write(scad_object.string + "\n")

    def close(self):
        self.file.flush()
        self.file.close()


#abstract definition for a SCAD object
class SCADObject:
    def __init__(self):
        self.string = ""

    #returns the object's representative string
    def __str__(self):
        return self.string

    def __unicode__(self):
        return self.string

    #takes union of two objects using +
    def __add__(self, other):
        scad_sum = SCADObject()
        scad_sum.string = ("union(){\n"+self+"\n"+other+"\n}\n")
        return scad_sum

    #takes difference of two objects using -
    def __sub__(self, other):
        scad_sub = SCADObject()
        scad_sub.string = ("difference(){\n"+self+"\n"+other+"\n}\n")
        return scad_sub

    #takes intersection of two objects using ^
    def __xor__(self, other):
        scad_int = SCADObject()
        scad_int.string = ("intersection(){\n"+self+"\n"+other+"\n}\n")
        return scad_int

    #translates an object
    def translate(self, x, y, z):
        old_string = self.string
        self.string = ("translate(["+str(x)+","+str(y)+","+str(z)+"]){\n"+old_string+"\n}\n")
        return self

    #scales an object
    def scale(self, x, y, z):
        old_string = self.string
        self.string = ("scale([" + str(x) + "," + str(y) + "," + str(z) +"]){\n" + old_string + "\n}\n")
        return self


#union for >2 objects
def union(object_list):
    scad_union = SCADObject()
    scad_union.string = ("union(){\n")
    for scad_object in object_list:
        scad_union.string += scad_object.string + "\n"
    scad_union.string += "}\n"
    return scad_union

def union2d(object_list):
    scad_union = SCADObject()
    scad_union.string = ("union(){\n")
    for scad_row in object_list:
        for scad_object in scad_row:
            scad_union.string += scad_object.string + "\n"
    scad_union.string += "}\n"
    return scad_union

#difference for >2 objects
def difference(object_list):
    scad_diff = SCADObject()
    scad_diff.string = ("difference(){\n")
    for object in object_list:
        scad_diff.string += object.string + "\n"
    scad_diff.string += "}\n"
    return scad_diff

#intersection for >2 objects
def intersection(object_list):
    scad_int = SCADObject()
    scad_int.string = ("intersection(){\n")
    for object in object_list:
        scad_int.string += object.string + "\n"
    scad_int.string += "}\n"
    return scad_int

#extrudes an object to a point
def point_extrude(shape, height):
    scad_ext = SCADObject()
    scad_ext.string = ("linear_extrude(height="+str(height)+", center=true, scale = 0.000001){\n"+shape.string+"\n}\n")
    return scad_ext

#box definition
class SCADBox(SCADObject):
    def __init__(self, size_tup):
        self.string = "cube(["+str(size_tup[0])+","+str(size_tup[1])+","+str(size_tup[2])+"], center=true);"


#sphere definition
class SCADSphere(SCADObject):
    def __init__(self, radius):
        self.string = "sphere(r="+str(radius)+");"

#cone definition
class SCADCone(SCADObject):
    def __init__(self, rtop, rbottom, height):
        self.string = "cylinder(h="+str(height)+", r1="+str(rtop)+", r2="+str(rbottom)+", center=true);"

#circle definition
class SCADCircle(SCADObject):
    def __init__(self, radius):
        self.string = "square("+str(radius)+", center = true);"

class SCADSkewCone(SCADObject):
    def __init__(self, radius, x, y, xtop, ytop, height):
        cone = point_extrude(SCADCircle(radius).translate(x-xtop, y-ytop, 0), height).translate(xtop, ytop, 0)
        self.string = cone.string


