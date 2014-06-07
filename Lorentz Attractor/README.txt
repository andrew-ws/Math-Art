Lorentz Attractor

This project maps the Lorentz Attractor in 3-space, with interactivity/time variance on parameters and viewing angle. It is easily extensible to other equations that can be solved numerically, but I wanted to focus on manipulating parameters, so I stuck to the Lorentz Attractor. It would be interesting to try out differnet equations or to explore more of the parameter space, perhaps including places where the equation goes to infinity.

The actual application packages require Java 7 to load, double click on the application file in each folder, move the mouse over the image to change things when relevant, and click close in the bottom left to close. These only work on mac unfortunately, but I was pretty sure your office computer was a mac? If that's not convenient let me know and I can try to repackage them. The source files are also included, including a java version of the source, if that's easier to read. There are some errant comments and such that I forgot to take out.

Contents:
lorentzSpin: Mouse interaction changes the viewing angle on the equation model.
lorentzPhase: The parameters change on a loop, where each loop has a different phase. No mouse interaction.
lorentzParam1: Moving the mouse changes the parameters (one maps to x position, one maps to y position, and one is constant)
lorentzParam2: Same as above, but the controlled parameters are different
lorentzParam3: Same as above, but controlled parameters are different and all three are controlled (two by x position, one by y)
