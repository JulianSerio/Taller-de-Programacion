program Parcial13;
type
	str = String[20];
		
	venta = record
		codProd:integer;
		monto:real;
		cantVendida:integer;
		fecha:str;
	end;
	
	ventaAcotada = record
		codProd:integer;
		total:integer;
	end;
	
	arbol = ^nodo;
	nodo = record
		elem:ventaAcotada;
		HI:arbol;
		HD:arbol;
	end;

procedure cargarArbol (var a:arbol);
	procedure leoVenta (var v:venta);
	begin
		with v do begin
			write('Codigo de producto: ');readln(codProd);
			if (codProd <> -1) then begin
				write('Cantidad vendida: ');readln(cantVendida);
				write('Fecha: ');readln(fecha);
				write('Monto: ');readln(monto);
			end;
			writeln;
		end;
	end;
	procedure insertarNodo (var a:arbol; v:ventaAcotada);
	begin
		if (a = nil) then begin
			new(a);
			a^.elem:=v;
			a^.HI:=nil;
			a^.HD:=nil;
		end
		else
			if (v.codProd = a^.elem.codProd) then 
				a^.elem.total := a^.elem.total + v.total
			else
				if (v.codProd < a^.elem.codProd) then
					insertarNodo(a^.HI,v)
				else
					insertarNodo(a^.HD,v);
	end;
var
	v:venta;
	vA:ventaAcotada;
begin
	a:=nil;
	leoVenta(v);
	while (v.codProd <> -1) do begin
		vA.codProd := v.codProd;
		vA.total := v.cantVendida;
		insertarNodo(a,vA);
		leoVenta(v);
	end;
end;

procedure imprimirArbol (a:arbol);
begin
	if (a <> nil) then begin
		imprimirArbol(a^.HI);
		writeln('codigo de producto: ',a^.elem.codProd);
		writeln('total: ',a^.elem.total);
		writeln;
		imprimirArbol(a^.HD);
	end;
end;

procedure cantCodigos (a:arbol);
	procedure buscar (a:arbol; cant:integer; var sum:integer);
	begin
		if (a <> nil) then begin
			if (a^.elem.total > cant) then
				sum:= sum + 1;
			buscar(a^.HI,cant,sum);
			buscar(a^.HD,cant,sum);
		end;
	end;
var
	cantRecibir:integer;
	sum:integer;
begin
	sum:=0;
	write('Cantidad a recibir: ');readln(cantRecibir);
	buscar(a,cantRecibir,sum);
	writeln('Codigos de producto mayores a la cant recibida: ',sum);
end;

var
	a:arbol;
begin
	cargarArbol(a);
	imprimirArbol(a);
	cantCodigos(a);
end.
