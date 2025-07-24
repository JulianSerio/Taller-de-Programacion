program parcial1;
type 
	
	rangoSocio = 1..5000;
	rangoLibro = 0..300000;
	rangoMeses = 1..12;
	
	prestamo = record
		codSocio:rangoSocio;
		codLibro:rangoLibro;
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
		
procedure cargarArbol (var a:arbol);
	procedure leoPrestamo (var p:prestamo);
	begin
		with p do begin
			write('Codigo de libro: ');readln(codLibro);
			if (codLibro <> 0) then begin
				write('Codigo de socio: ');readln(codSocio);
				write('Mes ');readln(mes);
			end;
			writeln;
		end;
	end;
	
	procedure insertarNodo (var a:arbol; p:prestamo);
	begin
		if (a = nil) then begin
			new(a);
			a^.elem:=p;
			a^.HI:=nil;
			a^.HD:=nil;
		end
		else
			if (p.codSocio < a^.elem.codSocio) then 
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

procedure cargoVectorListas (a:arbol; var v:vector);
	procedure inicializar (var v:vector);
	var
		i:integer;
	begin
		for i:= 1 to 12 do 
			v[i]:=nil;
	end;
	
	procedure agregarAdelante (var L:lista; p:prestamo);
	var
		aux:lista;
	begin
		new(aux);
		aux^.elem:=p;
		aux^.sig:=L;
		L:=aux;
	end;
	
	procedure buscar (a:arbol; codSocio:integer; var v:vector);
	begin
		if (a <> nil) then begin
			if (a^.elem.codSocio > codSocio) then begin
				agregarAdelante(v[a^.elem.mes],a^.elem);
				buscar(a^.HI,codSocio,v);
				buscar(a^.HD,codSocio,v);
			end
			else
				if (codSocio < a^.elem.codSocio) then 
					buscar(a^.HI,codSocio,v)
				else
					buscar(a^.HD,codSocio,v);
		end;
	end;
var
	codSocio:integer;
begin
	inicializar(v);
	write('Codigo de socio: ');readln(codSocio);
	buscar(a,codSocio,v);
end;

procedure imprimirVectorListas (v:vector);
	procedure imprimirLista (L:lista);
	begin
		if (L <> nil) then begin
			writeln('Codigo de cliente: ',L^.elem.codSocio);
			writeln('Codigo de libro: ',L^.elem.codLibro);
			writeln('Mes: ',L^.elem.mes);
			writeln;
			imprimirLista(L^.sig);
		end;
	end;
var
	i:integer;
begin
	for i:= 1 to 12 do begin
		writeln('------MES ',i,' -----');
		imprimirLista(v[i]);
	end;
end;

procedure cantPrestamos (v:vector);
	procedure cantidad (L:lista; var cant:integer);
	begin
		if (L <> nil) then begin
			cant := cant + 1;
			cantidad(L^.sig,cant);
		end;
	end;
var
	mes:rangoMeses;
	cant:integer;
begin
	cant:=0;
	write('Mes ');readln(mes);
	cantidad(v[mes],cant);
	writeln(cant);

end;

var
	a:arbol;
	v:vector;
begin
	cargarArbol(a);
	cargoVectorListas(a,v);
	imprimirVectorListas(v);
	cantPrestamos(v);
end.

