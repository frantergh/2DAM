#include <iostream>
using namespace std;

string nombres[5] = {"juan", "perico", "andres", "fulano", "vengao"};
string numCuentas[5] = {"100", "101", "102", "103", "103"};
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
    // SCANER DE JAVA EN C
    cin >> cantidad;
    // (*cI).ingresar(cantidad); es igual que lo de baix
    cI->ingresar(cantidad);
    mostrar(*cI);
}

void retirarCuenta(Cuenta &cI)
{
    float cantidad;
    cout << "introduce la cantidad a retirar: ";
    cin >> cantidad;
    cI.retirar(cantidad);
    mostrar(cI);
}

Cuenta cuentas[5];

void mostrarCuentas(Cuenta cuentasM[5])
{
    for (int i = 0; i < 5; i++)
    {
        cout << cuentasM[i].numCuenta << "\t";
    }
    cout << endl;

    for (int i = 0; i < 5; i++)
    {
        cout << cuentasM[i].titular << "\t";
    }
    cout << endl;

    for (int i = 0; i < 5; i++)
    {
        cout << cuentasM[i].saldo << "$ \t";
    }
    cout << endl;
}

void inicializar(Cuenta cuentasP[5])
{
    for (int i = 0; i < 5; i++)
    {
        cuentas[i].saldo = 0;
        cuentas[i].titular = nombres[i];
        cuentas[i].numCuenta = numCuentas[i];
    }
}

int main(int argc, char const *argv[])
{

    cuentas[0].ingresar(1000);
    cuentas[1].titular = "pepe";
    cuentas[2].numCuenta = "111";

    inicializar(cuentas);
    //mostrarCuenta(cuentas);
}
