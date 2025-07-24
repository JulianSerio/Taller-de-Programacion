program Ejercicio2;
const 
	DIMF = 8;
type 
	
	rangoGenero = 1..DIMF;
	
	pelicula = record
		codPeli:integer;
		codGenero:rangoGenero;
		puntProm:real;
	end;
	
	lista = ^nodo;
	nodo = record
		elem:pelicula;
		sig:lista;
	end;
	
	vector = array [rangoGenero] of lista;

procedure cargoVector (var v:vector);
	procedure leoPelicula (var p:pelicula);
	begin
		with p do begin
			write('Codigo de pelicula: ');readln(codPeli);
			if (codPeli <> -1) then begin
				write('Codigo de genero: ');readln(codGenero);
				write('Puntaje promedio: ');readln(puntProm);
			end;
		end;
		writeln;
	end;	
	
	procedure inicializar (var v:vector);
	var
		i:integer;
	begin
		for i:= 1 to 8 do begin
			v[i] := nil;
		end;
	end;
	
	procedure insertarOrdenado (var L:lista; p:pelicula);
	var
		ant,act,aux:lista;
	begin
		new(aux);
		aux^.elem:=p;
		ant:=L;
		act:=L;
		while (act <> nil) and (p.codPeli > act^.elem.codPeli) do begin
			ant:= act;
			act:= act^.sig;
		end;
		if (act = ant) then
			L:= aux
		else
			ant^.sig:=aux;
		aux^.sig:=act;
	end;	

var
	p:pelicula;
begin
	leoPelicula(p);
	while (p.codPeli <> -1) do begin
		insertarOrdenado(v[p.codGenero],p);
		leoPelicula(p);
	end;
end;

procedure imprimirLista (L:lista);
begin
	if (L <> nil) then begin
		writeln('Codigo de pelicula: ',L^.elem.codPeli);
		writeln('Codigo de genero: ',L^.elem.codGenero);
		writeln('Puntaje promedio: ',L^.elem.puntProm:2:0);
		writeln;
		imprimirLista(L^.sig);
	end;
end;

procedure imprimirVector (v:vector);
	procedure imprimirLista (L:lista);
	begin
		if (L <> nil) then begin
			writeln('Codigo de pelicula: ',L^.elem.codPeli);
			writeln('Codigo de genero: ',L^.elem.codGenero);
			writeln('Puntaje promedio: ',L^.elem.puntProm:2:0);
			writeln;
			imprimirLista(L^.sig);
		end;
	end;
var
	i:integer;
begin
	for i:= 1 to DIMF do begin
		writeln;
		writeln('-----RUBRO ',i,'-----');
		imprimirLista(v[i]);
	end;
end;

procedure merge (v:vector; var L:lista);
	procedure agregarAdelante (var L:lista; p:pelicula);
	var
		aux:lista;
	begin
		new(aux);
		aux^.elem:=p;
		aux^.sig:=L;
		L:=aux;
	end;
	procedure minimo (var v:vector; var min:pelicula);
	var
		indiceMin,i:integer;
	begin
		min.codPeli := 9999;
		for i:= 1 to DIMF do begin
			if (v[i] <> nil) then begin
				if (v[i]^.elem.codPeli <= min.codPeli) then begin
					indiceMin:=i;
					min:= v[i]^.elem;
				end;
			end;
		end;
		if (min.codPeli <> 9999) then 
			v[indiceMin] := v[indiceMin]^.sig;
	end;
var
	min:pelicula;
begin
	L:=nil;
	minimo(v,min);
	while (min.codPeli <> 9999) do begin
		agregarAdelante(L,min);
		minimo(v,min);
	end;
end;

var
	v:vector;
	L:lista;
begin
	cargoVector(v);
	imprimirVector(v);
	merge(v,L);
	writeln('----------LISTA----------');
	imprimirLista(L);
	
end.
