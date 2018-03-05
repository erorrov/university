program ex1p4;
var x, res : real;
begin
  readln(x);
  res := exp(ln(exp(ln(x)*8)+exp(ln(8)*x))*(1/8));
  writeln(res);
end.
