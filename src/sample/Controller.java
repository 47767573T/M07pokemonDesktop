package sample;

import sample.DataBaseManagement.DBMmanager;

public class Controller {

    public static void main(String[] args) {
        DBMmanager dbm = new DBMmanager();

        dbm.createDB("caca");

    }
}
