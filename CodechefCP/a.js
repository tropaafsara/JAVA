//Write a code on how to calculate the number of vowels and consonants in a string?
//bcdfghjklmnpqrstvwxyz

function countVowelAndConsonent(string){
    const lowercaseString = string.toLowerCase();

    const vowels = ['a','e','i','o','u'];
    const consonents = 'bcdfghjklmnpqrstvwxyz'.split('');

    let countVowel  = 0;
    let countConsonent =0;

    for(let char of lowercaseString){
        if(vowels.includes(char)){
            countVowel++;
        }else if(consonents.includes(char)){
            countConsonent++;
        }
    }

    return {vowels: countVowel, consonents : countConsonent}
}


const string = 'Hello World';
const result = countVowelAndConsonent(string);
console.log(result);