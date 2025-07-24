program Parcial10;
var
	DIMF = 250;
type
	rangoVentas = 1..DIMF;
	rangoSucursales = 1..5;
	
	venta = record 
		codProd:integer;
		cantVendida:integer;
		montoTotal:real;
	end;
	
	vVentas = array [rangoVentas] of venta;
	
	sucursal = record	
		v:vVentas;
		dimL:integer;
	end;
	
	vSucursales = array [rangoSucursales] of sucursal;


BEGIN
	
	
END.

