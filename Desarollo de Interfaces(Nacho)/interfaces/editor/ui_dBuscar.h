/********************************************************************************
** Form generated from reading UI file 'dBuscar.ui'
**
** Created by: Qt User Interface Compiler version 5.12.8
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_DBUSCAR_H
#define UI_DBUSCAR_H

#include <QtCore/QVariant>
#include <QtWidgets/QApplication>
#include <QtWidgets/QCheckBox>
#include <QtWidgets/QDialog>
#include <QtWidgets/QHBoxLayout>
#include <QtWidgets/QLabel>
#include <QtWidgets/QLineEdit>
#include <QtWidgets/QPushButton>
#include <QtWidgets/QVBoxLayout>

QT_BEGIN_NAMESPACE

class Ui_DBuscar
{
public:
    QHBoxLayout *horizontalLayout_2;
    QVBoxLayout *verticalLayout_3;
    QHBoxLayout *horizontalLayout;
    QLabel *label;
    QLineEdit *leBuscar;
    QVBoxLayout *verticalLayout;
    QCheckBox *chMayus;
    QCheckBox *chAtras;
    QVBoxLayout *verticalLayout_2;
    QPushButton *btnBuscar;
    QPushButton *btnCerrar;

    void setupUi(QDialog *DBuscar)
    {
        if (DBuscar->objectName().isEmpty())
            DBuscar->setObjectName(QString::fromUtf8("DBuscar"));
        DBuscar->resize(393, 187);
        horizontalLayout_2 = new QHBoxLayout(DBuscar);
        horizontalLayout_2->setObjectName(QString::fromUtf8("horizontalLayout_2"));
        verticalLayout_3 = new QVBoxLayout();
        verticalLayout_3->setObjectName(QString::fromUtf8("verticalLayout_3"));
        horizontalLayout = new QHBoxLayout();
        horizontalLayout->setObjectName(QString::fromUtf8("horizontalLayout"));
        label = new QLabel(DBuscar);
        label->setObjectName(QString::fromUtf8("label"));

        horizontalLayout->addWidget(label);

        leBuscar = new QLineEdit(DBuscar);
        leBuscar->setObjectName(QString::fromUtf8("leBuscar"));

        horizontalLayout->addWidget(leBuscar);


        verticalLayout_3->addLayout(horizontalLayout);

        verticalLayout = new QVBoxLayout();
        verticalLayout->setObjectName(QString::fromUtf8("verticalLayout"));
        chMayus = new QCheckBox(DBuscar);
        chMayus->setObjectName(QString::fromUtf8("chMayus"));

        verticalLayout->addWidget(chMayus);

        chAtras = new QCheckBox(DBuscar);
        chAtras->setObjectName(QString::fromUtf8("chAtras"));

        verticalLayout->addWidget(chAtras);


        verticalLayout_3->addLayout(verticalLayout);


        horizontalLayout_2->addLayout(verticalLayout_3);

        verticalLayout_2 = new QVBoxLayout();
        verticalLayout_2->setObjectName(QString::fromUtf8("verticalLayout_2"));
        btnBuscar = new QPushButton(DBuscar);
        btnBuscar->setObjectName(QString::fromUtf8("btnBuscar"));

        verticalLayout_2->addWidget(btnBuscar);

        btnCerrar = new QPushButton(DBuscar);
        btnCerrar->setObjectName(QString::fromUtf8("btnCerrar"));

        verticalLayout_2->addWidget(btnCerrar);


        horizontalLayout_2->addLayout(verticalLayout_2);


        retranslateUi(DBuscar);

        QMetaObject::connectSlotsByName(DBuscar);
    } // setupUi

    void retranslateUi(QDialog *DBuscar)
    {
        DBuscar->setWindowTitle(QApplication::translate("DBuscar", "Dialog", nullptr));
        label->setText(QApplication::translate("DBuscar", "Buscar: ", nullptr));
        chMayus->setText(QApplication::translate("DBuscar", "Mayusculas/minusculas", nullptr));
        chAtras->setText(QApplication::translate("DBuscar", "CheckBox", nullptr));
        btnBuscar->setText(QApplication::translate("DBuscar", "Buscar", nullptr));
        btnCerrar->setText(QApplication::translate("DBuscar", "Cerrar", nullptr));
    } // retranslateUi

};

namespace Ui {
    class DBuscar: public Ui_DBuscar {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_DBUSCAR_H
