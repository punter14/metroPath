# metroPath
Small Java program to find shortest path between two metro stations

Input configuration file is data.txt, where different metro lines are added to configuration.
Structure of input file (data.txt) is as below

<Line #>|<Station_Name>_<Color>|<Station_Name>_<Color>|<Station_Name>_<Color>|<Station_Name>_<Color>...........

Below is a sample
Line 1|A|B|C|D|E|F
Line 2|A|B|C|G_Green|H_Red|I_Green|F

On execution of main class, InitiateMetroSearch, it will ask for input parameters of 
1) Start station
2) Destination
3) Color (optional) - can be left blank
