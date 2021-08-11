# -*- coding: utf-8 -*-
"""
Created on Wed Oct 23 09:33:39 2019

@author: zyverus

This program is a guessing game. You must guess the correct randomly generated
number. An incorrect guess will give you a hint to guess higher or lower.
When the correct number has been guessed, it will give you the amount of tries
it took to get the answer.

"""

#Guess my number game
import random

print("\tWelcome to 'Guess My Number'!")
print("\nI'm thinking of a number between 1 and 100.")
print("\nTry to guess it in as few attempts as possible.\n")

#Set the initial values
secret_number = random.randint(1, 100)
guess = int(input("Take a guess: \n"))
tries = 1

#Guessing Loop
while guess != secret_number:
    if guess > secret_number:
        print("Lower please")
    else:
        print("Higher please")
        
    guess = int(input("Take a guess: \n"))
    tries = tries + 1
    
print("You guessed it! The number was ", secret_number)
print("\nAnd it only took you ", tries, "tries!")

input("\n\nPress the 'Enter' key to exit.")