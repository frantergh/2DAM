#include "editor.h"
#include <QMenuBar>
#include <QTextDocument>
#include <QMessageBox>
#include <QFileDialog>
#include <QFile>
#include <QDebug>
#include <QTextStream>
#include <QTextBlock>
#include <QCloseEvent>

Editor::Editor(QWidget *parent) : QMainWindow(parent)
{
    resize(800, 600);
    editorCentral = new QTextEdit();

    this->setCentralWidget(editorCentral);

    setWindowIcon(QIcon("./imagenes/cat.png"));

    hacerMenus();

    modificado = false;
    ruta = "";

    connect(editorCentral, SIGNAL(textChanged()), this, SLOT(slotModificado()));
}

void Editor::hacerMenus()
{

    menuArchivo = new QMenu("Archivo");

    QMenuBar *barra = new QMenuBar();
    barra->addMenu(menuArchivo);

    accionSalir = new QAction("Salir");
    accionSalir->setIcon(QIcon("./imagenes/cat.png"));
    accionSalir->setShortcut(QString("Ctrl+q"));
    accionSalir->setStatusTip("Salir del programa");
    accionSalir->setToolTip("Salir del programa");

    accionAbrir = new QAction("Abrir");
    accionAbrir->setIcon(QIcon("./imagenes/cat.png"));
    accionAbrir->setShortcut(QString("Ctrl+o"));
    accionAbrir->setStatusTip("Abrir Archivo");
    accionAbrir->setToolTip("Abrir Archivo");

    accionGuardar = new QAction("Guardar");
    accionGuardar->setIcon(QIcon("./imagenes/cat.png"));
    accionGuardar->setShortcut(QString("Ctrl+o"));
    accionGuardar->setStatusTip("Guardar Archivo");
    accionGuardar->setToolTip("Guardar Archivo");

    accionGuardarComo = new QAction("GuardarComo");
    accionGuardarComo->setIcon(QIcon("./imagenes/cat.png"));
    accionGuardarComo->setShortcut(QString("Ctrl+o"));
    accionGuardarComo->setStatusTip("Guardar Archivo Como");
    accionGuardarComo->setToolTip("Guardar Archivo Como");

//menudEditar->addAction(accionBUscar) foto en el movil

    connect(accionSalir, SIGNAL(triggered()), this, SLOT(slotSalir()));
    connect(accionAbrir, SIGNAL(triggered()), this, SLOT(slotAbrir()));
    connect(accionGuardar, SIGNAL(triggered()), this, SLOT(slotGuardar()));
    connect(accionGuardarComo, SIGNAL(triggered()), this, SLOT(slotGuardarComo()));
    menuArchivo->addAction(accionSalir);
    menuArchivo->addAction(accionAbrir);
    menuArchivo->addAction(accionGuardar);
    menuArchivo->addAction(accionGuardarComo);

    editorCentral->addAction(accionSalir);
    editorCentral->addAction(accionAbrir);
    editorCentral->addAction(accionGuardar);
    editorCentral->addAction(accionGuardarComo);
    editorCentral->setContextMenuPolicy(Qt::ActionsContextMenu);

    barraHerramientas = new QToolBar();
    barraHerramientas->addAction(accionSalir);
    barraHerramientas->addAction(accionAbrir);
    barraHerramientas->addAction(accionGuardar);
    barraHerramientas->addAction(accionGuardarComo);
    addToolBar(barraHerramientas);
}

void Editor::slotSalir()
{
    close();
}

void Editor::slotAbrir()
{
    if (modificado)
    {

        int respuesta1 = QMessageBox::warning(this, QString("Abrir Documento"), QString("Achivo modificado, que hago?"), QMessageBox::Ok | QMessageBox::Cancel);

        if (respuesta1 == QMessageBox::Cancel)
        {
            return;
        }
        if (respuesta1 == QMessageBox::Ok)
        {
            slotGuardar();
        }
    }

    QString rutaArchivo = QFileDialog::getOpenFileName(this, QString("Abrir Archivo"), "/home/ubuntu/", QString("Ficheros de texto (*.txt)"));

    if (rutaArchivo.isEmpty())
    {
        return;
    }

    qDebug() << "Vas a abrir el archivo " << rutaArchivo;

    QFile fichero(rutaArchivo);

    if (!fichero.open(QIODevice::ReadOnly))
    {
        QMessageBox::critical(this, QString("Problema gordo"), QString("No podemos tocar el archivo"), QMessageBox::Ok);
        return;
    }

    QTextDocument *documento = editorCentral->document();

    documento->clear();

    QTextStream flujo(&fichero);

    while (!flujo.atEnd())
    {
        QString linea = flujo.readLine();
        editorCentral->append(linea);
    }
    ruta = rutaArchivo;
    modificado = false;
}

bool Editor::slotGuardar()
{

    qDebug() << "" << ruta;
    if (ruta.isEmpty())
    {
        return slotGuardarComo();
        
    }
    return escribirADisco(ruta);
    
}

bool Editor::slotGuardarComo()
{

    QString rutaArchivo = QFileDialog::getSaveFileName(this, tr("Guardar Como"), ".", tr("Texto (*.txt *.doc *.info)"));
    qDebug() << "" << rutaArchivo;
    return escribirADisco(rutaArchivo);
}

bool Editor::escribirADisco(QString rutaArchivo)
{
    QFile fichero(rutaArchivo);
    if (!fichero.open(QIODevice::WriteOnly))
    {
        QMessageBox::critical(this, QString("Problema gordo"), QString("No podemos Guardar el archivo"), QMessageBox::Ok);
        return false;
    }
    QTextStream flujo(&fichero);

    for (int i = 0; i < editorCentral->document()->blockCount(); i++)
    {
        QString cadena = editorCentral->document()->findBlockByNumber(i).text();
        flujo << cadena << endl;
    }

    ruta = rutaArchivo;
    qDebug() << "Vas a Guardar el archivo " << ruta;
    modificado = false;
    return true;
}

void Editor::slotModificado()
{
    modificado = true;
}

void Editor::closeEvent(QCloseEvent *event)
{
    

    if (modificado)
    {
        int respuesta = QMessageBox::warning(this, QString("Cerrar Documento"), QString("Guardar archivo modificado, que hago?"), QMessageBox::Ok | QMessageBox::Cancel);

        if (respuesta == QMessageBox::Cancel)
        {
            qDebug() << "Salir";
            
            return;

        }
        if (respuesta == QMessageBox::Ok)
        {
            if (!slotGuardar())
            {
                event->ignore();
                qDebug() << "No Salir";
                return;

            }  else {
                qDebug() << "Salir";
                return;
            }
            
            
        }
    }
    event->accept();
}
void Editor::slotBuscar(){

}
