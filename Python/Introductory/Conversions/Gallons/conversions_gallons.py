# -*- coding: utf-8 -*-
"""
Created on Wed Dec 11 01:25:15 2019

@author: zyverus
"""

class ConversionsGallons:
    # an init method that accepts arguments for the gallons
    def __init__(self, gallons):
        self.__gallons = gallons
        
    # a set_gallons method that accepts an argument for the gallons
    def set_gallons(self, gallons):
        self.__gallons = gallons
        
    # a get_gallons method that returns the gallons
    def get_gallons(self):
        return self.__gallons