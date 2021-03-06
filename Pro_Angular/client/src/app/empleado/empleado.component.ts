import { Component, OnInit } from '@angular/core';
import { Empleado } from './empleado';

@Component({
  selector: 'app-empleado',
  templateUrl: './empleado.component.html',
  styleUrls: ['./empleado.component.css']
})
export class EmpleadoComponent implements OnInit {

	public titulo = 'Componente de Empleado';

	public empleado:Empleado;
	public trabajadores:Array<Empleado>;
	public trabajador_externo:boolean;
	public color:string;
	public color_seleccionado:string;

  constructor() {
  	this.empleado = new Empleado('Yo', 38, 'Profesor', true);
  	this.trabajadores = [
  		new Empleado('Yo', 38, 'Profesor', true),
  		new Empleado('Tu', 39, 'Estudiante', false),
  		new Empleado('El', 34, 'Administartivo', true)
  	];
  	this.trabajador_externo = false;
  	this.color = 'red';
  	this.color_seleccionado = 'red';
  }

  ngOnInit() {
  }

  cambiarExterno(valor) {
  	this.trabajador_externo = valor;
  }
}
