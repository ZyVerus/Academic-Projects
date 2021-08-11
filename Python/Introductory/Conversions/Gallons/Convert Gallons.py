# -*- coding: utf-8 -*-
"""
Created on Wed Dec 11 01:32:53 2019

@author: zyverus

This program converts gallons to liters for 3 items

"""

import conversions_gallons

def main():
    
    # Get a list of gallons objects
    my_gallons = make_list()
    
    # Display the data in the list
    print("Here are the measurements that you entered:")
    display_list(my_gallons)
    
    # Display totals
    display_totals(my_gallons)
    
# Get data from the user for 3 measurements in gallons
# and return a list of conversions containing the data
def make_list():
    
    # Create an empty list
    gallons_list = []
    # add 3 gallons measurements to the list
    for i in range(0, 3):
        
        # get the data
        print("Please enter the gallons for Item ", (i + 1))
        lbs = float(input())
        
        # Create the object
        gallons_object = conversions_gallons.ConversionsGallons(lbs)
        
        #add the object to the list
        gallons_list.append(gallons_object)
        
    # return the list
    return gallons_list

# Display items    
def display_list(gallons_list):
    print("%-20s%-20s" % ("Gallons", "Liters"))
    for item in gallons_list:
        print("%-20.1f%-20.2f" % (item.get_gallons(), (item.get_gallons() * 3.79)))
        
def display_totals(gallons_list):
    total = 0.0
    print("%-40s" % ("__________________________________"))
    for item in gallons_list:
        total = total + item.get_gallons()
        
    print("%-19.1f%-20.2f" % ( total, (total * 3.79)))
    print("%-40s" % ("=================================="))
    
    
# call the main function
main()