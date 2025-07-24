program Parcial2;
const 
	DIMF = 10;
type
	rangoSocio = 0..DIMF;
	rangoLibro = 1..15000;
	rangoMeses = 1..12;

	prestamo = record	
		codSocio:rangoSocio;
		codLibro:rangoLibro;
		mes:rangoMeses;
	end;
	
	lista = ^nodo;
	nodo = record
		elem:prestamo;
		sig:lista;
	end;
	
	vector = array [1..DIMF] of lista;
	vContador = array [1..DIMF] of integer;

procedure cargarVector (var v:vector);
	procedure inicializar (var v:vector);
	var
		i:integer;
	begin
		for i:= 1 to DIMF do begin
			v[i]:=nil;
		end;
	end;
	
	procedure leoPrestamo (var p:prestamo);
	begin
		with p do begin
			write('Codigo de socio: ');readln(codSocio);
			if (codSocio <> 0) then begin
				codLibro := random(15000) + 1;
				writeln('Codigo de libro: ',codLibro);
				mes := random(12) + 1;
				writeln('Mes: ',mes);
			end;
			writeln;
		end;
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
var
	p:prestamo;
begin
	inicializar(v);
	leoPrestamo(p);
	while (p.codSocio <> 0) do begin
		agregarAdelante(V[p.codSocio],p);
		leoPrestamo(p);
	end;
end;

procedure imprimirVector (v:vector);
	procedure imprimirLista (L:lista);
	begin
		if (L <> nil) then begin
			writeln('codigo de socio: ',L^.elem.codSocio);
			writeln('codigo de libro',L^.elem.codLibro);
			writeln('mes: ',L^.elem.mes);
			imprimirLista(L^.sig);
		end;
	end;
var
	i:Integer;
begin
	for i:= 1 to DIMF do begin
		writeln('-------COD SOCIO ',i,' ------');
		imprimirLista(v[i]);
	end;
end;


procedure inicializar (var v:vContador);
var
	i:integer;
begin
	for i:= 1 to DIMF do
		v[i]:=0;
end;

procedure cargarVectorContador (v:vector; var vC:vContador; i:integer);
	procedure recorroYsumo (L:lista; var vC:vContador);
	begin
		if (L <> nil) then begin
			vC[L^.elem.codSocio] := vC[L^.elem.codSocio] + 1;
			recorroYsumo(L^.sig,vC);
		end;
	end;
begin
	if (i <= DIMF) then begin
		recorroYsumo(v[i],vC);
		cargarVectorContador(v,vC,i+1);
	end;
end;

procedure ordenar (var v:vContador);
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
		item:= v[p];
		v[p]:= v[i];
		v[i]:=item;
	end;
end;

procedure imprimirVectorContador (v:vContador);
var
	i:integer;
begin
	for i:= 1 to DIMF do begin
		writeln('------CODIGO DE CLIENTE ',i,' --------');
		writeln('TOTAL PRESTAMOS: ',v[i]);
	end;
end;

var
	v:vector;
	vC:vContador;
begin
	Randomize;
	cargarVector(v);
	imprimirVector(v);
	cargarVectorContador(v,vC,1);
	imprimirVectorContador(vC);
	writeln('--------------');
	ordenar(vC);
	writeln('--------------');
	imprimirVectorContador(vC);
end.
