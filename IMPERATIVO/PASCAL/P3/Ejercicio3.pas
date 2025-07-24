program ejercicio3;
type
	
	rangoAnios = 2010..2070;
	
	alumno = record
		legajo:integer;
		DNI:integer;
		ingreso:rangoAnios;
	end;
	
	arbol = ^nodo;
	nodo = record
		elem:alumno;
		HI:arbol;
		HD:arbol;
	end;
	
procedure cargarArbol (var a:arbol);
	procedure leoAlumno (var a:alumno);
	begin
		with a do begin
			write('Anio de ingreso: ');readln(ingreso);
			if (ingreso > 2010) and (legajo <> 0) then begin
				write('DNI: ');readln(DNI);
				write('Nro de legajo: ');readln(legajo);
			end;
			writeln;
		end;
	end;
	
	procedure insertarNodo (var a:arbol; alu:alumno);
	begin
		if (a = nil) then begin
			new(a);
			a^.elem:=alu;
			a^.HI:=nil;
			a^.HD:=nil;
		end
		else begin
			if (alu.legajo < a^.elem.legajo) then
				insertarNodo(a^.HI,alu)
			else
				insertarNodo(a^.HD,alu);
		end;
	end;

var
	alu:alumno;
begin
	a:=nil;
	leoAlumno(alu);
	while (alu.ingreso > 2010) and (alu.legajo <> 0) do begin
		insertarNodo(a,alu);
		leoAlumno(alu);
	end;
end;

procedure imprimirArbol (a:arbol);
begin
	if (a <> nil) then begin
		imprimirArbol(a^.HI);
		writeln('------ALUMNO-----');
		writeln('ingreso: ',a^.elem.ingreso);
		writeln('dni: ',a^.elem.DNI);
		writeln('legajo: ',a^.elem.legajo);
		imprimirArbol(a^.HD);
	end;
end;

procedure legajoMenor (a:arbol);
	procedure buscar (a:arbol; valor:integer);
	begin
		if (a <> nil) then begin
			if (a^.elem.legajo < valor) then begin
				writeln('ingreso: ',a^.elem.ingreso);
				writeln('dni: ',a^.elem.DNI);
				buscar(a^.HI,valor);
				buscar(a^.HD,valor);
			end
			else
				buscar(a^.HI,valor);
		end;
	end;
var
	legajo:integer;
begin
	write('Ingrese nro de legajo a buscar: ');readln(legajo);
	buscar(a,legajo)
end;

procedure entreValores (a:arbol);
	procedure buscarEntre (a:arbol; v1,v2:integer);
	begin
		if (a <> nil) then begin
			if (v1 <= a^.elem.legajo) then begin
				if (v2 >= a^.elem.legajo) then begin
					writeln('ingreso: ',a^.elem.ingreso);
					writeln('dni: ',a^.elem.DNI);
					buscarEntre(a^.HI,v1,v2);
					buscarEntre(a^.HD,v1,v2);
				end
				else
					buscarEntre(a^.HI,v1,v2);
			end
			else
				buscarEntre(a^.HD,v1,v2);
		end;
	end;
var
	valor1,valor2:integer;
begin
	write('Ingrese valor 1: ');readln(valor1);
	write('Ingrese valor 2: ');readln(valor2);
	buscarEntre(a,valor1,valor2);
end;

procedure DNImasGrande (a:arbol);
	procedure maximo (a:arbol; var max:integer);
	begin
		if (a<>nil) then begin
			if (a^.elem.DNI > max) then 
				max:=a^.elem.DNI;
			maximo(a^.HI,max);
			maximo(a^.HD,max);
		end;
	end;
var
	max:integer;
begin
	max:=-1;
	maximo(a,max);
	writeln('El DNI mas grande es: ',max);
end;

procedure legajosImpares(a:arbol);
	procedure impares (a:arbol; var cant:integer);
	begin
		if (a <> nil) then begin
			if (a^.elem.legajo mod 2 = 1) then 
				cant:= cant + 1;
			impares(a^.HI,cant);
			impares(a^.HD,cant);
		end;
	end;
var
	cant:integer;
begin
	cant:=0;
	impares(a,cant);
	writeln('La cantidad de alumnos con legajo impar son: ',cant);
end;

var
	a:arbol;
begin
	cargarArbol(a);
	imprimirArbol(a);
	legajoMenor(a);
	entreValores(a);
	DNImasGrande(a);
	legajosImpares(a);
end.
