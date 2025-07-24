program Parcial;

type
	rangoDias = 1..31;
	
	compra = record
		dia:rangoDias;
		codCli:integer;
		cantProd:integer;
		monto:real;
	end;
	
	lista = ^nodo;
	nodo = record	
		elem:compra;
		sig:lista;
	end;
	
	cliente = record
		codCli:integer;
		L:lista;
	end;
	
	arbol = ^nodoArbol;
	nodoArbol = record
		elem:cliente;
		HI:arbol;
		HD:arbol;
	end;

procedure cargoArbol (var a:arbol);
	procedure leoCompra (var c:compra);
	begin
		with c do begin
			write('Cantidad de productos: ');readln(cantProd);
			if (cantProd <> 0) then begin
				write('Codigo de cliente: ');readln(codCli);
				dia:= random(31) + 1;
				writeln('Dia: ',dia);
				monto:= random(3000) + 5;
				writeln('Monto: ',monto:2:2);
			end;
			writeln;
		end;
	end;
	
	procedure agregarAdelante (var L:lista; c:compra);
	var
		aux:lista;
	begin
		new(aux);
		aux^.elem := c;
		aux^.sig := L;
		L:= aux;
	end;
	
	procedure insertarNodo (var a:arbol; c:compra);
	begin
		if (a = nil) then begin
			new(a);
			a^.elem.codCli := c.codCli;
			a^.elem.L := nil;
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
		writeln('codcli: ',L^.elem.codCli);
		writeln('dia: ',L^.elem.dia);
		writeln('monto: ',L^.elem.monto:2:2);
		writeln('cant prod: ',L^.elem.cantProd);
		writeln;
		imprimirLista(L^.sig);
	end;
end;

procedure imprimirArboldeListas (a:arbol);
begin
	if (a <> nil) then begin
		imprimirArboldeListas(a^.HI);
		imprimirLista(a^.elem.L);
		imprimirArboldeListas(a^.HD);
	end;
end;

procedure comprasCliente (a:arbol; var L:lista);
	procedure buscar (a:arbol; cod:integer; var L:lista);
	begin
		if (a <> nil) then begin
			if (cod = a^.elem.codCli) then
				L:= a^.elem.L
			else
				if (cod < a^.elem.codCli) then 
					buscar(a^.HI,cod,L)
				else
					buscar(a^.HD,cod,L);
		end;
	end;
var
	cod:integer;
begin
	L:=nil;
	write('Ingrese codigo de cliente: ');readln(cod);
	buscar(a,cod,L);
end;

procedure masCantProd (L:lista);
	procedure maximo (L:lista; var max:integer; var monto:real);
	begin
		if (L <> nil) then begin
			if (L^.elem.cantProd > max) then begin
				max:= L^.elem.cantProd;
				monto := L^.elem.monto;				
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
	writeln('El monto de la compra con mayor cant de prod es: ',monto:2:2);
end;


var
	a:arbol;
	L:lista;
begin
	Randomize;
	cargoArbol(a);
	imprimirArboldeListas(a);
	comprasCliente(a,L);
	imprimirLista(L);
	masCantProd(L);
end.
		
