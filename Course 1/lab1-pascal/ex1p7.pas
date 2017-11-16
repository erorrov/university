program ex1p7;
var x, y, res : real;
begin
  readln(x, y);
  res := (x+1)*ln(y)/sqr(abs(y-2)+3)+x+y/(1-ln(abs(x-y))/2*abs(x+y));
  writeln(res)
end.
