# -*- coding: utf-8 -*-
"""
Created on Wed Dec  4 08:19:39 2019

@author: zyverus
"""
def main():
    
    gas_price = [0.0]*52
    week = 1
    sum_price = 0
    
    try:        
        # Take the inputs
        file_name = 'GasPricesFile.txt'

        # Open the input file
        input_file = open(file_name, 'r')
    
        # Open the output file
        output_file = open('GasPriceStatistics.txt', 'w')

        # Print headings
        print("%-15s%15s" % ("Week", "Gas Prices"))

        index = 0     
        # Read all of the lines in the file into a list
        # Read the data and print the report
        for line in input_file:
            data_list = line.split() #splits the string at the blank space
            gas_price[index] = float(data_list[0])
            print("%-15s%15s" % (week, gas_price[index]))
            week += 1
            index += 1

        highest_gas_price = gas_price[0]
        lowest_gas_price = gas_price[0]
        highest_gas_week = 0
        lowest_gas_week = 0
        
        print()
        for n in range(len(gas_price)):
            if gas_price[n] > highest_gas_price:
                highest_gas_price = gas_price[n]
                highest_gas_week = n + 1
            if gas_price[n] < lowest_gas_price:
                lowest_gas_price = gas_price[n]
                lowest_gas_week = n + 1

        print("%-15s%15s" % ("Highest Week", "Gas Price"))
        print("%-15d%15.2f" % (highest_gas_week, highest_gas_price))
        print("%-15s%15s" % ("\nLowest Week", "Gas Price"))
        print("%-15d%15.2f" % (lowest_gas_week, lowest_gas_price))

        # Find average gas price
        for a in range(len(gas_price)):
            sum_price += gas_price[a]

        average_price = sum_price / 52

        print("%-15s%13.2f" % ("\nAverage Gas Price", average_price))

        output_file.write("Highest Week: " + str(highest_gas_week) + "\n")
        output_file.write("Gas Price: " + str(highest_gas_price) + "\n")
        output_file.write("Lowest Week: " + str(lowest_gas_week) + "\n")
        output_file.write("Gas Price: " + str(lowest_gas_price) + "\n")

    except IOError:
        print('The file could not be found.')
    except IndexError:
        print('There was an indexing error.')
    except Exception as err:
        print('An error occurred. Give the following to the help desk')
        print(err)
        
# Call the main function.
main()  