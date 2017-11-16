program ex2p16;
const str = 9;
const stb = 9;
var arr : Array[1..str,1..stb] of integer;
var i, j : integer;
begin
    randomize;
    for i := 1 to str do
    begin
        for j:=1 to stb do 
        begin
            arr[i][j] := random(9);
            if (i<str-j+1) and (i>j) then arr[i][j] := 0; 
        end;
    end;
    
    for i := 1 to str do
    begin
        for j:=1 to stb do 
        begin
            if (i<j) and (i>str-j+1) then write(arr[i][j], '  ');
            if j = str then writeln();
        end;
    end;
end.