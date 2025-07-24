program Parcial7;
type
	rangoDias = 1..31;
	
	compra = record
		codCli:integer;
		dia:rangoDias;
		cantProd:integer;
		monto:real;
	end;
	
	arbol = ^nodo;
	nodo = record
		elem:compra;
		HI:arbol;
		HD:arbol;
	end;
	
	lista = ^nodoLista;
	nodoLista = record
		elem:compra;
		sig:lista;
	end;

procedure cargarArbol (var a:arbol);
	procedure leoCompra (var c:compra);
	begin
		with c do begin
			write('Cantidad de productos: ');readln(cantProd);
			if (cantProd <> 0) then begin
				write('Codigo de cliente: ');readln(codCli);
				monto:= random(8000) + 150.70;
				writeln('Monto: ',monto:2:2);
				dia:= random(31) + 1;
				writeln('Dia: ',dia);
			end;
			writeln;
		end;
	end;
	
	procedure insertarNodo (var a:arbol; c:compra);
	begin
		if (a = nil) then begin
			new(a);
			a^.elem:=c;
			a^.HI:=nil;
			a^.HD:=nil;
		end
		else
			if (c.codCli <= a^.elem.codCli) then
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

procedure imprimirArbol (a:arbol);
begin
	if (a <> nil) then begin
		imprimirArbol(a^.HI);
		writeln('cod cli: ',a^.elem.codCli);
		writeln('cant prod: ',a^.elem.cantProd);
		writeln('dia: ',a^.elem.dia);
		writeln('monto: ',a^.elem.monto:2:2);
		writeln;
		imprimirArbol(a^.HD);
	end;
end;

procedure comprasCliente (a:arbol; var L:lista);
	procedure agregarAdelante (var L:lista; c:compra);
	var
		aux:lista;
	begin
		new(aux);
		aux^.elem:=c;
		aux^.sig:=L;
		L:=aux;
	end;
	
	procedure buscar (a:arbol; cod:integer; var L:lista);
	begin
		if (a <> nil) then begin
			if (cod = a^.elem.codCli) then begin
				agregarAdelante(L,a^.elem);
				buscar(a^.HI,cod,L);
			end
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
	write('Ingrese codigo de cliente a buscar: ');readln(cod);
	buscar(a,cod,L);
end;

procedure imprimirLista (L:lista);
begin
	if (L <> nil) then begin
		writeln('cod cli: ',L^.elem.codCli);
		writeln('cant prod: ',L^.elem.cantProd);
		writeln('dia: ',L^.elem.dia);
		writeln('monto: ',L^.elem.monto:2:2);
		writeln;
		imprimirLista(L^.sig);
	end;
end;

procedure totalGastado (L:lista);
	procedure total (L:lista; var suma:real);
	begin
		if (L <> nil) then begin
			suma:= suma + L^.elem.monto;
			total(L^.sig,suma);
		end;
	end;
var
	suma:real;
begin
	suma:=0;
	total(L,suma);
	writeln('El monto total gastado por este cliente es: ',suma:2:2);
end;

var
	a:arbol;
	L:lista;
begin
	cargarArbol(a);
	imprimirArbol(a);
	comprasCliente(a,L);
	imprimirLista(L);
	totalGastado(L);
end.
		
