program Ejercicio2;
const	
	DIMF = 300;
type
	
	oficina = record
		ID:integer;
		DNI:integer;
		exp:real;
	end;
	
	vector = array [1..DIMF] of oficina;
	
procedure leoOficina (var o:oficina);
begin
	with o do begin
		write('ID: ');Readln(ID);
		if (ID <> -1) then begin
			write('DNI propietario: ');Readln(DNI);
			write('Expensas: ');Readln(exp);
		end;
		writeln();
	end;
end;
	
procedure cargoVector (var v:vector; var dimL:integer);
var
	o:oficina;
begin
	dimL:=0;
	leoOficina(o);
	while (o.ID <> -1) and (dimL < DIMF) do begin
		dimL:= dimL + 1;
		v[dimL] := o;
		leoOficina(o);
	end;
end;

procedure imprimirVector (v:vector; dimL:integer);
var
	i:integer;
begin
	for i:= 1 to dimL do begin
		writeln('-----OFICINA-----');
		writeln('id: ',v[i].ID);
		writeln('dni: ',v[i].DNI);
		writeln('expensa: ',v[i].exp);
	end;
end;

procedure ordenarSeleccion (var v:vector; dimL:integer);
var
	item:oficina;
	p,j,i:integer;
begin
	for i:= 1 to dimL - 1 do begin
		p:=i;
		for j:= i + 1 to dimL do begin
			if (v[j].ID < v[p].ID) then 
				p:=j;
		end;
		item := v[p];
		v[p] := v[i];
		v[i] := item;
	end;
end;

procedure ordenarInsercion (var v:vector; dimL:integer);
var 
	i,j:integer;
	item:oficina;
begin
	for i:= 2 to dimL do begin
		item := v[i];
		j := i - 1;
		while (j > 0) and (v[j].ID > item.ID) do begin
			v[j + 1]:= v[j];
			j:= j - 1;
		end;
		v[j + 1] := item;
	end;

end;

var
	v:vector;
	dimL:integer;
begin
	cargoVector(v,dimL);
	writeln('----VECTOR SIN ORDENAR----');
	imprimirVector(v,dimL); 
	writeln('----ORDENADO POR SELECCION----');
	ordenarSeleccion(v,dimL);
	imprimirVector(v,dimL);
	writeln('----ORDENADO POR INSERCION----');
	ordenarInsercion(v,dimL);
	imprimirVector(v,dimL);
end.
