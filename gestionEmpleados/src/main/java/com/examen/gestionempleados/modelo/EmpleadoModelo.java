/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examen.gestionempleados.modelo;

import java.util.ArrayList;

/**
 *
 * @author julio
 */
public class EmpleadoModelo {
    private ArrayList<Empleado> empleados;

    public EmpleadoModelo() {
        empleados = new ArrayList();
    }

    
    public EmpleadoModelo(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }
    
    public void agregarEmpleado(String nombre, int id, double salario){
        empleados.add(new Empleado(nombre, id, salario));
    }
    
    public double calcularSalarioPromedio(){
        double totalSalarios = 0;
        for(Empleado empleado : empleados){
            totalSalarios += empleado.getSalario();
        }
        return totalSalarios / empleados.size();
    }
    
    public Empleado obtenerEmpleadoConSalarioMaximo(){
        Empleado empleadoMaximo = null;
        double salarioMaximo = Double.MIN_VALUE;
        for(Empleado empleado : empleados){
            if (empleado.getSalario() > salarioMaximo){
                salarioMaximo = empleado.getSalario();
                empleadoMaximo = empleado;
            }
        }
        return empleadoMaximo;
    }
    
    public Empleado obtenerEmpleadoConSalarioMinimo(){
        Empleado empleadoMinimo = null;
        double salarioMinimo = Double.MAX_VALUE;
        for (Empleado empleado : empleados){
            if (empleado.getSalario() < salarioMinimo){
                salarioMinimo = empleado.getSalario();
                empleadoMinimo = empleado;
            }
        }
        return empleadoMinimo;
    }
    
    public Empleado buscarEmpleadoPorId(int id){
        for (Empleado empleado : empleados){
            if (empleado.getId() == id){
                return empleado;
            }
        }
        return null;
    }
}
