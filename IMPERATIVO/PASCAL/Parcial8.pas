program Parcial8;
type

	compra = record	
		codCli:integer;
		dia:integer;
		cantProd:integer;
		monto:real;
	end;
	
	lista = ^nodoLista;
	nodoLista = record
		elem:compra;
		sig:lista;
	end;
	
	cliente = record
		codCli:integer;
		L:lista;
	end;
	
	arbol = ^nodo;
	nodo = record
		elem:cliente;
		HI:arbol;
		HD:arbol;
	end;
	
procedure cargoArbol (var a:arbol);	
	procedure agregarAdelante (var L:lista; c:compra);
	var
		aux:lista;
	begin
		new(aux);
		aux^.elem:=c;
		aux^.sig:=L;
		L:=aux;
	end; 
	
	procedure insertarNodo (var a:arbol; c:compra);
	begin
		if (a = nil) then begin
			new(a);
			a^.elem.L := nil;
			a^.elem.codCli := c.codCli;
			agregarAdelante(a^.elem.L,c);
			a^.HI:=nil;
			a^.HD:=nil;
		end
		else
			if (c.codCli = a^.elem.codCli) then
				agregarAdelante(a^.elem.L,c)
			else
				if (c.codCli < a^.elem.codCli) then
					insertarNodo(a^.HI,c)
				else
					insertarNodo(a^.HD,c);
	end;
	
	procedure leoCompra (var c:compra);
	begin
		with c do begin
			write('Cantidad de productos: ');readln(cantProd);
			if (cantProd <> 0) then begin
				write('Codigo de cliente: ');readln(codCli);
				write('Dia: ');readln(dia);
				write('Monto: ');readln(monto);
			end;
			writeln;
		end;
	end;
var
	c:compra;
begin
	a:=nil;
	leoCompra(c);
	while (c.cantProd <> 0) do begin
		insertarNodo(a,c);
		leoCompra(c);
	end;
end;

procedure imprimirLista (L:lista);
begin
	if (L <> nil) then begin
		writeln('codigo cliente: ',L^.elem.codCli);
		writeln('cant prod: ',L^.elem.cantProd);
		writeln('dia: ',L^.elem.dia);
		writeln('monto:',L^.elem.monto:2:2);
		writeln;
		imprimirLista(L^.sig);
	end;
end;

procedure imprimirArbolListas (a:arbol);
begin
	if (a <> nil) then begin
		imprimirArbolListas(a^.HI);
		writeln('----- LISTA CLIENTE ',a^.elem.codCli,' -----');
		imprimirLista(a^.elem.L);
		imprimirArbolListas(a^.HD);
	end;
end;

procedure comprasCliente (a:arbol; var L:lista); 
	procedure buscar (a:arbol; var L:lista; cod:integer);
	begin
		if (a <> nil) then begin
			if (cod = a^.elem.codCli) then
				L:= a^.elem.L
			else
				if (cod < a^.elem.codCli) then
					buscar(a^.HI,L,cod)
				else
					buscar(a^.HD,L,cod);
		end;
	end;
var
	cod:integer;
begin
	writeln;
	write('Ingrese codigo de cliente a buscar: ');readln(cod);
	buscar(a,L,cod);
end;

procedure compraMax (L:lista);
	procedure maximo (L:lista; var max:integer; var monto:real);
	begin
		if (L <> nil) then begin
			if (L^.elem.cantProd > max) then begin
				max:= L^.elem.cantProd;
				monto:= L^.elem.monto;
			end;
			maximo(L^.sig,max,monto);
		end;
	end;
var
	max:integer;
	monto:real;
begin
	max:=-1;
	maximo(L,max,monto);
	writeln('El monto de la compra con mayor cantidad de productos es: ',monto:2:2, ' y la cantidad de productos es: ',max);
end;

var
	a:arbol;
	L:lista;
begin
	L:=nil;
	cargoArbol(a);
	imprimirArbolListas(a);
	comprasCliente(a,L);
	imprimirLista(L);
	compraMax(L);
end.
