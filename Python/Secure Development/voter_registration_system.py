# -*- coding: utf-8 -*-
"""
Created on Thu Aug 26 00:18:39 2021

@author: ZyVerus
Title: Voter Registration System

Description: This program provides a CLI interface for a voter
registration appplication.
"""

def main():
    """ main function """
    # Define User Data
    info = {
                "fname": "",
                "lname": "",
                "age": "",
                "citizen": "",
                "state": "",
                "zip": ""
                }
    # Functions Step-Through Pass Variable
    passed = False
    # Show CLI Menu
    display_menu("upper")
    passed = set_fname(info, "fname")
    if passed:
        passed = set_lname(info, "lname")
    if passed:
        passed = set_age(info, "age")
    if passed:
        passed = verify_citizenship(info, "citizen")
    if passed:
        passed = set_state(info, "state")
    if passed:
        passed = set_zip(info, "zip")
    # Registration Successful Message
    if passed:
        print("\nThanks for registering to vote. Here is the information we received:")
        print("Name (first last):", info["fname"], info["lname"])
        print("Age:", info["age"])
        print("U.S. Citizen:", info["citizen"])
        print("State:", info["state"])
        print("Zipcode:", info["zip"])
        print("\n")
        display_menu("lower")
    # Registration Failed Message
    else:
        print("\nERROR: Registration Failed.")
        print("Exiting program. Thank you, and have a great day!\n")

## F U N C T I O N S
## User Information
# First Name
def set_fname(info, item):
    """ function to set the user's first name """
    option = "What is your first name?: "
    pass_flag = False
    while not pass_flag:
        input_data = input(option).strip()
        if input_data == "0":
            break
        # Input validation for letters
        if input_data.isalpha():
            info[item] = input_data
            pass_flag = True
        else:
            print("ERROR: First name must contain letters. Try again.")
    return pass_flag
# Last Name
def set_lname(info, item):
    """ function to set the user's last name """
    option = "What is your last name?: "
    pass_flag = False
    while not pass_flag:
        input_data = input(option).strip()
        if input_data == "0":
            break
        # Input validation for letters
        if input_data.isalpha():
            info[item] = input_data
            pass_flag = True
        else:
            print("ERROR: Last name must contain letters. Try again.")
    return pass_flag
# Age
def set_age(info, item):
    """ function to set the user's age """
    option = "What is your age?: "
    age = 0
    pass_flag = False
    while not pass_flag:
        input_data = input(option).strip()
        if input_data == "0":
            break
        # Input validation for integer
        if int_val(input_data):
            age = int(input_data)
            # Validate Age
            if 18 <= age <= 120:
                info[item] = str(age)
                pass_flag = True
            else:
                # Under-age Error Message
                print("ERROR: You must be over the age of 18 years old to register.")
                input_data = input("Enter '0' to exit or any other key to try again.").strip()
                if input_data == "0":
                    break
        else:
            print("ERROR: Selection must be a whole number.")
    return pass_flag
# Citizenship
def verify_citizenship(info, item):
    """ function to set user's citizenship """
    option = "Are you a U.S. Citizen? (Y/N): "
    pass_flag = False
    while not pass_flag:
        input_data = input(option).strip()
        if input_data == "0":
            break
        # Input validation for Yes or No selection
        if input_data.upper() == 'Y':
            info[item] = "Yes"
            pass_flag = True
        elif input_data.upper() == 'N':
            # Citizenship Error Message
            print("ERROR: You must be a US citizen to register.")
            input_data = input("Enter '0' to exit or any other  key to try again.").strip()
            if input_data == "0":
                break
        else:
            print("ERROR: Enter 'Y' or 'N'...")
    return pass_flag
# State
def set_state(info, item):
    """ function to set user's state """
    option = "What state do you live in? (2-Letter Code): "
    state_list = {'AL', 'AK', 'AZ', 'AR', 'CA', 'CO', 'CT', 'DE', 'FL', 'GA',
                  'HI', 'ID', 'IL', 'IN', 'IA', 'KS', 'KY', 'LA', 'ME', 'MD',
                  'MA', 'MI', 'MN', 'MS', 'MO', 'MT', 'NE', 'NV', 'NH', 'NJ',
                  'NM', 'NY', 'NC', 'ND', 'OH', 'OK', 'OR', 'PA', 'RI', 'SC',
                  'SD', 'TN', 'TX', 'UT', 'VT', 'VA', 'WA', 'WV', 'WI', 'WY'}
    pass_flag = False
    while not pass_flag:
        input_data = input(option).strip()
        if input_data == "0":
            break
        # Input validation for States 2-letter codes
        if input_data.upper() in state_list:
            info[item] = input_data.upper()
            pass_flag = True
        else:
            print("ERROR: Enter a 2-letter code for one of the 50 states."
                  +"\n'AL', 'AK', 'AZ', 'AR', 'CA', 'CO', 'CT', 'DE', 'FL', 'GA',"
                  +"\n'HI', 'ID', 'IL', 'IN', 'IA', 'KS', 'KY', 'LA', 'ME', 'MD',"
                  +"\n'MA', 'MI', 'MN', 'MS', 'MO', 'MT', 'NE', 'NV', 'NH', 'NJ',"
                  +"\n'NM', 'NY', 'NC', 'ND', 'OH', 'OK', 'OR', 'PA', 'RI', 'SC',"
                  +"\n'SD', 'TN', 'TX', 'UT', 'VT', 'VA', 'WA', 'WV', 'WI', 'WY'")
    return pass_flag
# Zip Code
def set_zip(info, item):
    """ function to set user's zip """
    option = "Enter your 5-digit zipcode: "
    pass_flag = False
    while not pass_flag:
        input_data = input(option).strip()
        if input_data == "0":
            break
        # Input validation for a 5-digit Zip Code
        if (len(input_data) == 5) and (int_val(input_data)):
            info[item] = input_data
            pass_flag = True
        else:
            print("ERROR: Zip Code must be a 5-digit Number")
    return pass_flag
## Input Validation
# Integer Check
def int_val(str_val):
    """ function for integer validation """
    # Validation Variable
    int_flag = False
    try:
        int(str_val)
        int_flag = True
    except ValueError:
        int_flag = False
    return int_flag
## CLI Menu
def display_menu(option):
    """ used for displaying the menu in the CLI """
    # Menu row variables
    border = "************************************************************"
    intro = "Welcome to the Python Voter Registration Application."
    terminate = "Enter '0' to exit"
    closing = "Thanks for trying the Voter Registration Application." \
    + "Your voter registration card should be shipped within 3 weeks."
    if option == "upper":
        print(border)
        print(intro)
        print(terminate)
    elif option == "lower":
        print(closing)
        print(border)

# Execute main function
main()
