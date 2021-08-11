# -*- coding: utf-8 -*-
"""
Created on Wed Dec 11 01:32:53 2019

@author: zyverus

This program converts ounces to grams for 3 items

"""

import conversions_ounces

def main():
    
    # Get a list of ounces objects
    my_ounces = make_list()
    
    # Display the data in the list
    print("Here are the measurements you entered:")
    display_list(my_ounces)
    
    # Display totals
    display_totals(my_ounces)
    
# Get data from the user for 3 measurements in ounces
# and return a list of conversions containing the data
def make_list():
    
    # Create an empty list
    ounces_list = []
    # add 3 ounces measurements to the list
    for i in range(0, 3):
        
        # get the data
        print("Please enter the ounces for Item ", (i + 1))
        ozs = float(input())
        
        # Create the object
        ounces_object = conversions_ounces.Conversions(ozs)
        
        #add the object to the list
        ounces_list.append(ounces_object)
        
    # return the list
    return ounces_list

# Display items       
def display_list(ounces_list):
    print("%-20s%-20s" % ("Ounces", "Grams"))
    for item in ounces_list:
        print("%-20.1f%-20.1f" % (item.get_ounces(), (item.get_ounces() * 28.35)))
        
def display_totals(ounces_list):
    total = 0.0
    print("%-40s" % ("__________________________________"))
    for item in ounces_list:
        total = total + item.get_ounces()
        
    print("%-19.1f%-20.1f" % ( total, (total * 28.35)))
    print("%-40s" % ("=================================="))
    
    
# call the main function
main()