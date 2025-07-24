program Ejercicio2;

type
	str = String[15];
	rangoAnios = 2010..2018;
	
	auto = record
		patente:str;
		anio:rangoAnios;
		marca:str;
		modelo:str;
	end;
	
	arbol = ^nodo;
	nodo = record	
		elem:auto;
		HI:arbol;
		HD:arbol;
	end;
	
	lista = ^nodoLista;
	nodoLista = record
		elem:auto;
		sig:lista;
	end;
	
	vector = array [rangoAnios] of lista;
	
procedure cargarArbol (var a:arbol);
	procedure leoAuto (var a:auto);
	begin
		with a do begin
			write('Patente: ');readln(patente);
			if (patente <> 'ZZZ') then begin
				write('Anio de fabricacion: ');readln(anio);
				write('Marca: ');readln(marca);
				write('Modelo: ');readln(modelo);
			end;
			writeln;
		end;
	end;
	
	procedure insertarNodo (var a:arbol; au:auto); 
	begin
		if (a=nil) then begin
			new(a);
			a^.elem:=au;
			a^.HI:=nil;
			a^.HD:=nil;
		end
		else
			if (au.patente < a^.elem.patente) then
				insertarNodo(a^.HI,au)
			else
				insertarNodo(a^.HD,au);
	end;
var
	au:auto;
begin
	a:=nil;
	leoAuto(au);
	while (au.patente <> 'ZZZ') do begin
		insertarNodo(a,au);
		leoAuto(au);
	end;
end;

procedure imprimirArbol (a:arbol);
begin
	if (a <> nil) then begin
		imprimirArbol(a^.HI);
		writeln('patente: ',a^.elem.patente);
		writeln('fabricacion: ',a^.elem.anio);
		writeln('marca: ',a^.elem.marca);
		writeln('modelo: ',a^.elem.modelo);
		writeln;
		imprimirArbol(a^.HD);
	end;
end;

procedure cantAutos (a:arbol);
	procedure buscar (a:arbol; marca:str; var cant:integer);
	begin
		if (a <> nil) then begin
			if (a^.elem.marca = marca) then
				cant:= cant + 1;
			buscar(a^.HI,marca,cant);
			buscar(a^.HD,marca,cant);
		end;
	end;
var
	marca:str;
	cant:integer;
begin
	cant:=0; 
	write('Marca: ');readln(marca);
	buscar(a,marca,cant);
	writeln('La cantidad de autos para la marca ',marca,' es: ',cant);
end;

procedure inicializoVector (var v:vector);
var
	i:integer;
begin
	for i:= 2010 to 2018 do 
		v[i]:=nil;
end;

procedure agregarAdelante (var L:lista; a:auto);
var
	aux:lista;
begin
	new(aux);
	aux^.elem:=a;
	aux^.sig:=L;
	L:=aux;
end;

procedure cargarVectorListas (a:arbol; var v:vector);
begin
	if (a <> nil) then begin
		agregarAdelante(v[a^.elem.anio],a^.elem);
		cargarVectorListas(a^.HI,v);
		cargarVectorListas(a^.HD,v);
	end;
end;

procedure imprimirVectorListas (v:vector);
	procedure imprimirLista (L:lista);
	begin
		if (L <> nil) then begin
			writeln('patente: ',L^.elem.patente);
			writeln('fabricacion: ',L^.elem.anio);
			writeln('marca: ',L^.elem.marca);
			writeln('modelo: ',L^.elem.modelo);
			writeln;
			imprimirLista(L^.sig);
		end;
	end;
var
	i:integer;
begin
	for i:= 2010 to 2018 do begin
		writeln('------ANIO ',i,' -------');
		imprimirLista(v[i]);
	end; 
end;

procedure buscarPatente (a:arbol);
	procedure buscarPatente (a:arbol; patente:str; var anio:integer);
	begin
		if (a <> nil) then begin
			if (a^.elem.patente = patente) then
				anio := a^.elem.anio
			else
				if (patente < a^.elem.patente) then
					buscarPatente(a^.HI,patente,anio)
				else
					buscarPatente(a^.HD,patente,anio);
		end;
	end;
var
	anio:integer;
	patente:str;
begin
	write('Patente: ');readln(patente);
	buscarPatente(a,patente,anio);
	writeln('El anio de fabricacion es: ',anio);
end;

var
	a:arbol;
	v:vector;
begin
	cargarArbol(a);
	imprimirArbol(a);
	cantAutos(a);
	inicializoVector(v);
	cargarVectorListas(a,v);
	imprimirVectorListas(v);
	buscarPatente(a);	
end.
		
