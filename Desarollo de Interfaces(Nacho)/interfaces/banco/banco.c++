#include <stdlib.h>
#include <iostream>
using namespace std;

#define BORRARPANTALLA           \
    for (int i = 0; i < 10; i++) \
        cout << endl;

#define TAMVECTOR 5
string nombres[TAMVECTOR] = {"juan", "perico", "andres", "fulano", "vengao"};
string numCuentas[TAMVECTOR] = {"100", "101", "102", "103", "103"};
class NUumCuenta{

string entidad;
string sucursal;
string dc;
string numCuentAfinal;


};
class Cuenta
{
public:
    float saldo;
    string numCuenta;
    string titular;

    Cuenta(string titular2, string numCuenta2)
    {
        titular = titular2;
        numCuenta = numCuenta2;
        saldo = 0;
    }

    Cuenta()
    {
    }

    void ingresar(float cantidad)
    {
        saldo += cantidad;
    }

    bool retirar(float cantidad)
    {
        if (saldo <= cantidad)
        {
            return false;
        }
        else
        {
            saldo -= cantidad;
            return true;
        }
    }

    float getSaldo()
    {
        return saldo;
    }
};
void mostrar(Cuenta cuentaMostrar)
{
    cout << cuentaMostrar.numCuenta << "\t " << cuentaMostrar.titular << "\t " << cuentaMostrar.saldo << "$" << endl;
}

void ingresoCuenta(Cuenta *cI)
{
    float cantidad;
    cout << "introduce la cantidad a ingresar: ";
    cin >> cantidad;
    cI->ingresar(cantidad);
}

Vector<Cuenta> cuentas2{
    Cuenta c;
    cuentas2.pushBack(c);
    cuentas2[4] ;



}

void retirarCuenta(Cuenta &cI)
{
    float cantidad;
    cout << "introduce la cantidad a retirar: ";
    cin >> cantidad;
    cI.retirar(cantidad);
    mostrar(cI);
}

Cuenta *cuentas[5];

void mostrarCuentas(Cuenta *cuentasM[TAMVECTOR])
{
    for (int i = 0; i < TAMVECTOR; i++)
    {
        if (cuentasM[i] != NULL)
        {
            cout << cuentasM[i]->numCuenta << "\t";
        }
    }
    cout << endl;

    for (int i = 0; i < TAMVECTOR; i++)
    {
        if (cuentasM[i] != NULL)
        {
            cout << cuentasM[i]->titular << "\t";
        }
    }
    cout << endl;

    for (int i = 0; i < TAMVECTOR; i++)
    {
        if (cuentasM[i] != NULL)
        {
            cout << cuentasM[i]->saldo << "$ \t";
        }
    }
    cout << endl;
}

void inicializar(Cuenta *cuentasP[TAMVECTOR])
{

    for (int i = 0; i < 5; i++)
    {
        cuentas[i] = new Cuenta();
        cuentas[i]->saldo = 0;
        cuentas[i]->titular = nombres[i];
        cuentas[i]->numCuenta = numCuentas[i];
    }
}

void menu()
{

    BORRARPANTALLA
    cout << "    	1 - Elegir Cuenta " << endl;
    cout << "    	2 - Ingresar " << endl;
    cout << "    	3 - Reintegrar " << endl;
    cout << "    	4 - Ver saldo " << endl;
    cout << "    	b - Borrar Cuenta " << endl;
    cout << "    	g - Agregar Cuentas " << endl;
    cout << "    	5 - Salir a MSDOS " << endl;
}
void borar(Cuenta * cuentasP[TAMVECTOR],
                    Cuenta * cBorrar ) {

                 if (cuentasP ==
                           // cuentasP.)
   //Cuenta *p;
    //delete p;
        //CuentaP[i] = NULL;
//}

//void añadirCuenta(){


//
}

void seleccionarCuenta(Cuenta *cuentaActual, Cuenta *cuentasS[TAMVECTOR])
{
    string numCuenta;

    cout << "Introduce el numero de la cuenta a seleccionar: " << endl;
    cin >> numCuenta;
    bool esta = false;
    for (int i = 0; i < TAMVECTOR; i++)
    {
        if ((*cuentasS[i]).numCuenta == numCuenta)
        {
            cuentaActual = cuentasS[i];
            mostrar(*cuentaActual);
            esta = true;
        }
    }
    if (!esta)
    {
        cout << "Esta cuenta no existe " << endl;
    }
}
bool retirarCuenta ( Cuenta *cR){
float cantidad;

cout << "cantidad a retirar: ";
cin >> cantidad;
if(cR !=NULL) 
    if(cR-> retirar(cantidad) )
    return true;
return false;


}

int main(int argc, char const *argv[])
{
inicializarV(cuentasV);
mostrarTodasCuentasV(cuentasV);

return 0;

char opcion = '0'

    for (int i = 0; i < TAMVECTOR; i++)
    {
        cuentas[i] = NULL;
    }

    inicializar(cuentas);
    mostrarCuentas(cuentas);
    char opcion = '0';

    Cuenta *cuentaActual;

    while (opcion != '5')
    {
        menu();
        cin >> opcion;

        switch (opcion)
        {
        case '1':
            seleccionarCuenta(cuentaActual, cuentas);
            break;

        case '2':
            /* code */
            break;

        case '3':
            /* code */
            break;

        case '4':
            /* code */
            break;

        case 'b':
            /* code */
            break;

        case 'g':
            /* code */
            break;

        case '5':
            cout << "FIN" << endl;
            // exit(0); acaba el programa
            break;

        default:
            break;
        };
    };
}
