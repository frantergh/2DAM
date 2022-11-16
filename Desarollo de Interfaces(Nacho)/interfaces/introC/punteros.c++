#include <iostream>
using namespace std;

 void incrementar (int  *direccion){
 *direccion = *direccion +1;
 
 }
 
 int * maximo(int *num1, num2){
 
 if(*num1 > *num2)
 return num1;
 {
 return num2;
 }
 
 } 
 
int main (int argc, char *argv[]){

int i=9; //es un entero
int j=10;

int *max;
 max = maximo (&j, &i);
 *max = *max + 1;
 //int *pi;

 //*pi=&i;

  cout << " i vale" << i << endl;
  //incrementar(&i);
  cout << " j vale" << j << endl;
  
 // cout << " i esta en la pos " << &i << endl;
 // cout << " i esta en la pos " << pi << endl;

}
