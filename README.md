# IdealoTask
These are the details regarding tasks. I pick the task 3 which is the following below. The project is completely dockerize with a public image available on docker hub please use the command <b>docker pull aqibbutt3078/toyrobot:image</b> to pull the image, if you like to run it from docker shell.
# Task 3

Code problem details:
- The application is a simulation of a toy robot moving on a square tabletop, of
dimensions 5 x 5 units.
- There are no other obstructions on the table surface.
- The robot is free to roam around the surface of the table, but must be prevented from
falling to destruction. Any movement that would result in the robot falling from the table must
be prevented, however further valid movement commands must still be allowed.
Create an application that can read in commands of the following form:
- PLACE X,Y,F
- MOVE
- LEFT
- RIGHT
- REPORT
PLACE will put the toy robot on the table in position X,Y and facing NORTH,
SOUTH, EAST or WEST. The origin (0,0) can be considered to be the SOUTH WEST
most corner.
MOVE will move the toy robot one unit forward in the direction it is currently facing.
LEFT and RIGHT will rotate the robot 90 degrees in the specified direction without
changing the position of the robot.
REPORT will announce the X,Y and F of the robot. 
Constraints:
- The application must be a Spring-Boot-Application
- Input must be realised over the REST-API, take care when designing the REST-API
- The robot that is not on the table can choose the ignore the MOVE, LEFT, RIGHT
and REPORT commands.
- The robot must not fall off the table during movement. This also includes the initial
placement of the toy robot.
- Any move that would cause the robot to fall must be ignored.
- It is not required to provide any graphical output showing the movement of the toy
robot. 
Deliverables: 
- the whole project, example requests to test a robot-application in form of PostmanCollection or in form of a text file.
