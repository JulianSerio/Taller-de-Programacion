program Ejercicio3;
type
	lista = ^nodo;
	nodo = record
		elem:integer;
		sig:lista;
	end;

procedure numerosRandom (var L:lista);
	procedure agregar (var L:lista; num:integer);
	var
		aux:lista;
	begin
		new(aux);
		aux^.elem:=num;
		aux^.sig:=L;
		L:=aux;
	end;
var
	num:integer;
begin
	num := Random(20);
	if (num <> 0) then begin
		agregar(L,num);
		numerosRandom(L);
	end;
end;

procedure imprimirLista (L:lista; var count:integer);
begin
	if (L <> nil) then begin
		writeln('num: ',L^.elem);
		count:= count + 1;
		imprimirLista(L^.sig,count);
	end;
end;

procedure maxYmin (L:lista);
	procedure maximo (L:lista; var max:integer);
	begin
		if (L <> nil) then begin
			if (L^.elem > max) then
				max:= L^.elem;
			maximo(L^.sig,max);
		end;
	end;
	procedure minimo (L:lista; var min:integer);
	begin
		if (L <> nil) then begin
			if (L^.elem < min) then
				min:= L^.elem;
			minimo(L^.sig,min);
		end;
	
	end;
var
	max,min:integer;
begin
	max:=0;min:=9999;
	minimo(L,min);
	maximo(L,max);
	writeln('Valor Maximo: ',max);
	writeln('Valor Minimo: ',min);
end;

procedure encontrarValor (L:lista);
	procedure buscar (L:lista; var esta:boolean; valor:integer);
	begin
		if (L <> nil) then begin
			if (valor = L^.elem) then 
				esta := true;
			buscar(L^.sig,esta,valor);
		end;
	end;
var
	esta:boolean;
	valor:integer;
begin
	esta:=False;
	write('Ingrese valor: ');readln(valor);
	buscar(L,esta,valor);
	if (esta) then
		writeln('El valor ',valor,' SE encuentra en la Lista!')
	else
		writeln('El valor NO se encuentra en la lista!');
end;

var
	L:lista;
	count:integer;
BEGIN
	Randomize;
	count:=0; 
	L:=nil;
	numerosRandom(L);
	imprimirLista(L,count);
	writeln('Hay ',count, ' elementos en la lista');
	maxYmin(L);
	encontrarValor(L);
END.

