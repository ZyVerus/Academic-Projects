# -*- coding: utf-8 -*-
"""
Created on Mon Nov 11 08:30:31 2019

Program: Lawyer Fees Calculation
Author: ZyVerus
Date: 2019 Nov 11

This program calculated lawyer fees based on settlement amount

"""

quantity = int(input("How many lawyers need to be processed?\n"))
lawyers = [quantity]

for n in range(0, quantity, 1):
    lawyer_id = int(input("Please enter the Lawyer Number\n"))
    settlement_amount = int(input("Please enter the settlement amount\n"))
    while (settlement_amount < 0) or (settlement_amount > 10000000):
        print("Settlement amount must fall between 0 and 100,000,000")
        settlement_amount = int(input())
        
    if (settlement_amount >= 0) and (settlement_amount <= 150000):
        percent = (2)
    elif (settlement_amount > 150000) and (settlement_amount <= 400000):
        percent = (4)
    elif (settlement_amount > 400000) and (settlement_amount <= 600000):
        percent = (6)
    elif (settlement_amount > 600000) and (settlement_amount <= 10000000):
        percent = (10)

    fee = settlement_amount * (percent / 100)

    print("%-10s%20s%10s%20s" % ("\nLawyer #", "Settlement in $", "%", "Fee in $"))
    print("%-10s%20s%10s%20s" % (lawyer_id, format(settlement_amount, ',.2f'), format(percent, ',.1f'), format(fee, ',.2f')))