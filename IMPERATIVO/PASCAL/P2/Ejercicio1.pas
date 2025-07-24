program Ejercicio1;
const
	DIMF = 10;
type
	vector = array [1..DIMF] of char;
	
	lista = ^nodo;
	nodo = record
		elem:char;
		sig:lista;
	end;

procedure leerSecuencia (var v:vector; var dimL:integer);
var
	c:char;
begin
	write('Ingrese caracter: ');Readln(c);
	if (c <> '.') and (dimL < DIMF) then begin
		dimL:= dimL + 1;
		v[dimL] := c;
		leerSecuencia(v,dimL);
	end;
end;


procedure imprimirVector (v:vector; dimL:integer);
var
	i:integer;
begin
	for i:= 1 to dimL do 
		writeln('contenido: ',v[i]);
end;

procedure imprimirVectorRecursivo (v:vector; i:integer ;dimL:integer);
begin
	i:= i + 1;
	if (i <= dimL) then begin
		writeln('contenido: ',v[i]);
		imprimirVectorRecursivo(v,i,dimL);
	end;
end;

procedure leerSecuenciaYcontar (var count:integer);
var
	c:char;
begin
	write('Ingrese caracter: ');Readln(c);
	if (c <> '.') then begin
		count:= count + 1;
		leerSecuenciaYcontar(count);
	end;
end;

procedure leerSecuenciaLista (var L:lista);
	procedure agregarAdelante (var L:lista; c:char);
	var
		aux:lista;
	begin
		new(aux);
		aux^.elem:=c;
		aux^.sig:=L;
		L:=aux;
	end;
var
	c:char;
begin
	write('Ingrese caracter: ');Readln(c);
	if (c <> '.') then begin
		agregarAdelante(L,c);
		leerSecuenciaLista(L^.sig);
	end;
end;

procedure imprimirListaOrden (L:lista);
begin
	if (L <> nil) then begin
		writeln('caracter: ',L^.elem);
		imprimirListaOrden(L^.sig);
	end;
end;

procedure imprimirListaOrdenInverso (L:lista);
begin
	if (L <> nil) then begin
		imprimirListaOrden(L^.sig);
		writeln('caracter: ',L^.elem);
	end;
end;

var
	dimL,i,count:integer;
	v:vector;
	L:lista;
begin
	dimL:=0;i:=0;count:=0;
	leerSecuencia(v,dimL);
	writeln('----IMPRIMIR NORMAL----');
	imprimirVector(v,dimL);
	//writeln('----IMPRIMIR RECURSIVO----');
	//imprimirVectorRecursivo(v,i,dimL);
	//leerSecuenciaYcontar(count);
	//writeln('La cantidad de chars leidos es: ',count);
	//leerSecuenciaLista(L);
	//writeln('----IMPRIMIR LISTA EN ORDEN----');
	//imprimirListaOrden(L);
	//writeln('----IMPRIMIR LISTA EN ORDEN INVERSO----');
	//imprimirListaOrdenInverso(L);
end.
