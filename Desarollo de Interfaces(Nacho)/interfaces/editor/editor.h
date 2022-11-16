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
#include <QVector>
#include <QStringList>
#include "dbuscar.h"
// #include "ui_editor.h"

class Editor : public QMainWindow //, public Ui::Editor
{
    Q_OBJECT

public:
    Editor(QWidget *parent = NULL);

    QTextEdit *editorCentral;
    QMenu *menuArchivo;

    QMenu *menuContectual;
    QAction *accionSalir;
    QAction *accionAbrir;
    QAction *accionGuardar;
    QAction *accionGuardarComo;

    QAction *accionBuscar;
    QToolBar *barraHerramientas;

    bool modificado;
    QString ruta;

    QVector<QAction*> acciones;

    DBuscar *dBuscar;

    QStringList listaArchivosRecientes;

    bool escribirADisco(QString ruta);
    void leerDisco(QString);
    void hacerMenus();
    void closeEvent(QCloseEvent * );
    void anadirArchivoMenu(QString ruta);

public slots:
    void slotSalir();
    void slotAbrir();
    bool slotGuardar();
    bool slotGuardarComo();
    void slotModificado();
    void slotReciente();
    void slotBuscar();
};

#endif