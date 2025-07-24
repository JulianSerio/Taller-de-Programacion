program Parcial;
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
				dia:= random(31) + 1;
				writeln('Dia: ',dia);
				monto:= random(20000) + 1.5;
				writeln('Monto: ',monto:2:2);
			end;
			writeln;
		end;
	end;
	
	procedure insertarNodo (var a:arbol; c:compra);
	begin
		if (a = nil) then begin
			new(a);
			a^.elem := c;
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
		writeln('cant prod: ',a^.elem.cantProd);
		writeln('cod cli: ',a^.elem.codCli);
		writeln('monto: ',a^.elem.monto:2:2);
		writeln('dia: ',a^.elem.dia);
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
	write('Ingrese codigo de cliente: ');readln(cod);
	buscar(a,cod,L);
end;

procedure montoTotal (L:lista);	
	procedure sumar (L:lista; var total:real);
	begin
		if (L <> nil) Then begin
			total := total + L^.elem.monto;
			sumar(L^.sig,total);
		end;
	end;
var
	total:real;
begin
	total:=0;
	sumar(L,total);
	writeln('El monto total gastado por el cliente es: ',total:2:2);
end;

procedure imprimirLista (L:lista);
begin
	if (L <> nil) then begin
		writeln('cant prod: ',L^.elem.cantProd);
		writeln('cod cli: ',L^.elem.codCli);
		writeln('monto: ',L^.elem.monto:2:2);
		writeln('dia: ',L^.elem.dia);
		writeln;
		imprimirLista(L^.sig);
	end;
end;

var
	a:arbol;
	L:lista;
begin
	Randomize;
	cargarArbol(a);
	imprimirArbol(a);
	comprasCliente(a,L);
	writeln('------LISTA DEL CLIENTE-------');
	imprimirLista(L);
	montoTotal(L);
	
end.
