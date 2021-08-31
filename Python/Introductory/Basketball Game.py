# -*- coding: utf-8 -*-
"""
Created on Sun Nov  3 15:47:10 2019

@author: zyverus 

This program simulates two players competing against each other in a basketball
free-throw competition.

"""

import random

print("The 2019-2020 NBA season starts October 22. Let's play some one-on-one with our favorite players! \n")

player1 = input("Please enter the name for Player 1: \n")
player2 = input("Please enter the name for Player 2: \n")

player1_score = int(0)
player2_score = int(0)
shot_num = int(0)
quarter_num = int(0)
num_seconds = int(720)
while quarter_num < 4:
    print("%-40s%-7s%-1d%-40s" % ("~"*40, "QUARTER ", quarter_num + 1, "~"*40))
    print("%-11s%-14s%-32s%-12s" % (" ", player1, " ", player2))
    print("%-5s%-6s%-4s%-15s%-5s%-22s%-4s%-15s%-5s" % ("Shot#", " ", "Shot", " ", "Score", " ", "Shot", " ", "Score"))

    for x in range(0, num_seconds, 30):
        player1_shot = random.randint(0, 3)
        player2_shot = random.randint(0, 3)

        if player1_shot == 0:
            message1 = str("Air Ball")
            player1_score += 0
        if player1_shot == 1:
            message1 = str("Free Throw")
            player1_score += 1
        if player1_shot == 2:
            message1 = str("Two Points!")
            player1_score += 2
        if player1_shot == 3:
            message1 = str("Three Pointer!")
            player1_score += 3

        if player2_shot == 0:
            message2 = str("Air Ball")
            player2_score += 0
        if player2_shot == 1:
            message2 = str("Free Throw")
            player2_score += 1
        if player2_shot == 2:
            message2 = str("Two Points!")
            player2_score += 2
        if player2_shot == 3:
            message2 = str("Three Pointer!")
            player2_score += 3

        print("%-2d%-9s%-15s%-6s%3d%-22s%-15s%-6s%3d" % (shot_num + 1, " ", message1, " ", player1_score,
              " ", message2, " ", player2_score))

        shot_num += 1
    quarter_num += 1

if player1_score > player2_score:
    print("\n",player1, "Bringing a W!")
if player1_score < player2_score:
    print("\n",player2, "Bringing a W!")
if player1_score == player2_score:
    print("\nTie Game..Go Home..See ya' later!")

print("~"*91, "\n")
