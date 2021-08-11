# -*- coding: utf-8 -*-
"""
Created on Wed Dec 11 01:25:15 2019

@author: zyverus
"""

class Conversions:
    # an init method that accepts arguments for the ounces
    def __init__(self, ounces):
        self.__ounces = ounces
        
    # a set_ounces method that accepts an argument for the ounces
    def set_ounces(self, ounces):
        self.__ounces = ounces
        
    # a get_ounces method that returns the ounces
    def get_ounces(self):
        return self.__ounces