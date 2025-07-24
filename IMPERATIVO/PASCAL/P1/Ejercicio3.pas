program Ejercicio3;
type
	
	rangoGeneros = 1..8;
	
	pelicula = record
		codPeli:integer;
		codGenero:rangoGeneros;
		punProm:real;
	end;
	
	lista = ^nodo;
	nodo = record
		elem:pelicula;
		sig:lista;
	end;
	
	vector = array [rangoGeneros] of lista;
	vCodigos = array [rangoGeneros] of pelicula;
	
procedure leoPelicula (var p:pelicula);
begin
	with p do begin 
		writeln('-------PELICULA------');
		write('Codigo de pelicula: ');readln(codPeli);
		if (codPeli <> -1) then begin
			write('Codigo de genero: ');readln(codGenero);
			write('Puntaje promedio: ');readln(punProm);
		end;
		writeln();
	end;
end;

procedure cargoVector (var v:vector);
	procedure inicializo (var v:vector);
	var
		i:integer;
	begin
		for i:= 1 to 8 do begin
			v[i]:= NIL;
		end;
	end;
	
	procedure agregarAlFinal (var L:lista; p:pelicula);
	var
		act,aux:lista;
	begin
		new(aux);
		aux^.elem:= p;
		aux^.sig := nil;
		if (L <> nil) then begin
			act:=L;
			while (act^.sig <> nil) do 
				act:= act^.sig;
			act^.sig:= aux;
		end
		else
			L:= aux;
	end;
		
var
	p:pelicula;
begin
	inicializo(v);
	leoPelicula(p);
	while (p.codPeli <> -1) do begin
		agregarAlFinal(v[p.codGenero],p);
		leoPelicula(p);
	end;
end;

procedure codPeliMax (var vC:vCodigos; v:vector);
	procedure recorroLista (L:lista; var vC:vCodigos; var max:real);
	begin
		if (L <> nil) then begin
			if (L^.elem.punProm > max) then begin
				max:= L^.elem.punProm;
				vC[L^.elem.codGenero] := L^.elem;
			end;
			recorroLista(L^.sig,vC,max);
		end;
	end;
var
	i:integer;
	max:real;
begin
	for i:= 1 to 8 do begin
		max:=0;
		recorroLista(v[i],vC,max);
	end;
end;

procedure imprimirVector(vC:vCodigos);
var
	i:integer;
begin
	for i:= 1 to 8 do begin
		writeln('Para el GENERO: ',i,' la pelicula con mayor puntaje es: ', vC[i].codPeli, ' y su Promedio de puntaje es: ',vC[i].punProm:2:0);
	end;
end;

procedure ordenoVectorGenerador (var v:vCodigos);
var
	i,j,p:integer;
	item:pelicula;
begin
	for i:= 1 to 7 do begin
		p:= i;
		for j:= i + 1 to 8 do begin
			if (v[j].punProm < v[p].punProm) then 
				p:=j;
		end;
		item := v[p];
		v[p] := v[i];
		v[i] := item;
	end;
end;

procedure mayorYmenor (v:vCodigos);
	procedure mayor (v:vCodigos; var max:real; var codMax:integer);
	var
		i:integer;
	begin
		for i:= 1 to 8 do begin
			if (v[i].punProm > max) then begin
				max:= v[i].punProm;
				codMax:= v[i].codPeli;
			end;
		end;
	end;
	
	procedure menor (v:vCodigos; var min:real; var codMin:integer);
	var
		i:integer;
	begin
		for i:= 1 to 8 do begin
			if (v[i].punProm < min) then begin
				min:= v[i].punProm;
				codMin:= v[i].codPeli;
			end;
		end;
	end;
var
	max,min:real;
	codMax,codMin:integer;
begin
	min:=9999;max:=0;codMax:=0;codMin:=0;
	mayor(v,max,codMax);
	menor(v,min,codMin);
	writeln('Codigo de peli con mayor puntaje: ',codMax, ' y su promedio es: ',max:2:2);
	writeln('Codigo de peli con menor puntaje: ',codMin, ' y su promedio es: ',min:2:2);
end;

var
	v:vector;
	vC:vCodigos;
begin
	cargoVector(v);//a 
	codPeliMax(vC,v);//b
	writeln('-----VECTOR OBTENIDO----');
	imprimirVector(vC);
	ordenoVectorGenerador(vC);//c
	mayorYmenor(vC);//d
	

end.

