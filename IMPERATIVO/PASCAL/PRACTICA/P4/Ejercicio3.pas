program Ejercio3;
const
	DIMF = 4;
type
	
	rangoSucursales = 0..DIMF;
	str = String[20];
	
	venta = record	
		fecha:str;
		codProd:integer;
		codSucursal:rangoSucursales;
		cantV:integer;
	end;
	
	lista = ^nodo;
	nodo = record	
		elem:venta;
		sig:lista;
	end;
	
	ventaAcotada = record
		codProd:integer;
		total:integer;
	end;
	
	listaMerge = ^nodoMerge;
	nodoMerge = record
		elem:ventaAcotada;
		sig:listaMerge;
	end;
	
	vector = array [1..DIMF] of lista;
	
procedure cargoVector (var v:vector);
	procedure insertarOrdenado (var L:lista; v:venta);
	var
		ant,act,aux:lista;
	begin
		new(aux);
		aux^.elem:=v;
		ant:=L;
		act:=L;
		while (act <> nil) and (v.codProd < act^.elem.codProd) do begin 
			ant:= act;
			act:= act^.sig;
		end;
		if (ant = act) then
			L:=aux
		else
			ant^.sig:=aux;
		aux^.sig:=act;
	end;
	
	procedure inicializar (var v:vector);
	var
		i:integer;
	begin
		for i:= 1 to DIMF do 
			v[i]:=nil;
	end;
	
	procedure leerVenta (var v:venta);
	begin
		with v do begin
			write('Codigo de sucursal: ');readln(codSucursal);
			if (codSucursal <> 0) then begin
				write('Codigo de producto: ');readln(codProd);
				cantV:= random(400) + 1;
				writeln('Cantidad Vendida: ',cantV);
				write('Fecha: ');readln(fecha);
				
			end;
			writeln;
		end;
	end;

var		
	ve:venta;
begin
	inicializar(v);
	leerVenta(ve);
	while (ve.codSucursal <> 0) do begin
		insertarOrdenado(v[ve.codSucursal],ve);
		leerVenta(ve);
	end;
end;


procedure imprimirVectorListas (v:vector);
	procedure imprimirLista (L:lista);
	begin
		if (L <> nil) then begin
			writeln('codigo de producto: ',L^.elem.codProd);
			writeln('codigo de sucursal: ',L^.elem.codSucursal);
			writeln('fecha: ',L^.elem.fecha);
			writeln('cantidad vendida: ',L^.elem.cantV);
			writeln;
			imprimirLista(L^.sig);
		end;
	end;
var
	i:integer;
begin
	for i:= 1 to DIMF do begin
		writeln('--------CODIGO DE SUCURSAL: ',i,' --------');
		imprimirLista(v[i]);
	end;
end;

procedure mergeAcumulador (v:vector; var L:listaMerge);
	procedure agregarAdelante (var L:listaMerge; v:ventaAcotada);
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
		indiceMin,i:integer;
	begin
		min.codProd := 9999;
		for i:= 1 to DIMF do begin
			if (v[i] <> nil) then begin
				if (v[i]^.elem.codProd <= min.codProd) then begin
					indiceMin:= i;
					min:= v[i]^.elem;
				end;
			end;
		end;
		if (min.codProd <> 9999) then
			v[indiceMin] := v[indiceMin]^.sig;
	end;
var
	min:venta;
	reg:ventaAcotada;
	act,total:integer;
begin
	L:=nil;
	minimo(v,min);
	while (min.codProd <> 9999) do begin
		act := min.codProd;
		total:= 0;
		while (min.codProd <> 9999) and (act = min.codProd) do begin
			total := total + min.cantV;
			minimo(v,min);
		end;
		reg.codProd := act;
		reg.total := total;
		agregarAdelante(L,reg);
	end;
end;

procedure imprimirLista (L:listaMerge);
begin
	if (L <> nil) then begin
		writeln('codigo de producto: ',L^.elem.codProd);
		writeln('total: ',L^.elem.total);
		writeln;
		imprimirLista(L^.sig);
	end;
end;


var
	v:vector;
	L:listaMerge;
begin
	cargoVector(v);
	imprimirVectorListas(v);
	mergeAcumulador(v,L);
	writeln('-------LISTA MERGE--------');
	imprimirLista(L);

end.
