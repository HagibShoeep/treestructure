/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treestructure;

import java.util.ArrayList;
import static java.util.Collections.list;

public class TreeStructure {

    public static void main(String[] args) throws Exception {
        LinearHahTable bublesort = new LinearHahTable(10);

        bublesort.insert("yelow", "car");
        bublesort.insert("blue", "car");
        bublesort.insert("white", "tank");
        bublesort.insert("red", "motor");
        bublesort.insert("geeen", "cell");

        bublesort.printHashTable();

    }
}
