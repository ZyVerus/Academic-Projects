# -*- coding: utf-8 -*-
"""
Created on Sun Aug 29 09:43:28 2021

@author: ZyVerus

Description: This program provides a calculator interface
and secure password generator.
"""

import sys
import math
import string
import secrets
import datetime

# Algorithm Termination Value
SENTINEL = "0"

def main():
    """ main function """
    # Define Attrbutes
    # Password
    passwd_attributes = {
        "length" : 0,
        "uppercase" : 0,
        "lowercase" : 0,
        "numbers" : 0,
        "special" : 0
        }
    # Percent
    percent_attributes = {
        "numerator" : 0,
        "denominator" : 1,
        "decimal" : 0,
        }
    # Triangle
    triangle_attributes = {
        "line_ac" : 0,
        "line_bc" : 0,
        "angle_c" : 0
        }
    # Cylinder
    cylinder_attributes = {
        "radius" : 0,
        "height" : 0
        }

    # CLI Menu
    display_menu("init_run")
    while True:

        display_menu("prompts")
        inp = input("\n> ").strip()
        #python_switch(inp)

        # Switch
        if inp == '1':
            if set_passwd_attributes(passwd_attributes):
                gen_secure_passwd(passwd_attributes)
        elif inp == '2':
            if set_percent_attributes(percent_attributes):
                calc_percentage(percent_attributes)
        elif inp == '3':
            calc_date()
        elif inp == '4':
            if set_triangle_attributes(triangle_attributes):
                calc_triangle(triangle_attributes)
        elif inp == '5':
            if set_cylinder_attributes(cylinder_attributes):
                calc_cylinder(cylinder_attributes)
        elif inp == '0':
            display_menu("exit")
            sys.exit(0)
        else:
            print("Invalid Selection. Please select from 1 - 5 for menu options, or '0' to exit.")
            input("Press ENTER to proceed.")

def set_passwd_attributes(passwd_attributes):
    """ Sets the attributes for a secure password based on user selections
    of length and complexity (Use of Upper Case, Lower Case, Numbers, and Special Characters"""
    # Value to determine if an attribute was set
    set_flag = False

    # Algorithm termination
    sentinel = False

    # Attribute length variable
    attribute_length = 0

    prompts = [
        "Password Length: ",
        "Upper case character count: ",
        "Lower case character count: ",
        "Number count: ",
        "Special character count: "
        ]

    print("\nSecure Password Generator")
    print("Select '0' at any point to return to the main menu.\n")

    for attribute, prompt in zip(passwd_attributes, prompts):
        # Set flag through each iteration
        set_flag = False

        while ((not sentinel) and (not set_flag)):
            inp = input(prompt).strip()

            if inp == SENTINEL:
                sentinel = True

            # If Sentinel not set, step through program
            if not sentinel:
                if (int_check(inp) and int(inp) >= 0):
                    if attribute != "length":
                        attribute_length += int(inp)
                    # Verify attribute lengths are less than the desired password length
                    if attribute_length <= passwd_attributes['length']:
                        passwd_attributes[attribute] = int(inp)
                        set_flag = True
                    else:
                        print("\nERROR: Your complexity lengths exceed the"
                              +" desired password length of %d" %passwd_attributes["length"])
                        input("Press ENTER to proceed.")
                        break
                else:
                    print("ERROR: Please enter a number.\n")
        if sentinel or not set_flag:
            break

    return set_flag

def gen_secure_passwd(passwd_attributes):
    """ Generates a secure password with the attributes set in set_passwd_attributes """
    password = ""
    characters = string.ascii_letters + string.digits + string.punctuation
    completed = False

    # Loop through characters until password parameters have been satisfeid
    while not completed:
        password = "".join(secrets.choice(characters) for i in range(passwd_attributes["length"]))
        # Check parameters are satisfied
        if ((len(password) == passwd_attributes["length"])
                and (sum(x.isupper() for x in password)
                     >= passwd_attributes["uppercase"])
                and (sum(x.islower() for x in password)
                     >= passwd_attributes["lowercase"])
                and (sum(x.isdigit() for x in password)
                     >= passwd_attributes["numbers"])
                and (sum(x in string.punctuation for x in password)
                     >= passwd_attributes["special"])):
            completed = True
        else:
            password = password[1:]
            break
    # Output the generated password
    print("\nSecure Password Generated: %s" % password)
    input("\nPress ENTER to proceed.")

def set_percent_attributes(percent_attributes):
    """ Sets the attributes for a percentage to be calcualted """
    # Value to determine if an attribute was set
    set_flag = False

    # Algorithm termination
    sentinel = False

    prompts = [
        "Enter a numerator: ",
        "Enter a denominator: ",
        "Enter the decimal places displayed: "
        ]

    print("\nPercentage Calculator")
    print("Select '0' at any point to return to the main menu.\n")

    # Step through program and set attributes for the prompts displayed
    for attribute, prompt in zip(percent_attributes, prompts):
        # Set flag through each iteration
        set_flag = False

        min_value = (0 if attribute != "numerator" else 1)

        while ((not sentinel) and (not set_flag)):
            inp = input(prompt).strip()

            if inp == SENTINEL:
                sentinel = True
            # If Sentinel not set, step through program
            if not sentinel:
                if (int_check(inp) and int(inp) >= min_value):
                    percent_attributes[attribute] = int(inp)
                    set_flag = True
                else:
                    print("ERROR: Enter a number greater than %d \n" % (min_value))

        if sentinel:
            break

    return set_flag

def calc_percentage(percent_attributes):
    """ Calculates percentage from the attributes set in set_percent_attributes """
    percentage = round((percent_attributes["numerator"] / percent_attributes["denominator"]),
                       percent_attributes["decimal"])
    percentage = percentage * 100

    # Output the calculated percentage
    print("\nCalculated Percentage: %.*f" % (percent_attributes["decimal"], percentage))
    input("\nPress ENTER to proceed.")

def calc_date():
    """ Show the number of days until July 4, 2025"""
    today = datetime.date.today()
    target = datetime.date.fromisoformat("2025-07-04")
    days = target - today

    # Output the number of days
    print("\n", days.days, " days until July 4th, 2025.")
    input("\nPress ENTER to proceed.")

def set_triangle_attributes(triangle_attributes):
    """ Sets the attributes to calculate the leg of a triangle  """
    # Value to determine if an attribute was set
    set_flag = False

    # Algorithm termination
    sentinel = False

    prompts = [
        "Enter a number for Side B (Line A - C): ",
        "Enter a number for Side A (Line B - C): ",
        "Enter the degree of Angle C: "
        ]

    print("\nTriangle Leg Calculator")
    print("Select '0' at any point to return to the main menu.\n")

    # Step through program and set attributes for the prompts displayed
    for attribute, prompt in zip(triangle_attributes, prompts):
        # Set flag through each iteration
        set_flag = False

        while ((not sentinel) and (not set_flag)):
            inp = input(prompt).strip()

            if inp == SENTINEL:
                sentinel = True
            # If Sentinel not set, step through program
            if not sentinel:
                if (int_check(inp) and int(inp) >= 0):
                    triangle_attributes[attribute] = int(inp)
                    set_flag = True
                else:
                    print("ERROR: Please enter a positive number.\n")

        if sentinel or not set_flag:
            break

    return set_flag

def calc_triangle(triangle_attributes):
    """ Calculates the leg of a triangle from the attributes set in set_triangle_attributes """

    # Convert attributes to float
    side_b = float(triangle_attributes["line_ac"])
    side_a = float(triangle_attributes["line_bc"])
    # Convert degree attribute to a radian
    radians = float(triangle_attributes["angle_c"]) * (math.pi / 180)
    #Find lenght of Line C with Law of Cosines
    side_c = math.sqrt((side_b ** 2) + (side_a ** 2) - (2 * side_b * side_a * math.cos(radians)))

    # Output the calculated triangle leg
    print("\nThe length of Side C (Line A - B) is: %.2f" % side_c)
    input("\nPress ENTER to proceed.")

def set_cylinder_attributes(cylinder_attributes):
    """ Sets the attributes to calculate volume of a right cylinder """
    # Value to determine if an attribute was set
    set_flag = False

    # Algorithm termination
    sentinel = False

    prompts = [
        "Enter a number for radius: ",
        "Enter a number for height: "
        ]

    print("\nRight Cylinder Volume Calculator")
    print("Select '0' at any point to return to the main menu.\n")

    # Step through program and set attributes for the prompts displayed
    for attribute, prompt in zip(cylinder_attributes, prompts):
        # Set flag through each iteration
        set_flag = False

        while ((not sentinel) and (not set_flag)):
            inp = input(prompt).strip()

            if inp == SENTINEL:
                sentinel = True
            # If Sentinel not set, step through program
            if not sentinel:
                if (int_check(inp) and int(inp) >= 0):
                    cylinder_attributes[attribute] = int(inp)
                    set_flag = True
                else:
                    print("ERROR: Please enter a positive number.\n")

        if sentinel or not set_flag:
            break

    return set_flag

def calc_cylinder(cylinder_attributes):
    """ Calculates the volume of a right cylinder from
    the attributes set in set_cylinder_attributes """
    volume = (math.pi * (float(cylinder_attributes["radius"]) ** 2)
              * float(cylinder_attributes["height"]))

    # Output the calculated right cylinder volume
    print("\nRight Cylinder Volume: %.2f" % volume)
    input("\nPress ENTER to proceed.")

def display_menu(option):
    """ used for displaying the menu in the CLI """
    intro = "Welcome to the Python Calculator Application."
    closing = ("\nThank you for using the Calculator Application."
               + "\nPress ENTER to close this console."
               )
    prompts = "\nPlease choose an option below:" \
        + "\n1 - Generate a secure password." \
        + "\n2 - Calculate a percentage." \
        + "\n3 - Calculate days until July 4, 2025." \
        + "\n4 - Calculate the leg of a triangle." \
        + "\n5 - Calculate the volume of a right cylinder." \
        + "\n0 - Exit Application"
    if option == "init_run":
        print(intro)
    elif option == "prompts":
        print(prompts)
    elif option == "exit":
        print(closing)

# Interger Input Validation
def int_check(inp):
    """ Input validation to test for integer value """
    is_int = False
    try:
        int(inp)
        is_int = True
    except ValueError:
        is_int = False
    return is_int

# Execute main function
main()
