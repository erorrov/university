program ex1p2;
var x, res, y, a, b : real;
begin
  readln(x, y, a, b);
  res := ((1+sqr(sin(x+y)))/((2*a))+x-((exp(ln(x)*12))+1)/(2+b));
  writeln(res);
end.
