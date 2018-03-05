program ex1p1;
var a, b, c, d, f, x : real;
begin
  readln(a,b,c,d,f);
  x := (1/(a+(1/(b+c+(1/d)))))-(a/(2*d+(c/(2*b+(1/f)))));
  writeln(x);
end.
