program Ejercicio1;
const
	DIMF = 12;
type
	rangoMeses = 1..12;
	
	prestamo = record	
		cantDias:integer;
		ISBN:integer;
		mes:rangoMeses;
		numSocio:integer;
	end;
	
	lista = ^nodo;
	nodo = record	
		elem:prestamo;
		sig:lista;
	end;
	
	vector = array [rangoMeses] of lista;
	
	prestamoAcotado = record	
		ISBN:integer;
		total:integer;
	end;
	
	listaMerge = ^nodoMerge;
	nodoMerge = record	
		elem:prestamoAcotado;
		sig:listaMerge;
	end;

procedure cargoVector (var v:vector);
	procedure leoPrestamo (var p:prestamo);
	begin
		with p do begin
			write('ISNB: ');readln(ISBN);
			if (ISBN <> -1) then begin
				write('Mes: ');readln(mes);
				cantDias := random(50) + 1;
				writeln('Dias: ',cantDias);
				numSocio := random(5000) + 1;
				writeln('Numero de socio: ',numSocio);
			end;
			writeln;
		end;
	end;
	
	procedure insertarOrdenado (var L:lista; p:prestamo);
	var
		ant,aux,act:lista;
	begin
		new(aux);
		aux^.elem:=p;
		act := L; ant := L;
		while (act <> nil) and (p.ISBN > act^.elem.ISBN) do begin
			ant := act;
			act := act^.sig;
		end;
		if (ant = act) then 
			L:=aux
		else
			ant^.sig := aux;
		aux^.sig:= act;
	end;
	
	procedure inicializar (var v:vector; i:integer);
	begin
		if (i <= DIMF) then begin
			v[i]:=nil;
			inicializar(v,i+1);
		end;
	end;
var
	p:prestamo;
begin 
	inicializar(v,1);
	leoPrestamo(p);
	while (p.ISBN <> -1) do begin
		insertarOrdenado(v[p.mes],p);
		leoPrestamo(p);
	end;
end;

procedure imprimirLista (L:lista);
begin
	if (L <> nil) then begin
		writeln('isbn: ',L^.elem.ISBN);
		writeln('num socio: ',L^.elem.numSocio);
		writeln;
		imprimirLista(L^.sig);
	end;
end;
		
procedure imprimirVectorLista (v:vector; i:integer);
begin
	if (i <= DIMF) then begin
		writeln('------MES ',i,' ------');
		imprimirLista(v[i]);
		imprimirVectorLista(v,i+1);
	end;
end;

procedure minimo (var v:vector; var min:prestamo);
var
	indiceMin:integer;
	i:integer;
begin
	min.ISBN := 9999;
	for i:= 1 to DIMF do begin
		if (v[i] <> nil) then begin
			if (v[i]^.elem.ISBN <= min.ISBN) then begin
				indiceMin:= i;
				min := v[i]^.elem;
			end;
		end;
	end;
	if (min.ISBN <> 9999) then 
		v[indiceMin] := v[indiceMin]^.sig;
end;

procedure merge (v:vector; var L:lista);
	procedure agregarAtras (var L,ult:lista; p:prestamo);
	var
		aux:lista;
	begin
		new(aux);
		aux^.elem:=p;
		aux^.sig:=NIL;
		if (L <> nil) then 
			ult^.sig := aux
		else
			L := aux;
		ult:= aux;
	end;	
var	
	ult:lista;
	min:prestamo;
begin
	L:=nil;
	minimo(v,min);
	while (min.ISBN <> 9999) do begin
		agregarAtras(L,ult,min);
		minimo(v,min);
	end;
end;

procedure mergeAcumulador (v:vector; var L:listaMerge);
	procedure agregarAtras (var L,ult:listaMerge; p:prestamoAcotado);
	var
		aux:listaMerge;
	begin
		new(aux);
		aux^.elem:=p;
		aux^.sig:=NIL;
		if (L <> nil) then 
			ult^.sig := aux
		else
			L := aux;
		ult:= aux;
	end;	

var
	ult:listaMerge;
	min:prestamo;
	act,total:integer;
	reg:prestamoAcotado;
begin
	L:=NIL;
	minimo(v,min);
	while (min.ISBN <> 9999) do begin
		act := min.ISBN;
		total := 0;
		while (min.ISBN <> 9999) and (act = min.ISBN) do begin
			total := total + 1;
			minimo(v,min);
		end;
		reg.ISBN := act;
		reg.total := total;
		agregarAtras(L,ult,reg);
	end;
end;

procedure imprimirListaMerge (L:listaMerge);
begin
	if (L <> nil) then begin
		writeln('isbn: ',L^.elem.ISBN);
		writeln('cant veces prestado: ',L^.elem.total);
		writeln;
		imprimirListaMerge(L^.sig);
	end;
end;

var
	v:vector;
	L:lista;
	LA:listaMerge;
begin
	cargoVector(v);
	imprimirVectorLista(v,1);
	merge(v,L);
	writeln('-------LISTA MERGE------');
	imprimirLista(L);
	mergeAcumulador(v,LA);
	writeln('-------LISTA MERGE ACUMULADOR ------');
	imprimirListaMerge(LA);

end.
