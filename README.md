# Fractals

Design and implementation of a software that would plot two of the most popular fractals: Mandelbrot set and Julia set. 
Fractals are infinity many, self-similar shapes formed by some simple mathematical computations. The computation varies from fractal set to set but are generally based on complex numbers.

Specification:

We have a area (with some dimension) to plot the pattern. This area will
contain pixels and will be fixed for 800x800 pixels. For each point it is checked whether the point is in the
set specified by the user and color is assigned accordingly. 
The program accepts arguments; at least one which would specify what set to plot. If
the set selected is Mandelbrot the user should give either 0, 4 or 5 arguments. If there are 0 arguments
then use the default values will be selected. 4 arguments will be the region of interest in
the complex plane and the 5th one is the number of iterations to do for a point.
