//Write a code to calculate if the string is palindrome ?

function ispalindrome(inputString){
    const string = inputString.replace(/[^a-zA-Z0-9]/g, '').toLowerCase();

    const reverseString = string.split('').reverse().join('');

    return string === reverseString;
}

const string1 = "racecar";
console.log(ispalindrome(string1));

const string2 = "Hello World";
console.log(ispalindrome(string2));