program Ejercicio2;
procedure prueba (x:integer);
var
	dig:integer;
begin
	if (x <> 0) then begin
		dig := x mod 10;
		prueba(x div 10);
		writeln(dig);
	end;
end;

var
	x:integer;
begin
	write('Ingrese numero:');Readln(x);
	while (x <> 0) do begin
		prueba(x);
		write('Ingrese numero:');Readln(x);
	end;
end.
