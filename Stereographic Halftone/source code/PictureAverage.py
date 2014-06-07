__author__ = 'Andrew'

def avg_square(pic, x_corner, y_corner, sample_edge, color_band):
    color_sum = 0
    for i in range(x_corner, x_corner + sample_edge):
        for j in range(y_corner, y_corner + sample_edge):
            color_sum += pic.getpixel((i,j))[color_band]
    return color_sum/(sample_edge**2)

def avg_matrix(pic, sample_edge, color_band):
    x_squares = pic.size[0]/sample_edge
    y_squares = pic.size[1]/sample_edge
    values = [[0 for x in range(y_squares)] for x in range(x_squares)]
    for i in range(x_squares):
        for j in range(y_squares):
            values[i][j] = avg_square(pic, i*sample_edge, j*sample_edge, sample_edge, color_band)
    return values

def avg_matrix_grey(pic, sample_edge):
    x_squares = pic.size[0] / sample_edge
    y_squares = pic.size[1] / sample_edge
    values = [[0 for x in range(y_squares)] for x in range(x_squares)]
    for i in range(x_squares):
        for j in range(y_squares):
            values[i][j] = avg_square_grey(pic, i * sample_edge, j * sample_edge, sample_edge)
    return values

def avg_square_grey(pic, x_corner, y_corner, sample_edge):
    color_sum = 0
    for i in range(x_corner, x_corner + sample_edge):
        for j in range(y_corner, y_corner + sample_edge):
            pixel = pic.getpixel((i,j))
            color_sum += (pixel[0]+pixel[1]+pixel[2])/3
    return color_sum/(sample_edge**2)