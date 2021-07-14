import xlsxwriter
import xlrd
import xlwt
import os

run = True

while run:

    print()
    print()
    print(' WHAT WOULD LIKE TO DO: \n')
    print(' 1. CREATE AN EXCEL FILE')
    print(' 2. WRITE TO AN EXCEL FILE ')
    print(' 3. READ AN EXCEL FILE')
    print(' 4. DELETE AN EXCEL FILE')
    print(' 5. QUIT')


    option = input('Enter an option (1, 2, 3, 4 or 5): ')

    if int(option) == 1:
        name = input('Enter the name of the file(".\shop.xlsx"): ')  # example .\shop.xlsx
        if os.path.exists(name + ".xlsx"):    # check if file exists
            print('File ' + name + ' already exists!!!')

        else:
             workbook = xlsxwriter.Workbook(name + ".xlsx")
             ws = input('Enter name of your worksheet: ')
             worksheet = workbook.add_worksheet(ws)
             workbook.close()
             print('Successful you have created a file ' + name )



    # Read from an excel file
    elif int(option) == 3:
                    # check if file exists
                    name = input('Enter the name of the file(".\shop.xlsx"): ')  # example .\shop.xlsx
                    if os.path.exists(name):

                        # Goto to the location of the excel file
                        loc = (name)

                        # In python an excel document is a workbook
                        wb = xlrd.open_workbook(loc)

                        # Choose a spread sheet, in this case the first one at index 0
                        sheet = wb.sheet_by_index(0)
                        print(str(sheet.ncols))

                        # Select the information at a certain location, this case at (0,0)
                        for row in range(sheet.nrows):
                           for column in range(sheet.ncols):
                                   print(sheet.cell_value(row, column))


                    else:
                        print('The file ' + name + ' doesn\'t exists')


    # Delete a file
    elif int(option) == 4:
        # check if file exists
        name = input('Enter the name of the file(".\shop.xlsx"): ')  # example .\shop.xlsx
        if os.path.exists(name):
            os.remove(name)
            print('Success file ' + name + ' has been deleted')
        else:
            print('The file ' + name + ' doesn\'t exists')


    elif int(option) == 5:
        run == False
        break

    # Invalid user input
    else: print('INVALID INPUT: Please Enter one of the options..')

    print()
    print("YOU HAVE EXITED THE PROGRAM...")
    print("*******#############******")
    print()
    print()
