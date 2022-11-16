#include <QApplication>
#include <unistd.h>
#include <QLabel>
#include <QDialog>
#include "editor.h"

int main(int argc, char *argv[])
{
    QApplication app(argc, argv);
    Editor *editor = new Editor();
    editor->show();
    return app.exec();
}
