program ex1p5;
var x, y, res : real;
begin
  read(x);
  read(y);
  res := 1/3*((sqr(sin(x))-cos(sqr(x))/sin((x+y)/2)-exp(sqrt(sqr(cos(x)))-sin(x))*ln(x)-sqrt(x-1)));
  writeln(res);
end.
