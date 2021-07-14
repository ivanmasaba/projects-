# THIS IS A GUESS MY NUMBER GAME

import random

# set game running to true, and false to quit game
game_running = True

# A continius loop
while game_running:
    # Ask for player input
    print()
    print("I am thinking of a number, can u guess it? ")
    # Let computer create a random number between 0 and 9
    secret_number = random.randint(0, 9)
    # set the initial player guess number to -1(outside the range)
    guess_number = -1
    # create infinite loop until player guesses the number or when they quit
    while guess_number != secret_number:
        # get player's input
        print()
        print("IF YOU WANT TO QUIT, ENTER 'q' ")
        guess = input("Please enter your guess: ")
        # check if player wants to quit
        if (guess == "q") or (guess == "Q"):
            game_running = False
            break
        # Keep playing
        else:
            print()
            guess_number = int(guess)

        # check if player guessed the number
        if guess_number == secret_number:
            print()
            print("Congratulations, " + guess + " is correct, " + "You guessed the number...")
        else:
            print()
            print("Oh no, " + guess + " is not right")
    # quit the game
    print()
    print("THANKS FOR PLAYING...")