# -*- coding: utf-8 -*-
"""
@author: ZyVerus

Description: This program provides an output of states with their
associated capitals, flowers, and population.

Third party library utilized using a separate Anaconda environment in Visual Studio 2019.

Third party libraries:
matplotlib
PIL (Python Imaging Library)

"""

import os
import sys
import matplotlib.pyplot as plt
import matplotlib.ticker as mticker
from PIL import Image
import states_data as states

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
            for i in states.states:
                show_state(i, False)
        # Search for a state
        elif inp == '2':
            state = get_state()
            if state:
                show_state(state, True)
        # Display Top 5 Populated States
        elif inp == '3':
            show_top_population()
        # Update a state's population
        elif inp == '4':
            update_population()
        # Exit Program
        elif inp == '0':
            menu("exit")
            sys.exit(0)
        else:
            menu("invalid")

def show_state(state, specific):
    """ Show State Information """
    # Set population value to integer
    pop_value = int(states.states[state]["Population"])
    print("State:\t\t", state)
    print("Capital:\t", states.states[state]["Capital"])
    print("Flower:\t\t", states.states[state]["Flower"])
    print("Population:\t {:,}".format(pop_value))
    menu("sl")

    # Show Flower Picture if a specific State was selected
    if specific:
        # / for filepath used for interoperability between different Operating Systems.
        image_path = os.path.join(sys.path[0] + "/Flowers/" + state + ".jpg")
        print("ALERT:\nOpening File: " + image_path + " ...\n")
        image = Image.open(image_path)
        image.show()

def get_state():
    """ Requests user to specify a state they would like to display """
    state = ""
    menu("back")
    print("Please enter a State:")
    while not state:
        inp = input("\n> ").strip()
        menu("sl")
        # Check for Sentinel Value
        if inp == SENTINEL:
            break
        # Input Validation
        fix_inp = ""
        # Check to see if input only contains alphabetical characters (ignores spaces)
        if inp.replace(" ", "").isalpha():
            # Split input string value into separate a list
            # split() uses whitespace as the default separator
            word_list = inp.split()
            # Check each word
            for i in word_list:
                # Capitalizes the first letter in each word
                fix_inp += i.capitalize() + " "
            # Strip the fixed input of any spaces at the end of the string
            fix_inp = fix_inp.strip()
        # Check for fixed input value in States dictionary
        if fix_inp in states.states.keys():
            state = fix_inp
        else:
            print("ERROR: Please enter a valid State.")

    return state

def show_top_population():
    """ Shows the states with the highest population in descending order """
    # Get state populations listed in descending order
    populations = sorted(
        states.states.keys(), key=lambda key_: int(
            states.states[key_]["Population"]
            ), reverse=True
        )

    # Keep only first five top items
    populations = populations[:5]
    pop_list = []
    print("Top 5 Populated States (Descending Order):\n")
    # Output List
    for i in populations:
        pop_value = int(states.states[i]["Population"])
        print(i + ":  {:,}".format(pop_value))
        pop_list.append(pop_value)

    menu("sl")
    # Plot Data
    plt.bar(populations, pop_list,)
    # Get Y Values in the Bar Graph
    y_values = plt.gca().get_yticks()
    # Set Labels Format to show Commas for Thousandths place
    label_format = "{:,.0f}"
    # Set FixedLocator to suppress FixedFormatter UserWarning
    plt.gca().yaxis.set_major_locator(mticker.FixedLocator(y_values))
    # Set Y Values (Labels)
    plt.gca().set_yticklabels([label_format.format(i) for i in y_values])
    # Create X Label
    plt.xlabel("States", fontsize=12)
    # Create Bar Title
    plt.title("Top 5 Populated States (Bar):")
    # Display Bar Graph to User
    plt.show()

def update_population():
    """ Function to update state population based on User's input """
    # Nested Function
    def inp_population():
        """ Validate that user input is an integer """
        value = ""
        while not value:
            print("Please enter the new population value:")
            inp = input("\n> ").strip()
            menu("sl")

            # Check for Sentinel Value
            if inp == SENTINEL:
                break
            # Input Validation
            if int_val(inp):
                if int(inp) > 0:
                    value = inp
                else:
                    print("ERROR: Population can not be 0 or a negative value.\n")
            else:
                print("ERROR: Population must be a number with a value of 1 or greater\n")
        return value

    # Nested Function
    def set_population(state, population):
        """ Set the value of the data in states_data.py dictonary """

        states.states[state]["Population"] = population
        print("Population of " + state + " set to " + population + "\n")
        #else:
            #print("ERROR: State could not be found.")

    # Prompt for state input and run nested functions
    #print("Please enter the State you would like to update.")
    #menu("back")
    state = get_state()
    if state:
        value = inp_population()
        if value:
            set_population(state, value)

def menu(option):
    """ used for displaying the menu in the CLI """
    intro = "Welcome to the Python State Capital and Flower List Application.\n"
    closing = (
        "Thank you for using the State Capital and Flower List Application."
        + "\nPress ENTER to close this console."
        )
    prompts = (
        "Please choose an option below:" \
        + "\n1 - Display all States in alphabetical order with their respective" \
        + " Capital, Population, and Flower." \
        + "\n2 - Search for a specific state and display its respective Capital," \
        + " Population, and Flower (with image)." \
        + "\n3 - Display a bar graph of the 5 most populated states and their" \
        + " overall population." \
        + "\n4 - Update the overall state population for a specific state." \
        + "\n0 - Exit Application."
        )
    invalid = "ERROR: Invalid Selection. Please select from 1 - 4 of the menu" \
        + " options, or '0' to exit.\n"
    back = "BACK: Input '0' at any point to return to the main menu."

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
        print("")
    elif option == "exit":
        print(closing)

# Integer Input Validation
def int_val(inp):
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
