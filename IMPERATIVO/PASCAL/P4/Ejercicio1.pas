program untitled;
const
	DIMF = 12;
type 	
	rangoMeses = 1..DIMF;
	
	prestamo = record
		ISBN:integer;
		numSocio:integer;
		mes:rangoMeses;
		diasPrestado:integer;
	end;
	
	prestamoMerge = record
		ISBN:integer;
		total:integer;
	end;
	
	listaMerge = ^nodoMerge;
	nodoMerge = record
		elem:prestamoMerge;
		sig:listaMerge;
	end;
	
	lista = ^nodo;
	nodo = record
		elem:prestamo;
		sig:lista;
	end;

	
	vector = array [rangoMeses] of lista;

procedure cargarVector (var v:vector);
	procedure inicializar (var v:vector);
	var
		i:integer;
	begin
		for i:= 1 to DIMF do 
			v[i]:=nil;
	end;
	
	procedure leoPrestamo (var p:prestamo);
	begin
		with p do begin
			write('ISBN: ');readln(ISBN);
			if (ISBN <> -1) then begin
				write('Numero de socio: ');readln(numSocio);
				write('Mes: ');readln(mes);
				write('Dias Prestado: ');readln(diasPrestado);
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
		ant:=L;
		act:=L;
		while (act <> nil) and (p.ISBN > act^.elem.ISBN) do begin
			ant:=act;
			act:= act^.sig;
		end;
		if (act = ant) then 
			L:=aux
		else
			ant^.sig:=aux;
		aux^.sig:=act;
	end;

var
	p:prestamo;
begin
	inicializar(v);
	leoPrestamo(p);
	while (p.ISBN <> -1) do begin
		insertarOrdenado(v[p.mes],p);
		leoPrestamo(p);
	end;
end;

procedure imprimirVector (v:vector);
var
	i:integer;
begin
	for i:= 1 to DIMF do begin
		writeln('---------MES ',i,'---------');
		while (v[i] <> nil) do begin
			writeln('ISBN: ',v[i]^.elem.ISBN);
			writeln('NUM SOCIO: ',v[i]^.elem.numSocio);
			writeln;
			v[i]:= v[i]^.sig;
		end;
	end;
end;

procedure merge (v:vector; var L:lista);
	procedure agregarAtras (var L:lista; p:prestamo);
	var
		act,aux:lista;
	begin
		new(aux);
		aux^.elem:=p;
		aux^.sig:=NIL;
		if (L <> NIL) then begin
			act:= L;
			while (act^.sig <> nil) do
				act:=act^.sig;
			act^.sig:=aux;
		end
		else
			L:=aux;
	end;
	
	procedure minimo (var v:vector; var min:prestamo);
	var
		indiceMin,i:integer;
	begin
		min.ISBN := 9999;
		for i:= 1 to DIMF do begin
			if (v[i] <> nil) then begin
				if (v[i]^.elem.ISBN <= min.ISBN) then begin
					indiceMin:=i;
					min:= v[i]^.elem;
				end;
			end;
		end;
		if (min.ISBN <> 9999) then 
			v[indiceMin] := v[indiceMin]^.sig;
	end;
	
var
	min:prestamo;
begin
	L:=nil;
	minimo(v,min);
	while (min.ISBN <> 9999) do begin
		agregarAtras(L,min);
		minimo(v,min);
	end;
end;

procedure imprimirLista (L:lista);
begin
	if (L <> nil) then begin
		writeln('ISBN: ',L^.elem.ISBN);
		writeln('NUM SOCIO: ',L^.elem.numSocio);
		writeln();
		imprimirLista(L^.sig);
	end;
end;

procedure imprimirListaMerge (L:listaMerge);
begin
	if (L <> nil) then begin
		writeln('ISBN: ',L^.elem.ISBN);
		writeln('TOTAL: ',L^.elem.total);
		writeln();
		imprimirListaMerge(L^.sig);
	end;
end;

procedure mergeAcumulador (v:vector; var L:listaMerge);
	procedure agregarAtras (var L:listaMerge; p:prestamoMerge);
	var
		act,aux:listaMerge;
	begin
		new(aux);
		aux^.elem:=p;
		aux^.sig:=NIL;
		if (L <> NIL) then begin
			act:= L;
			while (act^.sig <> nil) do
				act:=act^.sig;
			act^.sig:=aux;
		end
		else
			L:=aux;
	end;
	
	procedure minimo (var v:vector; var min:prestamo);
	var
		indiceMin,i:integer;
	begin
		min.ISBN := 9999;
		for i:= 1 to DIMF do begin
			if (v[i] <> nil) then begin
				if (v[i]^.elem.ISBN <= min.ISBN) then begin
					indiceMin:=i;
					min:= v[i]^.elem;
				end;
			end;
		end;
		if (min.ISBN <> 9999) then 
			v[indiceMin] := v[indiceMin]^.sig;
	end;
var
	min,act:prestamo;
	total:integer;
	reg:prestamoMerge;
begin
	L:=nil;
	minimo(v,min);
	while (min.ISBN <> 9999) do begin
		act:=min;
		total:=0;
		while (min.ISBN <> 9999) and (act.ISBN = min.ISBN) do begin
			total:= total + 1;
			minimo(v,min);
		end; 
		reg.ISBN := act.ISBN;
		reg.total := total;
		agregarAtras(L,reg);
	end;
end;

var
	v:vector;
	L:lista;
	L2:listaMerge;
BEGIN
	cargarVector(v);
	imprimirVector(v);
	merge(v,L);
	imprimirLista(L);
	mergeAcumulador(v,L2);
	imprimirListaMerge(L2);

END.

