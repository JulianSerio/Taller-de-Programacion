program Ejercicio3;
const
	DIMF = 10;
type
	rangoRubro = 1..DIMF;
	
	producto = record
		cod:integer;
		rubro:rangoRubro;
		stock:integer;
		precio:real;
	end;
	
	arbol = ^nodo;
	nodo = record	
		elem:producto;
		HI:arbol;
		HD:arbol;
	end;
	
	vector = array [rangoRubro] of arbol;

procedure cargarVector (var v:vector);
	procedure leoProducto (var p:producto);
	begin
		with p do begin
			write('Codigo de producto: ');readln(cod);
			if (cod <> -1) then begin
				write('Rubro: ');readln(rubro);
				stock := random(200);
				writeln('Stock: ',stock);
				precio:= random(6000);
				writeln('Precio: ',precio:2:2);
			end;
			writeln;
		end;
	end;
	
	procedure insertarNodo (var a:arbol; p:producto);
	begin
		if (a = nil) then begin
			new(a);
			a^.elem:=p;
			a^.HI:=nil;
			a^.HD:=nil;
		end
		else
			if (p.cod < a^.elem.cod) then 
				insertarNodo(a^.HI,p)
			else
				insertarNodo(a^.HD,p);
	end;
	
	procedure inicializar (var v:vector);
	var
		i:integer;
	begin
		for i:= 1 to DIMF do 
			v[i]:=nil;
	end;
	
var
	p:producto;
begin
	inicializar(v);
	leoProducto(p);
	while (p.cod <> -1) do begin
		insertarNodo(v[p.rubro],p);
		leoProducto(p);
	end;
end;

procedure imprimirVectorArboles (v:vector);
	procedure imprimirArbol (a:arbol);
	begin
		if (a <> nil) then begin
			imprimirArbol(a^.HI);
			writeln('codigo: ',a^.elem.cod);
			writeln('stock: ',a^.elem.stock);
			writeln('precio: ',a^.elem.precio:2:2);
			writeln;
			imprimirArbol(a^.HD);
		end;
	end;
var
	i:integer;
begin
	for i:= 1 to DIMF do begin
		writeln('-------- RUBRO ',i,' --------');
		imprimirArbol(v[i]);
	end;
end;

procedure buscarCodigo (v:vector);
	procedure buscar (a:arbol; cod:integer; var existe:boolean);
	begin
		if (a <> nil) then begin
			if (cod = a^.elem.cod) then 
				existe:= true
			else
				if (cod < a^.elem.cod) then
					buscar(a^.HI,cod,existe)
				else
					buscar(a^.HD,cod,existe);
		end;
	end;

var
	cod,rubro:integer;
	existe:boolean;
begin
	existe:=false;
	write('Ingrese codigo a buscar: ');readln(cod);
	write('Ingrese rubro: ');readln(rubro);
	buscar(v[rubro],cod,existe);
	if (existe) then
		writeln('El codigo existe!')
	else
		writeln('El codigo NO existe!');
end;

procedure cantProductosEntre (v:vector);
	procedure buscarEntre (a:arbol; v1,v2:integer; var cant:integer);
	begin
		if (a <> nil) then begin
			if (v1 <= a^.elem.cod) then begin
				if (v2 >= a^.elem.cod) then begin
					cant:= cant + 1;
					buscarEntre(a^.HI,v1,v2,cant);
					buscarEntre(a^.HD,v1,v2,cant);
				end
				else
					buscarEntre(a^.HI,v1,v2,cant);
			end
			else
				buscarEntre(a^.HD,v1,v2,cant);
		end;
	end;
var
	cant,i:integer;
	v1,v2:integer;
begin
	write('Ingrese valor 1: ');readln(v1);
	write('Ingrese valor 2: ');readln(v2);
	for i:= 1 to DIMF do begin
		cant:=0;
		buscarEntre(v[i],v1,v2,cant);
		writeln('La cantidad de productos entre los valores ',v1,' y ',v2,' en el rubro ',i,' son ',cant); 
	end;
end;

procedure maximoXrubro (v:vector);
	procedure maximo (a:arbol; var max,stock:integer);
	begin
		if (a <> nil) then begin
			if (a^.elem.cod > max) then begin
				max:= a^.elem.cod;
				stock:= a^.elem.stock; 
			end;
			maximo(a^.HD,max,stock);
		end;
	end;
var
	max,stock:integer;
	i:integer;
begin
	for i:= 1 to DIMF do begin
		max:=-1;
		stock:=0;
		maximo(v[i],max,stock);
		writeln('Para el rubro ',i,' el codigo mas grande es ',max, ' y su stock es ',stock);
	end;
end;

var
	v:vector;
BEGIN
	Randomize;
	cargarVector(v);
	imprimirVectorArboles(v);
	buscarCodigo(v);
	cantProductosEntre(v);
	maximoXrubro(v);
END.

