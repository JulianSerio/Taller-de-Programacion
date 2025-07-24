program parcial5;
type	
	
	str = String[20];
	
	venta = record	
		codProd:integer;
		fecha:str;
		cantVendida:integer;
		monto:real;
	end;
	
	ventaAcotada = record
		codProd:Integer;
		total:real;
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
		write('Codigo de producto: ');readln(v.codProd);
		if(v.codProd <> -1) then begin
			write('Fecha: ');readln(v.fecha);
			write('Cantidad vendida: ');readln(v.cantVendida);
			write('Monto: ');readln(v.monto);
		end;
		writeln;
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
				a^.elem.total:= a^.elem.total + v.total
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
		vA.total := v.monto;
		insertarNodo(a,vA);
		leoVenta(v);
	end;
end;

procedure sumaMontos (a:arbol);
	procedure buscar (a:arbol; cod:integer; var total:real);
	begin
		if (a <> nil) then begin
			if (a^.elem.codProd > cod) then begin
				total:= total + a^.elem.total;
				buscar(a^.HI,cod,total);
				buscar(a^.HD,cod,total);
			end
			else
				buscar(a^.HD,cod,total);
		end;
	end;
var
	total:real;
	cod:integer;
begin
	total:=0;
	write('Ingrese codigo: ');readln(cod);
	buscar(a,cod,total);
	writeln('La suma total de los codigos de productos mayores a ',cod,' es:',total:2:2);
end;

procedure imprimirArbol (a:arbol);
begin
	if (a <>nil) then begin
		imprimirArbol(a^.HI);
		writeln('codigo de producto: ',a^.elem.codProd);
		writeln('total: ',a^.elem.total:2:2);
		writeln;
		imprimirArbol(a^.HD);
	end;
end;

var
	a:arbol;
begin
	cargarArbol(a);
	imprimirArbol(a);
	sumaMontos(a)

end.
