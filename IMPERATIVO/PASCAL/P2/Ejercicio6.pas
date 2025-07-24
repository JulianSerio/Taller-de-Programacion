program Ejercicio6;

procedure imprimirBinario (x:integer);
var
	dig:integer;
begin
	if (x <> 0) then begin
		dig := x mod 2;
		imprimirBinario(x div 2);
		writeln(dig);
	end;
end;

var
	x:integer;
BEGIN
	write('Ingrese numero: ');readln(x);
	while (x <> 0) do begin
		imprimirBinario(x);
		write('Ingrese numero: ');readln(x);
	end;
END.

