__author__ = 'Andrew'
from PySCAD import *
from PictureAverage import *
from PIL import Image

filename = "lichtenstein.jpg"
filename_out = "lichtenstein.scad"
radius = 25
spacing = 15
sample_edge = 50
thickness = 2
hole_radius = 5
pic = Image.open(filename, mode='r')
model_width = (pic.size[0] * spacing) / sample_edge
model_height = (pic.size[1] * spacing) / sample_edge


def halftone_band(band_num, x_top, y_top):
    cones = make_cones(avg_matrix(pic, sample_edge, band_num), x_top, y_top)
    cones_obj = union2d(cones)
    return difference([SCADSphere(radius).translate(x_top, y_top, 0), SCADSphere(radius-thickness).translate(x_top, y_top, 0), SCADSphere(hole_radius).translate(x_top,y_top,radius), cones_obj])

def make_cones(values, x_top, y_top):
    cones = [[0 for n in range(pic.size[1]/sample_edge)] for n in range(pic.size[0]/sample_edge)]
    for i in range(pic.size[0]/sample_edge):
        for j in range(pic.size[1]/sample_edge):
            x_pos = i*spacing - model_width/2
            y_pos = j*spacing - model_height/2
            cones[i][j] = SCADSkewCone(values[i][j]/20, x_pos, y_pos, x_top, y_top, radius*8).translate(0,0,-radius*3)
    return cones


model = SCADModel(filename_out)
model.write(union([halftone_band(0, 0, 40), halftone_band(1, 50, -40), halftone_band(2, -50, -40)]))
model.close()