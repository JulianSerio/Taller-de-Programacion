program Ejercicio4;
type

	vector = array [1..20] of integer;

procedure generarVector (var v:vector; i:integer);
var
	num:integer;
begin
	i:= i + 1;
	if (i <= 20) then begin
		num := Random(100);
		v[i] := num;
		generarVector(v,i);
	end;
end;

procedure imprimoVector (v:vector);
var
	i:integer;
begin
	for i:= 1 to 20 do begin
		writeln('num: ',v[i]);
	end;
end;

procedure maxYmin (v:vector);
	procedure minimo (v:vector; i:integer; var min:integer);
	begin
		i:= i + 1;
		if (i <= 20) then begin
			if (v[i] < min) then
				min:= v[i];
			minimo(v,i,min);
		end;
	end;
	
	procedure maximo (v:vector; i:integer; var max:integer);
	begin
		i:= i + 1;
		if (i <= 20) then begin
			if (v[i] > max) then  
				max:= v[i];
			maximo(v,i,max);
		end;
	end;
var
	max,min,i:integer;
begin
	max:=0;min:=9999;i:=0;
	minimo(v,i,min);
	maximo(v,i,max);
	writeln('Valor Maximo: ',max);
	writeln('Valor Minimo: ',min);
end;

procedure sumaTotal (v:vector; i:integer ;var total:integer);
begin
	i:= i + 1 ;
	if (i <= 20) then begin
		total:= total + v[i];
		sumaTotal(v,i,total);
	end;
end;

var
	i,total:integer;
	v:vector;
BEGIN
	Randomize;
	i:=0;total:=0;
	generarVector(v,i);
	imprimoVector(v);
	maxYmin(v);
	sumaTotal(v,i,total);
	writeln('La suma total de elementos es: ',total);
END.

