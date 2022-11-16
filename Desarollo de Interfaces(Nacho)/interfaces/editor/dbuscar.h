#ifndef DBUSCAR_H
#define DBUSCAR_H

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
#include <QCheckBox>
#include "ui_dBuscar.h"

// #include "ui_editor.h"

class DBuscar : public QDialog, public Ui::DBuscar
{
    Q_OBJECT

public:
    DBuscar(QWidget *parent = NULL);

    QTextEdit *leBuscar;
    QCheckBox *chMayus;
    QCheckBox *chAtras;
    QPushButton *btnBuscar;
    QPushButton *btnCerrar;





};

#endif