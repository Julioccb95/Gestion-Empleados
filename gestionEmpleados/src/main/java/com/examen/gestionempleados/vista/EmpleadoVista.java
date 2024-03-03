/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examen.gestionempleados.vista;

import com.examen.gestionempleados.controlador.EmpleadoControlador;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author julio
 */
public class EmpleadoVista {
    public void mostrarMenu(EmpleadoControlador controlador){
        Scanner scanner = new Scanner(System.in);
        int opcion= 0;
        do{
            System.out.println("\nGESTIÓN DE EMPLEADOS");
            System.out.println("1. Agregar nuevo empleado");
            System.out.println("2. Mostrar salario promedio de todos los empleados");
            System.out.println("3. Mostrar empleado con salario más alto");
            System.out.println("4. Mostrar empleado con salario más bajo");
            System.out.println("5. Buscar empleado por número de identificación");
            System.out.println("6. Salir");
            try{
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            
            switch(opcion){
                case 1:
                    agregarEmpleado(controlador, scanner);
                    break;
                case 2:
                    controlador.mostrarSalarioPromedio();
                    break;
                case 3:
                    controlador.mostrarEmpleadoConSalarioMaximo();
                    break;
                case 4:
                    controlador.mostrarEmpleadoConSalarioMinimo();
                    break;
                case 5:
                    buscarEmpleado(controlador, scanner);
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por Favor, seleccione una opción valida.");
            }
            }catch(NumberFormatException e){
                System.out.println("Formato invalido, favor de ingresar un número del 1 al 6");
                scanner.nextLine();
                opcion  = 0;
            }catch(Exception e){
                System.out.println("Favor de validar datos ingresados.");
                scanner.nextLine();
                opcion  = 0;
                
            }
        } while (opcion != 6);
        scanner.close();
    }

    public void mostrarInformacion(String mensaje) {
            System.out.println(mensaje);
    }
    
    public void agregarEmpleado(EmpleadoControlador controlador, Scanner scanner){
        
        try{
        System.out.println("\nAgregar nuevo empleado:");
        System.out.print("Nombre: ");
        String nombre = scanner.next();
            boolean validaId;
            int id =0;
        System.out.print("Número de identificación: ");
        id = scanner.nextInt();
        validaId = controlador.validarIdDuplicado(id);
        System.out.print("Salario: ");
        double salario = scanner.nextDouble();
        if (!validaId){
            controlador.agregarEmpleado(nombre, id, salario);
            System.out.println("Empleado Agregado Correctamente.");
        }else{
            System.out.println("\nYa existe un empleado con el mismo ID, favor de validarlo.");
        }
        
        }catch(NumberFormatException e){
            System.out.println("Error: formato de id o salario invalidos");
            scanner.nextLine();
        }catch(Exception e){
            System.out.println("Error inesperado, valide información ingresada.");
            scanner.nextLine();
        }
    }
    
    public void buscarEmpleado(EmpleadoControlador controlador, Scanner scanner){
        try{
        System.out.print("\nIngrese el número de identificación del empleado a buscar: ");
        int id = scanner.nextInt();
        controlador.buscarEmpleadoPorId(id);
        }catch(NumberFormatException e){
            System.out.println("Error: favor de ingresar un nùmero entero valido.");
            scanner.nextLine();
        }catch(InputMismatchException e){
            System.out.println("Error: Debe ingresar un número entero.");
            scanner.nextLine();
        }
        catch(Exception e){
            System.out.println("Error: Ocurrio un error inesperado, favor de reportar a Sistemas");
            scanner.nextLine();
        }
    }
    
}
