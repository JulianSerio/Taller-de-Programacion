program Parcial1;
type	

	rangoCodigos = 1..5000;
	rangoLibros = 1..300000;
	rangoMeses = 1..12;
	
	prestamo = record
		codSocio:rangoCodigos;
		codLibro:rangoLibros;
		mes:rangoMeses;
	end;
	
	arbol = ^nodo;
	nodo = record
		elem:prestamo;
		HI:arbol;
		HD:arbol;
	end;
	
	lista = ^nodoLista;
	nodoLista = record
		elem:prestamo;
		sig:lista;
	end;
	
	vector = array [rangoMeses] of lista;
	
procedure inicializo (var v:vector);
var
	i:integer;
begin
	for i:= 1 to 12 do begin
		v[i]:= nil;
	end;
end;

procedure cargoArbol (var a:arbol);
	procedure leoPrestamo (var p:prestamo);
	begin
		with p do begin
			write('Codigo de libro: ');readln(codLibro);
			if (codLibro <> 0) then begin
				write('Codigo de socio: ');readln(codSocio);
				write('Mes del prestamo: ');readln(mes);
			end;
			writeln;
		end;
	end;
	
	procedure insertarNodo (var a:arbol; p:prestamo);
	begin
		if (a = nil) then begin
			new(a);
			a^.elem:= p;
			a^.HI:=nil;
			a^.HD:=nil;
		end
		else
			if (p.codSocio <= a^.elem.codSocio) then 
				insertarNodo(a^.HI,p)
			else
				insertarNodo(a^.HD,p);
	end;
	
var
	p:prestamo;
begin
	a:=nil;
	leoPrestamo(p);
	while (p.codLibro <> 0) do begin
		insertarNodo(a,p);
		leoPrestamo(p);
	end;
end;

procedure prestamosPorMes (a:arbol; var v:vector);
	procedure agregarAdelante (var L:lista; p:prestamo);
	var
		aux:lista;
	begin
		new(aux);
		aux^.elem:=p;
		aux^.sig:=L;
		L:=aux;
	end;
	
	procedure agregar (a:arbol; x:integer; var v:vector);
	begin
		if (a <> nil) then begin
			if (a^.elem.codSocio > x) then begin
				agregarAdelante(v[a^.elem.mes],a^.elem);
				agregar(a^.HI,x,v);
				agregar(a^.HD,x,v);
			end
			else
				agregar(a^.HD,x,v);
		end;
	end;

var
	cod:integer;
begin
	writeln('Ingrese codigo de socio: ');readln(cod);
	agregar(a,cod,v);
end;

procedure imprimirVectorListas (v:vector);
	procedure imprimirLista(L:lista);
	begin
		if (L <> nil) then begin
			writeln;
			writeln('Codigo de libro: ',L^.elem.codLibro);
			writeln('Codigo de socio: ',L^.elem.codSocio);
			writeln('Mes del prestamo: ',L^.elem.mes);
			imprimirLista(L^.sig);
		end;
	end;
var
	i:integer;
begin
	for i:= 1 to 12 do begin
		writeln('-----MES ',i,'-----');
		imprimirLista(v[i]);
	end;
end;

procedure cantPrestamos (v:vector);
	procedure prestamos (L:lista; var cant:integer);
	begin
		if (L <> nil) then begin
			cant:= cant + 1;
			prestamos(L^.sig,i+1,cant);
		end;
	end;
var
	mes,cant:integer;
begin
	cant:=0;
	writeln('Ingrese mes: ');readln(mes);
	prestamos(v[mes],cant);
	writeln('La cantidad de prestamos para el mes ',mes,' es: ',cant);
end;

var
	a:arbol;
	v:vector;
	
begin
	cargoArbol(a);
	inicializo(v);
	prestamosPorMes(a,v);
	imprimirVectorListas(v);
	cantPrestamos(v);

end.
