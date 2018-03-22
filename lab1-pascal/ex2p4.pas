program ex2p4;
const str = 11;
const stb = 11;
var arr : Array[1..11, 1..11] of integer;
var i, j : integer;
begin
	randomize;
	for i := 1 to str do
	begin
		for j:=1 to stb do
		begin
			if i > 6 and j > 6 then arr[i][j] := 0 else arr[i][j] := random(9);
		end;
	end;

	for i := 1 to str do
    begin
        for j:=1 to stb do 
        begin
            write(arr[i][j], '	');
            if j = 11 then writeln();
        end;
    end;
end.