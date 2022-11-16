#include "dbuscar.h"
#include <QDebug>
DBUscar::DBuscar(QWidget *parent): QDialog(parent){

setupUi(this);


}

voidDBuscar::slotEjemplo(){





}
void DBuscar::slotBtnBuscar(){
emit senyalBuscarAlante(QString("hola"));

}