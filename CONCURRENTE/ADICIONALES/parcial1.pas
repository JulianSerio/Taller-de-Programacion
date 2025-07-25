program parcial;
const
	DIMF = 10; //5000
type
	
	rangoSocios = 0..DIMF;
	rangoLibros = 1..15000;
	meses = 1..12;
	
	prestamo = record
		codSocio:rangoSocios;
		codLibro:rangoLibros;
		mes:meses
	end;
	
	lista = ^nodo;
	nodo = record
		elem:prestamo;
		sig:lista;
	end;
	
	vector = array [rangoSocios] of lista;
	vContador = array [rangoSocios] of integer;

procedure cargoVector (var v:vector);
	procedure leoPrestamo (var p:prestamo);
	begin
		with p do begin
			write('Codigo Socio: ');Readln(codSocio);
			if (codSocio <> 0) then begin
				write('Codigo Libro: ');Readln(codLibro);
				write('Mes: ');Readln(mes);
			end; 
		end;
		writeln();
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
	
	procedure inicializo (var v:vector);
	var
		i:integer;
	begin
		for i:= 1 to DIMF do 
			v[i]:=nil
	end;
var
	p:prestamo;
begin
	inicializo(v);
	leoPrestamo(p);
	while (p.codSocio <> 0) do begin
		agregarAdelante(v[p.codSocio],p);
		leoPrestamo(p);
	end;
end;

procedure imprimoVectorListas (v:vector);
	procedure imprimoLista (L:lista);
	begin
		if (L <> nil) then begin
			writeln('codigo de socio: ',L^.elem.codSocio);
			writeln('codigo de libro: ',L^.elem.codLibro);
			writeln('mes: ',L^.elem.mes);
			imprimoLista(L^.sig);
			writeln();
		end;
	end;
var
	i:integer;
begin
	for i:= 1 to DIMF do begin
		writeln('----CODIGO DE SOCIO ',i,' ----');
		imprimoLista(v[i]);
	end;
end;


procedure inicializo(var v:vContador);
var
	i:integer;
begin
	for i:= 1 to DIMF do 
		v[i]:=0;
end;

procedure cargoVectorContador (v:vector; var vC:VContador; var i:integer);
	procedure recorroLista (L:lista; var vC:VContador);
	begin
		if (L <> nil) then begin
			vC[i]:= vC[i] + 1;
			recorroLista(L^.sig,vC);
		end;
	end;
begin
	if (i <= DIMF) then begin
		i:= i + 1;
		recorroLista(v[i],vC);
		cargoVectorContador(v,vC,i);
	end;
end;

procedure muestroVectorContador (v:vContador);
var
	i:integer;
begin
	for i:= 1 to DIMF do begin
		writeln('CODIGO SOCIO: ',i);
		writeln('TOTAL: ',v[i]);
	end;
end;

procedure ordenoVector (var v:vContador);
var
	i,j,p:integer;
	item:integer;
begin
	for i:= 1 to DIMF - 1 do begin
		p:= i;
		for j:= i + 1 to DIMF do begin
			if (v[j] > v[p]) then 
				p:=j;
		end;
		item:= v[p];
		v[p]:= v[i];
		v[i]:= item;
	end;

end;
		
var
	v:vector;
	vC:vContador;
	i:integer;
begin
	i:=0;
	cargoVector(v);
	imprimoVectorListas(v);
	inicializo(vC);
	cargoVectorContador(v,vC,i);
	writeln('---VECTOR SIN ORDENAR---');
	muestroVectorContador(vC);
	ordenoVector(vC);
	writeln('---VECTOR ORDENADO---');
	muestroVectorContador(vC);
end.
