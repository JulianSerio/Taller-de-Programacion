program Ejercicio4;
const 
	DIMF = 7;
type
	
	rangoDias = 1..7;
	
	entrada = record
		codObra:integer;
		dia:rangoDias;
		asiento:integer;
		monto:real;
	end;
	
	lista = ^nodo;
	nodo = record	
		elem:entrada;
		sig:lista;
	end;
	
	vector = array [rangoDias] of lista;
	
	entradaAcotada = record
		codObra:integer;
		total:integer;
	end;
	
	listaMerge = ^nodoMerge;
	nodoMerge = record
		elem:entradaAcotada;
		sig:listaMerge;
	end;

procedure cargarVector (var v:vector);
	procedure inicializar (var v:vector);
	var
		i:integer;
	begin
		for i:= 1 to DIMF do begin
			v[i]:=nil;
		end;
	end;

	procedure leoEntrada (var e:entrada);
	begin
		with e do begin
			write('Codigo de obra: ');readln(codObra);
			if (codObra <> 0) then begin
				write('Dia: ');readln(dia);
				monto := random(500) + 1.50;
				writeln('Monto: ',monto:2:2);
				asiento := random(100) + 1;
				writeln('Asiento: ',asiento);
			end;
			writeln;
		end;
	end;
	
	procedure insertarOrdenado (var L:lista; e:entrada);
	var
		aux,ant,act:lista;
	begin
		new(aux);
		aux^.elem:=e;
		ant:=L;act:=L;
		while (act <> nil) and (e.codObra > act^.elem.codObra) do begin
			ant:= act;
			act:= act^.sig;
		end;
		if (act = ant) then
			L:=aux
		else
			ant^.sig := aux;
		aux^.sig := act;
	end;
var
	e:entrada;
begin
	inicializar(v);
	leoEntrada(e);
	while (e.codObra <> 0) do begin
		insertarOrdenado(v[e.dia],e);
		leoEntrada(e);
	end;
end;

procedure agregarAtras (var L:listaMerge; e:entradaAcotada);
var
	aux,act:listaMerge;
begin
	new(aux);
	aux^.elem:=e;
	aux^.sig:=nil;
	if (L <> nil) then begin
		act:=L;
		while (act^.sig <> nil) do begin
			act:=act^.sig;
		end;
		act^.sig:=aux;
	end
	else begin
		L:=aux;
	end;
end;


procedure mergeAcumulador (v:vector; var L:listaMerge);
	procedure minimo (var v:vector; var min:entrada);
	var
		indiceMin,i:integer;
	begin
		min.codObra := 9999;
		for i:= 1 to DIMF do begin
			if (v[i] <> nil) then begin
				if (v[i]^.elem.codObra <= min.codObra) then begin
					indiceMin:= i;
					min:= v[i]^.elem;
				end;
			end;
		end;
		if (min.codObra <> 9999) then begin
			v[indiceMin] := v[indiceMin]^.sig;
		end;
	end;
	
var
	min:entrada;
	act,total:integer;
	reg:entradaAcotada;
begin
	L:=nil;
	minimo(v,min);
	while (min.codObra <> 9999) do begin
		act:= min.codObra;
		total:=0;
		while (min.codObra <> 9999) and (act = min.codObra) do begin
			total := total + 1;
			minimo(v,min);
		end;
		reg.codObra := act;
		reg.total := total;
		agregarAtras(L,reg);
	end;
end;

procedure imprimirVectorListas (v:vector);
	procedure imprimirLista (L:lista);
	begin
		if (L <> nil) then begin
			writeln('Codigo de obra: ',L^.elem.codObra);
			writeln('Dia: ',L^.elem.dia);
			writeln('Monto: ',L^.elem.monto:2:2);
			writeln('Asiento: ',L^.elem.asiento);
			writeln;
			imprimirLista(L^.sig);
		end;
	end;
var
	i:integer;
begin
	for i:= 1 to DIMF do begin
		writeln('------------ DIA ',i,' -----------');
		imprimirLista(v[i]);
	end;
end;

procedure imprimirLista (L:listaMerge);
begin
	if (L <> nil) then begin
		writeln('Codigo de obra: ',L^.elem.codObra);
		writeln('Total: ',L^.elem.total);
		writeln;
		imprimirLista(L^.sig);
	end;
end;

var
	L:listaMerge;
	v:vector;
begin
	cargarVector(v);
	imprimirVectorListas(v);
	mergeAcumulador(v,L);
	writeln('-----LISTA MERGE------');
	imprimirLista(L);

end.
