program ex1p3;
var x, y, res : real;
begin
  readln(x, y);
  res := (sqr(arctan((sqr(x)/2)-1)))+((2*cos(x-pi/6))/((1/2)+sqr(sin(y))));
  writeln(res);
end.
