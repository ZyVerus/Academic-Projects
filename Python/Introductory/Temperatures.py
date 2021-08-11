# -*- coding: utf-8 -*-
"""
Created on Mon Nov  4 08:27:33 2019

@author: zyverus

This program tracks low, high, and average temperatures over a set number of dates

"""

lowest_low = 0
lowest_high_index = 0
sum_highs = 0.0

print("This is the Temperature Stats Program")
print("It allows you to analyze temperatures over a period of time.")
num_days = int(input("How many days do you want to track temperatures?\n"))

lows = [0] * num_days
highs = [0] * num_days
average_temps = [0] * num_days
dates = [" "] * num_days

#loop loads the values for lows, highs, dates, and average-temps arrays
for i in range(0, num_days, 1):
    dates[i] = (input("Please enter the date:\n(Ex. Oct 25)\n"))
    print("\nPlease enter the low temperature for ", dates[i], ": ")
    lows[i] = float(input())
    print("\nPlease enter the high temperature for ", dates[i], ": ")
    highs[i] = float(input())
    average_temps[i] = (lows[i] + highs[i]) / 2
    
print("%-20s%20s%20s%20s" % ("Dates", "Lows", "Highs", "Average Temps"))

#loop to display the contents of each array
for j in range(0, num_days, 1):
        print("%-20s%20.1f%20.1f%20.1f" % (dates[j], lows[j], highs[j], average_temps[j]))
        
#Code to find the lowest of the low temperatures and its date
lowest_low = lows[0]
lowest_low_date = dates[0]

for k in range(0, num_days, 1):
    if lows[k] < lowest_low:
        lowest_low = lows[k]
        lowest_low_date = dates[k]
        
print("The lowest of the lows is ", lowest_low, " occurring on ", lowest_low_date, ".")

#code to find the highest of the low temperatures
highest_low = lows[0]
highest_low_date = dates[0]
for m in range(0, num_days, 1):
    if lows[m] > highest_low:
        highest_low = lows[m]
        highest_low_date = dates[m]
        
print("The highest of the lows is ", highest_low, " occurring on ", highest_low_date, ".")

#Code to find the lowest of the high temperatures and its date
lowest_high = highs[0]

for n in range(0, num_days, 1):
    if highs[n] < lowest_high:
        lowest_high_index = n
        
lowest_high = highs[lowest_high_index]
lowest_high_date = dates[lowest_high_index]

print("The lowest of the highs is ", lowest_high, " occurring on ", lowest_high_date, ".")

#Code to find the highest of the high temperatures and its date
highest_high = highs[0]

for p in range(0, num_days, 1):
    if highs[p] > highest_high:
        highest_high_index = p

print("The highest of the highs is ", highs[highest_high_index], " occurring on ", dates[highest_high_index], ".")


#Code to find and display average temps above 50
for q in range(0, num_days, 1):
    if average_temps[q] > 50:
        print("The average temperature exceeded 50 degrees on ", dates[q], " and it was ", average_temps[q], ",")
        
#Code to sum the high temperature in order to calculate the average high
for r in range(0, num_days, 1):
    sum_highs = sum_highs + highs[r]
    
average_high = sum_highs / len(highs)

print("The average high temperature is ", format(average_high, ',.1f'), ".")