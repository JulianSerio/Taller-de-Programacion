program Ejercicio4;
const
	DIMF = 7;
type
	rangoDias = 1..7;
	
	entrada = record
		monto:real;
		asiento:integer;
		codObra:integer;
		dia:rangoDias;
	end;
	
	entradaMerge = record
		codObra:integer;
		total:integer;
	end;
	
	listaMerge = ^nodoMerge;
	nodoMerge = record
		elem:entradaMerge;
		sig:listaMerge;
	end;
	
	lista = ^nodo;
	nodo = record
		elem:entrada;
		sig:lista;
	end;
	
	vector = array [rangoDias] of lista;
	
procedure cargarVector (var v:vector);
	procedure leoEntrada (var e:entrada);
	begin
		with e do begin
			write('Codigo de obra: ');readln(codObra);
			if (codObra <> 0) then begin
				write('Dia: ');readln(dia);
				write('Monto: ');readln(monto);
				write('Asiento: ');readln(asiento);
			end; 
			writeln;
		end;
	end;
		
	procedure inicializar (var v:vector);
	var
		i:integer;
	begin
		for i:= 1 to DIMF do
			v[i]:=nil;
	end;
	
	procedure insertarOrdenado (var L:lista; e:entrada);
	var
		ant,act,aux:lista;
	begin
		new(aux);
		aux^.elem:=e;
		ant:=L;
		act:=L;
		while (act <> nil) and (act^.elem.codObra < e.codObra) do begin
			ant:=act;
			act:=act^.sig;
		end;
		if (ant = act) then
			L:=aux
		else
			ant^.sig:=aux;
		aux^.sig:=act;
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


procedure imprimirVectorListas (v:vector);
	procedure imprimirLista (L:lista);
	begin
		if (L <> nil) then begin
			writeln('codigo de obra: ',L^.elem.codObra);
			writeln('monto: ',L^.elem.monto:2:2);	
			writeln('asiento: ',L^.elem.asiento);
			writeln;
			imprimirLista(L^.sig);
		end;
	end;
var
	i:integer;
begin
	for i:= 1 to DIMF do begin
		writeln('----- DIA ',i,' -----');
		imprimirLista(v[i]);
	end;
end;

procedure agregarAtras (var L:listaMerge; e:entradaMerge);
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
		i,indiceMin:integer;
	begin
		min.codObra := 9999;
		for i:= 1 to DIMF do begin
			if (v[i] <> nil) then begin
				if (v[i]^.elem.codObra <= min.codObra) then begin
					indiceMin:=i;
					min:= v[i]^.elem;
				end;
			end;
		end;
		if (min.codObra <> 9999) then begin
			v[indiceMin] := v[indiceMin]^.sig;
		end;
	end;
	
	
var
	min,act:entrada;
	reg:entradaMerge;
	total:integer;
begin
	L:=nil;
	minimo(v,min);
	while (min.codObra <> 9999) do begin
		act:=min;
		total:=0;
		while (min.codObra <> 9999) and (act.codObra = min.codObra) do begin
			total:= total + 1;
			minimo(v,min);
		end;
		reg.codObra := act.codObra;
		reg.total := total;
		agregarAtras(L,reg);
	end;
end;

procedure imprimirListaMerge (L:listaMerge);
begin
	if (L <> nil) then begin
		writeln('codigo de obra: ',L^.elem.codObra);
		writeln('total entradas vendidas: ',L^.elem.total);	
		writeln;
		imprimirListaMerge(L^.sig);
	end;
end;

var
	v:vector;
	L:listaMerge;
begin
	cargarVector(v);
	imprimirVectorListas(v);
	mergeAcumulador(v,L);
	writeln('---------LISTA MERGE----------');
	imprimirListaMerge(L);
end.
