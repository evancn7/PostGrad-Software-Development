import java.util.Scanner;
import java.lang.Math;

class GreatCircleDistance{
  public static void main(String[] args){
    Scanner s = new Scanner(System.in);
    double[] coords = new double[4]; // define array to hold coordinates
    int pos = 0; // tracks positon for insertion
    // while new input add coordinate to array but convert it to radians first
    while( pos < coords.length ) coords[pos++] = degToRad( s.nextDouble() );
    System.out.println( getDistance( coords ) );
    s.close();
    // System.out.println( round ( getDistance( coordinates ) ) );
  }
  static double getDistance(double[] coords){
    // coordinates are laid out as:  lat 1 , long 1 , lat 2 , long 2
    double deltaLong = coords[1] - coords[3];
    double theta =
    Math.acos(
    ( Math.sin(coords[0]) * Math.sin(coords[2]) ) +
    (( Math.cos(coords[0]) * Math.cos(coords[2]) ) * Math.cos( deltaLong ) )
     );
     double distance = 6371 * theta;
     return distance;
  }
  static double degToRad(double coordinate){ // convert the cords to radians
    return (coordinate * Math.PI) / 180;
  }
  static int round( double target ){
    int number = (int) target;  // convert double distance to integer
    int rem = number % 100;
    if ( rem < 50 ) return number - rem;
    else return number + (100 - rem);
  }
}
