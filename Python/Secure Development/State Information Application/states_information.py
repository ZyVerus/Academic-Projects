# -*- coding: utf-8 -*-
"""
@author: ZyVerus

Description: This program provides an output of states with their
associated capitals, flowers, and population.

Third party library utilized using a separate Anaconda environment in Visual Studio 2019.

Third party libraries:
matplotlib

"""

import os
import sys
import matplotlib.pyplot as plt
import matplotlib.image as mpimg
import states_data as states
from PIL import Image

# Algorithm Termination Value
SENTINEL = "0"

def main():
    """ main function """
    # CLI Menu
    menu("init_run")
    while True:
        menu("prompts")
        inp = input("\n> ").strip()
        menu("sl")
        # Switch
        # Display all States
        if inp == '1':
            specific = False
            for i in states.states:
                show_state(i, specific)
        # Search for a state
        elif inp == '2':
            specific = True
            state_bool = get_state()
            if state_bool:
                show_state(state_bool, specific)
        # Display Top 5 Populated States
        elif inp == '3':
            show_top_population()
        # Update a state's population
        elif inp == '4':
            print("ALERT: Function Under Construction.\nPlease check back at a later time.")
        # Exit Program
        elif inp == '0':
            menu("exit")
            sys.exit(0)
        else:
            menu("invalid")

def show_state(state, specific):
    """ Show State Information """
    menu("sl")
    print("State:\t", state)
    print("Capital:", states.states[state]["Capital"])
    print("Flower:\t", states.states[state]["Flower"])

    # Show Flower Picture if a specific State was selected
    if specific == True:
        # / for filepath used for interoperability between different Operating Systems.
        image_path = os.path.join(sys.path[0] + "/Flowers/" + state + ".jpg")
        print("\nALERT:\nOpening File: " + image_path + " ...")
        image = Image.open(image_path)
        image.show()

def get_state():
    """ Requests user to specify a state they would like to display """
    state = ""
    print("Please enter the State you would like to retrieve information for.")
    menu("back")
    while not state:
        inp = input("\n> ").strip()
        # Check for Sentinel Value
        if inp == SENTINEL:
            break
        # Input Validation
        fix_inp = ""
        # Check to see if input only contains alphabetical characters (ignores spaces)
        if inp.replace(" ", "").isalpha():
            # Split input string value into separate a list (split() using whitespace as the default separator)
            list = inp.split()
            # Check each word 
            for i in list:
                # Capitalizes the first letter in each word
                fix_inp += i.capitalize() + " "
            # Strip the fixed input of any spaces at the end of the string
            fix_inp = fix_inp.strip()
        # Check for fixed input value in States dictionary
        if fix_inp in states.states.keys():
            state = fix_inp
        else:
            print("Please enter a valid State.")

    return state

def show_top_population():
    """ Shows the states with the highest population in descending order """
    # Get state populations listed in descending order
    populations = sorted(
        states.states.keys(),key=lambda key_:int(
            states.states[key_]["Population"]
            ),reverse=True
        )

    # Keep only first five top items
    populations = populations[:5]
    pop_list = []
    print("Top 5 Populated States:")
    # Output List
    for i in populations:
        pop_value = int(states.states[i]["Population"])
        print(i + ": {:,}".format(pop_value))
        pop_list.append(pop_value)

    # Plot Data
    plt.bar(populations, pop_list,)
    # Get Y Values in the Bar Graph
    y_values = plt.gca().get_yticks()
    # Format Y Values (Labels) to show Commas for Thousandths place
    plt.gca().set_yticklabels(["{:,.0f}".format(i) for i in y_values])
    # Create X Label
    plt.xlabel("States", fontsize=12)
    # Create Bar Title
    plt.title("Top 5 Populated States (Bar):")
    # Display Bar Graph to User
    plt.show()

def menu(option):
    """ used for displaying the menu in the CLI """
    intro = "Welcome to the Python State Capital and Flower List Application."
    closing = ("\nThank you for using the State Capital and Flower List Application."
               + "\nPress ENTER to close this console."
               )
    prompts = "\nPlease choose an option below:" \
        + "\n1 - Display all States in alphabetical order with their respective Capital, Population, and Flower." \
        + "\n2 - Search for a specific state and display its respective Capital, Population, and Flower (with image)." \
        + "\n3 - Display a bar graph of the 5 most populated states and their overall population." \
        + "\n4 - Update the overall state population for a specific state." \
        + "\n0 - Exit Application."
    invalid = "Invalid Selection. Please select from 1 - 4 of the menu options, or '0' to exit."
    back = "Input '0' at any point to return to the main menu."

    if option == "init_run":
        print(intro)
    elif option == "prompts":
        print(prompts)
    elif option == "invalid":
        print(invalid)
    elif option == "back":
        print(back)
    elif option == "proceed":
        input("Press ENTER to proceed...")
    elif option == "sl":
        print("\n")
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
