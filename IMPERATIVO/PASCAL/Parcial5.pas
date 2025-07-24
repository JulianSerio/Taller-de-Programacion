program Parcial5;
type
	venta = record	
		fecha:integer;
		codProd:integer;
		cantVendida:integer;
		monto:real;
	end;
	
	ventaAcotada = record
		codProd:integer;
		totalVendido:real;
	end;
		
	arbol = ^nodo;
	nodo = record
		elem:ventaAcotada;
		HI:arbol;
		HD:arbol;
	end;
	
procedure cargoArbol (var a:arbol);
	procedure leoVenta (var v:venta);
	begin
		with v do begin
			write('Codigo de producto: ');readln(codProd);
			if (codProd <> -1) then begin
				write('Cantidad vendida: ');readln(cantVendida);
				write('Monto: ');readln(monto);
				write('Fecha: ');readln(fecha);
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
		else begin
			if (v.codProd = a^.elem.codProd) then 
				a^.elem.totalVendido := a^.elem.totalVendido + v.totalVendido
			else begin
				if (v.codProd < a^.elem.codProd) then 
					insertarNodo(a^.HI,v)
				else
					insertarNodo(a^.HD,v);
			end;
		end;
	end;
	
var	
	v:venta;
	v2:ventaAcotada;
begin
	leoVenta(v);
	while (v.codProd <> -1) do begin
		v2.codProd := v.codProd;
		v2.totalVendido := v.monto;
		insertarNodo(a,v2);
		leoVenta(v);
	end;
end;

procedure imprimirArbol (a:arbol);
begin
	if (a <> nil) then begin
		imprimirArbol(a^.HI);
		writeln('------VENTA-----');
		writeln('codigo: ',a^.elem.codProd);
		writeln('total vendido: ',a^.elem.totalVendido:2:2);
		imprimirArbol(a^.HD);
	end;
end;

procedure sumoMontos (a:arbol);
	procedure buscar (a:arbol; cod:integer; var total:real);
	begin
		if (a <> nil) then begin
			if (a^.elem.codProd > cod) then begin
				total := total + a^.elem.totalVendido;
				buscar(a^.HI,cod,total);
				buscar(a^.HD,cod,total);
			end
			else
				buscar(a^.HD,cod,total);
		end;
	end;
var
	cod:integer;
	total:real;
begin
	total:=0;
	write('Ingrese codigo de producto: ');readln(cod);
	buscar(a,cod,total);
	writeln('La suma es: ',total:2:2); 
end;
		
		
var
	a:arbol;
begin
	a:=nil;
	cargoArbol(a);
	imprimirArbol(a);
	sumoMontos(a);
end.

