# -*- coding: utf-8 -*-
"""
Created on Mon Oct 21 08:20:28 2019

@author: zyverus

This program gives you ticket prices for a baseball game at the Washington
Nationals stadium based on your age and if you are active duty military.

"""

name = input("Please enter your name.\n")
age = int(input("Please enter your age.\n"))
if age >= 18:
    print("Are you an active member of the military or a veteran?", \
           "(Enter Y for Yes. N for No):")
else:
    print("Is your parent an active member of the military or a veteran?", \
          "(Enter Y for Yes. N for No):")
military_status = input().lower()
print("Please choose your seat from the menu below:")
print("FB for Field Box ($17)")
print("BX for Box ($15)")
print("RS for Reserved Seating($14 for Adults, Youth (4-10)/Seniors(62+) $13)")
print("GS for Grandstand ($12 for Adults, Youth (6-12)/Senior (62+) $11)", \
      "Kids 5-and-under Free!")
seat_type = input().upper()

#Assign Values to Seat Types
if seat_type == "FB":
    seat_description = "Field Box"
    if age > 5:
        ticket_price_before_discount = 17
    else:
        ticket_price_before_discount = 0
        
elif seat_type == "BX":
    seat_description = "Box"
    if age > 5:
        ticket_price_before_discount = 15
    else:
        ticket_price_before_discount = 0
    
elif seat_type == "RS":
    seat_description = "Reserved Seating"
    if (age >= 6 and age <= 10) or age >= 62:
        ticket_price_before_discount = 13
    elif age < 6: 
        ticket_price_before_discount = 0
    else:
        ticket_price_before_discount = 14

elif seat_type == "GS":
    seat_description = "Grandstand"
    if (age >= 6 and age <= 12) or age >= 62:
        ticket_price_before_discount = 11
    elif age < 6:
        ticket_price_before_discount = 0
    else:
        ticket_price_before_discount = 12
    
else:
    ticket_price_before_discount = 0
    seat_description = "Invalid Seat Type. Please run the program again."

if military_status == "y":
    military_discount_amount = ticket_price_before_discount * .30
else:
    military_discount_amount = 0
    
ticket_price_after_discount = ticket_price_before_discount - military_discount_amount

print("Ticket Price for", name)
print("Age: ", format(age, 'd'))
print("Seat Chosen: ", seat_description)
print("Ticket Price Before Discount: ", format(ticket_price_before_discount, ',.2f'))
print("Military Discount:            ", format(military_discount_amount, ',.2f'))
print("Ticket Price After Discount:  ", format(ticket_price_after_discount, ',.2f'))