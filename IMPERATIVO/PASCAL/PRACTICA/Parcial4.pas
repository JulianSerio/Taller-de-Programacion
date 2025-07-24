program Parcial;
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
	procedure leoPedido (var p:pedido);
	begin
		with p do begin
			write('Numero de cliente ');readln(numCli);
			if (numCli <> 0) then begin
				dia:= random(31) + 1;
				writeln('Dia: ',dia);
				monto := random(4000) + 170.5;
				writeln('Monto: ',monto:2:2);
				cantCombos := random(50) + 1;
				writeln('Cantidad de combos: ',cantCombos);
			end;
			writeln;
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
		else
			if (p.numCli = a^.elem.numCli) then
				agregarAdelante(a^.elem.L,p)
			else
				if (p.numCli < a^.elem.numCli) then
					insertarNodo(a^.HI,p)
				else
					insertarNodo(a^.HD,p);
	end;
	
var
	p:pedido;
begin
	a:=nil;
	leoPedido(p);
	while (p.numCli <> 0) do begin
		insertarNodo(a,p);
		leoPedido(p);
	end;
end;

procedure imprimirArbolListas (a:arbol);
	procedure imprimirLista (L:lista);
	begin
		if (L <> nil) then begin
			writeln('Numero de cliente: ',L^.elem.numCli);
			writeln('Cantidad de combos: ',L^.elem.cantCombos);
			writeln('Monto: ',L^.elem.monto:2:2);
			writeln('Dia: ',L^.elem.dia);
			writeln;
			imprimirLista(L^.sig);
		end;
	end;
begin
	if (a <> nil) then begin
		imprimirArbolListas(a^.HI);
		writeln('------Numero de cliente ',a^.elem.numCli,' ------');
		imprimirLista(a^.elem.L);
		imprimirArbolListas(a^.HD);
	end;
end;

procedure comprasCliente (a:arbol; var L:lista);
	procedure buscar (a:arbol; num:integer; var L:lista);
	begin
		if (a <> nil) then begin
			if (num = a^.elem.numCli) then 
				L:= a^.elem.L
			else
				if (num < a^.elem.numCli) then
					buscar(a^.HI,num,L)
				else
					buscar(a^.HD,num,L);
			
		end;
	end;
var
	num:integer;
begin
	write('Numero de cliente ');readln(num);
	buscar(a,num,L);
end;

procedure mostrarTotal (L:lista);
	procedure sacoTotal (L:lista; var total:real);
	begin
		if (L <> nil) then begin
			total:= total + L^.elem.monto;
			sacoTotal(L^.sig,total);
		end;
	end;
var
	total:real;
begin
	total:=0;
	sacoTotal(L,total);
	writeln('El monto total abonado por el cliente es: ',total:2:2);
end;


var
	a:arbol;
	L:lista;
begin
	L:=nil;
	cargarArbol(a);
	imprimirArbolListas(a);
	comprasCliente(a,L);
	mostrarTotal(L);
end.
