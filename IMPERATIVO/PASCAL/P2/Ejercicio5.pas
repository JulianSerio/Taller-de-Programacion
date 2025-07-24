program Ejercicio5;
type
	vector = array [1..10] of integer;

procedure cargarVector (var v:vector);
var
	i:integer;
begin
	for i:= 1 to 10 do begin
		v[i] := random(40);
	end;
end;

procedure imprimirVector (v:vector);
var
	i:integer;
begin
	for i:= 1 to 10 do begin
		writeln('valor: ',v[i]);
	end;
end;

procedure ordenar (var v:vector);
var
	i,j,p,item:integer;
begin
	for i:= 1 to 9 do begin
		p:=i;
		for j:= i + 1 to 10 do begin
			if (v[j] < v[p]) then
				p:=j;
		end;
		item:=v[p];
		v[p]:=v[i];
		v[i]:=item;
	end;
end;

procedure busquedaDicotomica (v:vector; ini,fin,dato:integer; var pos:integer);
var	
	medio:integer;
begin
	medio := (ini + fin) div 2;
	if (v[medio] = dato) then 
		pos:= medio
	else
		if (ini >= fin) then
			pos:= -1
		else begin
			if (dato > v[medio]) then
				busquedaDicotomica(v,medio+1,fin,dato,pos)
			else
				busquedaDicotomica(v,ini,medio-1,dato,pos);
				
		end;
end;
var
	v:vector;
	ini,fin,dato,pos:integer;
BEGIN
	ini:=1;fin:=10;
	Randomize;
	cargarVector(v);
	ordenar(v);
	imprimirVector(v);
	write('Ingrese dato: ');readln(dato);
	busquedaDicotomica(v,ini,fin,dato,pos);
	writeln(pos);
END.

