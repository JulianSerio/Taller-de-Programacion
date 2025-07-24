program Parcial4;
type
	pedido = record	
		numCli:integer;
		dia:integer;
		cantCombos:integer;
		monto:real;
	end;
	
	lista = ^nodoLista;
	nodoLista = record
		elem:pedido;
		sig:lista;
	end;
	
	cliente = record
		numCli:integer;
		L:lista;
	end;
	
	arbol = ^nodo;
	nodo = record
		elem:cliente;
		HI:arbol;
		HD:arbol;
	end;

procedure cargarArbol (var a:arbol);
	procedure leerPedido (var p:pedido);
	begin
		with p do begin
			write('Numero de cliente: ');readln(numCli);
			if (numCli <> 0) then begin
				write('Dia: ');readln(dia);
				write('Monto: ');readln(monto);
				write('Cantidad de combos: ');readln(cantCombos);
			end;
			writeln
		end;
	end;
	
	procedure agregarAdelante (var L:lista; p:pedido);
	var
		aux:lista;
	begin
		new(aux);
		aux^.elem:=p;
		aux^.sig:=L;
		L:=aux;
	end;
	
	procedure insertarNodo (var a:arbol; p:pedido);
	begin
		if (a = nil) then begin
			new(a);
			a^.elem.numCli := p.numCli;
			a^.elem.L := nil;
			agregarAdelante(a^.elem.L,p);
			a^.HI:=nil;
			a^.HD:=nil;
		end
		else begin
			if (p.numCli = a^.elem.L^.elem.numCli) then 
				agregarAdelante(a^.elem.L,p)
			else begin
			  	if (p.numCli < a^.elem.L^.elem.numCli) then 
					insertarNodo(a^.HI,p)
				else
			  		insertarNodo(a^.HD,p);
			end;
		end;
	end;
var
	p:pedido;
begin	
	a:=nil;
	leerPedido(p);
	while (p.numCli <> 0) do begin
		insertarNodo(a,p);
		leerPedido(p);
	end;
end;

procedure imprimirLista (L:lista);
begin
	if (L <> nil) then begin
		writeln('cliente: ',L^.elem.numCli);
		writeln('dia: ',L^.elem.dia);
		writeln('monto: ',L^.elem.monto:2:2);
		writeln('cant combos: ',L^.elem.cantCombos);
		writeln;
		imprimirLista(L^.sig);
	end;
end;

procedure imprimirArbol (a:arbol);
begin
	if (a <> nil) then begin
		imprimirArbol(a^.HI);
		writeln();
		writeln('------NUMERO DE CLIENTE ',a^.elem.numCli,' ------');
		imprimirLista(a^.elem.L);
		imprimirArbol(a^.HD);
	end;
end;

procedure comprasCliente (a:arbol; var L:lista);
	procedure buscar (a:arbol; var L:lista; num:integer);
	begin
		if (a <> nil) then begin
			if (a^.elem.numCli = num) then 
				L:= a^.elem.L
			else
				if (num < a^.elem.numCli) then	
					buscar(a^.HI,L,num)
				else
					buscar(a^.HD,L,num);
		end;
	end;
var
	num:integer;
begin
	write('Ingrese numero de cliente a buscar: ');readln(num);
	buscar(a,L,num);
	imprimirLista(L);
end;

procedure totalAbonado (L:lista; var total:real);
begin
	if (L <> nil) then begin
		total:= total + L^.elem.monto;
		totalAbonado(L^.sig,total);
	end;
end;


var
	a:arbol;
	L:lista;
	total:real;
begin
	total:=0;
	cargarArbol(a);
	imprimirArbol(a);
	comprasCliente(a,L);
	totalAbonado(L,total);
	writeln('El monto total abonado por el cliente es: ',total:2:2);
end.
