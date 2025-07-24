program Ejercicio2;
type
	
	venta = record
		codProd:integer;
		fecha:Integer;
		cantUnidades:integer;
	end;
	
	ventaAcotada = record
		codProd:integer;
		cantTotal:integer;
	end;
	
	arbol = ^nodo;
	nodo = record
		elem:venta;
		HI:arbol;
		HD:arbol;
	end;
	
	arbolAcotado = ^nodoAcotado;
	nodoAcotado = record
		elem:ventaAcotada;
		HI:arbolAcotado;
		HD:arbolAcotado;
	end;

procedure cargarArbol (var a:arbol; var aA:arbolAcotado);
	procedure leoVenta (var v:venta);
	begin
		with v do begin
			write('Codigo de Producto: ');Readln(codProd);
			if (codProd <> 0) then begin
				write('Fecha: ');Readln(fecha);
				write('Cantidad de unidades vendidas: ');Readln(cantUnidades);
			end;
			writeln;
		end;
	end;
	
	procedure insertoNodo (var a:arbol; v:venta);
	begin
		if (a = nil) then begin
			new(a);
			a^.elem:=v;
			a^.HI:= nil;
			a^.HD:= nil;
		end
		else begin
			if (v.codProd <= a^.elem.codProd) then 
				insertoNodo(a^.HI,v)
			else
				insertoNodo(a^.HD,v);
		end;
	end;
	procedure insertoNodo2 (var a:arbolAcotado; v:ventaAcotada);
	begin
		if (a = nil) then begin
			new(a);
			a^.elem:=v;
			a^.HI:= nil;
			a^.HD:= nil;
		end
		else begin
			if (v.codProd = a^.elem.codProd) then // si el codigo que se lee es el mismo que el que esta ahora 
				a^.elem.cantTotal := a^.elem.cantTotal + v.cantTotal // sumo las unidades
			else begin
				if (v.codProd < a^.elem.codProd) then // si es menor 
					insertoNodo2(a^.HI,v) //al hijo izq
				else //sino 
					insertoNodo2(a^.HD,v); // al hijo der
			end;
		end;
	end;
var
	v:venta;
	vA:ventaAcotada;
begin
	a:=nil;
	aA:=NIL;
	leoVenta(v);
	while (v.codProd <> 0) do begin
		insertoNodo(a,v); //inserto en el arbol 1
		vA.codProd := v.codProd; //asigno los campos al record acotado
		vA.cantTotal:= v.cantUnidades; 
		insertoNodo2(aA,vA); //inserto en el arbol 2
		leoVenta(v);
	end;
end;

procedure imprimirArbol (a:arbol);
begin
	if (a <> nil) then begin
		imprimirArbol(a^.HI);
		writeln('----VENTA----');
		writeln('codigo: ',a^.elem.codProd);
		writeln('fecha: ',a^.elem.fecha);
		writeln('cant unidades vendidas: ',a^.elem.cantUnidades);
		imprimirArbol(a^.HD);
	end;
end;

procedure imprimirArbolAcotado(a:arbolAcotado);
begin
	if (a <> nil) then begin
		imprimirArbolAcotado(a^.HI);
		writeln('----VENTA----');
		writeln('codigo: ',a^.elem.codProd);
		writeln('total: ',a^.elem.cantTotal);
		imprimirArbolAcotado(a^.HD);
	end;
end;

procedure totalUnidadesVArbol (a:arbol);
	procedure buscar (a:arbol; cod:integer; var cant:integer);
	begin
		if (a <> nil) then begin
			if (cod = a^.elem.codProd) then begin
				cant:= cant + a^.elem.cantUnidades;
				buscar(a^.HI,cod,cant);
			end
			else begin
				if (cod < a^.elem.codProd) then
					buscar(a^.HI,cod,cant)
				else
					buscar(a^.HD,cod,cant);
			end;
		end;
	end;
var
	cod,cant:integer;
begin
	cant:=0;
	write('Ingrese codigo de producto a buscar: ');Readln(cod);
	buscar(a,cod,cant);
	writeln('La cantidad de productos vendidos para el codigo ',cod, ' es: ',cant);
end;

procedure totalUnidadesVArbolAcotado (a:arbolAcotado);
	procedure buscar (a:arbolAcotado; cod:integer; var cant:integer);
	begin
		if (a <> nil) then begin
			if (cod = a^.elem.codProd) then 
				cant:= a^.elem.cantTotal
			else begin
				if (cod < a^.elem.codProd) then 	
					buscar(a^.HI,cod,cant)
				else
					buscar(a^.HD,cod,cant);
			end;
		end;
	end;

var
	cod,cant:integer;
begin
	cant:=0;
	write('Ingrese codigo de producto a buscar: ');Readln(cod);
	buscar(a,cod,cant);
	writeln('La cantidad de productos vendidos para el codigo ',cod, ' es: ',cant);
end;

var
	a:arbol;
	a2:arbolAcotado;
begin
	cargarArbol(a,a2);
	imprimirArbol(a);
	writeln('------------------');
	imprimirArbolAcotado(a2);
	totalUnidadesVArbol(a);
	totalUnidadesVArbolAcotado(a2);
end.
