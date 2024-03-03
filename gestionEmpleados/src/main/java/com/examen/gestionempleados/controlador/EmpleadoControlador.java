/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examen.gestionempleados.controlador;

import com.examen.gestionempleados.modelo.Empleado;
import com.examen.gestionempleados.modelo.EmpleadoModelo;
import com.examen.gestionempleados.vista.EmpleadoVista;

/**
 *
 * @author julio
 */
public class EmpleadoControlador {
    private EmpleadoModelo modelo;
    private EmpleadoVista vista;

    public EmpleadoControlador() {
    }
    
    public EmpleadoControlador(EmpleadoModelo modelo, EmpleadoVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }
    
    public void agregarEmpleado(String nombre, int id, double salario){
        modelo.agregarEmpleado(nombre, id, salario);
    }
    
    public void mostrarSalarioPromedio() {
        double salarioPromedio = modelo.calcularSalarioPromedio();
        vista.mostrarInformacion("\nSalario promedio de los empleados: " + salarioPromedio);
    }

    public void mostrarEmpleadoConSalarioMaximo() {
        Empleado empleadoMaximo = modelo.obtenerEmpleadoConSalarioMaximo();
        if (empleadoMaximo != null){
            vista.mostrarInformacion("\nEmpleado con el salario más alto: " + empleadoMaximo.getNombre() + " - Salario: " + empleadoMaximo.getSalario());
        }else{vista.mostrarInformacion("\nNo hay empleados registrados\n");
            
        }
        
    }

    public void mostrarEmpleadoConSalarioMinimo() {
        Empleado empleadoMinimo = modelo.obtenerEmpleadoConSalarioMinimo();
        if (empleadoMinimo != null){
            vista.mostrarInformacion("\nEmpleado con el salario más bajo: " + empleadoMinimo.getNombre() + " - Salario: " + empleadoMinimo.getSalario());
        } else{
            vista.mostrarInformacion("\nNo hay empleados registrados.");
        }
        
    }

    public void buscarEmpleadoPorId(int id) {
        Empleado empleado = modelo.buscarEmpleadoPorId(id);
        if (empleado != null) {
            vista.mostrarInformacion("Información del empleado encontrado:\nNombre: " + empleado.getNombre() + "\nID: " + empleado.getId() + "\nSalario: " + empleado.getSalario());
        } else {
            vista.mostrarInformacion("No se encontró ningún empleado con el ID proporcionado.");
        }
    }
    public boolean validarIdDuplicado(int id){
        Empleado empleado = modelo.buscarEmpleadoPorId(id);
        return empleado != null;
    }
    
}
