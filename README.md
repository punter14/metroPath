# metroPath

## description
Small Java program to find shortest path between two metro stations

Input configuration file is data.txt, where different metro lines are added to configuration.

## Usage
Below is a sample structure of input file (data.txt)

Line 1|A|B|C|D|E|F

Line 2|A|B|C|G_Green|H_Red|I_Green|F

On execution of main class, InitiateMetroSearch, it will ask for input parameters of 
1) Start station
2) Destination
3) Color (optional) - can be left blank

If you wish to execute and wish to see the output for inputs in github itself, then please edit metroPath/.github/workflows/maven.yml

Replace the existing parameters "pedro de valdivia" "las mercedes" "red" with desired parameters
  1) arg_0 - From_Station
  2) arg_1 - To_Station
  3) arg_2 - Line_Color (optional)

File data.txt (metroPath/src/main/java/metrosearch/main/) is loaded with santiago de chile metro lines , if you wish to change the metro configuration, you can change the input in data.txt

Once the maven.yml is updated with desired inputs

1) Please goto tab Actions
2) Please select workflow "Java CI with Maven"
3) Select "Run workflow" option

Once run manually, after the build is run... you can click on recent workflow run and then on build to see the output of the program run with desired inputs

you can see it in this step **Running the program**, as below


Below is the shortest path 
PEDRO DE VALDIVIA->LOS LEONES->INÉS DE SUÁREZ->ÑUÑOA->ESTADIO NACIONAL->ÑUBLE->CARLOS VALDOVINOS->SAN JOAQUÍN->MIRADOR->BELLAVISTA DE LA FLORIDA->VICENTE VALDÉS->TRINIDAD->LOS QUILLAYES->ELISA CORREA->HOSPITAL SÓTERO DEL RÍO->LAS MERCEDES

Need to change metro lines 3 times at <LOS LEONES> <ÑUBLE> <VICENTE VALDÉS> 
