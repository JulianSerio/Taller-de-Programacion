program Ejercicio1;

type
	str = String[20];
	
	socio = record
		num:integer;
		nombre:str;
		edad:integer;
	end;
	
	arbol = ^nodo;
	nodo = record
		elem:socio;
		HI:arbol;
		HD:arbol;
	end;

procedure leoSocio (var s:socio);
begin
	with s do begin
		write('Numero: ');readln(num);
		if (num <> 0) then begin
			write('Nombre: ');readln(nombre);
			write('Edad: ');readln(edad);
		end;
		writeln();
	end;
end;

procedure cargoArbol (var a:arbol);
	procedure insertarNodo (var a:arbol; s:socio);
	begin
		if (a = nil) then begin
			new(a);
			a^.elem:= s;
			a^.HI:= nil;
			a^.HD:= nil;
		end
		else
			if (s.num < a^.elem.num) then 
				insertarNodo(a^.HI,s)
			else
				insertarNodo(a^.HD,s);
	end;
var
	s:socio;
begin
	a:=nil;
	leoSocio(s);
	while (s.num <> 0) do begin
		insertarNodo(a,s);
		leoSocio(s);
	end;
end;

procedure imprimirArbol (a:arbol);
begin
	if (a <> nil) then begin
		imprimirArbol(a^.HI);
		writeln();
		writeln('----socio----');
		writeln('num: ',a^.elem.num);
		writeln('edad: ',a^.elem.edad);
		writeln('nombre: ',a^.elem.nombre);
		imprimirArbol(a^.HD);
	end;
end;


procedure imprimirArbolDecreciente (a:arbol);
begin
	if (a <> nil) then begin
		imprimirArbolDecreciente(a^.HD);
		if (a^.elem.num mod 2 = 0) then begin
			writeln();
			writeln('----socio----');
			writeln('num: ',a^.elem.num);
			writeln('edad: ',a^.elem.edad);
			writeln('nombre: ',a^.elem.nombre);
		end;
		imprimirArbolDecreciente(a^.HI);
	end;
end;

procedure maxYminNumSocio (a:arbol);
	procedure maximo (a:arbol; var max:integer);
	begin
		if (a <> nil) then begin
			if (a^.elem.num > max) then 
				max:= a^.elem.num;
			maximo(a^.HD,max);
		end;
	end;

	procedure minimo (a:arbol; var min:socio);
	begin
		if (a <> nil) then begin
			if (a^.elem.num < min.num) then 
				min:= a^.elem;
			minimo(a^.HI,min);
		end;
	end;
var
	max:integer;
	min:socio;
begin
	max:=-1;min.num:=9999;
	maximo(a,max);
	minimo(a,min);
	writeln();
	writeln('El numero de socio maximo es: ',max);
	writeln();
	writeln('----Socio con numero mas chico----');
	writeln('numero: ',min.num);
	writeln('nombre: ',min.nombre);
	writeln('edad: ',min.edad);
end;

procedure mayorEdad (a:arbol; var max,numSocio:integer);
begin
	if (a <> nil) then begin
		if (a^.elem.edad > max) then begin
			max:= a^.elem.edad;
			numSocio:= a^.elem.num;
		end;
		mayorEdad(a^.HI,max,numSocio);
		mayorEdad(a^.HD,max,numSocio);
	end;
end;

procedure aumentarEdad (var a:arbol);
begin
	if (a <> nil) then begin
		aumentarEdad(a^.HI);
		a^.elem.edad := a^.elem.edad + 1;
		aumentarEdad(a^.HD);
	end;
end;


procedure buscarNumero (a:arbol);
	function buscar (a:arbol; num:integer):boolean;
	begin
		if (a = nil) then	
			buscar:= false
		else begin
			if (a^.elem.num = num) then 
				buscar:= true
			else begin
				if (num < a^.elem.num) then
					buscar:= buscar(a^.HI,num)
				else
					buscar:= buscar(a^.HD,num);
			end;
		end;
	end;
var
	valor:integer;
begin
	write('Ingrese valor a buscar: ');readln(valor);
	if (buscar(a,valor)) then 
		writeln('EXISTE!')
	else
		writeln('NO EXISTE!');
end;


procedure buscarNombre (a:arbol);
	procedure buscar (a:arbol; nom:str; var esta:boolean);
	begin
		if (a <> nil) then begin
			if (nom = a^.elem.nombre) then
				esta:= true
			else begin
				buscar(a^.HI,nom,esta);
				buscar(a^.HD,nom,esta);
			end;
		end;
	end;
var
	nom:str;
	esta:boolean;
begin
	esta:= false;
	write('Ingrese nombre a buscar: ');readln(nom);
	buscar(a,nom,esta);
	if (esta) then 
		writeln('EXISTE!')
	else
		writeln('NO EXISTE!')	
end;

procedure cantSocios (a:arbol; var cant:integer);
begin
	if (a <> nil) then begin
		cantSocios(a^.HI,cant);
		cant := cant + 1;
		cantSocios(a^.HD,cant);
	end;
end;

procedure sumaEdades (a:arbol; var edades:integer);
begin
	if (a <> nil) then begin
		sumaEdades(a^.HI,edades);
		edades := edades + a^.elem.edad;
		sumaEdades(a^.HD,edades);
	end;
end;

procedure cantSociosEntreValores(a:arbol);
	procedure buscarEntre (a:arbol; valor1,valor2:integer; var cant:integer);
	begin
		if (a <> nil) then
			if (valor1 <= a^.elem.num) then begin
				if (valor2 >= a^.elem.num) then begin
					cant:= cant + 1;
					buscarEntre(a^.HI,valor1,valor2,cant);
					buscarEntre(a^.HD,valor1,valor2,cant);
				end
				else
					buscarEntre(a^.HI,valor1,valor2,cant);
			end		
			else
				buscarEntre(a^.HD,valor1,valor2,cant);
				
	end;
var
	valor1,valor2,cant:integer;
begin
	cant:=0;
	write('Ingrese valor 1: ');readln(valor1);
	write('Ingrese valor 2: ');readln(valor2);
	buscarEntre(a,valor1,valor2,cant);
	writeln('La cantidad de socios entre los valores ',valor1,' y ',valor2,' es: ',cant);
	
end;

var
	a:arbol;
	prom:real;
	max,numSocio,cant,edades:integer;
BEGIN
	max:=-1;cant:=0;edades:=0;
	cargoArbol(a);
	imprimirArbol(a);
	maxYminNumSocio(a);
	mayorEdad(a,max,numSocio);
	writeln('El numero de socio con mayor edad es: ',numSocio, ' y tiene ',max);
	writeln('----POST AUMENTAR EDADES----');
	aumentarEdad(a);
	imprimirArbol(a);
	buscarNumero(a);
	buscarNombre(a);
	cantSocios(a,cant);
	writeln('La cantidad total de socios es: ',cant);
	sumaEdades(a,edades);
	prom := edades / cant;
	writeln('El promedio de edad de los socios es: ',prom:2:0);
	cantSociosEntreValores(a);
	imprimirArbolDecreciente(a);
END.

