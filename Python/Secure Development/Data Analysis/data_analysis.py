# -*- coding: utf-8 -*-
"""
@author: ZyVerus

Description: This program imports .csv files and outputs their data in the CLI and as a plotted graph using matplotlib.

Note: Plotting for the Population Data is currently not working and displaying as intended. Code requires some rework.

Third party library utilized using a separate Anaconda environment in Visual Studio 2019.

Third party libraries:
matplotlib
pandas

"""

import sys
import pandas as pd
import matplotlib.pyplot as plt

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
        if inp == "1":
            analyze_population()
        elif inp == "2":
            analyze_housing()
        # Exit Program
        elif inp == "0":
            menu("exit")
            sys.exit(0)
        else:
            menu("invalid")
            menu("proceed")

def conv_file(type):
    """ Set dataframe from the csv file """
    if type == "population":
        filename = "PopChange.csv"
    elif type == "housing":
        filename = "Housing.csv"
    try:
        file = open(filename, 'r')
        data_frame = pd.read_csv(file)
        return data_frame
        file.close()
    except (FileNotFoundError, Exception):
        print("ERROR: File " + filename + " not found.")
        menu("proceed")
        return None
    #finally:
    #    file.close()

def analyze_population():
    """ Takes panda data and outputs it to the user for population data """
    # Filter Outliers Constants
    LOWER_QUANTILE = .15
    UPPER_QUANTILE = .85
    # Algorithm Conrols
    flag = False
    col = -1
    # Get Data Frame
    data_frame = conv_file("population")
    # If converting File Data failed, return to Main Menu
    if data_frame is None:
        return

    print("You have chosen to analyze Population Data.")

    while not flag:
        print("Select the Column you want to analyze: ")
        print("a.", data_frame.columns[4])
        print("b.", data_frame.columns[5])
        print("c.", data_frame.columns[6])
        print("z. Exit")
        inp = input("\n> ").strip().lower()

        if inp == "a":
            flag = True
            col = 4
        elif inp == "b":
            flag = True
            col = 5
        elif inp == "c":
            flag = True
            col = 6
        elif inp == "z":
            flag = True
        else:
            menu("invalid")
            menu("proceed")

    if col != -1:
        print("You selected {}".format(data_frame.columns[col].title()))
        print("The statistics for this column are: ")
        print(
            data_frame.describe()[data_frame.columns[col]].apply(
                lambda val: format(val, '.0f')
            )
        )

        count = 20
        bins = [
            data_frame[data_frame.columns[col]].quantile(x / count)
            for x in range(count)
            if LOWER_QUANTILE < (x / count) < UPPER_QUANTILE
            ]
        bins.sort() 
        data_frame.hist(
            column=data_frame.columns[col], bins=bins, edgecolor="w"
            )
        plt.xlim(
            [data_frame[data_frame.columns[col]].quantile(LOWER_QUANTILE),
             data_frame[data_frame.columns[col]].quantile(UPPER_QUANTILE)]
            )
        plt.xlabel(data_frame.columns[col], fontsize=14)
        plt.ylabel("Instances of Population", fontsize=14)
        plt.title("Population Data")
        print("\nThe Histogram for this column is now displayed.\n")
        plt.show()

def analyze_housing():
    """ Takes panda data and outputs it to the user for housing data """
    # Algorithm Conrols
    flag = False
    col = -1
    # Get Data Frame
    data_frame = conv_file("housing")
    # If converting File Data failed, return to Main Menu
    if data_frame is None:
        return
    # Initialize Column Type
    column_type = ""

    print("You have chosen to analyze Housing Data.")

    while not flag:
        print("Select the Column you want to analyze: ")
        print("a.", data_frame.columns[0])
        print("b.", data_frame.columns[1])
        print("c.", data_frame.columns[2])
        print("d.", data_frame.columns[4])
        print("e.", data_frame.columns[6])
        print("z. Exit")
        inp = input("\n> ").strip().lower()

        if inp == "a":
            flag = True
            col = 0
            column_type = "Age"
        elif inp == "b":
            flag = True
            col = 1
            column_type = "Bedrooms"
        elif inp == "c":
            flag = True
            col = 2
            column_type = "Year Built"
        elif inp == "d":
            flag = True
            col = 4
            column_type = "Overall Rooms"
        elif inp == "e":
            flag = True
            col = 6
            column_type = "Utility Cost"
        elif inp == "z":
            flag = True
        else:
            menu("invalid")
            menu("proceed")

    bins = 20
    if col != -1:
        print("You selected {}".format(data_frame.columns[col].title()))
        print("The statistics for this column are: ")
        print(
            data_frame.describe()[data_frame.columns[col]].apply(
                lambda val: format(val, '.0f')
            )
        )
        data_frame.hist(
            column=data_frame.columns[col], bins=bins, edgecolor="w"
            )
        plt.xlabel(column_type, fontsize=14)
        plt.ylabel("Quantity Built", fontsize=14)
        plt.title("Housing Data")
        print("\nThe Histogram for this column is now displayed.\n")
        plt.show()

def menu(option):
    """ used for displaying the menu in the CLI """
    intro = "Welcome to the Python Data Analysis Application.\n"
    closing = (
        "Thank you for using the Python Data Analysis Application."
        + "\nPress ENTER to close this console."
        )
    prompts = (
        "Select the file you want to analyze:" \
        + "\n1 - Population Data" \
        + "\n2 - Housing Data" \
        + "\n0 - Exit Program"
        )
    invalid = "ERROR: Invalid Selection..."
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
        input("Press ENTER to proceed...\n")
    elif option == "sl":
        print()
    elif option == "exit":
        print(closing)

# Execute main function
main()
