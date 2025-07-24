program Ejercicio3;
const
	DIMF = 8;
type
	rangoSucursales = 0..DIMF;
	str = String[10];
		
	venta = record	
		codProd:integer;
		fecha:string;
		sucursal:rangoSucursales;
		cantVendida:integer;
	end;
	
	ventaMerge = record
		codProd:integer;
		total:integer;
	end;
	
	listaMerge = ^nodoMerge;
	nodoMerge = record
		elem:ventaMerge;
		sig:listaMerge;
	end;
	
	lista = ^nodo;
	nodo = record
		elem:venta;
		sig:lista;
	end;
	
	vector = array [1..DIMF] of lista;


procedure cargarVector (var v:vector);
	procedure leoVenta (var v:venta);
	begin
		with v do begin
			write('Sucursal: ');readln(sucursal);
			if (sucursal <> 0) then begin
				write('Codigo de producto: ');readln(codProd);
				write('Fecha: ');readln(fecha);
				write('Cantidad vendida: ');readln(cantVendida);
			end;
			writeln;
		end;
	end;
	
	procedure insertarOrdenado (var L:lista; v:venta);
	var
		aux,ant,act:lista;
	begin
		new(aux);
		aux^.elem:=v;
		ant:=L;
		act:=L;
		while (act <> nil) and (v.codProd > act^.elem.codProd) do begin
			ant := act;
			act := act^.sig;
		end;
		if (act = ant) then 
			L:= aux
		else
			ant^.sig:=aux;
		aux^.sig:= act;
	end;
	
	procedure inicializar (var v:vector);
	var
		i:integer;
	begin
		for i:= 1 to DIMF do
			v[i]:=nil;
	end;
var
	ve:venta;
	
begin
	inicializar(v);
	leoVenta(ve);
	while (ve.sucursal <> 0) do begin
		insertarOrdenado(v[ve.sucursal],ve);
		leoVenta(ve);
	end;
end;

procedure imprimirVectorListas (v:vector);
	procedure imprimirLista (L:lista);
	begin
		if (L <> NIL) then begin
			writeln('codigo de producto: ', L^.elem.codProd);
			writeln('cantidad vendida: ', L^.elem.cantVendida);
			writeln('Fecha: ', L^.elem.fecha);
			imprimirLista(L^.sig);
		end;
	end;
var
	i:integer;
begin
	for i:= 1 to DIMF do begin
		writeln('-------SUCURSAL ',i,' -------');
		imprimirLista(v[i]);
	end;
end;

procedure mergeAcumulador (v:vector; var L:listaMerge);
	procedure agregarAdelante (var L:listaMerge; v:ventaMerge);
	var
		aux:listaMerge;
	begin
		new(aux);
		aux^.elem:=v;
		aux^.sig:=L;
		L:=aux;
	end;
	
	procedure minimo (var v:vector; var min:venta);
	var
		i,indiceMin:integer;
	begin
		min.codProd := 9999;
		for i:= 1 to DIMF do begin
			if (v[i] <> nil) then begin
				if (v[i]^.elem.codProd <= min.codProd) then begin
					min:= v[i]^.elem;
					indiceMin:= i;
				end;
			end;
		end;
		if (min.codProd <> 9999) then
			v[indiceMin]:= v[indiceMin]^.sig;
	end;
	
var
	min,act:venta;
	reg:ventaMerge;
	suma:integer;
begin
	L:=NIL;
	minimo(v,min);
	while (min.codProd <> 9999) do begin
		act:=min;
		suma:=0;
		while (min.codProd <> 9999) and (act.codProd = min.codProd) do begin
			suma:= suma + min.cantVendida;
			minimo(v,min);
		end;
		reg.codProd := act.codProd;
		reg.total := suma;
		agregarAdelante(L,reg);
	end;
end;

procedure imprimirListaMerge (L:listaMerge);
begin
	if (L <> NIL) then begin
		writeln('codigo de producto: ', L^.elem.codProd);
		writeln('cantidad total vendida: ', L^.elem.total);
		writeln;
		imprimirListaMerge(L^.sig);
	end;
end;

var
	v:vector;
	L:listaMerge;
begin
	cargarVector(v);
	imprimirVectorListas(v);
	mergeAcumulador(v,L);
	writeln('--------LISTA MERGE--------');
	imprimirListaMerge(L);
end.
