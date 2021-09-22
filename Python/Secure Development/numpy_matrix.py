
# -*- coding: utf-8 -*-
"""
@author: ZyVerus

Description: Python Numpy & Matrix Application

Third party library utilized using a separate Anaconda environment in Visual Studio 2019.

Third party libraries:
numpy

"""

import sys
import re
import numpy as np

# CONSTANTS
# Algorithm termination value
SENTINEL = "0"
# Matrix Size
SIZE = 9

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
        if inp.lower() == 'y':
            menu("back")
            flag = True
            if not get_phone():
                flag = False
            if flag and (not get_zip()):
                flag = False
            if flag:
                run_matrix()
        # Exit Program
        elif inp.lower() == 'n':
            menu("exit")
            sys.exit(0)
        else:
            menu("invalid")
            menu("proceed")

def run_matrix():
    """ Run the matrix """
    flag = True
    # Run get_matrix() for first matrix
    print("\nFirst Matrix (3x3):")
    matrix_one = get_matrix()
    # If matrix matches global constant, output it to the user
    if matrix_one.size == SIZE:
        print("\nYour First Matrix is: ")
        display_matrix(matrix_one)
    else:
        flag = False
    # Get matrix two
    if flag:
        # Run get_matrix() for second matrix
        print("\nSecond Matrix (3x3):")
        matrix_two = get_matrix()
        # If matrix matches global constant, output it to the user
        if matrix_two.size == SIZE:
            print("\nYour Second Matrix is: ")
            display_matrix(matrix_two)
        else:
            flag = False
    # Run matrix operations
    if flag:
        operate_matrices(matrix_one, matrix_two)
    return 0

def operate_matrices(matrix_one, matrix_two):
    """ Operate on the matrices """
    flag = False
    show_matrix = np.array([])
    confirmation = ""

    while not flag:
        menu("back")
        menu("operations")
        inp = input("\n> ").strip()

        # Switch
        if inp == '1':
            flag = True
            show_matrix = matrix_one + matrix_two
            confirmation = "You selected Addition. The results are: "
        elif inp == '2':
            flag = True
            show_matrix = matrix_one - matrix_two
            confirmation = "You selected Subtraction. The results are: "
        elif inp == '3':
            flag = True
            show_matrix = np.matmul(matrix_one, matrix_two)
            confirmation = ("You selected Matrix Multiplication. The results are: ")
        elif inp == '4':
            flag = True
            show_matrix = matrix_one * matrix_two
            confirmation = ("You selected Element by Element Multiplication. The results are: ")
        elif inp == SENTINEL:
            break
        else:
            print("ERROR: Please enter a valid selection.")
            menu("proceed")

    # Display results if proper menu item selected
    if flag:
        print(confirmation)
        display_matrix(show_matrix)
        print("The transpose is: ")
        display_matrix(show_matrix.T)
        print("The row and column mean values of the results are: ")
        print("Rows: ", ["{:0.2f}".format(x) for x in show_matrix.mean(axis=1)])
        print("Columns: ", ["{:0.2f}".format(x) for x in show_matrix.mean(axis=0)])
        print()

def get_matrix():
    """ grabs user input to create a 3x3 matrix """
    # Row Pattern
    pattern = r'-?\d+ -?\d+ -?\d+'
    matrix = np.array([], dtype=int)

    while matrix.size < SIZE:
        print(
            "Enter a row of number for a 3x3 matrix (# # #):" \
            + "\nExample: 3 8 7"
            )
        inp = input("\n> ").strip()
        if re.fullmatch(pattern, inp):
            # Build list
            row = [int(i) for i in inp.split()]
            # Add to list
            matrix = np.append(matrix, row)
        elif inp == SENTINEL:
            break
        else:
            print("ERROR: Please enter numbers in a proper format.")
            menu("proceed")
    if matrix.size == 9:
        # Format size
        matrix.resize(3, 3)
    else:
        matrix = np.array([], dtype=int)

    # Return matrix value
    return matrix

def display_matrix(matrix):
    """ display 3x3 matrix array """
    for row in matrix:
        for i in row:
            print(i, end="   ")
        print()

    menu("proceed")

def get_phone():
    """ Get user input for their phone number """
    # Phone pattern
    pattern = r'\d{3}-\d{3}-\d{4}'
    # Value to return
    phone = ""

    while not phone:
        print(
            "\nEnter your phone number in standard US format with hyphens (###-###-####):" \
            + "\nExample: 123-456-7890"
            )
        inp = input("\n> ").strip()
        # Compare input to pattern
        compare = re.fullmatch(pattern, inp)
        # If input matches pattern, change return value, or return error message
        if compare:
            phone = compare.group()
        elif inp == SENTINEL:
            break
        else:
            print("ERROR: Phone number is not formatted correctly.")
            menu("proceed")

    return phone

def get_zip():
    """ Get user input for their zip code """
    # Zip code pattern
    pattern = r'\d{5}-\d{4}'
    # Value to return
    zip_code = ""

    while not zip_code:
        print(
            "\nEnter your zip code in nine-digit format with a hyphen (#####-####):" \
            + "\nExample: 12345-6789"
            )
        inp = input("\n> ").strip()
        # Compare input to pattern
        compare = re.fullmatch(pattern, inp)
        # If input matches pattern, change return value, or return error message
        if compare:
            zip_code = compare.group()
        elif inp == SENTINEL:
            break
        else:
            print("ERROR: Zip code is not formatted correctly.")
            menu("proceed")

    return zip_code

def menu(option):
    """ used for displaying the menu in the CLI """
    intro = "Welcome to the Python Matrix Application.\n"
    closing = (
        "Thank you for using the Python Matrix Numpy Application."
        + "\nPress ENTER to close this console."
        )
    prompts = (
        "Do you want to play the Matrix Game?" \
        + "\nInput 'Y' for Yes, or 'N' for No:"
        )
    operations = (
        "Select Matrix Operation:" \
        + "\n1 - Addition" \
        + "\n2 - Subtraction" \
        + "\n3 - Matrix Multiplication" \
        + "\n4 - Element by Element Multiplication" \
        + "\n0 - Return."
        )
    invalid = "ERROR: Invalid Selection..."
    back = "BACK: Input '0' at any point to return to the main menu."

    if option == "init_run":
        print(intro)
    elif option == "prompts":
        print(prompts)
    elif option == "operations":
        print(operations)
    elif option == "invalid":
        print(invalid)
    elif option == "back":
        print(back)
    elif option == "proceed":
        input("Press ENTER to proceed...\n")
    elif option == "sl":
        print()
    elif option == "exit":
        print(closing)

# Execute main function
main()
