program Parcial2;
const
	DIMF = 10;
type

	rangoCodigos = 0..DIMF;
	rangoLibros = 1..300000;
	rangoMeses = 1..12;
	
	prestamo = record
		codSocio:rangoCodigos;
		codLibro:rangoLibros;
		mes:rangoMeses;
	end;
	
	lista = ^nodoLista;
	nodoLista = record
		elem:prestamo;
		sig:lista;
	end;
	
	vector = array [1..DIMF] of lista;
	
	vContador = array [1..DIMF] of integer;

procedure cargarVectorListas (var v:vector);
	procedure inicializo (var v:vector);
	var
		i:integer;
	begin
		for i:= 1 to DIMF do begin
			v[i]:=nil;
		end;
	end;
	
	procedure agregarAdelante(var L:lista; p:prestamo);
	var
		aux:lista;
	begin
		new(aux);
		aux^.elem:=p;
		aux^.sig:=L;
		L:=aux;
	end;
	
	procedure leoPrestamo (var p:prestamo);
	begin
		with p do begin
			write('Codigo de socio: ');readln(codSocio);
			if (codSocio <> 0) then begin
				write('Codigo de libro: ');readln(codLibro);
				write('Mes: ');readln(mes);
			end;
			writeln;
		end;
	end;
var
	p:prestamo;
begin
	leoPrestamo(p);
	while (p.codSocio <> 0) do begin
		agregarAdelante(v[p.codSocio],p);
		leoPrestamo(p);
	end;
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
	for i:= 1 to DIMF do begin
		writeln('-----MES ',i,'-----');
		imprimirLista(v[i]);
	end;
end;

procedure cantTotalPrestamos(v:vector; var vC:vContador);
	procedure inicializoVC (var v:vContador); 
	var
		i:integer;
	begin
		for i:= 1 to DIMF do 
			v[i]:=0;
	end;
	
	procedure recorroLista (L:lista; var vC:vContador);
	begin
		if (L <> nil) then begin
			vC[L^.elem.codSocio] := vC[L^.elem.codSocio] + 1;
			recorroLista(L^.sig,vC);
		end;
	end;
	
	procedure totalPrestamos (v:vector; var vC:vContador; i:integer);
	begin
		if (i <= DIMF) then begin
			if (v[i] <> nil) then begin
				recorroLista(v[i],vC);
			end;
			totalPrestamos(v,vC,i+1);
		end;
	end;
	
	procedure imprimirVectorContador (v:vContador);
	var
		i:integer;
	begin
		for i:= 1 to DIMF do
			writeln('EL MES ',i,' tuvo ',v[i], ' prestamos'); 
	end;
begin
	inicializoVC(vC);
	totalPrestamos(v,vC,1);
	imprimirVectorContador(vC);
end;


procedure ordenarVector (var v:vContador);
var
	i,j,p:integer;
	item:integer;
begin
	for i:= 1 to DIMF - 1 do begin
		p:=i;
		for j:= i + 1 to DIMF do begin
			if (v[j] < v[p]) then
				p:=j;
		end;
		item:=v[p];
		v[p]:=v[i];
		v[i]:=item;
	end;
end;

procedure imprimirValores (v:vContador);
var
	i:integer;
begin
	for i:= 1 to DIMF do 
		writeln(v[i]);
end;

VAR
	v:vector;
	vC:vContador;
begin
	cargarVectorListas(v);
	imprimirVectorListas(v);
	cantTotalPrestamos(v,vC);
	ordenarVector(vC);
	imprimirValores(vC);
end.
