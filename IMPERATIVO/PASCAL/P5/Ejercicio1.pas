program Ejercicio1;
const
	DIMF = 10;
type
	rangoOficinas = 1..DIMF;
	
	oficina = record
		ID:integer;
		DNI:integer;
		expensa:real;
	end;
	
	vector = array [rangoOficinas] of oficina;
	
procedure cargoVector (var v:vector; var dimL:integer);
	procedure leoOficina (var o:oficina);
	begin
		with o do begin
			write('ID: ');readln(ID);
			if (ID <> -1) then begin
				DNI:=random(5000);
				writeln('DNI: ',DNI);
				expensa:= random(60000);
				writeln('Expensa: ',expensa:2:2);
			end;
			writeln;
		end;
	end;
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
		writeln('id: ',v[i].ID);
		writeln('dni: ',v[i].DNI);
		writeln('expensa: ',v[i].expensa:2:2);
		writeln;
	end;
end;

procedure ordenarVector (var v:vector; dimL:integer);
var
	item:oficina;
	i,j,p:integer;
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

procedure montoTotal (v:vector; dimL:integer; i:integer; var totalExp:real);
begin
	if (i <= dimL) then begin
		totalExp := totalExp + v[i].expensa;
		montoTotal(v,dimL,i+1,totalExp);
	end;
end;

procedure BusquedaDicotomica (v:vector; dimL:integer);
	procedure buscar (v:vector; ini:integer; fin:integer; id:integer; var DNI:integer);
	var
		medio:integer;
	begin
		medio := (ini + fin) div 2;
		if (v[medio].ID = id) then
			DNI := v[medio].DNI
		else
			if (ini >= fin) then
				DNI := -1
			else	
				if (id > v[medio].id) then
					buscar(v,medio+1,fin,id,DNI)
				else
					buscar(v,ini,medio-1,id,DNI);
	end;
var
	id:integer;
	DNI:integer;
begin
	write('Ingrese ID a buscar: ');readln(id);
	buscar(v,1,dimL,id,DNI);
	if (DNI <> -1) then
		writeln('El valor existe! ',DNI)
	else
		writeln('El valor no existe!');
end;

var
	v:vector;
	dimL:integer;
	totalExp:real;
begin
	totalExp:=0;
	Randomize;
	cargoVector(v,dimL);
	ordenarVector(v,dimL);
	imprimirVector(v,dimL);
	montoTotal(v,dimL,1,totalExp);
	writeln('Total expensas: ',totalExp:2:2);
	BusquedaDicotomica(v,dimL);
end.
