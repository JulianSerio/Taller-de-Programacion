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
	procedure inicializar (var v:vector);
	var
		i:integer;
	begin
		for i:= 1 to DIMF do
			v[i]:=nil;
	end;
	
	procedure leoProducto (var p:producto);
	begin
		with p do begin
			write('Ingrese codigo de producto: ');readln(cod);
			if (cod <> -1) then begin
				write('Rubro: ');readln(rubro);
				stock := random(100) + 1;
				writeln('Stock: ',stock);
				precio := random(200) + 1.50;
				writeln('Precio ',precio:2:2);
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
			writeln('rubro: ',a^.elem.rubro);
			writeln('precio: ',a^.elem.precio:2:2);
			writeln('stock: ',a^.elem.stock);
			writeln;
			imprimirArbol(a^.HD);
		end;
	end;
var
	i:integer;
begin
	for i:= 1 to DIMF do begin
		writeln('-------RUBRO ',i,' --------');
		imprimirArbol(v[i]);
	end;
end;

procedure buscarCod (v:vector);
	procedure buscar (a:arbol; cod:integer; var existe:boolean);
	begin
		if (a <> nil) then begin
			if (a^.elem.cod = cod) then
				existe := True
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
	write('Ingrese codigo de producto a buscar: ');readln(cod);
	write('Ingrese rubro: ');readln(rubro);
	buscar(v[rubro],cod,existe);
	if (existe) then 
		writeln('El codigo existe!')
	else
		write('El codigo NO existe!');
end;

procedure maximoPorRubro (v:vector);
	procedure codigoMasGrande (a:arbol; var max,stock:integer);
	begin
		if (a <> nil) then begin
			if (a^.elem.cod > max) then begin
				max := a^.elem.cod;
				stock := a^.elem.stock;
			end;
			codigoMasGrande(a^.HI,max,stock);
			codigoMasGrande(a^.HD,max,stock);
		end;
	end;
var
	max,stock,i:integer;
begin
	for i:= 1 to DIMF do begin
		max:=-1;
		stock:=0;
		codigoMasGrande(v[i],max,stock);
		if (max <> -1) then
			writeln('El codigo mas grande para el rubro ',i,' es: ',max,' y su stock es: ',stock)
		else
			writeln('Arbol vacio!');
	end;
end;

procedure cantidadEntre (v:vector);
	function buscar (a:arbol; v1,v2:integer):integer;
	begin
		if (a <> nil) then begin
			if (a^.elem.cod >= v1) then begin
				if (a^.elem.cod <= v2) then begin
					buscar := buscar(a^.HI,v1,v2) + buscar(a^.HD,v1,v2) + 1;
				end
				else
					buscar := buscar (a^.HI,v1,v2);
			end
			else
				buscar := buscar(a^.HD,v1,v2);
		end
		else
			buscar:=0;
	end;
var
	v1,v2,i,cant:integer;
begin
	write('Valor 1: ');readln(v1);
	write('Valor 2: ');readln(v2);
	for i:= 1 to DIMF do begin
		cant:= buscar(v[i],v1,v2);
		writeln('La cantidad de codigos entre, para el rubro ',i, ' es: ',cant);
	end;
end;

var
	v:vector;
begin
	cargarVector(v);
	imprimirVectorArboles(v);
	//buscarCod(v);
	maximoPorRubro(v);
	cantidadEntre(v);
end.	
