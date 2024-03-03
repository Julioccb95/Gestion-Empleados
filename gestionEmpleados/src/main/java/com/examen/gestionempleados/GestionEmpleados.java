/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.examen.gestionempleados;

import com.examen.gestionempleados.controlador.EmpleadoControlador;
import com.examen.gestionempleados.modelo.EmpleadoModelo;
import com.examen.gestionempleados.vista.EmpleadoVista;

/**
 *
 * @author julio
 */
public class GestionEmpleados {

    public static void main(String[] args) {
        EmpleadoModelo modelo = new EmpleadoModelo();
        EmpleadoVista vista = new EmpleadoVista();
        EmpleadoControlador controlador = new EmpleadoControlador(modelo, vista);
        
        controlador.agregarEmpleado("Juan", 1, 2000);
        controlador.agregarEmpleado("Sarahi", 2, 3000);
        controlador.agregarEmpleado("Luis", 3, 4000);
        
        vista.mostrarMenu(controlador);
    }
}
