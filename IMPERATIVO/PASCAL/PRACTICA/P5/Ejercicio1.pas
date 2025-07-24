program Ejercicio1;
const
	DIMF = 300;
type
	oficina = record
		DNI:integer;
		ID:integer;
		expensas:real;
	end;
	
	vector = array [1..DIMF] of oficina;

procedure cargoVector (var v:vector; var dimL:integer);
	procedure leoOficina (var o:oficina);
	begin
		with o do begin
			write('Codigo de id: ');readln(id);
			if (id <> -1) then begin
				DNI:= random(4000) + 1;
				writeln('DNI: ',DNI);
				expensas := random(5000) + 1.5;
				writeln('Expensa: ',expensas:2:2);
			end;
			writeln;
		end;
	end;
var
	o:oficina;
begin
	leoOficina(o);
	while (o.ID <> -1) do begin
		dimL := dimL + 1;
		v[dimL] := o;
		leoOficina(o);
	end;
end;

procedure ordenarVector (var v:vector; dimL:integer);
var
	i,j,p:integer;
	item:oficina;
begin
	for i:= 1 to dimL - 1 do begin
		p:=i;
		for j:= i + 1 to dimL do begin
			if (v[j].ID < v[p].ID) then begin
				p:=j;
			end;
		end;
		item:= v[p];
		v[p] := v[i];
		v[i] := item;
	end;
end;

procedure imprimirVector (v:vector; dimL:integer);
var
	i:integer;
begin
	for i:= 1 to dimL do begin
		writeln('ID: ',v[i].ID);
		writeln('DNI: ',v[i].DNI);
		writeln('EXPENSAS: ',v[i].expensas:2:2);
		writeln;
	end;
end;

procedure montoTotal (v:vector; dimL:integer);
	procedure sumo (v:vector; var total:real; dimL,i:integer);
	begin
		if (i <= dimL) then begin
			total := total + v[i].expensas;
			sumo(v,total,dimL,i+1);
		end;
	end;
var
	total:real;
begin
	total:=0;
	sumo(v,total, dimL,1);
	writeln('El monto total de expensas es: ',total:2:2);
end;

var
	dimL:integer;
	v:vector;
begin
	Randomize;
	dimL:=0;
	cargoVector(v,dimL);
	writeln('-------VECTOR SIN ORDENAR-------');
	imprimirVector(v,dimL);
	ordenarVector(v,dimL);
	writeln('-------VECTOR ORDENADO-------');
	imprimirVector(v,dimL);
	writeln;
	montoTotal(v,dimL);
end.
