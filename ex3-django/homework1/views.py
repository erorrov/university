from django.http import HttpResponse
from django.shortcuts import render

# Create your views here.
def about(request):
    return HttpResponse("Hey. It's my homework.");

def calc(request):
    a = request.GET.get('a', 0)
    b = request.GET.get('b', 0)

    return HttpResponse(int(a)+int(b));