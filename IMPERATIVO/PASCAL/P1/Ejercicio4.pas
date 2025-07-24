program Ejercicio4;
const
	DIMF = 30;
type
	rangoRubro = 1..8;
	
	producto = record
		codProd:integer;
		codRubro:rangoRubro;
		precio:real;
	end;
	
	lista = ^nodo;
	nodo = record
		elem:producto;
		sig:lista;
	end;
	
	vector = array [rangoRubro] of lista;
	
	vProd = array [1..DIMF] of producto;

procedure cargoVectorDeListas (var v:vector);
	procedure inicializar (var v:vector);
	var
		i:Integer;
	begin
		for i:= 1 to 8 do 
			v[i]:=nil;
	
	end; 
	
	procedure insertarOrdenado (var L:lista; p:producto);
	var
		ant,aux,act:lista;
	begin
		new(aux);
		aux^.elem:=p;
		ant:= L;
		act:= L;
		while (act <> nil) and (act^.elem.codProd < p.codProd) do begin
			ant:=act;
			act:= act^.sig;
		end;
		if (ant = act) then
			L:= aux
		else
			ant^.sig:= aux;
		aux^.sig:=act
	end;
	
	procedure leerProducto (var p:producto);
	begin
		writeln('-----PRODUCTO------');
		write('Precio: ');Readln(p.precio);
		if (p.precio <> 0) then begin
			write('Codigo de producto: ');Readln(p.codProd);
			write('Codigo de rubro: ');Readln(p.codRubro);
		end;
	end;
var
	p:producto;
begin
	leerProducto(p);
	while (p.precio <> 0) do begin
		insertarOrdenado(v[p.codRubro],p);
		leerProducto(p);
	end;
end;

procedure imprimoVectorListas (v:vector);
	procedure imprimoLista(L:lista);
	begin
		if (L <> nil) then begin
			writeln('----producto---');
			writeln('codigo: ',L^.elem.codProd);
			writeln();
			imprimoLista(L^.sig);
		end;
	end;
var
	i:integer;
begin
	for i:= 1 to 8 do begin
		writeln();
		writeln('----RUBRO ',i,' ----');
		imprimoLista(v[i]);
	end;
end;

procedure productoRubroTres (v:vector; var vP:vProd; var dimL:integer);
begin
	while (v[3] <> nil) and (dimL < DIMF) do begin	
		dimL:= dimL + 1;
		vP[dimL] := v[3]^.elem;
		v[3] := v[3]^.sig;
	end;
end;

procedure ordenoVector (var v:vProd; dimL:integer);
var
	p,j,i:integer;
	item:producto;
begin
	for i:= 1 to dimL - 1 do begin
		p:=i;
		for j:= i + 1 to dimL do 
			if (v[j].precio < v[p].precio) then 
				p:=j;
		item := v[p];
		v[p] := v[i];
		v[i] := item;
	end;
end;

procedure imprimoVector (v:vProd; dimL:integer);
var
	i:integer;
begin
	for i:= 1 to dimL do begin
		writeln('-------PRODUCTO ',i,' -------');
		writeln('precio: ',v[i].precio:2:2);
	end;
end;


var
	v:vector;
	vP:vProd;
	dimL:integer;
begin
	dimL:=0;
	cargoVectorDeListas(v); //a
	imprimoVectorListas(v);	//b
	productoRubroTres(v,vP,dimL); //c
	ordenoVector(vP,dimL); //d
	imprimoVector(vP,dimL); //e
end.






