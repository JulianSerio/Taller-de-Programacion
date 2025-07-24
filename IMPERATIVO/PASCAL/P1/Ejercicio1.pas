program Ejercicio1;
const 
	DIMF = 20;
type
	rangoProd = 0..15;
	rangoCant = 1..99;
	
	venta = record
		codProd:rangoProd;
		cantVendida:rangoCant;
	end;
	
	vector = array [1..DIMF] of venta;
	
	lista = ^nodo;
	nodo = record
		elem:venta;
		sig:lista;
	end;
	
procedure leoVenta (var v:venta);
begin
	with v do begin
		Randomize;
		codProd := Random(16);
		if (codProd <> 0) then begin
			writeln('Ingrese codigo de producto: ', codProd);
			write('Ingrese cantidad de unidades: ');Readln(cantVendida);
		end;
	end;
end;

procedure cargoVector (var v:vector; var dimL:integer);
var
	ve:venta;
begin
	dimL:=0;
	leoVenta(ve);
	while (ve.codProd <> 0) and (dimL < DIMF) do begin
		dimL:= dimL + 1;
		v[dimL]:= ve;
		leoVenta(ve);
	end;
end;

procedure imprimoVector (v:vector; dimL:integer);
var
	i:integer;
begin
	for i:= 1 to dimL do begin
		writeln('-----VENTA-----');
		writeln('CODIGO DE PRODUCTO: ',v[i].codProd);
		writeln('CANT VENDIDA: ',v[i].cantVendida);
		writeln();
	end;
end;

procedure ordenarSeleccion (var v:vector; dimL:integer);
var
	p,j,i:integer;
	item:venta;
begin
	for i:= 1 to dimL - 1 do begin
		p:=i;
		for j:= i + 1 to dimL do begin
			if (v[j].codProd < v[p].codProd) then begin
				p:=j;
			end;
		end;
		item := v[p];
		v[p] := v[i];
		v[i] := item;
	end;
end;

procedure Eliminar (var v: vector; var dimL: integer; valorInferior, valorSuperior: integer);

  function BuscarPosicion (v: vector; dimL: integer; elemABuscar: integer): integer;
  var pos: integer;
  begin
    pos:= 1;
    while (pos <= dimL) and (elemABuscar > v[pos].codProd) do
       pos:= pos + 1;
    if (pos > dimL) then 
		BuscarPosicion:= 0
	else 
		BuscarPosicion:= pos;
  end;
  
  function BuscarPosicionDesde (v: vector; dimL, pos : integer; elemABuscar: integer): integer;
  begin
    while (pos <= dimL) and (elemABuscar >= v[pos].codProd) do
       pos:= pos + 1;
    if (pos > dimL) then 
		BuscarPosicionDesde:= dimL
    else 
		BuscarPosicionDesde:= pos - 1;
  end;

var posInferior, posSuperior, salto: integer; 
Begin
	posInferior:= BuscarPosicion (v, dimL, valorInferior);
	if (posInferior <> 0) then begin
		{Escribir el código correspondiente para hacer el corrimiento y disminuir la dimensión lógica}
		posSuperior:= BuscarPosicionDesde (v, dimL, posInferior, valorSuperior);
        salto:= (posSuperior - posInferior) + 1;
        writeln('valor superior ',valorSuperior);
        writeln('valor inferior ',valorInferior);
        writeln('pos superior ',posSuperior);
        writeln('pos inferior ',posInferior);
        dimL:= dimL - salto;
    end;
end;

procedure insertarOrdenado (var L:lista; v:venta);
var
	ant,act,aux:lista;
begin
	new(aux);
	aux^.elem:= v;
	ant:=L;
	act:=L;
	while (act <> nil) and (act^.elem.codProd > v.codProd) do begin
		ant:= act;
		act:= act^.sig;
	end;
	if (act = ant) then begin
		L:= aux;
	end
	else	
		ant^.sig := aux;
	aux^.sig:= act
end;

procedure generoLista (var L:lista; v:vector; dimL:integer);
var
	i:Integer;
begin
	for i:= 1 to dimL do begin
		if (v[i].codProd mod 2 = 0) then begin
			insertarOrdenado(L,v[i]);
		end;
	end;
end;

procedure imprimoLista (L:lista);
begin
	if (L <> nil) then begin
		writeln('Codigo de producto: ',L^.elem.codProd);
		writeln('Cantidad de venta: ',L^.elem.cantVendida);
		imprimoLista(L^.sig);
	end;
end;

var
	v:vector;
	dimL,valorInferior,valorSuperior:integer;
	L:lista;
begin
	L:=nil;
	cargoVector(v,dimL); //a
	writeln('------VECTOR DESORDENADO------');
	imprimoVector(v,dimL); //b
	writeln('------VECTOR ORDENADOR------');
	ordenarSeleccion(v,dimL); //c
	imprimoVector(v,dimL); //d
	write('Ingrese valor superior: ');Readln(valorSuperior); 
	write('Ingrese valor inferior: ');Readln(valorInferior); 
	Eliminar(v,dimL,valorInferior,valorSuperior); //e
	writeln('------VECTOR POST ELIMINACION------');
	imprimoVector(v,dimL); //f
	generoLista(L,v,dimL); //g
	writeln('------LISTA------');
	imprimoLista(L); //h
end.
