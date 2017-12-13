from django.conf.urls import url
from django.contrib import admin

from homework1 import views

urlpatterns = [
    url(r'^about$', views.about, name='about'),
    url(r'^calc$', views.calc, name='calc'),
]