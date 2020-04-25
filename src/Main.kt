fun main(args: Array<String>) {
    Search().apply {
        search("A história de toda a sociedade até aqui é a história de lutas de classes.")
        search("patrício e plebeu, barão e servo")
        search("a")
        search("uahauhauhauh")
    }
    /*
    Output:
     I found 4 ocurrencies for "A história de toda a sociedade até aqui é a história de lutas de classes."
     These are the occurrence locations in the text
             [0, 15, 30, 45]
     I found 1 ocurrencies for "patrício e plebeu, barão e servo"
     These are the occurrence locations in the text
             [64]
     I found 9 ocurrencies for "a"
     These are the occurrence locations in the text
             [4, 9, 19, 24, 34, 39, 49, 54, 110]
     Sorry, I could not find the "uahauhauhauh" text in the book
     */
}