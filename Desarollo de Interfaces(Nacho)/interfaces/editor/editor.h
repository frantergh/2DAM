#ifndef EDITOR_H
#define EDITOR_H

#include <QDialog>
#include <QWidget>
#include <QTextEdit>
#include <QMainWindow>
#include <QMenu>
#include <QAction>
#include <QToolBar>
#include <QCloseEvent>
#include"dbuscar.h" 

// #include "ui_editor.h"

class Editor : public QMainWindow //, public Ui::Editor
{
    Q_OBJECT

public:
    Editor(QWidget *parent = NULL);
        

        //ACCIONES DE PUNTEROS.

    QTextEdit *editorCentral;
    QMenu *menuArchivo;
    QMenu *menuContectual;
    QAction *accionSalir;
    QAction *accionAbrir;
    QAction *accionGuardar;
    QAction *accionGuardarComo;
    QVector <QAction*> acciones;
    QAction dBuscar;
    QToolBar *barraHerramientas;
    Dbuscar *dBuscar;
void hacerMenus();
    bool modificado;
    QString ruta;
    bool escribirADisco(QString ruta);
    void hacerMenus();
    void closeEvent(QCloseEvent * );

public slots:
    void slotSalir();
    void slotAbrir();
    bool slotGuardar();
    bool slotGuardarComo();
    void slotModificado();
    void slotBuscar();
};

#endif