# -*- coding: utf-8 -*-
"""
Created on Sun Nov  3 15:47:10 2019

@author: zyverus

This program simulates a pair of dice being rolled 100 times. It outputs the value of the
dice and shows the total number of pair values.

"""

import random

NUMBER = 100

snake_eyes = 0
twos = 0
threes = 0
fours = 0
fives = 0
sixes = 0

print("%-10s%-15s%-15s\n" % ("Roll", "Die 1 Value", "Die 2 Value"))
for count in range(0, NUMBER, 1): #most like the inner for loop
    die_1_value = random.randint(1, 6)
    die_2_value = random.randint(1, 6)

    print("%-10d%-15d%-15d" % ((count + 1), die_1_value, die_2_value))
    #%-10d means you want to print an integer in a column 10 wide, left aligned
    #%-10s means you want to print a string in a column 10 wide, left aligned
    #%10.2f means you want to print a float in a column 10 wide, 2 decimal place, right aligned
    #- means left align, without the - the output would be right aligned

    if die_1_value == die_2_value:

        if die_1_value == 1:
            snake_eyes = snake_eyes + 1
        elif die_1_value == 2:
            twos = twos + 1
        elif die_1_value == 3:
            threes = threes + 1
        elif die_1_value == 4:
            fours = fours + 1
        elif die_1_value == 5:
            fives = fives + 1
        else:
            sixes = sixes + 1

#Print Values
print("\n%-s%d%s%d%s" % ("You rolled snake eyes ", snake_eyes, " out of ", NUMBER, " rolls"))
print("%-s%d%s%d%s" % ("You rolled a pair of twos ", twos, " out of ", NUMBER, " rolls"))
print("%-s%d%s%d%s" % ("You rolled a pair of threes ", threes, " out of ", NUMBER, " rolls"))
print("%-s%d%s%d%s" % ("You rolled a pair of fours ", fours, " out of ", NUMBER, " rolls"))
print("%-s%d%s%d%s" % ("You rolled a pair of fives ", fives, " out of ", NUMBER, " rolls"))
print("%-s%d%s%d%s" % ("You rolled a pair of sixes ", sixes, " out of ", NUMBER, " rolls"))
