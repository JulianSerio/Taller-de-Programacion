program Ejercicio4;
const
	DIMF = 7;
type
	rangoDias = 1..DIMF;
	
	entrada = record
		dia:integer;
		codObra:integer;
		monto:real;
		asiento:integer;
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
		end;
		writeln;
	end;
	
	procedure inicializo (var v:vector);
	var
		i:integer;
	begin
		for i:= 1 to DIMF do 
			v[i]:=nil;
	end;
	
	procedure insertarOrdenado (var L:lista; e:entrada);
	var
		ant,aux,act:lista;
	begin
		new(aux);
		aux^.elem:=e;
		act:=L;
		ant:=L;
		while (act <> nil) and (e.codObra < act^.elem.codObra) do begin
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
	inicializo(v);
	leoEntrada(e);
	while (e.codObra <> 0) do begin
		insertarOrdenado (v[e.dia],e);
		leoEntrada(e);
	end;
end;

procedure imprimirVectorLista (v:vector; i:integer);
	procedure imprimirLista (L:lista);
	begin
		if (L <> nil) then begin
			writeln('cod obra: ',L^.elem.codObra);
			writeln('monto: ',L^.elem.codObra);
			writeln('asiento: ',L^.elem.asiento);
			imprimirLista(L^.sig);
		end;
	end;
begin
	if (i<=DIMF) then begin
		writeln('-------DIA ',i,' -------');
		imprimirLista(v[i]);
		imprimirVectorLista(v,i+1);
	end;
end;


procedure mergeAcumulador (v:vector; var L:listaMerge);
	procedure agregarAtras (var L:listaMerge; e:entradaMerge);
	var
		act,aux:listaMerge;
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
		else
			L:=aux;
	end;
	
	procedure minimo (var v:vector; var min:entrada);
	var
		i,indiceMin:integer;
	begin
		min.codObra := 9999;
		for i:= 1 to DIMF do begin
			if (v[i] <> nil) then begin
				if (v[i]^.elem.codObra <= min.codObra) then begin
					indiceMin:=i;
					min:=v[i]^.elem;
				end;
			end;
		end;
		if (min.codObra <> 9999) then 
			v[indiceMin] := v[indiceMin]^.sig;
	end;
var
	min:entrada;
	act,total:integer;
	reg:entradaMerge;
begin
	L:=nil;
	minimo(v,min);
	while (min.codObra <> 9999) do begin
		act := min.codObra;
		reg.total:= 0;
		while (min.codObra <> 9999) and (act = min.codObra) do begin
			reg.total:= reg.total + 1;
			minimo(v,min);
		end;
		reg.codObra := act;
		agregarAtras(L,reg);
	end;
end;

procedure imprimirListaMerge (L:listaMerge);
begin
	if (L <> nil) then begin
		writeln('codigo de obra: ',L^.elem.codObra);
		writeln('total: ',L^.elem.total);
		imprimirListaMerge(L^.sig);
	end;
end;

var
	v:vector;
	L:listaMerge;
begin
	cargarVector(v);
	imprimirVectorLista(v,1);
	mergeAcumulador(v,L);
	imprimirListaMerge(L);
end.

