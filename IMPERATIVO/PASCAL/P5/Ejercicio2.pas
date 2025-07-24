program Ejercicio2;
const
	DIMF = 2018;
type
	str = String[20];
	rangoAnios = 2010..2018;

	auto = record
		patente:integer;
		anioFabricacion:rangoAnios;
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
	procedure insertarOrdenado (var a:arbol; au:auto);
	begin
		if (a = nil) then begin
			new(a);
			a^.elem:=au;
			a^.HI:=nil;
			a^.HD:=nil;
		end
		else
			if (au.patente < a^.elem.patente) then
				insertarOrdenado(a^.HI,au)
			else
				insertarOrdenado(a^.HD,au);
	end;
	
	procedure leoAuto (var a:auto);
	begin
		with a do begin
			write('Patente: ');readln(patente);
			if (patente <> 0) then begin
				write('Anio Frabricacion: ');readln(anioFabricacion);
				write('Marca: ');readln(marca);
				write('Modelo: ');readln(modelo);
			end;
			writeln;
		end;
	end;
var
	au:auto;
begin
	leoAuto(au);
	while (au.patente <> 0) do begin
		insertarOrdenado(a,au);
		leoAuto(au);
	end;
end;

procedure imprimirArbol (a:arbol);
begin
	if (a <> nil) then begin
		imprimirArbol(a^.HI);
		writeln('patente: ',a^.elem.patente);
		writeln('marca: ',a^.elem.marca);
		writeln('modelo: ',a^.elem.modelo);
		writeln('Anio Fabricacion: ',a^.elem.anioFabricacion);
		writeln;
		imprimirArbol(a^.HD);
	end;
end;

procedure inicializo (var v:vector);
var
	i:integer;
begin
	for i:= 2010 to DIMF do begin
		v[i]:=nil;
	end;
end;
	

procedure cargarVector (a:arbol; var v:vector);
	procedure agregarAdelante (var L:lista; a:auto);
	var
		aux:lista;
	begin
		new(aux);
		aux^.elem:=a;
		aux^.sig:=L;
		L:=aux;
	end;
begin
	if (a <> nil) then begin
		agregarAdelante(v[a^.elem.anioFabricacion],a^.elem);
		cargarVector(a^.HI,v);
		cargarVector(a^.HD,v);
	end;
end;

procedure imprimirVector (v:vector);
	procedure imprimirLista (L:lista);
	begin
		if (L <> nil) then begin
			writeln('patente: ',L^.elem.patente);
			writeln('marca: ',L^.elem.marca);
			writeln('modelo: ',L^.elem.modelo);
			writeln('Anio Fabricacion: ',L^.elem.anioFabricacion);
			writeln;
			imprimirLista(L^.sig);
		
		end;
	end;
var
	i:integer;
begin
	for i:= 2010 to 2018 do begin
		writeln('--------ANIO ',i,' ---------');
		imprimirLista(v[i]);
	end;
end;

procedure buscarMarca (a:arbol);
	procedure buscar (a:arbol; marca:str; var cant:integer);
	begin
		if (a <> nil) then begin
			if (marca = a^.elem.marca) then
				cant := cant + 1;
			buscar(a^.HI,marca,cant);
			buscar(a^.HD,marca,cant);
		end;
	end;
var
	marca:str;
	cant:integer;
begin
	cant:=0;
	write('Ingrese marca a buscar: ');readln(marca);
	buscar(a,marca,cant);
	if (cant = 0) then
		writeln('Esta marca no posee autos en la agencia!')
	else
		writeln('La cant de autos para esta marca es: ',cant)
end;

procedure buscarPatente (a:arbol);
	procedure buscar (a:arbol; patente:integer; var anio:rangoAnios);
	begin
		if (a <> nil) then begin
			if (a^.elem.patente = patente) then
				anio:=a^.elem.anioFabricacion
			else
				if (patente < a^.elem.patente) then
					buscar(a^.HI,patente,anio)
				else
					buscar(a^.HD,patente,anio);
		end;
	end;
var
	patente:integer;
	anio:rangoAnios;
begin
	write('Ingrese patente a buscar: ');readln(patente);
	buscar(a,patente,anio);	
	writeln('El anio de fabricacion con esa patente es: ',anio);

end;

var
	a:arbol;
	v:vector;
begin
	cargarArbol(a);
	imprimirArbol(a);
	inicializo(v);
	cargarVector(a,v);
	imprimirVector(v);
	buscarMarca(a);
	buscarPatente(a);
end.
