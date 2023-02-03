#include <vector>
#include <iostream>

bool isValidWalk(std::vector<char> walk) {

  // maybe position should become a coordinate pair, represented by a struct, 
  // that will return true if its values are (0, 0)...
  struct position {
    int lon;
    int lat;
  };

  // initialize struct position to a new variable, pos
  position pos;
  pos.lon = 0;
  pos.lat = 0;

  // check if walk will take exactly ten minutes before even evaluating directions 
  if (walk.size() != 10) {
    return false;
  } else {
   for (int i = 0; i < walk.size(); i ++) {

     // if direction is North, add one to longitude, else subtract one
     if (walk[i] == 'n') {
       pos.lon += 1;
     } else if (walk[i] == 's') {
       pos.lon = pos.lon - 1;
     }
    }

   // look at the pos.lon and pos.lat to see if that pair would return true
   std::cout << pos.lon << ", " << pos.lat << "\n";

   // if direction is East, add one to latitude, else subtract one
  for (int j = 0; j < walk.size(); j++) {

     if (walk[j] == 'e') {
       pos.lat += 1;
     } else if (walk[j] == 'w') {
       pos.lat = pos.lat - 1;
     }

     // look at pos.lat to see if pair would return true
     std::cout << pos.lon << ", " << pos.lat << "\n";
    }

  // print final pair, should be "(0, 0)", then return conditional
  std::cout << "( " << pos.lon << ", " << pos.lat << " )" << "\n";
  return pos.lon == 0 && pos.lat == 0;
  }
}

int main() {

  std::vector<char> test = {'n', 's', 'n', 's', 'n', 's', 'n', 's', 'n', 's'};
  isValidWalk(test);
}
