program ex1p6;
var x, y, res : real;
begin
  readln(x, y);
  res := (1+y)*(x+y/(sqr(x)-1))/(exp(x-2)+(1/sqr(x)+4));
  if res <> 0 then
    writeln(res)
  else
    writeln('-')
end.
